package com.SpBtStuManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpBtStuManagement.Dao.StudentDao;
import com.SpBtStuManagement.Model.Student;

@Service("stuService")
public class StudentServiceImpl implements StudentService 
{
     @Autowired
	private StudentDao stuDao;//using interface variable to achieve loose coupling and abstraction
     
	@Override
	public List<Student> getStudents(String stuClass1) throws Exception {
		   List<Student> li=stuDao.fetchStudents(stuClass1);
		return li;
	}

	@Override
	public int registerStudentDetails(int stuId, String stuName, String stuGender, String stuClass,String stuPerformance) throws Exception {
		
		int no=stuDao.registerStudent(stuId, stuName, stuGender, stuClass, stuPerformance);
		return no;
	}

	@Override
	public int updateStudentDetails(int stuId, String stuName, String stuGender, String stuClass, String stuPerformance)throws Exception
	{
		int no=stuDao.updateStudent(stuId, stuName, stuGender, stuClass, stuPerformance);
		return no;
	}

}
