package com.inno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.inno.dto.Student;
import com.inno.service.TemplateService;

@RestController
public class Controller {

	@Autowired private TemplateService templateService;
	
	@GetMapping("rec/{id}")
	public String getNameBydId(@PathVariable Integer id) {
		return	templateService.getNameById(id);
	}
	
	@GetMapping("student/{id}")
	public Student getStudentDetailsBydId(@PathVariable Integer id) {
		return	templateService.getStudentDetailsById(id);
	}
}
