package quanlidetaikhoahoc.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quanlidetaikhoahoc.domain.ThongBao;

@Repository
@Transactional
public class ThongBaoDAO extends BaseHibernateDAO {

	public void save(ThongBao thongBao) {
		getCurrentSession().save(thongBao);
	}

	@SuppressWarnings("unchecked")
	public List<ThongBao> get(int page, int pageSize) {
		int offset = (page - 1) * pageSize;
		Query query = getCurrentSession().createQuery("from ThongBao");
		query.setFirstResult(offset);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	public int count() {
		CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<ThongBao> tb = criteriaQuery.from(ThongBao.class);
		criteriaQuery.select(criteriaBuilder.count(tb));
		Query query = getCurrentSession().createQuery(criteriaQuery);
		Long count = (Long) query.getSingleResult();
		return count.intValue();

	}

	public ThongBao getById(int id) {
		return getCurrentSession().get(ThongBao.class, id);
	}

	public void delete(ThongBao thongBao) {
		getCurrentSession().delete(thongBao);
	}
}
