package com.springboot.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.springboot.jpa.dao.Studentdao;
import com.springboot.jpa.domain.Student;
import com.springboot.jpa.domain.StudentQuery;

@Service
public class studentqueryservicelmp implements studentqueryservice{
    @Autowired
    Studentdao studentdao;
	@Override
	public Page<Student> findstudentNo(Integer page, Integer size) {
		Pageable pageable=new PageRequest(page, size,Sort.Direction.ASC, "id");
		return studentdao.findAll(pageable);
	}

	@Override
	public Page<Student> findstudent(Integer page, Integer size, final StudentQuery Sq) {
		Pageable pageable=new PageRequest(page,size,Sort.Direction.ASC,"id");
		Page<Student>studentpage=studentdao.findAll(new Specification<Student>(){
			@Override
			public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list=new ArrayList<Predicate>();
				if(null!=Sq.getName()&&!"".equals(Sq.getName())){
					list.add(cb.equal(root.get("name").as(String.class), Sq.getName()));
				}
				if(null!=String.valueOf(Sq.getAge())&&!"".equals(Sq.getAge())){
				    list.add(cb.equal(root.get("age").as(String.class), Sq.getAge()));	
				}
				Predicate[] p=new Predicate[list.size()];
				return cb.and(list.toArray(p));
			}
		},pageable);
		return studentpage;
	}
}
