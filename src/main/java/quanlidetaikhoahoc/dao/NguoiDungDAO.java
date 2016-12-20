package quanlidetaikhoahoc.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quanlidetaikhoahoc.domain.NguoiDung;

@Repository
@Transactional
public class NguoiDungDAO extends BaseHibernateDAO {

	public NguoiDung save(NguoiDung nguoiDung) {
		getCurrentSession().save(nguoiDung);
		return nguoiDung;
	}

	public void update(NguoiDung nguoiDung) {
		getCurrentSession().update(nguoiDung);
	}

	public void delete(NguoiDung nguoiDung) {
		getCurrentSession().delete(nguoiDung);
	}

	@SuppressWarnings("rawtypes")
	public String getMaTacGia() {
		NativeQuery query = getCurrentSession().createNativeQuery("select max(id_nguoi_dung) from nguoi_dung");
		BigInteger maxId = (BigInteger) query.getSingleResult();
		return "NCKH" + (maxId.intValue() + 1);
	}

	@SuppressWarnings("unchecked")
	public NguoiDung getByMaTacGia(String maTacGia) {
		Query<NguoiDung> query = getCurrentSession().createQuery("from NguoiDung where maTacGia= :maTacGia");
		query.setParameter("maTacGia", maTacGia);
		NguoiDung nguoiDung = query.getSingleResult();
		return nguoiDung;
	}

	public NguoiDung getById(long id) {
		return getCurrentSession().get(NguoiDung.class, id);
	}

	@SuppressWarnings("rawtypes")
	public int count(String dieuKienTimKiem) {

		CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<NguoiDung> nd = criteriaQuery.from(NguoiDung.class);
		Predicate predicate = null;
		criteriaQuery.select(criteriaBuilder.count(nd));
		if (!dieuKienTimKiem.equals("")) {
			Predicate maTacGiaPredicate = criteriaBuilder.equal(nd.get("maTacGia"), dieuKienTimKiem);
			Predicate tenTacGiaPredicate = criteriaBuilder.like(nd.<String> get("tenTacGia"), dieuKienTimKiem + "%");
			predicate = criteriaBuilder.or(maTacGiaPredicate, tenTacGiaPredicate);

			Predicate activePredicate = criteriaBuilder.equal(nd.get("active"), true);
			predicate = criteriaBuilder.and(activePredicate, predicate);
		} else {
			Predicate activePredicate = criteriaBuilder.equal(nd.get("active"), true);
			predicate = activePredicate;
		}
		criteriaQuery.where(predicate);

		Query query = getCurrentSession().createQuery(criteriaQuery);
		Long count = (Long) query.getSingleResult();

		return count.intValue();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<NguoiDung> search(int pageSize, int offset, String dieuKienTimKiem) {
		CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<NguoiDung> criteriaQuery = criteriaBuilder.createQuery(NguoiDung.class);
		Root<NguoiDung> nd = criteriaQuery.from(NguoiDung.class);
		criteriaQuery.select(nd);
		Predicate predicate = null;
		if (!dieuKienTimKiem.equals("")) {
			Predicate maTacGiaPredicate = criteriaBuilder.equal(nd.get("maTacGia"), dieuKienTimKiem);
			Predicate tenTacGiaPredicate = criteriaBuilder.like(nd.<String> get("tenTacGia"), dieuKienTimKiem);
			predicate = criteriaBuilder.or(maTacGiaPredicate, tenTacGiaPredicate);

			Predicate activePredicate = criteriaBuilder.equal(nd.get("active"), true);
			predicate = criteriaBuilder.and(activePredicate, predicate);

		} else {
			Predicate activePredicate = criteriaBuilder.equal(nd.get("active"), true);
			predicate = activePredicate;
		}
		criteriaQuery.where(predicate);

		Query query = getCurrentSession().createQuery(criteriaQuery);
		query.setFirstResult(offset);
		query.setMaxResults(pageSize);

		return query.getResultList();

	}
	
	@SuppressWarnings("unchecked")
	public List<NguoiDung> getAll(){
		javax.persistence.Query query = getCurrentSession().createQuery("from NguoiDung");
		return query.getResultList();
	}
}
