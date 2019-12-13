package com.douglastorquato.somaapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.douglastorquato.somaapp.entity.Employee;
import com.douglastorquato.somaapp.services.EmployeeService;

@Validated
@RestController
@RequestMapping(value="/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> listAll() {
		return employeeService.findAll();
	}
}
