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
	public Node oddevenView()
	{
		Node start=this;
		Node newnode= new Node(0);
		if(start==null)
			return null;
		else
		{
			while(start!=null)
			{
				if(start.data%2==0)
					newnode=newnode.next.PushStart(start.data);
				else
					newnode.PushEnd(start.data);
				start=start.next;
			}
			return newnode;
		}
	}
	public void PushEnd(int num)
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
	public Node PushStart(int num)
	{
		Node start=this;
		if(start==null)
		{
			Node newnode = new Node(num);
			start=newnode;
			return newnode;
		}
		Node newnode=new Node(num);
		newnode.next=start;
		return newnode;
	}
	public void printlist()
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

public class oddeven
{
	public static void main(String args[])
	{
		Scanner in =new Scanner(System.in);
		int n=in.nextInt();
		Node head=create(n);
		PrintList(head);
		View(head);
	}
	public static Node create(int n)
	{
		
		int num=1;
		Node start=new Node(num);
		// log("more?");
		// num=in.nextInt();
		// while(num!=-1)
		for(int i=2;i<=n;i++)
		{
			start.PushEnd(i);
			// log("more");
			// num=in.nextInt();
		}
		return start;
	}
	public static void PrintList(Node start)
	{
		start.printlist();
	}
	public static void log(String str)
	{
		System.out.println(str);
	}
	public static void View(Node start)
	{
		Node newlist=start.oddevenView();
		newlist.printlist();
	}
}