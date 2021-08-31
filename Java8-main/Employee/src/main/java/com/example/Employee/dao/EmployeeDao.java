package com.example.Employee.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Employee.model.Employee;



@Transactional
@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer>{

}
