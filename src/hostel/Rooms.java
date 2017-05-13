package hostel;

public class Rooms 
{
	Node head;
	Node tail;
	
	static class Node
	{
		Node next;
		int roomNumber;
		
		Node(int a)
		{
			roomNumber = a;
		}
	}
	
	void roomAllocation(int room)
	{
		if(head==null)						// if no nodes are there
		{
			Node newnode = new Node(room);
			head = newnode;
		}
		else								// if nodes are there
		{
			Node newnode = new Node(room);
			newnode.next = head;
			head = newnode;
		}
	}
	
	 int deleteFirst()
	{
		int temp = head.roomNumber;
		head = head.next;
		return temp;
	}
	
	 void insertLast(int room)
	{
		Node temp = head;
		Node prev = null;
		
		if(head==null)
		{
			Node newnode = new Node(room);
			head = newnode;
		}
		
		while(temp!=null)
		{
			prev = temp;
			temp = temp.next;
		}
		
		Node newnode = new Node(room);
		prev.next=newnode;
		tail=newnode;
	}
	 
	void rommAllocate()
	{
		roomAllocation(1);
		roomAllocation(2);
		roomAllocation(3);
		roomAllocation(4);
		roomAllocation(5);
		roomAllocation(6);
		roomAllocation(8);
		roomAllocation(7);
		roomAllocation(9);
		roomAllocation(12);
		roomAllocation(10);
		roomAllocation(11);
		roomAllocation(13);
		roomAllocation(16);
		roomAllocation(15);
		roomAllocation(14);
		roomAllocation(18);
		roomAllocation(17);
		roomAllocation(20);
		roomAllocation(19);
		
		roomAllocation(21);
		roomAllocation(23);
		roomAllocation(22);
		roomAllocation(25);
		roomAllocation(24);
		roomAllocation(27);
		roomAllocation(26);
		roomAllocation(29);
		roomAllocation(30);
		roomAllocation(28);
		roomAllocation(31);
		roomAllocation(32);
		roomAllocation(12);
		roomAllocation(10);
		roomAllocation(11);
		roomAllocation(13);
		roomAllocation(16);
		roomAllocation(15);
		roomAllocation(14);
		roomAllocation(18);
		roomAllocation(17);
		roomAllocation(20);
		roomAllocation(19);
		roomAllocation(21);
		roomAllocation(23);
		roomAllocation(22);
		roomAllocation(25);
		roomAllocation(24);
		roomAllocation(27);
		roomAllocation(26);
		roomAllocation(29);
		roomAllocation(30);
		roomAllocation(28);
		roomAllocation(31);
		roomAllocation(32);
		roomAllocation(1);
		roomAllocation(2);
		roomAllocation(3);
		roomAllocation(4);
		roomAllocation(5);
		roomAllocation(6);
		roomAllocation(8);
		roomAllocation(7);
		roomAllocation(9);
		roomAllocation(1);
		roomAllocation(2);
		roomAllocation(3);
		roomAllocation(4);
		roomAllocation(5);
		roomAllocation(6);
		roomAllocation(8);
		roomAllocation(7);
		roomAllocation(9);
		roomAllocation(12);
		roomAllocation(10);
		roomAllocation(11);
		roomAllocation(13);
		roomAllocation(16);
		roomAllocation(15);
		roomAllocation(14);
		roomAllocation(18);
		roomAllocation(17);
		roomAllocation(20);
		roomAllocation(19);
		roomAllocation(21);
		roomAllocation(23);
		roomAllocation(22);
		roomAllocation(25);
		roomAllocation(24);
		roomAllocation(27);
		roomAllocation(26);
		roomAllocation(29);
		roomAllocation(30);
		roomAllocation(28);
		roomAllocation(31);
		roomAllocation(32);
		
	}

}
