package com.siom.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class CrudDemo {

	public static void main(String[] args) {
		
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/crudoperation","root","Mah@Pavan@123");
		
	    String insert = "INSERT INTO student (STUDENT_NO,STUDENT_NAMEl,STUDENT_DOB,STUDENT_DOJ)"
	    		+"values ('104','RAM','1997-12-08','2019-06-15')";
	    String update= "UPDATE student SET STUDENT_DOB='1998-04-21' WHERE STUDENT_NO='102' ";
	    
	    String delete= "DELETE FROM student WHERE STUDENT_NO='101' ";
		
		Statement st= con.createStatement();
		
	    //int ins=st.executeUpdate(insert);
		int ins=st.executeUpdate(update);
		// ins=st.executeUpdate(delete);
		
		ResultSet rs=st.executeQuery("select * from student ");
		//ResultSet rs=st.executeQuery("SELECT * FROM student WHERE STUDENT_NO='101'");

		
		if(ins>0) {
			System.out.println("CRUD Perform Successfully...");
		}
		
	   
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		}
		con.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e);
			
		}

	}

}
