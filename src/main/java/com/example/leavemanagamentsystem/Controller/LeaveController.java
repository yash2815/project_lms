package com.example.leavemanagamentsystem.Controller;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.leavemanagamentsystem.Service.LeaveService;
import com.example.leavemanagamentsystem.Input.Input;
import com.example.leavemanagamentsystem.exception.IdNotFoundException;
import com.example.leavemanagamentsystem.exception.InvalidYearException;
import com.example.leavemanagamentsystem.*;

@RestController
public class LeaveController {
	
	@Autowired
	private LeaveService service;

	@RequestMapping(value="/result",method=RequestMethod.POST)
	public String getResult(@RequestBody Input input) {
		
		LocalDate startDate=null,endDate = null;
//		service.setEmployee(input.getId(),input.getName());
        String startDateStr = input.getStartDate();
        try {
         startDate = service.convertStringtoDate(startDateStr);
        }catch(DateTimeException e) {
        	return "Invalid Date Format";
        } catch (InvalidYearException e) {
			// TODO Auto-generated catch block
			return "Invalid Year! Please Enter Current Year";
		}
        String startMonth = startDate.getMonth().toString();
      
        String endDateStr = input.getEndDate();
        try {
        endDate = service.convertStringtoDate(endDateStr);
        }catch(DateTimeException e) {
        	return "Invalid Date Format";
        } catch (InvalidYearException e) {
			// TODO Auto-generated catch block
        	return "Invalid Year! Please Enter Current Year";
		}
        endDate = endDate.plusDays(1);
        String endMonth = endDate.getMonth().toString();
        
        int daysRequested = (int) ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("Days : " + daysRequested);
        int holidays = service.calculateHolidays(startDate,endDate);
        
        //Actual Leaves needed
        daysRequested -= holidays; 
        
        System.out.println("Holidays :" + holidays);
        
        System.out.println("Leaves Requested : " + daysRequested);
        
        int availableLeavesInMonth = 0;
        
        Employee emp = null;
		try {
			emp = service.getEmployeeById(input.getId());
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			return(e.getMessage());
		}
         service.convertToMap(emp);
        if(!service.checkMonth(startDate, endDate)) {
        	availableLeavesInMonth = service.getLeaves(endMonth) + service.getLeaves(startMonth);
        }else {
         availableLeavesInMonth = service.getLeaves(endMonth);
        }
        
       // gives all pending leaves including startDate month
        int PendingLeaves = service.getPendingLeaves(endMonth);
        
        if(PendingLeaves > daysRequested && !(service.checkMonth(startDate, endDate)) && daysRequested==2) {
        	service.setLeavesforDiffTwoMonth(startMonth, endMonth);
        	return "Requested Leaves are applied";
        }
        
        if(service.checkLeavesInMonth(daysRequested,availableLeavesInMonth)) {
        	return "Requested Leaves are applied";
        }
        
       
        
        System.out.println("Leaves Pending : " + PendingLeaves);
        
        if(PendingLeaves < daysRequested ) {
        	return "Leaves Request denied due to insufficient pending Leaves. Pending Leaves are " + PendingLeaves;
        }else {
        	service.setPendingLeaves(daysRequested,startMonth,endMonth);
        	return "Leaves Request Applied";
        }
	}

}


