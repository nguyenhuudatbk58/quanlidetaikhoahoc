package quanlidetaikhoahoc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.annotation.JsonView;

import quanlidetaikhoahoc.Utils;
import quanlidetaikhoahoc.dao.DeTaiDAO;
import quanlidetaikhoahoc.dao.NguoiDungDAO;
import quanlidetaikhoahoc.domain.DeTai;
import quanlidetaikhoahoc.domain.NguoiDung;
import quanlidetaikhoahoc.domain.Role;
import quanlidetaikhoahoc.domain.TrangThaiDeTai;
import quanlidetaikhoahoc.domain.Views;
import quanlidetaikhoahoc.responseData.PaginatedResponse;

@Controller
@RequestMapping(value="/quan-li")
public class AdminNavigationController {

	@Autowired
	private DeTaiDAO deTaiDAO;
	
	@Autowired
	private NguoiDungDAO nguoiDungDAO;
	
	@GetMapping("/tim-kiem-nang-cao")
	public String timKiemNangCao(){
		return "admin/tim-kiem-nang-cao";
	}
	
	@GetMapping(value="/tao-thong-bao")
	public String taoThongBao(){
		return "admin/quan-li-thong-bao";
	}
	
	@GetMapping(value="/quan-li-tai-khoan")
	public String quanLiTaiKhoan(){
		return "admin/quan-li-tai-khoan";
	}
	
	@GetMapping(value="/duyet-de-tai")
	public String duyetDeTai(){
		return "admin/duyet-de-tai";
	}
	
	@GetMapping(value="/danh-sach-de-tai")
	public String dsDeTai(Model model){
		model.addAttribute("dsNguoiDung", nguoiDungDAO.getAll());
		model.addAttribute("dsNam", deTaiDAO.getDanhSachNam());
		model.addAttribute("dsTrangThai", deTaiDAO.getTrangThaiDeTai());
		return "admin/danh-sach-de-tai";
	}
	
	@GetMapping(value="/tao-tai-khoan")
	public String taoTaiKhoan(Model model){
		String maTacGia = nguoiDungDAO.getMaTacGia();
		model.addAttribute("maTacGia", maTacGia);
		return "admin/tao-tai-khoan";
	}
	
	@GetMapping(value="/thong-tin-de-tai/{id}")
	public String deTai(@PathVariable("id") int id,Model model){
		DeTai deTai = deTaiDAO.get(id);
		List<TrangThaiDeTai> dsTrangThai = deTaiDAO.getTrangThaiDeTai();
		model.addAttribute("deTai",deTai);
		model.addAttribute("dsTrangThai",dsTrangThai);
		return "admin/thong-tin-de-tai";
	}
	@PostMapping(value="/tao-tai-khoan")
	@ResponseStatus(HttpStatus.CREATED)
	public void taoTaiKhoan(@RequestBody NguoiDung nguoiDung){
		String token = Utils.generateToken();
		String matKhau = nguoiDung.getMaTacGia();
		nguoiDung.setMatKhau(Utils.encryptMD5(token,matKhau));
		nguoiDung.setToken(token);
		nguoiDung.setRole(Role.USER);
		nguoiDungDAO.save(nguoiDung);
	}
	
	@PostMapping(value="/reset-mat-khau/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void resetMK(@PathVariable("id") int id){
		NguoiDung nguoiDung = nguoiDungDAO.getById(id);
		String token = nguoiDung.getToken();
		nguoiDung.setMatKhau(Utils.encryptMD5(token, nguoiDung.getMaTacGia()));
		
		nguoiDungDAO.update(nguoiDung);
	}
	
	@PostMapping(value="/xoa-tai-khoan/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void xoaTaiKhoan(@PathVariable("id") int id){
		NguoiDung nguoiDung = nguoiDungDAO.getById(id);
		nguoiDung.setActive(false);
		nguoiDungDAO.update(nguoiDung);
	}
	
	@PostMapping(value="/tim-kiem-nguoi-dung")
	@JsonView(Views.ReviewUser.class)
	public @ResponseBody PaginatedResponse<NguoiDung> timKiemTaiKhoan(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize,@RequestParam("dieuKienTimKiem") String dieuKienTimKiem){
		PaginatedResponse<NguoiDung> response = new PaginatedResponse<NguoiDung>();
		response.setPage(page);
		response.setPageSize(pageSize);
		int total = nguoiDungDAO.count(dieuKienTimKiem);
		response.setTotalElement(total);
		int totalPage = 0;
		if(total % pageSize == 0){
			totalPage = total / pageSize;
		}else{
			totalPage = total / pageSize + 1;
		}
		response.setTotalPage(totalPage);
		int offset = (page - 1)*pageSize;
		response.setDatas(nguoiDungDAO.search(pageSize, offset, dieuKienTimKiem));
		return response;
	}
	
	@GetMapping(value="/thong-tin-tai-khoan/{id}")
	public String thongTinTaiKhoan(@PathVariable("id") long id,Model model){
		model.addAttribute("nguoiDung", nguoiDungDAO.getById(id));
		return "admin/thong-tin-tai-khoan";
	}
}
