package com.cts.plan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cts.plan.model.MemberDetail;
import com.cts.plan.model.Plans;

@Repository
public class PlanDao {
	private final static Logger logger = LoggerFactory.getLogger(PlanDao.class);
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public List<MemberDetail> persistMember(List<MemberDetail> memberDetailList) {
		for(MemberDetail memberDetail : memberDetailList)
			em.persist(memberDetail);
		logger.info("Persisted Members");
		return memberDetailList;
	}
	
	public  Plans fetchPlanById(String planId){
		Plans plans = null;
		Query query = em.createNamedQuery("Plans.fetchByPlanId")
						.setParameter("planId", planId);
		try {
				plans = (Plans) query.getSingleResult();
		}catch(NoResultException e) {
			logger.error("Requested Plan "+planId+ "dosen't exists");
		}
		
		return plans;
	}
}
