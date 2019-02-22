package com.springboot.jpa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.springboot.jpa.domain.Student;

public interface Studentdao extends JpaRepository<Student,Integer> ,JpaSpecificationExecutor<Student>{

	Page<Student> findAll(Specification<Student> specification, Pageable pageable);

  
}
