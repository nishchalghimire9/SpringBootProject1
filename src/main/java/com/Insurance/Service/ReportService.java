package com.Insurance.Service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.Insurance.entity.CitizenPlan;
import com.Insurance.serarchRequest.SearchRequest;

public interface ReportService {
	
	   public List<String> getPlanNames();
	    public List<String> getPlanStatus();
	    public List<CitizenPlan> search(SearchRequest request);
	    public boolean exportExcel(HttpServletResponse response) throws Exception;
	    public boolean exportPdf(HttpServletResponse response) throws Exception;
	}
