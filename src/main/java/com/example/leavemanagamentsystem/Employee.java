//Define the package that this file belongs to
package com.example.leavemanagamentsystem;

//Import statements for necessary classes
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;



import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emp")
public class Employee {
	@Id
    @NonNull private int Emp_Id;
    private String Emp_Name;
    private int JANUARY;
    private int FEBRUARY;
    private int MARCH;
    private int APRIL;
    private int MAY;
    private int JUNE;
    private int JULY;
    private int AUGUST;
    private int SEPTEMBER;
    private int OCTOBER;
    private int NOVEMBER;
    private int DECEMBER;
    
//    public Employee() {
//    	
//    	this.JANUARY=2;
//    	this.FEBRUARY=2;
//    	this.MARCH=2;
//    	this.APRIL=2;
//    	this.MAY=2;
//    	this.JUNE=2;
//    	this.JULY=2;
//    	this.AUGUST=2;
//    	this.SEPTEMBER=2;
//    	this.OCTOBER=2;
//    	this.NOVEMBER=2;
//    	this.DECEMBER=2;
//    	
//    }
//    
//    public Employee(int id,String name) {
//    	this.Emp_Id=id;
//    	this.Emp_Name=name;
//    	this.JANUARY=2;
//    	this.FEBRUARY=2;
//    	this.MARCH=2;
//    	this.APRIL=2;
//    	this.MAY=2;
//    	this.JUNE=2;
//    	this.JULY=2;
//    	this.AUGUST=2;
//    	this.SEPTEMBER=2;
//    	this.OCTOBER=2;
//    	this.NOVEMBER=2;
//    	this.DECEMBER=2;
//    }
//    
    
    
public int getEmp_Id() {
		return Emp_Id;
	}



	public void setEmp_Id(int emp_Id) {
		Emp_Id = emp_Id;
	}



	public String getEmp_Name() {
		return Emp_Name;
	}



	public void setEmp_Name(String emp_Name) {
		Emp_Name = emp_Name;
	}



public int getJANUARY() {
		return JANUARY;
	}

	public void setJANUARY(int jANUARY) {
		JANUARY = jANUARY;
	}

	public int getFEBRUARY() {
		return FEBRUARY;
	}

	public void setFEBRUARY(int fEBRUARY) {
		FEBRUARY = fEBRUARY;
	}

	public int getMARCH() {
		return MARCH;
	}

	public void setMARCH(int mARCH) {
		MARCH = mARCH;
	}

	public int getAPRIL() {
		return APRIL;
	}

	public void setAPRIL(int aPRIL) {
		APRIL = aPRIL;
	}

	public int getMAY() {
		return MAY;
	}

	public void setMAY(int mAY) {
		MAY = mAY;
	}

	public int getJUNE() {
		return JUNE;
	}

	public void setJUNE(int jUNE) {
		JUNE = jUNE;
	}

	public int getJULY() {
		return JULY;
	}

	public void setJULY(int jULY) {
		JULY = jULY;
	}

	public int getAUGUST() {
		return AUGUST;
	}

	public void setAUGUST(int aUGUST) {
		AUGUST = aUGUST;
	}

	public int getSEPTEMBER() {
		return SEPTEMBER;
	}

	public void setSEPTEMBER(int sEPTEMBER) {
		SEPTEMBER = sEPTEMBER;
	}

	public int getOCTOBER() {
		return OCTOBER;
	}

	public void setOCTOBER(int oCTOBER) {
		OCTOBER = oCTOBER;
	}

	public int getNOVEMBER() {
		return NOVEMBER;
	}

	public void setNOVEMBER(int nOVEMBER) {
		NOVEMBER = nOVEMBER;
	}

	public int getDECEMBER() {
		return DECEMBER;
	}

	public void setDECEMBER(int dECEMBER) {
		DECEMBER = dECEMBER;
	}

	//    private  LinkedHashMap<String, Integer> leaves;
//    
    
//    , , APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
//    //Constructor for creating new Employee objects
//    public Employee(int id, String name) {
//        
//        //Initialize the instance variables
//        this.id = id;
//        this.name = name;
//        this.leaves = new LinkedHashMap<String,Integer>();
//        this.leaves.put("JANUARY", 2);
//        this.leaves.put("FEBRUARY", 2);
//        this.leaves.put("MARCH", 2);
//        this.leaves.put("APRIL", 2);
//        this.leaves.put("MAY", 2);
//        this.leaves.put("JUNE", 2);
//        this.leaves.put("JULY", 2);
//        this.leaves.put("AUGUST", 2);
//        this.leaves.put("SEPTEMBER", 2);
//        this.leaves.put("OCTOBER", 2);
//        this.leaves.put("NOVEMBER", 2);
//        this.leaves.put("DECEMBER", 2);
//        
//        // Calculate the total leaves and store it in the instance variable
////        this.totalLeaves = this.leaves.values().stream().mapToInt(Integer::intValue).sum();
//        
//    }
    

//	public LinkedHashMap<String,Integer> getLeaves() {
//		return leaves;
//	}
//
//	public void setLeaves(LinkedHashMap<String, Integer> leaves) {
//		this.leaves = leaves;
//	}
}
	//method for applying leave
   