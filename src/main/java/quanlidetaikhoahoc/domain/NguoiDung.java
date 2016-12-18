package quanlidetaikhoahoc.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "nguoi_dung")
public class NguoiDung {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_nguoi_dung")
	@JsonView(value={Views.ReviewUser.class})
	private long idNguoiDung;

	@Column(name = "ma_tac_gia")
	@JsonView(value={Views.ReviewDeTai.class,Views.ReviewUser.class})
	private String maTacGia;

	@Column(name = "mat_khau")
	private String matKhau;

	@Column(name = "token")
	private String token;

	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private Role role;

	@Column(name = "ten_tac_gia")
	@JsonView(value={Views.ReviewDeTai.class,Views.ReviewUser.class})
	private String tenTacGia;

	@Column(name = "nghe_nghiep")
	private String ngheNghiep;

	@Column(name = "sdt")
	@JsonView(value={Views.ReviewUser.class})
	private String sdt;

	@Column(name = "email")
	@JsonView(value={Views.ReviewUser.class})
	private String email;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "dong_tac_gia", joinColumns = @JoinColumn(name = "tac_gia_id"))
	@Column(name = "ten")
	private Set<String> dsDongTacGia = new HashSet<String>();

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "tacGia")
	private Set<DeTai> dsDeTai = new HashSet<DeTai>();
	
	
	@Column(name="active")
	private boolean active;


	public long getIdNguoiDung() {
		return idNguoiDung;
	}

	public void setIdNguoiDung(long idNguoiDung) {
		this.idNguoiDung = idNguoiDung;
	}

	public String getMaTacGia() {
		return maTacGia;
	}

	public void setMaTacGia(String maTacGia) {
		this.maTacGia = maTacGia;
	}

	public String getTenTacGia() {
		return tenTacGia;
	}

	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}

	public String getNgheNghiep() {
		return ngheNghiep;
	}

	public void setNgheNghiep(String ngheNghiep) {
		this.ngheNghiep = ngheNghiep;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getDsDongTacGia() {
		return dsDongTacGia;
	}

	public void setDsDongTacGia(Set<String> dsDongTacGia) {
		this.dsDongTacGia = dsDongTacGia;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<DeTai> getDsDeTai() {
		return dsDeTai;
	}
	

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setDsDeTai(Set<DeTai> dsDeTai) {
		this.dsDeTai = dsDeTai;
	}

}
