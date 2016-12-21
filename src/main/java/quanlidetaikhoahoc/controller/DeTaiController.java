package quanlidetaikhoahoc.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.annotation.JsonView;

import quanlidetaikhoahoc.Views;
import quanlidetaikhoahoc.dao.DeTaiDAO;
import quanlidetaikhoahoc.dao.NguoiDungDAO;
import quanlidetaikhoahoc.dao.YeuCauDuyetDeTaiDAO;
import quanlidetaikhoahoc.domain.DanhGia;
import quanlidetaikhoahoc.domain.DeTai;
import quanlidetaikhoahoc.domain.HuongNghienCuu;
import quanlidetaikhoahoc.domain.LoaiDeTai;
import quanlidetaikhoahoc.domain.NguoiDung;
import quanlidetaikhoahoc.domain.TrangThaiDeTai;
import quanlidetaikhoahoc.domain.YeuCauDuyetDeTai;
import quanlidetaikhoahoc.requestdata.SearchDeTaiRequestData;
import quanlidetaikhoahoc.requestdata.TypeSearch;
import quanlidetaikhoahoc.responseData.PaginatedResponse;

@Controller
public class DeTaiController {

	@Autowired
	private DeTaiDAO deTaiDAO;

	@Autowired
	private NguoiDungDAO nguoiDungDAO;

	@Autowired
	private YeuCauDuyetDeTaiDAO yeuCauDAO;

	@Autowired
	private SimpMessagingTemplate messaging;

	@GetMapping("/huong-nghien-cuu")
	public @ResponseBody List<HuongNghienCuu> getHuongNghienCuu() {
		return deTaiDAO.getHuongNghienCuu();
	}

	@GetMapping("/loai-de-tai")
	public @ResponseBody List<LoaiDeTai> getLoaiDeTai() {
		return deTaiDAO.getLoaiDeTai();
	}

	@GetMapping(value = "/danh-gia")
	public @ResponseBody List<DanhGia> getDanhGia() {
		return deTaiDAO.getDanhGia();
	}

	@GetMapping(value = "/danh-sach-de-tai")
	public String xemDSDeTai(Model model) {
		model.addAttribute("dsNguoiDung", nguoiDungDAO.getAll());
		model.addAttribute("dsNam", deTaiDAO.getDanhSachNam());
		model.addAttribute("dsTrangThai", deTaiDAO.getTrangThaiDeTai());
		return "/users/danh-sach-de-tai";
	}

	@GetMapping(value = "/thong-tin-de-tai/{id}")
	public String thongTinDeTai(@PathVariable("id") long id, Model model) {
		DeTai deTai = deTaiDAO.get(id);
		model.addAttribute("deTai", deTai);
		return "/users/thong-tin-de-tai";
	}

	@GetMapping(value = "/dang-ki-de-tai")
	public String dangkiDeTai() {
		return "/users/dang-ki-de-tai";
	}

	@PostMapping(value = "/quan-li/duyet-de-tai/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void duyetDeTai(@PathVariable("id") int id) {
		DeTai deTai = deTaiDAO.get(id);
		deTai.setDuyet(true);
		TrangThaiDeTai trangThaiDeTai = new TrangThaiDeTai();
		trangThaiDeTai.setId(1);
		deTai.setTrangThai(trangThaiDeTai);
		yeuCauDAO.delete(deTai.getYeuCauDuyetDeTai());
		deTaiDAO.update(deTai);
	}

	@PostMapping(value = "/quan-li/sua-de-tai/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void suaDeTai(@PathVariable("id") long id, @RequestBody DeTai deTai) {
		DeTai dt = deTaiDAO.get(id);

		dt.setTen(deTai.getTen());
		dt.setThoiGianBatDau(deTai.getThoiGianBatDau());
		dt.setThoiGianKetThuc(deTai.getThoiGianKetThuc());
		dt.setLoaiDeTai(deTai.getLoaiDeTai());
		dt.setHuongNghienCuu(deTai.getHuongNghienCuu());
		dt.setTrangThai(deTai.getTrangThai());
		dt.setLyDoHuy(deTai.getLyDoHuy());
		dt.setDanhGia(deTai.getDanhGia());
		dt.setThoiGianNghiemThu(deTai.getThoiGianNghiemThu());
		dt.setMoTa(deTai.getMoTa());

		deTaiDAO.update(dt);
	}

	@PostMapping(value = "/quan-li/xoa-de-tai/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void xoaDeTai(@PathVariable("id") int id) {
		DeTai deTai = deTaiDAO.get(id);
		deTaiDAO.delete(deTai);
		System.out.println(deTai.getTen());
	}

	@GetMapping(value = "/quan-li/sua-de-tai/{id}")
	public String suaDeTai(@PathVariable("id") int id, Model model) {
		model.addAttribute("deTai", deTaiDAO.get(id));
		model.addAttribute("dsLoaiDeTai", deTaiDAO.getLoaiDeTai());
		model.addAttribute("dsHuongNghienCuu", deTaiDAO.getHuongNghienCuu());
		model.addAttribute("dsDanhGia", deTaiDAO.getDanhGia());
		model.addAttribute("dsTrangThai", deTaiDAO.getTrangThaiDeTai());
		return "admin/sua-de-tai";
	}

