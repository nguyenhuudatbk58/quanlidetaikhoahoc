package quanlidetaikhoahoc.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import quanlidetaikhoahoc.config.RootConfig;
import quanlidetaikhoahoc.dao.DeTaiDAO;
import quanlidetaikhoahoc.dao.NguoiDungDAO;

public class App {

	private static AnnotationConfigApplicationContext configApplicationContext;

	public static void main(String[] args) {
		configApplicationContext = new AnnotationConfigApplicationContext(
				RootConfig.class);
		configApplicationContext.register(NguoiDungDAO.class);
		configApplicationContext.register(DeTaiDAO.class);

		NguoiDungDAO nguoiDungDAO = (NguoiDungDAO) configApplicationContext.getBean("nguoiDungDAO");
		nguoiDungDAO.getAll();
	}
}
