package hostel;
import hostel.*;
import java.util.*;
import java.sql.*;


public class Create 
{
	static void createDetails()
	{
		try
		{
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hostel?autoReconnect=true&useSSL=false","root","bhilai@123");
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter First Name of Student");
			String firstname = scan.nextLine();
			
			System.out.println("Enter Last Name of Student");
			String lastname = scan.nextLine();
			
			System.out.println("Enter Father Name");
			String fathername = scan.nextLine();
			
			System.out.println("Enter Mothers Name");
			String mothername = scan.nextLine();
			
			System.out.println("Enter Branch");
			String branch = scan.nextLine();
			
			System.out.println("Enter Address Only in 80 Characters ");
			String address = scan.nextLine();
			
			System.out.println("Enter Mobile Number");
			long mobilenumber = scan.nextLong();
			
			Rooms room = new Rooms();
			room.rommAllocate();
			int roomnumber = room.deleteFirst();
			room.insertLast(roomnumber);
			
			
			
			
			System.out.println("Entering Details into Database");
			
			PreparedStatement prep = myConn.prepareStatement("INSERT INTO Student(first_name,last_name,father_name,mother_name,branch,roomno,mobile_number,address) VALUES(?,?,?,?,?,?,?,?);");
			prep.setString(1, firstname);
			prep.setString(2,lastname);
			prep.setString(3,fathername);
			prep.setString(4,mothername);
			prep.setString(5,branch);
			prep.setInt(6,roomnumber);
			prep.setLong(7, mobilenumber);
			prep.setString(8, address);
			
			prep.executeUpdate();
			
			System.out.println("Details Sucessfully Entered");
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
