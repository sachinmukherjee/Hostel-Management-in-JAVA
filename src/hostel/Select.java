package hostel;
import hostel.*;
import java.util.*;

public class Select 
{
	static void selection()
	
	{	int sel = 0;
		System.out.println("Enter Your Choice");
		System.out.println(" ");
		System.out.println("1  Search Details ");
		System.out.println("2  Create Details");
		System.out.println("3  Edit Details");
		System.out.println("4  Delete Details");
		System.out.println("5  Outings ");
		System.out.println("6  To Exit");
		System.out.println(" ");
		Scanner scan = new Scanner(System.in);
		sel = scan.nextInt();
		
	switch(sel)
		{
		
		case 1:
			{
				Search.searchDetails();						// method for searching name
				break;
			}
			
		case 2:
			{
				Create.createDetails();   					// method for new details
				break;
			}
			
		case 3:
			{
				Edit.EditDetails();							//method for edit details
				break;
			}
			
		case 4:
			{
				Delete.deleteDetails();						//method for outings
				break;
			}
			
		case 5:
			{
				Outing.outingAllocation();					//method for outings
				break;
			}
		
		case 6:
		{
			System.exit(0);
		}
			
		default:
			{
			System.out.println("You Have Entered Choice");
			break;
			}
		}
			
		
	}

}
