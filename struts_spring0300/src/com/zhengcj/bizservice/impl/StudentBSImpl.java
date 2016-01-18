package com.zhengcj.bizservice.impl;

import java.util.List;

import com.zhengcj.bizservice.StudentBS;
import com.zhengcj.dao.StudentDAO;
import com.zhengcj.domain.Student;

public class StudentBSImpl implements StudentBS {

	private StudentDAO studentDao = null;

	/*
	 * public void setStudentDao(StudentDAO studentDao) { this.studentDao = studentDao; }
	 */

	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}

	public List<Student> getList() {
		return studentDao.queryList();
	}

	public void addStudent(Student student) throws Exception {
		studentDao.insert(student);
		// throw new Exception("1");
	}

}
