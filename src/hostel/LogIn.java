package hostel;
import java.util.*;
import hostel.*;
import java.sql.*;


public class LogIn 
{
	static
	{
		System.out.println("Created By SACHIN MUKHERJEE");
		System.out.println("A Hostel Management System");
		System.out.println("Copyright Sachin Mukherjee");
	}
	
	
	static int logIn()
	{		
				int confirm = 1;
		    try
				{	
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hostel?autoReconnect=true&useSSL=false","root","bhilai@123");
					Statement myStat = myConn.createStatement();
					ResultSet myRes = myStat.executeQuery("select * from Warden;");    // getting username and password from database
					
					System.out.print("Enter User Name");
					System.out.println(" ");
					Scanner scan = new Scanner(System.in);
					String u_name = scan.nextLine();							//username from user
					System.out.println("Enter Password");
					System.out.println("");
					int password = scan.nextInt();								// password from user
					
					while(myRes.next())
					{
						int value = myRes.getInt("pass");						// username from database
						String uname = myRes.getString("username");			//password from database
						
						if(uname.equals(u_name) && value==password)				// if both username and password are equal
						{
							confirm = 1;                						// username and password are equal
						}
						
						else 
							confirm = 0;										// username and password are not equal
							
			
			
					}
					
				}
		
		catch(Exception e)
		{
			e.printStackTrace();
			confirm = 0;
			
		}
		
		return confirm;
		

	}
	
	
	public static void main(String args[])
	{
		int confirmation = logIn();						// to know status of username and password and to procede further//				
		
		
		if(confirmation==1)
		{
			System.out.println("Successfully Logged In");
			Select.selection();           // for making choice 
		}
		
		else
		{
			System.out.println("Login Failed!!!!!!!!!!");
			
			
		}
	}
}
	