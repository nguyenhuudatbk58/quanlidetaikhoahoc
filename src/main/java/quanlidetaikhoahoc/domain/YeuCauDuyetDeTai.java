package quanlidetaikhoahoc.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "yeu_cau_duyet_de_tai")
@JsonSerialize(using=YeuCauSerializer.class)
public class YeuCauDuyetDeTai {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nguoi_dung_id")
	private NguoiDung nguoiDung;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "de_tai_id")
	private DeTai deTai;


	@Column(name = "thoi_gian_tao")
	@Temporal(TemporalType.DATE)
	private Date thoiGianTao;

	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}

	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

	public DeTai getDeTai() {
		return deTai;
	}

	public void setDeTai(DeTai deTai) {
		this.deTai = deTai;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getThoiGianTao() {
		return thoiGianTao;
	}

	public void setThoiGianTao(Date thoiGianTao) {
		this.thoiGianTao = thoiGianTao;
	}

}
