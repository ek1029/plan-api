package com.cts.plan.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.plan.dao.PlanDao;
import com.cts.plan.model.MemberDetail;
import com.cts.plan.model.Plans;

@Service
public class PlanServiceImpl {

	private final static Logger logger = LoggerFactory.getLogger(PlanServiceImpl.class);
	@Autowired
	PlanDao planDao;
	
	public void saveMemberDetail(List<MemberDetail> memberDetail) {
		logger.info("Persisting memberDetail");
		planDao.persistMember(memberDetail);
		
	}
	
	public Plans getPlanById(String planId){
		return planDao.fetchPlanById(planId);
	}
	
	
}
