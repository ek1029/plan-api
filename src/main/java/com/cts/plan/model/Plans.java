package com.cts.plan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "PLANS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@NamedQueries({
	
	@NamedQuery(name = "Plans.fetchByPlanId", query = "SELECT p FROM Plans p WHERE p.planId= :planId") 

})

public class Plans {

	@Id
	@GeneratedValue
	int no;
	String planId;
	String planName;
	String status;
	
}
