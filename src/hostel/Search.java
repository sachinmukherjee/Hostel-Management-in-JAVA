package hostel;
import hostel.*;
import java.sql.*;
import java.util.Scanner;

public class Search 
{	
	
	static String student;
	
	static void searchDetails()
	{	try
	   {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hostel?autoReconnect=true&useSSL=false","root","bhilai@123");
			Statement myStat = myConn.createStatement();
			ResultSet myRes = myStat.executeQuery("select first_name from Student;");			// getiing first name of all student from database
		
			System.out.println("Please Enter Student First Name");								// student name from user
			Scanner scan = new Scanner(System.in);
			student = scan.nextLine();
			String studentdb_name;
			
			while(myRes.next())
				
				{	studentdb_name = myRes.getString("first_name");							// taking firstname from database one by one
				
					if((student.equalsIgnoreCase(studentdb_name))) 						// if user's first name equals to database first name
					{
						System.out.println("Match Found");
						System.out.println(" ");
						PreparedStatement prep = myConn.prepareStatement("select * from Student where first_name = ?;");		// extract all the details of student 
						prep.setString(1, student);
						ResultSet myRes1 = prep.executeQuery();
						while(myRes1.next())
							
						{
							System.out.println("Student Name   " + myRes1.getString("first_name")  +  myRes1.getString("last_name"));
							System.out.println(" ");
							System.out.println("Father Name    " + myRes1.getString("father_name"));
							System.out.println(" ");
							System.out.println("Mother Name    " + myRes1.getString("mother_name"));
							System.out.println(" ");
							System.out.println("Branch         "+ myRes1.getString("branch"));
							System.out.println(" ");
							System.out.println("Mobile Number  "+ myRes1.getLong("mobile_number"));
							System.out.println(" ");
							System.out.println("Room Number    "+ myRes1.getInt("roomno"));
							System.out.println(" ");
							System.out.println("Address        "+ myRes1.getString("address"));
							
						}
					}
					
					
					
					
				}
				
			
		
	   }
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
