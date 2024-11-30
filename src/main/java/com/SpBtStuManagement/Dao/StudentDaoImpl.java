package com.SpBtStuManagement.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpBtStuManagement.Model.Student;

@Repository("stuDao")
public class StudentDaoImpl implements StudentDao
{
	@Autowired
     private DataSource datasource;
	 private final String fetchStudents="select * from stutable where stuClass in (?)";
	 private final String registerStudent="insert into stutable(stuId,stuName,stuGender,stuClass,stuPerformance) values(?,?,?,?,?)";
	 private final String updateStudent ="update stutable set stuName=?,stuGender=?,stuPerformance=? where stuId=? and stuClass=?";
	@Override
	public List<Student> fetchStudents(String stuClass1) throws Exception
	{
		List<Student> li=new ArrayList<Student>();
		try(Connection con=datasource.getConnection(); PreparedStatement ps=con.prepareStatement(fetchStudents))
		{
			ps.setString(1, stuClass1);
			
			try(ResultSet rs=ps.executeQuery())
			{
				while(rs.next())
				{
				Student st=new Student();
				st.setStuId(rs.getInt(1));
				st.setStuName(rs.getString(2));
				st.setStuGender(rs.getString(3));
				st.setStuClass(rs.getString(4));
				st.setStuPerformance(rs.getString(5));
				li.add(st);
				}
				
			}
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public int registerStudent(int stuId, String stuName, String stuGender, String stuClass, String stuPerformance) throws Exception
	{
		int no = 0;
		try(Connection con=datasource.getConnection(); PreparedStatement ps=con.prepareStatement(registerStudent))
		{
			ps.setInt(1, stuId);
			ps.setString(2, stuName);
			ps.setString(3, stuGender);
			ps.setString(4, stuClass);
			ps.setString(5, stuPerformance);
			 no=ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return no;
		
	}

	@Override
	public int updateStudent(int stuId, String stuName, String stuGender, String stuClass, String stuPerformance) throws Exception
	{
		int no=0;
		try(Connection con=datasource.getConnection(); PreparedStatement ps=con.prepareStatement(updateStudent))
		{
			ps.setString(1, stuName);
			ps.setString(2, stuGender);
			ps.setString(3,stuPerformance);
			ps.setInt(4, stuId);
			ps.setString(5, stuClass);
			no=ps.executeUpdate();
			
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return no;
	}

}
