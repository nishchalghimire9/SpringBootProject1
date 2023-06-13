package com.Insurance.Service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.Insurance.Repository.CitizenPlanRepo;
import com.Insurance.entity.CitizenPlan;
import com.Insurance.serarchRequest.SearchRequest;
@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	 private CitizenPlanRepo PlanRepo;
	@Override
	public List<String> getPlanNames() {
		List<String> planeNames = PlanRepo.getPlanNames();  // line 15 and line 24 does the same.
		return planeNames;
	}

	@Override
	public List<String> getPlanStatus() {
		return PlanRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		// this is used to search dynamically if we used return PlanRepo.findAll(); we can fetch all the data reside in the database
		CitizenPlan entity = new CitizenPlan();
		
		if(null!=request.getPlanName()&& !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if(null!=request.getPlanStatus()&& !"".equals(request.getPlanName())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if(null!=request.getGender()&& !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		
//		BeanUtils.copyProperties(request, entity);
//		BeanUtils.copyProperties(request, entity);
		return PlanRepo.findAll(Example.of(entity));
//		return PlanRepo.findAll();
		
		
	}

	@Override
	public boolean exportExcel() {
		return false;
	}

	@Override
	public boolean exportPdf() {
		return false;
	}

}
