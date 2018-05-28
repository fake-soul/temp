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
	public void SwapPair()
	{
			Node ptr=this;
		while(ptr!=null && ptr.next!=null)
		{
			int k=ptr.data;
			ptr.data=ptr.next.data;
			ptr.next.data=k;
			ptr=ptr.next.next;
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
public class swappair
{
	public static void main(String args[])
	{
		Node head=create();
		printlist(head);
		pairSwap(head);
		printlist(head);
	}
	public static void pairSwap(Node start)
	{
		start.SwapPair();
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