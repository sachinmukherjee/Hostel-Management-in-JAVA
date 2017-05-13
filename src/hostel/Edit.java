package hostel;
import hostel.*;
import java.sql.*;
import java.util.*;

public class Edit 

{	static String name;
	static String firstname,lastname,branch,fathername,mothername,address;
	static long mobile;
	static void EditDetails()
	{
		try
		{
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hostel?autoReconnect=true&useSSL=false","root","bhilai@123");
			
			System.out.println("Enter Name of Student to Edit");
			
			Scanner scan = new Scanner(System.in);
			String first = scan.nextLine();
			
			PreparedStatement prep = myConn.prepareStatement("select first_name from Student where first_name=?");
			prep.setString(1, first);
			ResultSet myRes=prep.executeQuery();
			
			while(myRes.next())
			{
				name = myRes.getString("first_name");
				
				if(first.equalsIgnoreCase(name))
				{
					System.out.println("Student Name Found");
					System.out.println(" ");
					System.out.println("Edit Details");
					
					System.out.println("Enter First Name");
					firstname = scan.nextLine();
					System.out.println(" ");
					
					System.out.println("Enter Last Name");
					lastname = scan.nextLine();
					System.out.println(" ");
					
					System.out.println("Enter Father Name");
					fathername = scan.nextLine();
					System.out.println(" ");
					
					System.out.println("Enter Mother Name");
					mothername = scan.nextLine();
					System.out.println(" ");
					
					System.out.println("Enter Branch ");
					branch = scan.nextLine();
					System.out.println(" ");
					
					System.out.println("Enter Address 80 Characters only");
					address = scan.nextLine();
					System.out.println(" ");
					
					System.out.println("Enter Mobile Number");
					mobile = scan.nextLong();
					
					PreparedStatement prep1 = myConn.prepareStatement("update Student set first_name=?,last_name=?,father_name=?,mother_name=?,branch=?,mobile_number=?,address=? where first_name=?;");
					prep1.setString(1, firstname);
					prep1.setString(2, lastname);
					prep1.setString(3, fathername);
					prep1.setString(4, mothername);
					prep1.setString(5, branch);
					prep1.setLong(6, mobile);
					prep1.setString(7,address);
					prep1.setString(8,first);
					
					prep1.executeUpdate();
					
					System.out.println("Details Updated");
					
					
					
				}
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
