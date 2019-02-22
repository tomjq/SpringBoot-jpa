package com.springboot.jpa.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.jpa.SpringBoot;
import com.springboot.jpa.dao.Studentdao;
import com.springboot.jpa.domain.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringBoot.class)
public class StudentTest {
	@Autowired
	private Studentdao studentdao;
	@Test
	public void studtest(){
		Student s=new Student();
		s.setName("zhangsan");
		s.setAge(16);
		studentdao.save(s);
		
	}
}
