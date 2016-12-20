package quanlidetaikhoahoc.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quanlidetaikhoahoc.domain.DanhGia;
import quanlidetaikhoahoc.domain.DeTai;
import quanlidetaikhoahoc.domain.HuongNghienCuu;
import quanlidetaikhoahoc.domain.LoaiDeTai;
import quanlidetaikhoahoc.domain.NguoiDung;
import quanlidetaikhoahoc.domain.TrangThaiDeTai;
import quanlidetaikhoahoc.domain.YeuCauDuyetDeTai;

@Repository
@Transactional
public class DeTaiDAO extends BaseHibernateDAO {

	public DeTai save(DeTai deTai) {
		getCurrentSession().save(deTai);
		return deTai;
	}

	public void update(DeTai deTai) {
		getCurrentSession().update(deTai);
	}

	public void delete(DeTai deTai) {
		getCurrentSession().delete(deTai);
	}

	public DeTai get(long id) {
		DeTai deTai = getCurrentSession().get(DeTai.class, id);
		return deTai;
	}

	@SuppressWarnings("rawtypes")
	public String getMaDeTai() {
		NativeQuery query = getCurrentSession().createNativeQuery("select max(id_de_tai) from de_tai");
		BigInteger maxId = (BigInteger) query.getSingleResult();
		return "KH" + (maxId.intValue() + 1);
	}

	@SuppressWarnings("unchecked")
	public List<HuongNghienCuu> getHuongNghienCuu() {
		Query query = getCurrentSession().createQuery("from HuongNghienCuu");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<DanhGia> getDanhGia() {
		Query query = getCurrentSession().createQuery("from DanhGia");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Integer> getDanhSachNam() {
		Query query = getCurrentSession().createQuery("select distinct nam from DeTai where duyet = 1");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TrangThaiDeTai> getTrangThaiDeTai() {
		Query query = getCurrentSession().createQuery("from TrangThaiDeTai");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<LoaiDeTai> getLoaiDeTai() {
		Query query = getCurrentSession().createQuery("from LoaiDeTai");
		return query.getResultList();
	}

	@SuppressWarnings("rawtypes")
	public int count(String tenDeTai, int duyet) {
		String sqlString = "select count(*) from de_tai where MATCH(ten) AGAINST(:tenDeTai) and duyet = :duyet";
		if (tenDeTai.equals("")) {
			sqlString = "select count(*) from de_tai where duyet = :duyet";
		}
		System.out.println(sqlString);
		NativeQuery query = getCurrentSession().createNativeQuery(sqlString);
		if (!tenDeTai.equals("")) {
			query.setParameter("tenDeTai", tenDeTai);
		}
		query.setParameter("duyet", duyet);
		BigInteger result = (BigInteger) query.getSingleResult();
		return result.intValue();
	}

	@SuppressWarnings("unchecked")
	public List<YeuCauDuyetDeTai> getThongBao() {
		Query query = getCurrentSession().createQuery("from YeuCauDuyetDeTai order by thoiGianTao desc");
		return query.getResultList();
	}

	public int count(NguoiDung tacGia, int nam, HuongNghienCuu huongNghienCuu, LoaiDeTai loaiDeTai,
			TrangThaiDeTai trangThaiDeTai) {
		CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<DeTai> dt = criteriaQuery.from(DeTai.class);
		criteriaQuery.select(criteriaBuilder.count(dt));

		Predicate predicate = getPredicate(tacGia, nam, huongNghienCuu, loaiDeTai, trangThaiDeTai, criteriaBuilder,
				criteriaQuery, dt);
		criteriaQuery.where(predicate);
		Query query = getCurrentSession().createQuery(criteriaQuery);
		Long count = (Long) query.getSingleResult();
		return count.intValue();
	}

	@SuppressWarnings("unchecked")
	public List<DeTai> search(NguoiDung tacGia, int nam, HuongNghienCuu huongNghienCuu, LoaiDeTai loaiDeTai,
			TrangThaiDeTai trangThai, int page, int pageSize) {
		int offset = (page - 1) * pageSize;
		CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<DeTai> criteriaQuery = criteriaBuilder.createQuery(DeTai.class);
		Root<DeTai> dt = criteriaQuery.from(DeTai.class);
		criteriaQuery.select(dt);

		Predicate predicate = getPredicate(tacGia, nam, huongNghienCuu, loaiDeTai, trangThai, criteriaBuilder,
				criteriaQuery, dt);
		criteriaQuery.where(predicate);
		Query query = getCurrentSession().createQuery(criteriaQuery);
		query.setFirstResult(offset);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}

	@SuppressWarnings("unused")
	private Predicate getPredicate(NguoiDung tacGia, int nam, HuongNghienCuu huongNghienCuu, LoaiDeTai loaiDeTai,
			TrangThaiDeTai trangThai, CriteriaBuilder criteriaBuilder, CriteriaQuery<?> criteriaQuery, Root<?> dt) {
		Predicate predicate = null;

		if (nam > 0) {
			Predicate otherPredicate = criteriaBuilder.equal(dt.get("nam"), nam);
			if (predicate == null) {
				predicate = criteriaBuilder.and(otherPredicate);
			} else {
				predicate = criteriaBuilder.and(predicate, otherPredicate);
			}
		}

		if (tacGia != null) {
			Predicate otherPredicate = criteriaBuilder.equal(dt.get("tacGia"), tacGia);
			if (predicate == null) {
				predicate = criteriaBuilder.and(otherPredicate);
			} else {
				predicate = criteriaBuilder.and(predicate, otherPredicate);
			}
		}

		if (huongNghienCuu != null) {
			Predicate otherPredicate = criteriaBuilder.equal(dt.get("huongNghienCuu"), huongNghienCuu);
			if (predicate == null) {
				predicate = criteriaBuilder.and(otherPredicate);
			} else {
				predicate = criteriaBuilder.and(predicate, otherPredicate);
			}
		}

		if (loaiDeTai != null) {
			Predicate otherPredicate = criteriaBuilder.equal(dt.get("loaiDeTai"), loaiDeTai);
			if (predicate == null) {
				predicate = criteriaBuilder.and(otherPredicate);
			} else {
				predicate = criteriaBuilder.and(predicate, otherPredicate);
			}
		}
		if (trangThai != null) {
			Predicate otherPredicate = criteriaBuilder.equal(dt.get("trangThai"), trangThai);
			if (predicate == null) {
				predicate = criteriaBuilder.and(otherPredicate);
			} else {
				predicate = criteriaBuilder.and(predicate, otherPredicate);
			}
		}
		Predicate otherPredicate = criteriaBuilder.equal(dt.get("duyet"), true);
		if (predicate == null) {
			predicate = criteriaBuilder.and(otherPredicate);
		} else {
			predicate = criteriaBuilder.and(predicate, otherPredicate);
		}

		return predicate;
	}

	public List<DeTai> search(String tenDeTai, int pageSize, int page, int duyet) {
		int offset = (page - 1) * pageSize;
		String sqlString = "select * from de_tai where MATCH(ten) AGAINST(:tenDeTai) and duyet = :duyet";
		if (tenDeTai.equals("")) {
			sqlString = "select * from de_tai where duyet = :duyet";
		}
		System.out.println(sqlString);
		NativeQuery<DeTai> query = getCurrentSession().createNativeQuery(sqlString, DeTai.class);
		query.setFirstResult(offset);
		query.setMaxResults(pageSize);
		if (!tenDeTai.equals("")) {
			query.setParameter("tenDeTai", tenDeTai);
		}
		query.setParameter("duyet", duyet);
		List<DeTai> deTai = query.getResultList();

		return deTai;
	}

}
