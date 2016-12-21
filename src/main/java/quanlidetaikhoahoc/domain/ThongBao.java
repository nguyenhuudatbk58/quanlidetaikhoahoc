package quanlidetaikhoahoc.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "thong_bao")
public class ThongBao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_thong_bao")
	private int idThongBao;

	@Column(name = "thoi_gian_tao")
	@Temporal(value = TemporalType.DATE)
	private Date thoiGianTao;

	@Column(name = "tieu_de")
	private String tieuDe;

	@Column(name = "noi_dung")
	private String noiDung;

	public int getIdThongBao() {
		return idThongBao;
	}

	public void setIdThongBao(int idThongBao) {
		this.idThongBao = idThongBao;
	}

	public Date getThoiGianTao() {
		return thoiGianTao;
	}

	public void setThoiGianTao(Date thoiGianTao) {
		this.thoiGianTao = thoiGianTao;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

}
