package com.SpBtStuManagement.Service;

import java.util.List;

import com.SpBtStuManagement.Model.Student;

public interface StudentService 
{
	public  List<Student> getStudents(String stuClass1) throws Exception;
    public  int registerStudentDetails(int stuId,String stuName,String stuGender,String stuClass, String stuPerformance) throws Exception;
	  public int updateStudentDetails(int stuId, String stuName, String stuGender, String stuClass, String stuPerformance) throws Exception;
	
}
