package com.springboot.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.jpa.domain.Student;
import com.springboot.jpa.domain.StudentQuery;
import com.springboot.jpa.service.studentqueryservice;

@Controller
@RequestMapping
public class StudentController {
	@Autowired
	studentqueryservice sqs;
	@RequestMapping("/findone")
	public String findone(Model m,@RequestParam(value="page",defaultValue="0")Integer page,@RequestParam(value="size",defaultValue="3")Integer size){
		Page<Student> p=sqs.findstudentNo(page, size);
		m.addAttribute("page", p);
		return "findone";
		
	}
	@RequestMapping(value="/findall",method = {RequestMethod.POST,RequestMethod.GET})
	public String findall(Model m,@RequestParam(value="page",defaultValue="0")Integer page,@RequestParam(value="size",defaultValue="3")Integer size,@ModelAttribute("sq")StudentQuery sq){
		Page<Student> p=sqs.findstudent(page, size, sq);
		m.addAttribute("page", p);
		return "findall";
		
	}
	

}
