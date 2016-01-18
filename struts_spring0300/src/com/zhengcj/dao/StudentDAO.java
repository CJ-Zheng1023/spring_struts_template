package com.zhengcj.dao;

import java.util.List;

import com.zhengcj.domain.Student;

public interface StudentDAO {

	public List<Student> queryList();

	public void insert(Student student);
}
