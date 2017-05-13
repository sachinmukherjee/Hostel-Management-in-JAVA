package hostel;
import hostel.*;
import java.util.*;
import java.sql.*;

public class Delete 
{
	static void deleteDetails()
	{	
		try
		{
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hostel?autoReconnect=true&useSSL=false","root","bhilai@123");
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter First Name of Student");
			String firstname = scan.nextLine();
			
			System.out.println("Enter Last Name of Student");
			String lastname = scan.nextLine();
			
			PreparedStatement prep = myConn.prepareStatement("select first_name,last_name from Student where first_name=? and last_name=?;");
			prep.setString(1, firstname);
			prep.setString(2, lastname);
			ResultSet myRes = prep.executeQuery();
			
			while(myRes.next())
			{
				String first_name = myRes.getString("first_name");
				String last_name = myRes.getString("last_name");
				if(firstname.equalsIgnoreCase(first_name) && lastname.equalsIgnoreCase(last_name))
				{
					System.out.println("Match Found.....Deleting Data......");
					PreparedStatement prep1 = myConn.prepareStatement("delete from Student where first_name=? and last_name=?;");
					prep1.setString(1, firstname);
					prep1.setString(2, lastname);
					prep1.execute();
					System.out.println("Data Deleted");
				}
				else
					System.out.println("Match Not Found");
			}
			
			}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	
	
}