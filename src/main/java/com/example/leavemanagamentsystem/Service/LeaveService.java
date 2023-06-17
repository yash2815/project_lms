package com.example.leavemanagamentsystem.Service;

import java.time.LocalDate;

import java.util.LinkedHashMap;
import java.util.List;

import com.example.leavemanagamentsystem.exception.IdNotFoundException;
import com.example.leavemanagamentsystem.exception.InvalidYearException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.leavemanagamentsystem.Employee;
import com.example.leavemanagamentsystem.Repository.EmployeeRepository;

@Service
public class LeaveService {
	
	@Autowired
	private EmployeeRepository repository;
	
	Employee employee = new Employee();
	
    LinkedHashMap<String,Integer> leaves = new LinkedHashMap<String,Integer>();
	
	public LinkedHashMap<String, Integer> getLeaves() {
		return leaves;
	}

	public void setLeaves(LinkedHashMap<String, Integer> leaves) {
		this.leaves = leaves;
	}
	
	public LinkedHashMap<String,Integer> getMap() {
		return leaves;
	}
	
	public Employee saveEmployee(Employee emp) {
		return repository.save(emp);
	}
	public List<Employee> saveAll(List<Employee> lst){
		return repository.saveAll(lst);
	}
	public List<Employee> getAll(){
		return repository.findAll();
	}
	public Employee getEmployeeById(int id) throws IdNotFoundException {
		Employee e = repository.findById(id).orElse(null);
		if(e == null) {
			throw new IdNotFoundException(id + " is not Registered");
		}else {
			return e;
		}
	}
	
	public void convertToMap(Employee emp)
	{
		leaves.put("JANUARY",emp.getJANUARY());
		leaves.put("FEBRUARY",emp.getFEBRUARY());
		leaves.put("MARCH",emp.getMARCH());
		leaves.put("APRIL", emp.getAPRIL());
		leaves.put("MAY", emp.getMAY());
		leaves.put("JUNE", emp.getJUNE());
		leaves.put("JULY", emp.getJULY());
		leaves.put("AUGUST", emp.getAUGUST());
		leaves.put("SEPTEMBER", emp.getSEPTEMBER());
		leaves.put("OCTOBER", emp.getOCTOBER());
		leaves.put("NOVEMBER", emp.getNOVEMBER());
		leaves.put("DECEMBER", emp.getDECEMBER());
		setLeaves(leaves);
		employee = emp;
	}
	
	
	public Employee revertFromMap(LinkedHashMap<String,Integer> leaves) {
		employee.setJANUARY(leaves.get("JANUARY"));
		employee.setFEBRUARY(leaves.get("FEBRUARY"));
		employee.setMARCH(leaves.get("MARCH"));
		employee.setAPRIL(leaves.get("APRIL"));
		employee.setMAY(leaves.get("MAY"));
		employee.setJUNE(leaves.get("JUNE"));
		employee.setJULY(leaves.get("JULY"));
		employee.setAUGUST(leaves.get("AUGUST"));
		employee.setSEPTEMBER(leaves.get("SEPTEMBER"));
		employee.setOCTOBER(leaves.get("OCTOBER"));
		employee.setNOVEMBER(leaves.get("NOVEMBER"));
		employee.setDECEMBER(leaves.get("DECEMBER"));
		return employee;
	}
	
	public Employee updateEmployee(Employee emp) {
		Employee existingEmployee = repository.findById(emp.getEmp_Id()).orElse(null);
		existingEmployee.setJANUARY(emp.getJANUARY());
		existingEmployee.setFEBRUARY(emp.getFEBRUARY());
		existingEmployee.setMARCH(emp.getMARCH());
		existingEmployee.setAPRIL(emp.getAPRIL());
		existingEmployee.setMAY(emp.getMAY());
		existingEmployee.setJUNE(emp.getJUNE());
		existingEmployee.setJULY(emp.getJULY());
		existingEmployee.setAUGUST(emp.getAUGUST());
		existingEmployee.setSEPTEMBER(emp.getSEPTEMBER());
		existingEmployee.setOCTOBER(emp.getOCTOBER());
		existingEmployee.setNOVEMBER(emp.getNOVEMBER());
		existingEmployee.setDECEMBER(emp.getDECEMBER());
		return repository.save(existingEmployee);
	}
	
	public LocalDate convertStringtoDate(String date) throws InvalidYearException  {
		LocalDate d = LocalDate.parse(date);
		if(d.getYear() != 2023) {
			throw new InvalidYearException("Invalid Year");
		}
		return d;
	}
	
	public int calculateHolidays(LocalDate startDate, LocalDate endDate) {
		int holiday = 0;
        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1))
        {
        	String day = date.getDayOfWeek().toString();
        	
            if( day.equalsIgnoreCase("Saturday") || day.equalsIgnoreCase("Sunday") ) {
            	holiday++;
            }
        }
        return holiday;
	}
	public boolean checkMonth(LocalDate startDate, LocalDate endDate) {
		if(startDate.getMonthValue() == endDate.getMonthValue()) {
		return true;
		}else {
			return false;
		}
	}
	
	public boolean checkLeavesInMonth(int daysRequested,int availableLeaves) {
		if(daysRequested <= availableLeaves) {
			return true;
	}else {
		return false;
	}
	}
	
	public void setLeavesforDiffTwoMonth(String month1,String month2) {
		updateLeaves(month1,1);
		updateLeaves(month2,1);
		updateEmployee(revertFromMap(getLeaves()));
	}

	
	public int getLeaves(String month) {
		int availableLeaves = 0;
		  availableLeaves =  leaves.get(month);
		//System.out.println(daysAvailable);
		return availableLeaves;
	}
	
	
	public void updateLeaves(String month,int availableLeaves) {
	    leaves.replace(month, availableLeaves);
	}
	
	public int getPendingLeaves(String month) {
		int pendingLeaves = 0;
		for(String mon : leaves.keySet()) {
			System.out.println();
			if(mon.equalsIgnoreCase(month)) {
				break;
			}else {
				pendingLeaves += leaves.get(mon);
			}
		}
		return pendingLeaves+leaves.get(month);
	}
	
	public void setPendingLeaves(int daysRequested,String startMonth,String month) {
		daysRequested = daysRequested - leaves.get(month);
		updateLeaves(month,0);
		if(!startMonth.equals(month)) {
		if(daysRequested<leaves.get(startMonth)) {
			updateLeaves(startMonth,leaves.get(startMonth)-daysRequested);
		}else {
			updateLeaves(startMonth,0);
			daysRequested -= 2;
		}
		}
		for(String mon : leaves.keySet()) {
			if(daysRequested > 0) {
				int availableLeaves = leaves.get(mon);
				if(daysRequested >= availableLeaves) {
					daysRequested = daysRequested - availableLeaves;
					updateLeaves(mon,0);
				}else if(daysRequested < availableLeaves ) {
					availableLeaves = availableLeaves-daysRequested;
					updateLeaves(mon,availableLeaves);
					break;
				}
			}
		}
		updateEmployee(revertFromMap(getLeaves()));
	}
}


