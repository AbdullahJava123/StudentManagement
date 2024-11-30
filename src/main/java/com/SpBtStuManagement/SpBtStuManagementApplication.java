package com.SpBtStuManagement;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.SpBtStuManagement.Controller.StudentController;
import com.SpBtStuManagement.Model.Student;

@SpringBootApplication
public class SpBtStuManagementApplication {

	public static void main(String[] args) throws Exception
	{
		
		ApplicationContext ctx= SpringApplication.run(SpBtStuManagementApplication.class, args);
		
		StudentController stuC=ctx.getBean("stuController",StudentController.class);
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Select One of the below operations to perform: ");
		System.out.println("Enter 1 to register a student");
		System.out.println("Enter 2 to update Student details");
		System.out.println("Enter 3 to retrive Students");
		int op=sc.nextInt();
		switch(op)
		{
		case 1:
			System.out.println("Enter stuId");
			int stuId=sc.nextInt();
			System.out.println("Enter stuName");
			String stuName=sc.next();
			System.out.println("Enter stuGender");
			String stuGender=sc.next();
			System.out.println("Enter stuClass");
			String stuClass=sc.next();
			System.out.println("Enter stuPerformance");
			String stuPerformance=sc.next();
			int no=stuC.registerStudentDet(stuId, stuName, stuGender, stuClass, stuPerformance);
			if(no>0)
			{
				System.out.println("Student Details Added Successfully");
				
			}
			else
			{
				System.out.println("Student Details Failed to Register");
			}
			break;
		case 2:
			System.out.println("Enter stuId");
			int stuId1=sc.nextInt();
			System.out.println("Enter stuName");
			String stuName1=sc.next();
			System.out.println("Enter stuGender");
			String stuGender1=sc.next();
			System.out.println("Enter stuClass");
			String stuClass1=sc.next();
			System.out.println("Enter stuPerformance");
			String stuPerformance1=sc.next();
			int no1=stuC.updateStudent(stuId1, stuName1, stuGender1, stuClass1, stuPerformance1);
			if(no1>0)
			{
				System.out.println("Student Details Updated Successfully");
				
			}
			else
			{
				System.out.println("Student Details Failed to Update");
			}
		      break;
		      
		case 3:
			System.out.println("Enter Class Name: ");
			String stuClass11=sc.next();
			
			
			List<Student> li=stuC.fetchStudentsDet(stuClass11);
			if(li!=null)
			{
				//li.forEach(stu->{System.out.println(stu);});//using forEach() method.
				for(Object stu:li)// using enhanced for loop
				{
					System.out.println(stu);
				}
			}
			else
			{
				System.out.println("Retrieval operation failed");
			} break;
		default :System.out.println("Invalid Input");
		      
		}
		
	}

}
