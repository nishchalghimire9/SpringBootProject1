package com.Insurance.Service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.Insurance.Repository.CitizenPlanRepo;
import com.Insurance.entity.CitizenPlan;
import com.Insurance.serarchRequest.SearchRequest;
import com.Insurance.util.EmailUtils;
import com.Insurance.util.ExcelGenerator;
import com.Insurance.util.PdfGenerator;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenPlanRepo PlanRepo;
	@Autowired
	private ExcelGenerator excelGenerator;
	@Autowired
	private PdfGenerator pdfGenerator;
	@Autowired
	private EmailUtils emailUtils;

	@Override
	public List<String> getPlanNames() {
		List<String> planeNames = PlanRepo.getPlanNames(); // line 15 and line 24 does the same.
		return planeNames;
	}

	@Override
	public List<String> getPlanStatus() {
		return PlanRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		// this is used to search dynamically if we used return PlanRepo.findAll(); we
		// can fetch all the data reside in the database
		CitizenPlan entity = new CitizenPlan();

		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}

		return PlanRepo.findAll(Example.of(entity)); // it is used to implement select dynamically

	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		List<CitizenPlan> plans = PlanRepo.findAll();
		excelGenerator.generate(response, plans);
		String subject ="Test mail subject";
		String body = "Test mail body";
		String to = "nishchalghimire9@gmail.com";
		emailUtils.sendEmail(subject, body, to);
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		List<CitizenPlan> plans = PlanRepo.findAll();
		pdfGenerator.generate(response, plans);

		return true;
	}

}
