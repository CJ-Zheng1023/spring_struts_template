package com.zhengcj.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.zhengcj.bizservice.StudentBS;
import com.zhengcj.domain.Student;

public class StudentAC extends ActionSupport {

	private StudentBS studentBS = null;

	private List<Student> list = null;

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	public void setStudentBS(StudentBS studentBS) {
		this.studentBS = studentBS;
	}

	public String execute() {
		list = studentBS.getList();
		return SUCCESS;
	}
}
