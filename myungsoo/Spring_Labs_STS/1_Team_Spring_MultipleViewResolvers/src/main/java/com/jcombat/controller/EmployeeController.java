package com.jcombat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jcombat.bean.Employee;

@Controller
@RequestMapping(value = "/Employee")
public class EmployeeController {
	
	
	@RequestMapping(value = "/BeanNameView/{name}/{empId}", method = RequestMethod.GET)
	public ModelAndView process2(
			@PathVariable("name") String name,
			@PathVariable("empId") String empId) {
		ModelAndView modelAndView = new ModelAndView();
		Employee employee = new Employee();
		employee.setEmpId(empId);
		employee.setName(name);
		modelAndView.setViewName("jsonView");
		modelAndView.addObject("employee", employee);
		return modelAndView;
	}

	
	@RequestMapping(value = "/XmlView/{name}/{empId}", method = RequestMethod.GET)
	public ModelAndView process1(
			@PathVariable("name") String name,
			@PathVariable("empId") String empId) {
		ModelAndView modelAndView = new ModelAndView();
		
		Employee employee = new Employee();
		employee.setEmpId(empId);
		employee.setName(name);
		modelAndView.setViewName("xmlView");
		modelAndView.addObject("employee", employee);
		return modelAndView;
	}
	
	
	
	@RequestMapping(value = "/InternalResourceView/{name}/{empId}", method = RequestMethod.GET)
	public ModelAndView process3(
			@PathVariable("name") String name,
			@PathVariable("empId") String empId) {
		ModelAndView modelAndView = new ModelAndView();
		
		Employee employee = new Employee();
		employee.setEmpId(empId);
		employee.setName(name);
		modelAndView.setViewName("employeeDetails");
		modelAndView.addObject("employee", employee);
		return modelAndView;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}