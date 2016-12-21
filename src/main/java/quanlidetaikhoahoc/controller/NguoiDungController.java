package quanlidetaikhoahoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import quanlidetaikhoahoc.Utils;
import quanlidetaikhoahoc.dao.NguoiDungDAO;
import quanlidetaikhoahoc.domain.NguoiDung;

@Controller
public class NguoiDungController {

	@Autowired
	private NguoiDungDAO nguoiDungDAO;

	@GetMapping(value = "/dang-nhap")
	public String dangNhap() {
		return "/users/login";
	}

	@GetMapping(value = "/trang-chu")
	public String hienthiTrangChu() {
		return "/users/trang-chu";
	}


	@GetMapping(value = "/thong-bao")
	public String xemThongBao() {
		return "/users/thong-bao";
	}


	@GetMapping(value = "/thong-tin-ca-nhan")
	public String xemThongTinCaNhan(UsernamePasswordAuthenticationToken currentUser, Model model) {
		NguoiDung nguoiDung = (NguoiDung) currentUser.getPrincipal();
		model.addAttribute("nguoiDung", nguoiDung);
		return "/users/thong-tin-ca-nhan";
	}



	@PostMapping(value = "/chinh-sua-thong-tin")
	@ResponseStatus(HttpStatus.OK)
	public void chinhSuaThongTin(@RequestParam("email") String email,@RequestParam("ngheNghiep") String ngheNghiep,@RequestParam("soDT") String sdt, UsernamePasswordAuthenticationToken currentUser) {
		NguoiDung nguoiDung = nguoiDungDAO.getByMaTacGia(((NguoiDung) currentUser.getPrincipal()).getMaTacGia());
		nguoiDung.setEmail(email);
		nguoiDung.setNgheNghiep(ngheNghiep);
		nguoiDung.setSdt(sdt);
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
