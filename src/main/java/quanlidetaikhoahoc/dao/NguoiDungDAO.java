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
	
	public void delete(NguoiDung nguoiDung){
		getCurrentSession().delete(nguoiDung);
	}
	
	public String getMaTacGia(){
		NativeQuery query = getCurrentSession().createSQLQuery("select max(id_nguoi_dung) from nguoi_dung");
		BigInteger maxId = (BigInteger)query.getSingleResult();
		return "NCKH"+(maxId.intValue()+1);
	}

	@SuppressWarnings("unchecked")
	public NguoiDung getByMaTacGia(String maTacGia) {
		Query<NguoiDung> query = getCurrentSession().createQuery("from NguoiDung where maTacGia= :maTacGia");
		query.setParameter("maTacGia", maTacGia);
		NguoiDung nguoiDung = query.getSingleResult();
		return nguoiDung;
	}
	
	public NguoiDung getById(int id){
       return getCurrentSession().get(NguoiDung.class, id);
	}
	
	public int count(String dieuKienTimKiem){
		
		CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<NguoiDung> nd = criteriaQuery.from(NguoiDung.class);
		
		criteriaQuery.select(criteriaBuilder.count(nd));
		if(!dieuKienTimKiem.equals("")){
			Predicate maTacGiaPredicate = criteriaBuilder.equal(nd.get("maTacGia"), dieuKienTimKiem);
			Predicate tenTacGiaPredicate = criteriaBuilder.like(nd.<String>get("tenTacGia"), dieuKienTimKiem);
			Predicate predicate = criteriaBuilder.or(maTacGiaPredicate, tenTacGiaPredicate);
			criteriaQuery.where(predicate);
		}
		
		Query query = getCurrentSession().createQuery(criteriaQuery);
		Long count = (Long)query.getSingleResult();
		
		return count.intValue();
	}
	
	public List<NguoiDung> search(int pageSize, int offset, String dieuKienTimKiem){
		CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<NguoiDung> criteriaQuery = criteriaBuilder.createQuery(NguoiDung.class);
		Root<NguoiDung> nd = criteriaQuery.from(NguoiDung.class);
		criteriaQuery.select(nd);
		if(!dieuKienTimKiem.equals("")){
			Predicate maTacGiaPredicate = criteriaBuilder.equal(nd.get("maTacGia"), dieuKienTimKiem);
			Predicate tenTacGiaPredicate = criteriaBuilder.like(nd.<String>get("tenTacGia"), dieuKienTimKiem);
			Predicate predicate = criteriaBuilder.or(maTacGiaPredicate, tenTacGiaPredicate);
			criteriaQuery.where(predicate);
		}
		Query query = getCurrentSession().createQuery(criteriaQuery);
	    query.setFirstResult(offset);
	    query.setMaxResults(pageSize);
		
		return query.getResultList();
		 
	}
}
