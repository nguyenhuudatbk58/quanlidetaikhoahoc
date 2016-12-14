package quanlidetaikhoahoc.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "de_tai")
public class DeTai {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_de_tai")
	@JsonView(value=Views.ReviewDeTai.class)
	private long idDeTai;

	@Column(name = "ma_de_tai")
	@JsonView(value=Views.ReviewDeTai.class)
	private String maDeTai;

	@Column(name = "ten")
	@JsonView(value=Views.ReviewDeTai.class)
	private String ten;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nguoi_dung_id")
	@JsonView(value=Views.ReviewDeTai.class)
	private NguoiDung tacGia;

	@Column(name = "mo_ta")
	private String moTa;

	@Column(name = "thoi_gian_bat_dau")
	@Temporal(TemporalType.DATE)
	@JsonView(value=Views.ReviewDeTai.class)
	private Calendar thoiGianBatDau;

	@Column(name = "thoi_gian_ket_thuc")
	@Temporal(TemporalType.DATE)
	@JsonView(value=Views.ReviewDeTai.class)
	private Calendar thoiGianKetThuc;

	@Column(name = "ly_do_huy")
	private String lyDoHuy;

	@Column(name = "thoi_gian_nghiem_thu")
	@Temporal(TemporalType.DATE)
	private Calendar thoiGianNghiemThu;

	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name="loai_de_tai")
	@JsonView(value=Views.ReviewDeTai.class)
	private LoaiDeTai loaiDeTai;

	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name="huong_nghien_cuu")
	@JsonView(value=Views.ReviewDeTai.class)
	private HuongNghienCuu huongNghienCuu;

	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name="trang_thai")
	@JsonView(value=Views.ReviewDeTai.class)
	private TrangThaiDeTai trangThai;

	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name="danh_gia")
	private DanhGia danhGia;

	@Column(name = "nam")
	private int nam;
	
	@Column(name="duyet")
	private boolean duyet;

	public long getIdDeTai() {
		return idDeTai;
	}

	public void setIdDeTai(long idDeTai) {
		this.idDeTai = idDeTai;
	}

	public String getMaDeTai() {
		return maDeTai;
	}

	public void setMaDeTai(String maDeTai) {
		this.maDeTai = maDeTai;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public NguoiDung getNguoiDung() {
		return tacGia;
	}

	public void setNguoiDung(NguoiDung nguoiDung) {
		this.tacGia = nguoiDung;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Calendar getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(Calendar thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public Calendar getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(Calendar thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public String getLyDoHuy() {
		return lyDoHuy;
	}

	public void setLyDoHuy(String lyDoHuy) {
		this.lyDoHuy = lyDoHuy;
	}

	public Calendar getThoiGianNghiemThu() {
		return thoiGianNghiemThu;
	}

	public void setThoiGianNghiemThu(Calendar thoiGianNghiemThu) {
		this.thoiGianNghiemThu = thoiGianNghiemThu;
	}

	public LoaiDeTai getLoaiDeTai() {
		return loaiDeTai;
	}

	public void setLoaiDeTai(LoaiDeTai loaiDeTai) {
		this.loaiDeTai = loaiDeTai;
	}

	public HuongNghienCuu getHuongNghienCuu() {
		return huongNghienCuu;
	}

	public void setHuongNghienCuu(HuongNghienCuu huongNghienCuu) {
		this.huongNghienCuu = huongNghienCuu;
	}

	public NguoiDung getTacGia() {
		return tacGia;
	}

	public void setTacGia(NguoiDung tacGia) {
		this.tacGia = tacGia;
	}

	public TrangThaiDeTai getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(TrangThaiDeTai trangThai) {
		this.trangThai = trangThai;
	}

	public DanhGia getDanhGia() {
		return danhGia;
	}

	public void setDanhGia(DanhGia danhGia) {
		this.danhGia = danhGia;
	}

	public int getNam() {
		return nam;
	}

	public void setNam(int nam) {
		this.nam = nam;
	}

	public boolean isDuyet() {
		return duyet;
	}

	public void setDuyet(boolean duyet) {
		this.duyet = duyet;
	}
	
	

}
