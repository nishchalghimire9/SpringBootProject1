package com.Insurance.serarchRequest;



import lombok.Data;

@Data
public class SearchRequest {
	
    private String planName;
    private String planStatus;
    private String gender;
  
    private String startDate;
    //@DateTimeFormat(pattern ="dd-mm-yyyy")
    private String endDate;
}


