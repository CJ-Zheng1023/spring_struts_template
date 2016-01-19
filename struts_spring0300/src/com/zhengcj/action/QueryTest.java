package com.zhengcj.action;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhengcj.bizservice.StudentBS;
import com.zhengcj.domain.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class QueryTest {
	private StudentBS studentBS;
	
	@Resource(name="zhengcj.studentBS")
	public void setStudentBS(StudentBS studentBS) {
		this.studentBS = studentBS;
	}
	@Test
	public void testFunction(){
		List<Student> list=studentBS.getList();
		System.out.println("query stop!!!!!");
	}
	
}
