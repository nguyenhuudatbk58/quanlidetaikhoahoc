package quanlidetaikhoahoc.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quanlidetaikhoahoc.domain.YeuCauDuyetDeTai;

@Repository
@Transactional
public class YeuCauDuyetDeTaiDAO extends BaseHibernateDAO{

	public YeuCauDuyetDeTai save(YeuCauDuyetDeTai yeuCau){
		getCurrentSession().save(yeuCau);
		return yeuCau;
	}		
	public void delete(YeuCauDuyetDeTai yeuCau){
		getCurrentSession().delete(yeuCau);
	}
	
	@SuppressWarnings("unchecked")
	public List<YeuCauDuyetDeTai> get(int page,int pageSize){
		int offset = (page-1)*pageSize;
		Query query = getCurrentSession().createQuery("from YeuCauDuyetDeTai order by thoiGianTao desc");
		query.setFirstResult(offset);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}
	public int count(){
		CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<YeuCauDuyetDeTai> yc = criteriaQuery.from(YeuCauDuyetDeTai.class);
		criteriaQuery.select(criteriaBuilder.count(yc));
		Query query = getCurrentSession().createQuery(criteriaQuery);
		Long count = (Long) query.getSingleResult();
		return count.intValue();
	}
}
