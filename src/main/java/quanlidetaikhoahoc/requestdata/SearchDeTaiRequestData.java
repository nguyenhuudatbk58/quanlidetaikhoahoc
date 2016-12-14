package quanlidetaikhoahoc.requestdata;

import java.util.Calendar;

import quanlidetaikhoahoc.domain.DanhGia;
import quanlidetaikhoahoc.domain.HuongNghienCuu;
import quanlidetaikhoahoc.domain.LoaiDeTai;

public class SearchDeTaiRequestData {

	private int nam;
	private String tenTacGia;
	private HuongNghienCuu huongNghienCuu;
	private LoaiDeTai loaiDeTai;
	private DanhGia danhGia;
	private Calendar thoiGianNghiemThu;
	private int page;
	private int pageSize;
	private String tenDeTai;
	private TypeSearch typeSearch;
	
	public int getNam() {
		return nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}
	public String getTenTacGia() {
		return tenTacGia;
	}
	public void setTenTacGia(String maTacGia) {
		this.tenTacGia = maTacGia;
	}
	public HuongNghienCuu getHuongNghienCuu() {
		return huongNghienCuu;
	}
	public void setHuongNghienCuu(HuongNghienCuu huongNghienCuu) {
		this.huongNghienCuu = huongNghienCuu;
	}
	public LoaiDeTai getLoaiDeTai() {
		return loaiDeTai;
	}
	public void setLoaiDeTai(LoaiDeTai loaiDeTai) {
		this.loaiDeTai = loaiDeTai;
	}
	public DanhGia getDanhGia() {
		return danhGia;
	}
	public void setDanhGia(DanhGia danhGia) {
		this.danhGia = danhGia;
	}
	public Calendar getThoiGianNghiemThu() {
		return thoiGianNghiemThu;
	}
	public void setThoiGianNghiemThu(Calendar thoiGianNghiemThu) {
		this.thoiGianNghiemThu = thoiGianNghiemThu;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getTenDeTai() {
		return tenDeTai;
	}
	public void setTenDeTai(String tenDeTai) {
		this.tenDeTai = tenDeTai;
	}
	public TypeSearch getTypeSearch() {
		return typeSearch;
	}
	public void setTypeSearch(TypeSearch typeSearch) {
		this.typeSearch = typeSearch;
	}
	
	
}
