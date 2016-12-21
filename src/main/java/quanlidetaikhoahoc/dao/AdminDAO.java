package quanlidetaikhoahoc.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quanlidetaikhoahoc.domain.Admin;

@Repository
@Transactional
public class AdminDAO extends BaseHibernateDAO {

	@SuppressWarnings("unchecked")
	public Admin getByUsername(String username) {
		Query query = getCurrentSession().createQuery("from Admin where tenTaiKhoan= :username");
		query.setParameter("username", username);
		List<Admin> admins = query.getResultList();
		if (admins.isEmpty()) {
			return null;
		} else {
			return admins.get(0);
		}
	}
}
