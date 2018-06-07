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
	public void getjosephus()
	{

	}
	public Node PushStart(int num)
	{
		Node newnode = new Node(num);
		Node start=this;
		Node ptr=this;
		if(start==null)
		{
			return null;
		}
		else if(start.next==start)
		{
			newnode.next=start;
			start.next=newnode;
			return newnode;
		}
		else
		{
			while(ptr.next!=start)
			{
				ptr=ptr.next;
			}
			ptr.next=newnode;
			newnode.next=start;
			return newnode;
		}
	}
	public void PushEnd(int num)
	{

		Node start=this;
		Node newnode = new Node(num);
		Node ptr=this;
		if(start==null)
		{
			return;
		}
		else if(start.next==start)
		{
			start.next=newnode;
			newnode.next=start;
		}
		else
		{
			while(ptr.next!=start)
			{
				ptr=ptr.next;
			}
			ptr.next=newnode;
			newnode.next=start;
			return;
		}
	}
	public void printlist()
	{
		Node ptr=this;
		Node start=this;
		if(ptr==null)
		{
			log("empty");
			return;
		}
		else
		{
			while(ptr.next!=start)
			{
				log(ptr.data);
				ptr=ptr.next;
			}
			log(ptr.data);
			return;
		}
	}
	public void log(int data)
	{
		System.out.println(data);
	}
	public void log(String str)
	{
		System.out.println(str);
	}
}
public class circularLL
{
	public static void main(String args[])
	{
		Node head=create();
		PrintList(head);
		GetJosephus(head);
	}
	public static Node create()
	{
		Scanner in =new Scanner(System.in);
		int num=in.nextInt();
		//int n=in.nextInt();
		//int num=1;
		Node start=new Node(num);
		start.next=start;
		log("more?");
		num=in.nextInt();
		while(num!=-1)
		// for(int i=2;i<=n;i++)
		{
			start.PushEnd(num);
			log("more");
			num=in.nextInt();
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
	public static void GetJosephus(Node start)
	{
		
		start.getjosephus();
	}
}