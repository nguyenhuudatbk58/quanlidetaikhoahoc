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
@Table(name="huong_nghien_cuu")
public class HuongNghienCuu {


  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @JsonView(value=Views.ReviewDeTai.class)
  private int id;
  
  @Column(name="ten")
  @JsonView(value=Views.ReviewDeTai.class)
  private String ten;
  
  public HuongNghienCuu(){
	  
  }
  public HuongNghienCuu(int id, String ten) {
	
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
