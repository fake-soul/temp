import java.util.Scanner;
class Node
{
	int data;
	Node next;
	Node(int num)
	{
		data=num;
		next=null;
	}
	public void middleList()
	{
		Node ptr1=this;
		Node ptr2=this;
			ptr1=ptr1.next;
			while(ptr1!=null)
			{
				ptr2=ptr2.next;
				ptr1=ptr1.next.next;
			}
			log(ptr2.data);
	}
	public void PushToEnd(int num)
	{
		Node start=this;
		if(start==null)
			return;
		while(start.next!=null)
		{
			start=start.next;
		}
		Node newnode=new Node(num);
		start.next=newnode;
	}
	public Node PushToStart(int num)
	{
		Node start=this;
		Node newnode=new Node(num);
		newnode.next=start;
		return newnode;
	}
	public void PrintList()
	{
		Node start=this;
		log("list is");
		while(start!=null)
		{
			log(start.data);
			start=start.next;
		}
	}
	public void log(int num)
	{
		System.out.println(num);
	}
	public void log(String string)
	{
		System.out.println(string);
	}
	public int nthLast(int pos)
	{
		Node fastptr=this;
		Node slowptr=this;
		for(int i=0;i<pos;i++)
			fastptr=fastptr.next;
		while(fastptr!=null)
		{
			slowptr=slowptr.next;
			fastptr=fastptr.next;
		}
		return slowptr.data;
    }
	public void swap(int x, int y)
    {
        Node head=this;
        // Nothing to do if x and y are same
        if (x == y) return;
 
        // Search for x (keep track of prevX and CurrX)
        Node prevX = null, currX = this;
        while (currX != null && currX.data != x)
        {
            prevX = currX;
            currX = currX.next;
        }
 
        // Search for y (keep track of prevY and currY)
        Node prevY = null, currY = this;
        while (currY != null && currY.data != y)
        {
            prevY = currY;
            currY = currY.next;
        }
 
        // If either x or y is not present, nothing to do
        if (currX == null || currY == null)
            return;
 
        // If x is not head of linked list
        if (prevX != null)
            prevX.next = currY;
        else //make y the new head
            head = currY;
 
        // If y is not head of linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x the new head
            head = currX;
 
        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }
	public void sort()
	{
		Node start=this;
		Node ptr1=null;Node ptr2=null;
		ptr1=start;ptr2=start;
			while(ptr1.next!=null)
			{
				ptr2=ptr1.next;
				while(ptr2!=null)
				{
					if(ptr1.data>ptr2.data)
					{
						start.swap(ptr1.data,ptr2.data);
					}
					ptr2=ptr2.next;
				}
				ptr1=ptr1.next;
			}

	}
	public Node insertSort(Node start, Node sorted)
	{
		if(sorted==null||sorted.data>=start.data)
		{
			Node newnode= new Node(start.data);
			newnode.next=sorted;
			return newnode;
		}
		else
		{
			while(start.next!=null || sorted.next.data<start.data)
			{
				sorted=sorted.next;
			}
			start.next=sorted.next;
			sorted.next=start;
		}
		return sorted;
	}
	public int loop()
	{
		Node fastptr=this;
		Node slowptr=this;
		while(slowptr!=null&&fastptr!=null&&fastptr.next!=null)
		{
			slowptr=slowptr.next;
			fastptr=fastptr.next.next;
			if(fastptr==slowptr)
				return 1;
		}
		return 0;
	}
}
public class nthNodeFromLast
{
	public static void main(String args[])
	{
		Node head=create();
		printlist(head);
		nthLastNode(head);
		Findloop(head);
		swapnumber(head);
		printlist(head);
		sortLinkedList(head);
		printlist(head);	
	}
	public static Node create()
	{
		Scanner in = new Scanner(System.in);
		int num=in.nextInt();
		Node start = new Node(num);
		System.out.println("more??");
		num=in.nextInt();
		while(num!=-1)
		{
			start.PushToEnd(num);
			System.out.println("more??");
			num=in.nextInt();
		}
		return start;
	}
	public static void printlist(Node start)
	{
		start.PrintList();
	}
	public static void nthLastNode(Node start)
	{
		Scanner in=new Scanner(System.in);
		int num=in.nextInt();
		System.out.println("Nth Last Node is: "+start.nthLast(num));
	}
	public static void Findloop(Node start)
	{
		System.out.println(start.loop());
	}
	public static void sortLinkedList(Node start)
	{
		start.sort();
	}
	public static void swapnumber(Node start)
	{
		start.swap(3,6);
	}
}