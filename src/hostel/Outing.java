package hostel;
import java.util.Scanner;
import hostel.*;
import java.sql.*;

class Outing
 {
	
		
	
	static void allocate(String firstname, String lastname) throws Exception
	
	{
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hostel?autoReconnect=true&useSSL=false","root","bhilai@123");
		//Statement myStat = myConn.createStatement();
		PreparedStatement prep;
		ResultSet myRes;
		String first = firstname;
		String last = lastname;
		prep = myConn.prepareStatement("select first_name,last_name,roomno,mobile_number from Student where first_name=? and last_name=?;");
		prep.setString(1, firstname);
		prep.setString(2, lastname);
		myRes = prep.executeQuery();
		while(myRes.next())
		{
			String first_name = myRes.getString("first_name");
			String last_name = myRes.getString("last_name");
			int room_no = myRes.getInt("roomno");
			long mobile_number = myRes.getLong("mobile_number");
			if(first_name.equalsIgnoreCase(firstname) && last_name.equalsIgnoreCase(lastname))
			{
				System.out.println("Allocating Outing");
				prep = myConn.prepareStatement("insert into Outings(firstname,lastname,mobile,roomno) values(?,?,?,?);");
				prep.setString(1, first);
				prep.setString(2, last);
				prep.setLong(3,mobile_number);
				prep.setInt(4, room_no);
				prep.executeQuery();
	        }
		}
		System.out.println("Allocated");
	}
	
	static void see() throws Exception
	{
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hostel?autoReconnect=true&useSSL=false","root","bhilai@123");
		Statement myStat = myConn.createStatement("Select * from Outings");
		PreparedStatement prep = myConn.prepareStatement();
		ResultSet myRes = myStat.executeQuery();
		while(myRes.next())
		{
			System.out.print(myRes.getString("firstname"));
			System.out.print("   ");
			System.out.print(myRes.getString("lastname"));
			System.out.print("   ");
			System.out.print(myRes.getString("mobile"));
			System.out.print("   ");
			System.out.println(myRes.getString("roomno"));
			
		}
		
		
	}
	static void delete(String firstname,String lastname) throws Exception
	{
		String first = firstname;
		String last = lastname;
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hostel?autoReconnect=true&useSSL=false","root","bhilai@123");
		PreparedStatement prep = myConn.prepareStatement("Select firstname,lastname from Outings where firstname=? and lastname=?");
		prep.setString(1, first);
		prep.setString(2, last);
		//prep.execute();
		ResultSet myRes = prep.executeQuery();
	    String f = myRes.getString("firstname");
	    String s = myRes.getString("lastname");
	    if(f.equalsIgnoreCase(first) && s.equalsIgnoreCase(last))
	    {
	    	prep=myConn.prepareStatement("delete from Outings where firstname=? and lastname=?;");
	    	prep.setString(1, f);
	    	prep.setString(2, s);
	    	prep.execute();
	    	System.out.println("DELETED !!!!!!");
	    }
		
	}
	
			
	static void Outings()
	{
	  try
	  {
	
	    Scanner scan = new Scanner(System.in);
	    System.out.println("Enter Your Choices");
	    System.out.print("1 ");
	    System.out.println("Allocate Outings");
	    System.out.print("2 ");
	    System.out.println("See Outings");
	    System.out.print("3 ");
	    System.out.println("Delete Outings ");
	    int choice = scan.nextInt();
	
	    switch(choice)
	   {
	     case 1:
	      {
            // Allocating Outings//
		
	       String firstn = scan.nextLine();
	       System.out.println("Enter First Name of Student");
		  
	       String lastn = scan.nextLine();
		   System.out.println("Enter Last Name of Student");
		  
		   allocate(firstn,lastn);
		   Select.selection();                                       // move to seletion page
		   break;			
	      } // case 1 close
	
	
	   case 2:
	    {
	    	see();
	    	Select.selection();
	    	break;
		}
	
	   case 3:
	     {
		    System.out.println("Enter First Name of Student");
		    String first = scan.nextLine();
		    System.out.println("Enter Last Name of Student");
		    String last = scan.nextLine();
		    delete(first,last);
		    Select.selection();
		    break;
		
	    }
	  }// switch close
	 } // try close
	
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	

	
	
	
	
	}
}