package hostel;
import java.util.*;
import java.sql.*;

import hostel.*;

public class Outing 
{
  static void outingAllocation()
  {
	try
	 {
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hostel?autoReconnect=true&useSSL=false","root","bhilai@123");
		PreparedStatement prep;
		ResultSet myRes;
		Scanner scan = new Scanner(System.in);
		System.out.print("Press 1");
		System.out.println("	Allocating Outings");
		System.out.print("Press 2");
		System.out.println("	Delete Outing");
		System.out.print("Press 3");
		System.out.println("	See Outings");
		int choice = scan.nextInt();
		
		switch(choice)
		{
			case 1:
			{
				System.out.println("Enter First Name of Student");
			
				String firstname = scan.nextLine();
				System.out.println(" ");
				System.out.println("Enter Lase Name of Student");
				System.out.println(" ");
				String lastname = scan.nextLine();
				System.out.println(" ");
				prep = myConn.prepareStatement("select first_name,last_name,mobile_number,roomno from Student where first_name=? and last_name=?;");
				prep.setString(1, firstname);
				prep.setString(2, lastname);
				myRes = prep.executeQuery();
				
				while(myRes.next())
				{
					String first_name = myRes.getString("first_name");
					String last_name = myRes.getString("last_name");
					int mobile = myRes.getInt("mobile_number");
					int roomnumber = myRes.getInt("roomno");
					if(firstname.equalsIgnoreCase(first_name) && lastname.equalsIgnoreCase(last_name))
					{
						prep = myConn.prepareStatement("insert into Outings(firstname,lastname,mobile,roomno) values(?,?,?,?);");
						prep.setString(1, first_name);
						prep.setString(2, last_name);
						prep.setInt(3, mobile);
						prep.setInt(4,roomnumber);
					}
				}
				Select.selection();
				break;
			}
		
			case 2:
			{
				System.out.println("Enter First Name of Student");
				String first_name = scan.nextLine();
				System.out.println("Enter Last Name of Student");
				String last_name = scan.nextLine();
				prep = myConn.prepareStatement("select firstname,lastname from Outings where firstname=? and lastname=?;");
				prep.setString(1, first_name);
				prep.setString(2, last_name);
				myRes = prep.executeQuery();
				while(myRes.next())
				{
					String firstname = myRes.getString("firstname");
					String lastname = myRes.getString("lastname");
					if(first_name.equalsIgnoreCase(firstname) && last_name.equalsIgnoreCase(lastname))
					{
						System.out.println("Deleteing Record............");
						prep = myConn.prepareStatement("delete from Outings where firstname=? and lastname=?;");
						prep.setString(1, firstname);
						prep.setString(2,lastname);
						prep.execute();
					}
				}
				Select.selection();
				break;
			}
		
			case 3:
			{
				Statement myStat = myConn.createStatement();
				myRes = myStat.executeQuery("select * from Outings");
				while(myRes.next())
				{
					System.out.println("FirstName "+myRes.getString("firstname") + " LastName " +myRes.getString("lastname") + " Mobile Number " + myRes.getInt("mobile") +"Room Number " + myRes.getInt("roomno"));
				}
				Select.selection();
				break;
			}
		
		
			
			
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
 }
}
