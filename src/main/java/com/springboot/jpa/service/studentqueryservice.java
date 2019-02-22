package com.springboot.jpa.service;

import org.springframework.data.domain.Page;

import com.springboot.jpa.domain.Student;
import com.springboot.jpa.domain.StudentQuery;

public interface studentqueryservice {
	Page<Student> findstudentNo(Integer page,Integer size);//当前页数，每页显示的数据；
	Page<Student> findstudent(Integer page,Integer size,StudentQuery Sq);

}
