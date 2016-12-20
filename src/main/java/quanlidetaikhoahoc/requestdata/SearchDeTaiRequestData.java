package quanlidetaikhoahoc.requestdata;

import quanlidetaikhoahoc.domain.HuongNghienCuu;
import quanlidetaikhoahoc.domain.LoaiDeTai;
import quanlidetaikhoahoc.domain.TrangThaiDeTai;

public class SearchDeTaiRequestData {

	private int nam;
	private long idNguoiDung;
	private HuongNghienCuu huongNghienCuu;
	private LoaiDeTai loaiDeTai;
	private TrangThaiDeTai trangThai;
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
	public long getIdNguoiDung() {
		return idNguoiDung;
	}
	public void setIdNguoiDung(long idNguoiDung) {
		this.idNguoiDung = idNguoiDung;
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
	
	
	public TrangThaiDeTai getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(TrangThaiDeTai trangThai) {
		this.trangThai = trangThai;
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
