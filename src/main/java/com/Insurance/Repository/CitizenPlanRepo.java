package com.Insurance.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Insurance.entity.CitizenPlan;

public interface CitizenPlanRepo  extends JpaRepository <CitizenPlan, Integer> {
	
	  @Query("select distinct(planName) from CitizenPlan") // this will use to create drop down list in front end 
	    public List<String> getPlanNames();

	    @Query("select distinct(planStatus) from CitizenPlan") // // this will use to create drop down list in front end 
	    public List<String> getPlanStatus();	

}
