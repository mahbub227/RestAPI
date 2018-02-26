package com.bjit.RestAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bjit.RestAPI.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
