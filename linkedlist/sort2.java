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
	public Node merge(Node head2)
	{
		Node head=this;
		Node sortedList=new Node(0);
		log("in Mege Function");
		if(head==null)
			return head2;
		else if(head2==null)
			return head;
		else
		{
			while(head!=null && head2!=null)
			{
				log("in while loop");
				if(head.data<=head2.data)
				{
					log(" less "+head.data+" then "+head2.data);
					sortedList.PushToEnd(head.data);
					head=head.next;
				}
				else 
				{
					log(" greater "+head.data+" then "+head2.data);
					
					sortedList.PushToEnd(head2.data);
					head2=head2.next;
				}
			}
			while(head!=null)
			{
				log("pus value from list 1 "+head.data);
				sortedList.PushToEnd(head.data);
				head=head.next;
			}
			while(head2!=null)
			{
				log("pus value from list 2 "+head2.data);
				
				sortedList.PushToEnd(head2.data);
				head2=head2.next;
			}
			return sortedList.next;
		}
	}
	public void sort()
	{
		Node start=this;
		Node ptr=this;
		Node ptr2=this;
		if(ptr==null)
			return;
		else if(ptr.next==null)
			return;
		else
		{
			while(ptr.next!=null)
			{
				ptr2=ptr.next;
				while(ptr2!=null)
				{
					if(ptr.data>ptr2.data)
					{
						SwapNum(ptr.data,ptr2.data);
					}
					ptr2=ptr2.next;
				}
				ptr=ptr.next;
			}
		}
	} 
	public void SwapNum(int num1,int num2)
	{
		Node ptr=this;
		Node ptr2=this;
		if(num1==num2)
			return;
		else if(ptr==null)
			return;
		else
		{
			while(ptr!=null && ptr.data!=num1)
				ptr=ptr.next;
			if(ptr==null)
				return;
			while(ptr2!=null && ptr2.data!=num2)
				ptr2=ptr2.next;
			if(ptr2==null)
				return;
			int temp;
			temp=ptr.data;
			ptr.data=ptr2.data;
			ptr2.data=temp;
			return;
		}
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
}
public class sort2
{
	public static void main(String args[])
	{
		log("enter List 1:");
		Node head=create();
		log("enter List 2:");
		Node head2=create();
		// printlist(head);
		Sorting(head);
		Sorting(head2);
		log("List 1:");
		printlist(head);
		log("List 2:");
		printlist(head2);
		Node head3=MergeLists(head,head2);
		log("list 3:");
		printlist(head3);
	}
	public static Node MergeLists(Node head,Node head2)
	{
		Node start=head.merge(head2);
		return start;
	}
	public static void log(String str)
	{
		System.out.println(str);
	}
	public static void Sorting(Node start)
	{
		start.sort();
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
}