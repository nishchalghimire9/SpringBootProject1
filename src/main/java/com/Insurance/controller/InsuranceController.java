package com.Insurance.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
	
	
	// to download the excellfile
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		response.addHeader("content-Disposition" ,"attachment;filename =plans.xlsx");
		reportService.exportExcel(response);
	}
	@GetMapping("/pdf")
	public void PdfExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		response.addHeader("content-Disposition" ,"attachment;filename =plans.pdf");
		reportService.exportPdf(response);
	}
	@PostMapping("/search")
	public String handleSearch(SearchRequest searched, Model model) {
				
		List<CitizenPlan> plans = reportService.search(searched);
		model.addAttribute("plans" , plans);
		model.addAttribute("search" , searched);
		
		init (model);
		
		return "index";
	}
	
	/* this method is used to load the index page */
	@GetMapping("/")
	public String indexPage(Model model) {
		//SearchRequest searchObj = new SearchRequest();
		//model.addAttribute("searched", searchObj);
		//or 
		model.addAttribute("search",  new SearchRequest());
		
		init(model);
		return "index";
	}

	private void init(Model model) {
		//model.addAttribute("search",  new SearchRequest());
		model.addAttribute("plansName", reportService.getPlanNames());
		model.addAttribute("planStatus", reportService.getPlanStatus());
	}
	
}
