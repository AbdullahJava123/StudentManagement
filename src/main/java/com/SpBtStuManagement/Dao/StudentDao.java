package com.SpBtStuManagement.Dao;

import java.util.List;

import com.SpBtStuManagement.Model.Student;

public interface StudentDao 
{
     public  List<Student> fetchStudents(String stuClass1) throws Exception;
     public  int registerStudent(int stuId,String stuName,String stuGender,String stuClass, String stuPerformance) throws Exception;
	  public int updateStudent(int stuId, String stuName, String stuGender, String stuClass, String stuPerformance) throws Exception;
}
