package com.Insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Insurance.Service.ReportService;
import com.Insurance.entity.CitizenPlan;
import com.Insurance.serarchRequest.SearchRequest;

@Controller
public class InsuranceController {

	@Autowired
	private ReportService reportService;
	
	@PostMapping("/search")
	public String handleSearch(SearchRequest request, Model model) {
		System.out.println(request);
		
		List<CitizenPlan> plans = reportService.search(request);
		model.addAttribute("plans" , plans);
		
		init (model);
		
		return "index";
	}
	
	@GetMapping("/")
	public String indexPage(Model model) {
		//SearchRequest searchObj = new SearchRequest();
		//model.addAttribute("searched", searchObj);
		//or 
		//model.addAttribute("search",  new SearchRequest());
		
		init(model);
		return "index";
	}

	private void init(Model model) {
		model.addAttribute("search",  new SearchRequest());
		model.addAttribute("plansName", reportService.getPlanNames());
		model.addAttribute("planStatus", reportService.getPlanStatus());
	}
	
}
