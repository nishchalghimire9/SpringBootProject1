package com.Insurance.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.Insurance.Repository.CitizenPlanRepo;
import com.Insurance.entity.CitizenPlan;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private CitizenPlanRepo repo;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		 repo.deleteAll(); // we have hardcoded data here so every time when we run the applilcation it will duplicate the data so we we delate first before we run
	        // cash plan data "Approved one"
	        CitizenPlan c1 = new CitizenPlan();
	        c1.setCitizenName("Mohan");
	        c1.setGender("Male");
	        c1.setPlanName("Cash");
	        c1.setPlanStatus("Approved");
	        c1.setPlanStartDate(LocalDate.now());
	        c1.setPlanEndDate(LocalDate.now().plusMonths(6));
	        c1.setBenefitAmount(5000.00);

	        // cash plan data "Denied one
	        CitizenPlan c2 = new CitizenPlan();
	        c2.setCitizenName("Prgyan");
	        c2.setGender("Male");
	        c2.setPlanName("Cash");
	        c2.setPlanStatus("Denied");
	        c2.setDenailReason("Rental Income");

	        // cash plan data "terminated one
	        CitizenPlan c3 = new CitizenPlan();
	        c3.setCitizenName("Aarya");
	        c3.setGender("Fe-Male");
	        c3.setPlanName("Cash");
	        c3.setPlanStatus("Teriminated");
	        c3.setPlanStartDate(LocalDate.now().minusMonths(4));
	        c3.setPlanEndDate(LocalDate.now().plusMonths(6));
	        c3.setBenefitAmount(5000.00);
	        c3.setTerminationDate(LocalDate.now());
	        c3.setTerminationReason("employed");


	        // Food plan data "Approved one"
	        CitizenPlan c4 = new CitizenPlan();
	        c4.setCitizenName("Aarav");
	        c4.setGender("Male");
	        c4.setPlanName("Food");
	        c4.setPlanStatus("Approved");
	        c4.setPlanStartDate(LocalDate.now());
	        c4.setPlanEndDate(LocalDate.now().plusMonths(6));
	        c4.setBenefitAmount(3500.00);

	        // Food Plan plan data "Denied one
	        CitizenPlan c5 = new CitizenPlan();
	        c5.setCitizenName("Nishchal");
	        c5.setGender("Male");
	        c5.setPlanName("Food");
	        c5.setPlanStatus("Denied");
	        c5.setDenailReason("high salary Income");

	        // Food  plan data "terminated one
	        CitizenPlan c6 = new CitizenPlan();
	        c6.setCitizenName("sangita");
	        c6.setGender("Fe-Male");
	        c6.setPlanName("Food");
	        c6.setPlanStatus("Teriminated");
	        c6.setPlanStartDate(LocalDate.now().minusMonths(4));
	        c6.setPlanEndDate(LocalDate.now().plusMonths(6));
	        c6.setBenefitAmount(300.00);
	        c6.setTerminationDate(LocalDate.now());
	        c6.setTerminationReason("employed");

	        // Medical plan data "Approved one"
	        CitizenPlan c7 = new CitizenPlan();
	        c7.setCitizenName("Kamal");
	        c7.setGender("Male");
	        c7.setPlanName("Medical");
	        c7.setPlanStatus("Approved");
	        c7.setPlanStartDate(LocalDate.now());
	        c7.setPlanEndDate(LocalDate.now().plusMonths(6));
	        c7.setBenefitAmount(3500.00);

	    // Medical plan data "Denied one"
	        CitizenPlan c8 = new CitizenPlan();
	        c8.setCitizenName("Bhagawatio");
	        c8.setGender("fe-Male");
	        c8.setPlanName("Medical");
	        c8.setPlanStatus("Denied");
	        c8.setDenailReason("high salary Income");

	        // Medical plan data "terminated one"
	        CitizenPlan c9 = new CitizenPlan();
	        c9.setCitizenName("suluchana");
	        c9.setGender("Fe-Male");
	        c9.setPlanName("Medical");
	        c9.setPlanStatus("Teriminated");
	        c9.setPlanStartDate(LocalDate.now().minusMonths(4));
	        c9.setPlanEndDate(LocalDate.now().plusMonths(6));
	        c9.setBenefitAmount(300.00);
	        c9.setTerminationDate(LocalDate.now());
	        c9.setTerminationReason("employed");

	        // Employment  plan data "Approved one"
	        CitizenPlan c10 = new CitizenPlan();
	        c10.setCitizenName("Nirmal");
	        c10.setGender("Male");
	        c10.setPlanName("Employement");
	        c10.setPlanStatus("Approved");
	        c10.setPlanStartDate(LocalDate.now());
	        c10.setPlanEndDate(LocalDate.now().plusMonths(6));
	        c10.setBenefitAmount(3500.00);

	        // Employment  plan data "Denied one"
	        CitizenPlan c11 = new CitizenPlan();
	        c11.setCitizenName("Nikita");
	        c11.setGender("fe-Male");
	        c11.setPlanName("Employement");
	        c11.setPlanStatus("Denied");
	        c11.setDenailReason("Government job");

	        // Employment  plan data "Terminated one"
	        CitizenPlan c12 = new CitizenPlan();
	        c12.setCitizenName("Morris");
	        c12.setGender("Male");
	        c12.setPlanName("Employement");
	        c12.setPlanStatus("Teriminated");
	        c12.setPlanStartDate(LocalDate.now().minusMonths(4));
	        c12.setPlanEndDate(LocalDate.now().plusMonths(6));
	        c12.setBenefitAmount(300.00);
	        c12.setTerminationDate(LocalDate.now());
	        c12.setTerminationReason("high salary");

	        List<CitizenPlan> list = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
	        repo.saveAll(list);

	    }


		
	}


