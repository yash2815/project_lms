package com.example.leavemanagamentsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.leavemanagamentsystem.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
