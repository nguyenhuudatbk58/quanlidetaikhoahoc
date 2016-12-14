package quanlidetaikhoahoc.test;

import java.util.Calendar;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import quanlidetaikhoahoc.config.RootConfig;
import quanlidetaikhoahoc.dao.DeTaiDAO;
import quanlidetaikhoahoc.dao.NguoiDungDAO;
import quanlidetaikhoahoc.domain.DeTai;
import quanlidetaikhoahoc.domain.HuongNghienCuu;
import quanlidetaikhoahoc.domain.LoaiDeTai;
import quanlidetaikhoahoc.domain.NguoiDung;
import quanlidetaikhoahoc.domain.TrangThaiDeTai;

public class App {

	public static void main(String[] args) {
	/*	
		AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(
				RootConfig.class);
		configApplicationContext.register(NguoiDungDAO.class);
		configApplicationContext.register(DeTaiDAO.class);

		NguoiDungDAO nguoiDungDAO = (NguoiDungDAO) configApplicationContext.getBean("nguoiDungDAO");
		DeTaiDAO deTaiDAO = (DeTaiDAO) configApplicationContext.getBean("deTaiDAO");
		DeTai deTai = new DeTai();
		deTai.setMaDeTai("KH6");
		deTai.setTen("Tối ưu hóa mô hình kết hợp các đồ thị Markov dạng cây trong bài toán phân đoạn ảnh");
		deTai.setNam(2013);
		Calendar t = Calendar.getInstance();
		t.set(2013, 2, 3);
		Calendar t2 = Calendar.getInstance();
		t.set(2013, 11, 3);
		deTai.setThoiGianKetThuc(t2);

		NguoiDung nguoiDung = new NguoiDung();
		nguoiDung.setIdNguoiDung(3);

		deTai.setTacGia(nguoiDung);

		deTaiDAO.save(deTai);
		*/
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTimeInMillis());
	}

}
