package quanlidetaikhoahoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import quanlidetaikhoahoc.Utils;
import quanlidetaikhoahoc.dao.DeTaiDAO;
import quanlidetaikhoahoc.dao.NguoiDungDAO;
import quanlidetaikhoahoc.domain.DeTai;
import quanlidetaikhoahoc.domain.NguoiDung;

@Controller
public class UserNavigationController {

	@Autowired
	private NguoiDungDAO nguoiDungDAO;

	@Autowired
	private DeTaiDAO deTaiDAO;

	@GetMapping(value = "/dang-nhap")
	public String dangNhap() {
		return "/users/login";
	}

	@GetMapping(value = "/trang-chu")
	public String hienthiTrangChu() {
		return "/users/trang-chu";
	}

	@GetMapping(value = "/danh-sach-de-tai")
	public String xemDSDeTai(Model model) {
		model.addAttribute("dsNguoiDung", nguoiDungDAO.getAll());
		model.addAttribute("dsNam", deTaiDAO.getDanhSachNam());
		model.addAttribute("dsTrangThai", deTaiDAO.getTrangThaiDeTai());
		return "/users/danh-sach-de-tai";
	}

	@GetMapping(value = "/thong-bao")
	public String xemThongBao() {
		return "/users/thong-bao";
	}

	@GetMapping(value = "/dang-ki-de-tai")
	public String dangkiDeTai() {
		return "/users/dang-ki-de-tai";
	}

	@GetMapping(value = "/thong-tin-ca-nhan")
	public String xemThongTinCaNhan(UsernamePasswordAuthenticationToken currentUser, Model model) {
		NguoiDung nguoiDung = (NguoiDung) currentUser.getPrincipal();
		model.addAttribute("nguoiDung", nguoiDung);
		return "/users/thong-tin-ca-nhan";
	}

	@GetMapping(value = "/tim-kiem-nang-cao")
	public String timKiem() {
		return "/users/tim-kiem-nang-cao";
	}

	@GetMapping(value = "/thong-tin-de-tai/{id}")
	public String thongTinDeTai(@PathVariable("id") long id, Model model) {
		DeTai deTai = deTaiDAO.get(id);
		model.addAttribute("deTai", deTai);
		return "/users/thong-tin-de-tai";
	}

	@PostMapping(value = "/chinh-sua-thong-tin")
	@ResponseStatus(HttpStatus.OK)
	public void chinhSuaThongTin(@RequestBody NguoiDung nguoiDung, UsernamePasswordAuthenticationToken currentUser) {
		NguoiDung ng = nguoiDungDAO.getByMaTacGia(((NguoiDung) currentUser.getPrincipal()).getMaTacGia());
		ng.setEmail(nguoiDung.getEmail());
		ng.setTenTacGia(nguoiDung.getTenTacGia());
		ng.setNgheNghiep(nguoiDung.getNgheNghiep());
		ng.setSdt(ng.getSdt());

		nguoiDungDAO.update(nguoiDung);
	}

	@PostMapping(value = "/thay-doi-mat-khau")
	public ResponseEntity<String> thayDoiMatKhau(@RequestParam("currentPassword") String currentPassword,
			@RequestParam("newPassword") String newPassword, UsernamePasswordAuthenticationToken currentUser) {
		NguoiDung nguoiDung = nguoiDungDAO.getByMaTacGia(((NguoiDung) currentUser.getPrincipal()).getMaTacGia());
		String currentHashedPassword = Utils.encryptMD5(nguoiDung.getToken(), currentPassword);
		if (currentHashedPassword.equals(nguoiDung.getMatKhau())) {
			String newHashedPassword = Utils.encryptMD5(nguoiDung.getToken(), newPassword);
			nguoiDung.setMatKhau(newHashedPassword);
			nguoiDungDAO.update(nguoiDung);
			return new ResponseEntity<String>(HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

}
