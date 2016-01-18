package com.zhengcj.bizservice;

import java.util.List;

import com.zhengcj.domain.Student;

public interface StudentBS {

	public List<Student> getList();

	public void addStudent(Student student) throws Exception;
}
