package quanlidetaikhoahoc.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import quanlidetaikhoahoc.dao.DeTaiDAO;
import quanlidetaikhoahoc.dao.NguoiDungDAO;
import quanlidetaikhoahoc.domain.DanhGia;
import quanlidetaikhoahoc.domain.DeTai;
import quanlidetaikhoahoc.domain.HuongNghienCuu;
import quanlidetaikhoahoc.domain.LoaiDeTai;
import quanlidetaikhoahoc.domain.NguoiDung;
import quanlidetaikhoahoc.domain.TrangThaiDeTai;
import quanlidetaikhoahoc.domain.Views;
import quanlidetaikhoahoc.domain.YeuCauDuyetDeTai;
import quanlidetaikhoahoc.requestdata.SearchDeTaiRequestData;
import quanlidetaikhoahoc.requestdata.TypeSearch;
import quanlidetaikhoahoc.responseData.SearchResponse;

@Controller
public class DeTaiController {
	
	@Autowired
	private DeTaiDAO deTaiDAO;
	
	@Autowired
	private NguoiDungDAO nguoiDungDAO;

	@GetMapping("/huong-nghien-cuu")
	public @ResponseBody List<HuongNghienCuu> getHuongNghienCuu(){
		return deTaiDAO.getHuongNghienCuu();
	}
	
	
	@GetMapping("/loai-de-tai")
	public @ResponseBody List<LoaiDeTai> getLoaiDeTai(){
		return deTaiDAO.getLoaiDeTai();
	}
	
	@GetMapping(value="/danh-gia")
	public @ResponseBody List<DanhGia> getDanhGia(){
		return deTaiDAO.getDanhGia();
	}
	
	@PostMapping(value="/quan-li/duyet-de-tai/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void duyetDeTai(@PathVariable("id") int id){
		DeTai deTai = deTaiDAO.get(id);
		deTai.setDuyet(true);
		TrangThaiDeTai  trangThaiDeTai  = new TrangThaiDeTai();
		trangThaiDeTai.setId(1);
		deTai.setTrangThai(trangThaiDeTai);
		deTaiDAO.update(deTai);
	}
	@PostMapping(value="/quan-li/sua-de-tai/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void suaDeTai(@PathVariable("id") long id,@RequestBody DeTai deTai){
		DeTai dt  = deTaiDAO.get(id);
		deTai.setIdDeTai(id);
		deTai.setMaDeTai(dt.getMaDeTai());
		deTai.setTacGia(dt.getTacGia());
		deTai.setDuyet(dt.isDuyet());
		deTai.setNam(dt.getNam());
		deTaiDAO.update(deTai);
	}
	@PostMapping(value="/quan-li/xoa-de-tai/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void xoaDeTai(@PathVariable("id") int id){
		DeTai deTai = deTaiDAO.get(id);
		deTaiDAO.delete(deTai);
		System.out.println(deTai.getTen());
	}
	@GetMapping(value="/quan-li/sua-de-tai/{id}")
	public String suaDeTai(@PathVariable("id") int id,Model model){
		model.addAttribute("deTai", deTaiDAO.get(id));
		model.addAttribute("dsLoaiDeTai", deTaiDAO.getLoaiDeTai());
		model.addAttribute("dsHuongNghienCuu", deTaiDAO.getHuongNghienCuu());
		model.addAttribute("dsDanhGia", deTaiDAO.getDanhGia());
		model.addAttribute("dsTrangThai", deTaiDAO.getTrangThaiDeTai());
		return "admin/sua-de-tai";
	}
	@PostMapping("/tao-de-tai")
	@ResponseStatus(HttpStatus.CREATED)
	public void taoDeTai(@RequestBody DeTai deTai,Principal currentUser){
		NguoiDung nguoiDung = nguoiDungDAO.getByMaTacGia(currentUser.getName());
        YeuCauDuyetDeTai thongBao = new YeuCauDuyetDeTai();
        thongBao.setThoiGianTao(new Date());
        thongBao.setDeTai(deTai);
        thongBao.setNguoiDung(nguoiDung);
        thongBao.setNoiDung("<strong>"+nguoiDung.getTenTacGia()+"</strong> đăng kí một đề tài");
        deTaiDAO.save(deTai);
        deTaiDAO.saveThongBao(thongBao);
		// luu de tai
		// gui thong bao
		// luu thong bao
	}
	@PostMapping("/search")
	@JsonView(value=Views.ReviewDeTai.class)
	public @ResponseBody SearchResponse<DeTai> search(@RequestBody SearchDeTaiRequestData searchRequestData){
		SearchResponse<DeTai> response = new SearchResponse<DeTai>();
		int pageSize = searchRequestData.getPageSize();
		int page = searchRequestData.getPage();
		response.setPage(page);
		response.setPageSize(pageSize);
		
		if(searchRequestData.getTypeSearch() == TypeSearch.NORMAL){
			int total = deTaiDAO.count(searchRequestData.getTenDeTai(),1);
			int totalPage = 0;
			if(total % pageSize == 0){
				totalPage = total / pageSize;
			}else{
				totalPage = total / pageSize + 1;
			}
			response.setTotalElement(total);
			response.setTotalPage(totalPage);
			response.setDatas(deTaiDAO.search(searchRequestData.getTenDeTai(),searchRequestData.getPageSize(), searchRequestData.getPage(),1));
		}else if(searchRequestData.getTypeSearch() == TypeSearch.ADVANCED){
			
		}
		return response;
	}
	
	@PostMapping("/de-tai-chua-duyet")
	@JsonView(value=Views.ReviewDeTai.class)
	public @ResponseBody SearchResponse<DeTai> getDSDeTaiChuaDuyet(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize, @RequestParam("tenDeTai")String tenDeTai){
		SearchResponse<DeTai> response = new SearchResponse<DeTai>();
		response.setPage(page);
		response.setPageSize(pageSize);
		
			int total = deTaiDAO.count(tenDeTai,0);
			int totalPage = 0;
			if(total % pageSize == 0){
				totalPage = total / pageSize;
			}else{
				totalPage = total / pageSize + 1;
			}
			response.setTotalElement(total);
			response.setTotalPage(totalPage);
			response.setDatas(deTaiDAO.search(tenDeTai,pageSize,page,0));
		return response;
	}
}
