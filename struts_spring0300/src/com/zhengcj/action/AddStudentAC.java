package com.zhengcj.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;
import com.zhengcj.bizservice.StudentBS;
import com.zhengcj.domain.Student;

public class AddStudentAC extends ActionSupport {

	private StudentBS studentBS;

	public void setStudentBS(StudentBS studentBS) {
		this.studentBS = studentBS;
	}

	public String execute() throws Exception {
		Student student = new Student();
		student.setAge(33);
		student.setId("666");
		student.setName("xx");
		File file = new File("d:\\1.jpg");
		InputStream is = new FileInputStream(file);
		byte[] b = new byte[(int) file.length()];
		int offSet = 0;
		int numRead = 0;
		while (offSet < b.length && (numRead = is.read(b, offSet, b.length - offSet)) > 0) {
			offSet += numRead;
		}
		is.close();
		student.setImage(b);
		studentBS.addStudent(student);
		return SUCCESS;
	}

}
