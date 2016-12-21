package quanlidetaikhoahoc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import quanlidetaikhoahoc.Views;

@Entity
@Table(name="loai_de_tai")
public class LoaiDeTai {
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(value=Views.ReviewDeTai.class)
	private int id;
	
	@Column(name="ten")
	@JsonView(value=Views.ReviewDeTai.class)
	private String ten;
	
	public LoaiDeTai(){
		
	}
	public LoaiDeTai(int id, String ten){
		this.id = id;
		this.ten = ten;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	
	
	


}
