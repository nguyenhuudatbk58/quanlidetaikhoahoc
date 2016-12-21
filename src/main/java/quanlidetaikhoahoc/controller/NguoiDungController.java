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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.annotation.JsonView;

import quanlidetaikhoahoc.Utils;
import quanlidetaikhoahoc.Views;
import quanlidetaikhoahoc.dao.NguoiDungDAO;
import quanlidetaikhoahoc.domain.Admin;
import quanlidetaikhoahoc.domain.NguoiDung;
import quanlidetaikhoahoc.domain.Role;
import quanlidetaikhoahoc.responseData.PaginatedResponse;

@Controller
public class NguoiDungController {

	@Autowired
	private NguoiDungDAO nguoiDungDAO;

	@GetMapping(value = "/dang-nhap")
	public String dangNhap(@RequestParam(value = "error", defaultValue = "", required = false) String error,
			Model model) {
		if (!error.equals("")) {
			model.addAttribute("error", true);
		}
		return "/users/login";
	}

	@GetMapping(value = "/trang-chu")
	public String hienthiTrangChu(UsernamePasswordAuthenticationToken currentUser) {
		if(currentUser != null){
			Object u = currentUser.getPrincipal();
			if(u instanceof Admin){
				return "redirect:/quan-li/quan-li-tai-khoan";
			}
		}
		return "/users/trang-chu";
	}


	@GetMapping(value = "/thong-tin-ca-nhan")
	public String xemThongTinCaNhan(UsernamePasswordAuthenticationToken currentUser, Model model) {
		NguoiDung nguoiDung = (NguoiDung) currentUser.getPrincipal();
		
		model.addAttribute("nguoiDung", nguoiDungDAO.getByMaTacGia(nguoiDung.getMaTacGia()));
		return "/users/thong-tin-ca-nhan";
	}

	@PostMapping(value = "/chinh-sua-thong-tin-ca-nhan")
	@ResponseStatus(HttpStatus.OK)
	public void chinhSuaThongTin( UsernamePasswordAuthenticationToken currentUser,@RequestParam("email") String email, @RequestParam("ngheNghiep") String ngheNghiep,
			@RequestParam("sdt") String sdt) {
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
	
	@GetMapping(value="/quan-li/tao-tai-khoan")
	public String taoTaiKhoan(Model model){
		String maTacGia = nguoiDungDAO.getMaTacGia();
		model.addAttribute("maTacGia", maTacGia);
		return "admin/tao-tai-khoan";
	}
	
	@PostMapping(value="/quan-li/tao-tai-khoan")
	@ResponseStatus(HttpStatus.CREATED)
	public void taoTaiKhoan(@RequestBody NguoiDung nguoiDung){
		String token = Utils.generateToken();
		String matKhau = nguoiDung.getMaTacGia();
		nguoiDung.setMatKhau(Utils.encryptMD5(token,matKhau));
		nguoiDung.setToken(token);
		nguoiDung.setRole(Role.USER);
		nguoiDung.setActive(true);
		nguoiDungDAO.save(nguoiDung);
	}
	
	@PostMapping(value="/quan-li/reset-mat-khau/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void resetMK(@PathVariable("id") int id){
		NguoiDung nguoiDung = nguoiDungDAO.getById(id);
		String token = nguoiDung.getToken();
		nguoiDung.setMatKhau(Utils.encryptMD5(token, nguoiDung.getMaTacGia()));
		nguoiDungDAO.update(nguoiDung);
	}
	
	@PostMapping(value="/quan-li/xoa-tai-khoan/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void xoaTaiKhoan(@PathVariable("id") int id){
		NguoiDung nguoiDung = nguoiDungDAO.getById(id);
		nguoiDung.setActive(false);
		nguoiDungDAO.update(nguoiDung);
	}
	
	@PostMapping(value="/quan-li/tim-kiem-nguoi-dung")
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
	
	@GetMapping(value="/quan-li/thong-tin-tai-khoan/{id}")
	public String thongTinTaiKhoan(@PathVariable("id") long id,Model model){
		model.addAttribute("nguoiDung", nguoiDungDAO.getById(id));
		return "admin/thong-tin-tai-khoan";
	}
	
	@GetMapping(value="/quan-li/quan-li-tai-khoan")
	public String quanLiTaiKhoan(){
		return "admin/danh-sach-tai-khoan";
	}

}
