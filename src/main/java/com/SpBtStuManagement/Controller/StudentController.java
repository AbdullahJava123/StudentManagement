package com.SpBtStuManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.SpBtStuManagement.Model.Student;
import com.SpBtStuManagement.Service.StudentService;

@Controller("stuController")
public class StudentController
{
	@Autowired
	private StudentService stuService;
	public  List<Student> fetchStudentsDet(String stuClass1) throws Exception
	{
		List<Student> li=stuService.getStudents(stuClass1);
		return li;
		
	}
    public  int registerStudentDet(int stuId,String stuName,String stuGender,String stuClass, String stuPerformance) throws Exception
    {
    	int no=stuService.registerStudentDetails(stuId, stuName, stuGender, stuClass, stuPerformance);
		return no;
    	
    }
	  public int updateStudent(int stuId, String stuName, String stuGender, String stuClass, String stuPerformance) throws Exception
	  {
		  int no=stuService.updateStudentDetails(stuId, stuName, stuGender, stuClass, stuPerformance);
		return no;
		  
	  }
}
