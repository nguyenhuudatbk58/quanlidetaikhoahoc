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
		AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(
				RootConfig.class);
		configApplicationContext.register(NguoiDungDAO.class);
		configApplicationContext.register(DeTaiDAO.class);

		NguoiDungDAO nguoiDungDAO = (NguoiDungDAO) configApplicationContext.getBean("nguoiDungDAO");
		DeTaiDAO deTaiDAO = (DeTaiDAO) configApplicationContext.getBean("deTaiDAO");
		DeTai deTai = new DeTai();
		deTai.setMaDeTai("KH18");
		TrangThaiDeTai trangThaiDeTai = new TrangThaiDeTai();
		trangThaiDeTai.setId(1);
		LoaiDeTai loaiDeTai = new LoaiDeTai();
		loaiDeTai.setId(2);
		HuongNghienCuu huongNghienCuu = new HuongNghienCuu();
		huongNghienCuu.setId(1);
		deTai.setHuongNghienCuu(huongNghienCuu);
		deTai.setLoaiDeTai(loaiDeTai);
		deTai.setTrangThai(trangThaiDeTai);
		deTai.setDuyet(true);
		deTai.setTen("Nghiên cứu phương pháp biểu diễn hiệu quả nội dung ảnh số cho bài toán gán đa nhãn");
		deTai.setNam(2013);
		Calendar t = Calendar.getInstance();
		t.set(2013, 2, 10);
		deTai.setThoiGianBatDau(t);
		Calendar t2 = Calendar.getInstance();
		t.set(2013, 8, 5);
		deTai.setThoiGianKetThuc(t2);

		NguoiDung nguoiDung = new NguoiDung();
		nguoiDung.setIdNguoiDung(2);

		deTai.setTacGia(nguoiDung);

		deTaiDAO.save(deTai);
	}

}
