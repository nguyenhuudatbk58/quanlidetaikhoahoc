package quanlidetaikhoahoc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import quanlidetaikhoahoc.dao.ThongBaoDAO;
import quanlidetaikhoahoc.domain.ThongBao;
import quanlidetaikhoahoc.responseData.PaginatedResponse;

@Controller
public class ThongBaoController {

	@Autowired
	private ThongBaoDAO thongBaoDAO;

	@PostMapping(value = "/quan-li/tao-thong-bao")
	@ResponseStatus(HttpStatus.OK)
	public void taoThongBao(@RequestParam("tieuDe") String tieuDe, @RequestParam("noiDung") String noiDung) {
		ThongBao thongBao = new ThongBao();
		thongBao.setTieuDe(tieuDe);
		thongBao.setNoiDung(noiDung);
		thongBao.setThoiGianTao(new Date());
		thongBaoDAO.save(thongBao);
	}

	@GetMapping(value = "/quan-li/quan-li-thong-bao")
	public String quanLiTB() {
		return "admin/danh-sach-thong-bao";
	}

	@PostMapping(value = "/quan-li/xoa-thong-bao/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void xoaThongBao(@PathVariable("id") int id) {
		ThongBao thongBao = thongBaoDAO.getById(id);
		thongBaoDAO.delete(thongBao);
	}

	@GetMapping(value = "/danh-sach-thong-bao")
	public String xemThongBao() {
		return "/users/danh-sach-thong-bao";
	}

	@PostMapping(value = "/danh-sach-thong-bao")
	public @ResponseBody PaginatedResponse<ThongBao> getDSThongBao(@RequestParam("page") int page,
			@RequestParam("pageSize") int pageSize) {
		PaginatedResponse<ThongBao> response = new PaginatedResponse<ThongBao>();
		int total = thongBaoDAO.count();
		int totalPage = 0;
		if (total % pageSize == 0) {
			totalPage = total / pageSize;
		} else {
			totalPage = total / pageSize + 1;
		}
		response.setPage(page);
		response.setPageSize(pageSize);
		response.setTotalElement(total);
		response.setTotalPage(totalPage);
		response.setDatas(thongBaoDAO.get(page, pageSize));

		return response;
	}

	@GetMapping(value = "/quan-li/tao-thong-bao")
	public String taoThongBao() {
		return "admin/tao-thong-bao";
	}

	@GetMapping(value = "/thong-bao/{id}")
	public String xemThongBao(@PathVariable("id") int id, Model model) {
		model.addAttribute("thongBao", thongBaoDAO.getById(id));
		return "users/thong-bao";
	}
}
