package com.cts.plan.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.plan.model.Plans;
import com.cts.plan.service.PlanServiceImpl;


@RestController
@RequestMapping("/plan")
public class PlanResource {

private static final Logger loger = LoggerFactory.getLogger(PlanResource.class);	
	
	@Autowired
	PlanServiceImpl planServiceImpl;
		
	@GetMapping(path = "/planDetail/{planId}", produces =  "application/json")
	public Plans fetchPlanById(@PathVariable(value = "planId") String planId){
		return planServiceImpl.getPlanById(planId);
	}
}