	@PostMapping("/tao-de-tai")
	@JsonView(Views.ReviewDeTai.class)
	public @ResponseBody ResponseEntity<DeTai> taoDeTai(@RequestBody DeTai deTai,
			UsernamePasswordAuthenticationToken currentUser) {
		NguoiDung nguoiDung = nguoiDungDAO.getByMaTacGia(((NguoiDung) currentUser.getPrincipal()).getMaTacGia());
		deTai.setDuyet(false);
		deTai.setNguoiDung(nguoiDung);
		deTai.setNam(Calendar.getInstance().get(Calendar.YEAR));
		deTai.setMaDeTai(deTaiDAO.getMaDeTai());
		YeuCauDuyetDeTai thongBao = new YeuCauDuyetDeTai();
		thongBao.setThoiGianTao(new Date());
		thongBao.setDeTai(deTai);
		thongBao.setNguoiDung(nguoiDung);
		deTaiDAO.save(deTai);
		yeuCauDAO.save(thongBao);
		messaging.convertAndSend("/post/thong-bao", thongBao);
		ResponseEntity<DeTai> responseEntity = new ResponseEntity<DeTai>(deTai,HttpStatus.CREATED);
		return responseEntity;
	}

	@PostMapping("/search")
	@JsonView(value = Views.ReviewDeTai.class)
	public @ResponseBody PaginatedResponse<DeTai> search(@RequestBody SearchDeTaiRequestData searchRequestData) {
		PaginatedResponse<DeTai> response = new PaginatedResponse<DeTai>();
		int pageSize = searchRequestData.getPageSize();
		int page = searchRequestData.getPage();
		response.setPage(page);
		response.setPageSize(pageSize);

		if (searchRequestData.getTypeSearch() == TypeSearch.NORMAL) {
			int total = deTaiDAO.count(searchRequestData.getTenDeTai(), 1);
			int totalPage = 0;
			if (total % pageSize == 0) {
				totalPage = total / pageSize;
			} else {
				totalPage = total / pageSize + 1;
			}
			response.setTotalElement(total);
			response.setTotalPage(totalPage);
			response.setDatas(deTaiDAO.search(searchRequestData.getTenDeTai(), searchRequestData.getPageSize(),
					searchRequestData.getPage(), 1));
		} else if (searchRequestData.getTypeSearch() == TypeSearch.ADVANCED) {
			long idNguoiDung = searchRequestData.getIdNguoiDung();
			NguoiDung tacGia = null;
			if (idNguoiDung > 0) {
				tacGia = new NguoiDung();
				tacGia.setIdNguoiDung(idNguoiDung);
			}
			int total = deTaiDAO.count(tacGia, searchRequestData.getNam(), searchRequestData.getHuongNghienCuu(),
					searchRequestData.getLoaiDeTai(), searchRequestData.getTrangThai());
			int totalPage = 0;
			if (total % pageSize == 0) {
				totalPage = total / pageSize;
			} else {
				totalPage = total / pageSize + 1;
			}
			response.setTotalElement(total);
			response.setTotalPage(totalPage);
			response.setDatas(deTaiDAO.search(tacGia, searchRequestData.getNam(), searchRequestData.getHuongNghienCuu(),
					searchRequestData.getLoaiDeTai(), searchRequestData.getTrangThai(), page, pageSize));
		}
		return response;
	}

	@PostMapping("/de-tai-chua-duyet")
	@JsonView(value = Views.ReviewDeTai.class)
	public @ResponseBody PaginatedResponse<DeTai> getDSDeTaiChuaDuyet(@RequestParam("page") int page,
			@RequestParam("pageSize") int pageSize, @RequestParam("tenDeTai") String tenDeTai) {
		PaginatedResponse<DeTai> response = new PaginatedResponse<DeTai>();
		response.setPage(page);
		response.setPageSize(pageSize);

		int total = deTaiDAO.count(tenDeTai, 0);
		int totalPage = 0;
		if (total % pageSize == 0) {
			totalPage = total / pageSize;
		} else {
			totalPage = total / pageSize + 1;
		}
		response.setTotalElement(total);
		response.setTotalPage(totalPage);
		response.setDatas(deTaiDAO.search(tenDeTai, pageSize, page, 0));
		return response;
	}

	@PostMapping(value = "/yeu-cau-duyet-de-tai")
	public @ResponseBody PaginatedResponse<YeuCauDuyetDeTai> get(@RequestParam("page") int page,
			@RequestParam("pageSize") int pageSize) {
		PaginatedResponse<YeuCauDuyetDeTai> response = new PaginatedResponse<YeuCauDuyetDeTai>();
		response.setDatas(yeuCauDAO.get(page, pageSize));
		response.setPage(page);
		response.setPageSize(pageSize);
		int total = yeuCauDAO.count();
		int totalPage = 0;
		if (total % pageSize == 0) {
			totalPage = total / pageSize;
		} else {
			totalPage = total / pageSize + 1;
		}
		response.setTotalElement(total);
		response.setTotalPage(totalPage);
		return response;
	}

	@GetMapping(value = "/quan-li/duyet-de-tai")
	public String duyetDeTai() {
		return "admin/duyet-de-tai";
	}

	@GetMapping(value = "/quan-li/danh-sach-de-tai")
	public String dsDeTai(Model model) {
		model.addAttribute("dsNguoiDung", nguoiDungDAO.getAll());
		model.addAttribute("dsNam", deTaiDAO.getDanhSachNam());
		model.addAttribute("dsTrangThai", deTaiDAO.getTrangThaiDeTai());
		return "admin/danh-sach-de-tai";
	}

	@GetMapping(value = "/quan-li/thong-tin-de-tai/{id}")
	public String deTai(@PathVariable("id") int id, Model model) {
		DeTai deTai = deTaiDAO.get(id);
		List<TrangThaiDeTai> dsTrangThai = deTaiDAO.getTrangThaiDeTai();
		model.addAttribute("deTai", deTai);
		model.addAttribute("dsTrangThai", dsTrangThai);
		return "admin/thong-tin-de-tai";
	}
}
