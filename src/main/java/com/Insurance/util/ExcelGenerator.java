package com.Insurance.util;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Insurance.Repository.CitizenPlanRepo;
import com.Insurance.entity.CitizenPlan;
@Component
public class ExcelGenerator {
	
	
public boolean generate(HttpServletResponse response, List<CitizenPlan> records) throws Exception {
		
		Workbook workbook = new XSSFWorkbook();
		Sheet  sheet = workbook.createSheet("plans-data");
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("CitizenName");
		headerRow.createCell(2).setCellValue("gender");
		headerRow.createCell(3).setCellValue("PlanName");
		headerRow.createCell(4).setCellValue("PlanStatus");
		headerRow.createCell(5).setCellValue("PlanStartDate");
		headerRow.createCell(6).setCellValue("PlanEndDate");
		headerRow.createCell(7).setCellValue("BenifitAmount");
		
		
		
		int dataRowIndex =1;
		for(CitizenPlan plan :records) {
			Row dataRow =sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(plan.getCitizenId());
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(2).setCellValue(plan.getGender());
			dataRow.createCell(3).setCellValue(plan.getPlanName());
			dataRow.createCell(4).setCellValue(plan.getPlanStatus());
			if(null!= plan.getPlanStartDate()) {
			dataRow.createCell(5).setCellValue(plan.getPlanStartDate()+ ""); // if ther is not data it will come null so to set NA
			}else {dataRow.createCell(5).setCellValue("NA");
			
			}
			if(null!= plan.getPlanEndDate()) {
				dataRow.createCell(6).setCellValue(plan.getPlanEndDate()+ ""); // if ther is not data it will come null so to set NA
				}else {dataRow.createCell(6).setCellValue("NA");
				
				}
			if(null!= plan.getBenefitAmount()) {
			dataRow.createCell(7).setCellValue(plan.getBenefitAmount());
			}else {dataRow.createCell(7).setCellValue("NA");
				
			}
			dataRowIndex++;
		}
		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		return true;
	}

	
}
