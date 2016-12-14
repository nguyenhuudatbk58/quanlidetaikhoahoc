package quanlidetaikhoahoc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseHibernateDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	protected boolean isClosed() {
		return sessionFactory.isClosed();
	}
	
	
	
}
