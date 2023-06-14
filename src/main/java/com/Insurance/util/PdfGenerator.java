package com.Insurance.util;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.Insurance.entity.CitizenPlan;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
@Component
public class PdfGenerator {


	
	public boolean generate(HttpServletResponse response, List<CitizenPlan> plans) throws Exception {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		
		
		Paragraph paragraph = new Paragraph("Citizen plan information");
		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(20);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		
		document.add(paragraph);
		
		
		PdfPTable table = new PdfPTable(8); // it will automatically goes into the another row.
		
		table.addCell("ID");
		table.addCell("CitizenName");
		table.addCell("Gender");
		table.addCell("PlanName");
		table.addCell("PlanStatus");
		table.addCell("PlanStartDate");
		table.addCell("PlanEndDate");
		table.addCell("BenifitAmount");
		
		
		for (CitizenPlan plan: plans) {
			
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getGender());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getPlanEndDate() + ""); // converting to string because we are getting date in form of string.
			table.addCell(plan.getPlanEndDate()+ "");
			table.addCell(plan.getBenefitAmount() + "");
		}
			
		
		document.add(table);

		document.close();
	return true;
}

}


