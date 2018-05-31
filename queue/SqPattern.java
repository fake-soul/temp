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
	public void enqueueEnd(int num)
	{
		Node start=this;
		Node newnode= new Node(num);
		while(start.next!=null)
			start=start.next;
		start.next=newnode;
	}
	public void dequeueStart()
	{
		Node start=this;
		if(start.next==null)
		{
			log("Underflow");
			return ;
		}
		start.next=start.next.next;
	}
	public Node Push(int num)
	{
		Node start=this;
		Node newnode = new Node(num);
		newnode.next=start;
		return newnode;
	}
	public Node pop()
	{
		Node start=this;
		if(start.next==null)
		{
			log("Error");
			return start;
		}
		return start.next;
	}
	public int QueueTop()
	{
		Node start=this;
		if(start.next==null)
		{
			return -99;
		}
		return start.next.data;
	}
	public int StackTop()
	{
		Node start=this;
		if(start.next==null)
		{
			return -99;
		}
		return start.data;
	}
	public void PrintList()
	{
		Node start=this;
		if(start.next==null)
		{
			log("Empty");
			return;
		}
		start=start.next;
		while(start!=null)
		{
			log(start.data);
			start=start.next;
		}
		return;
	}
	public void log(int data)
		{
			System.out.println(data);
		}
		public void log(String data)
		{
			System.out.println(data);
		}
}
public class SqPattern
{
	public static void main(String args[]) 
	{
		Node queue=create();
		CheckPattern(queue);
	}
	public static Node create()
	{
		Node start=new Node(-99);
		Scanner in = new Scanner(System.in);
		int num=in.nextInt();
		while(num!=-1)
		{
			start.enqueueEnd(num);
			num=in.nextInt();
		}
		start.PrintList();
		return start;
	}
	public static void CheckPattern(Node start)
	{
		Node startStack=new Node(-99);
		while(start.QueueTop()!=-99)
		{
			if(start.QueueTop()-startStack.StackTop()==1 || start.QueueTop()-startStack.StackTop()==-1 )
			{
				System.out.println("Pair ("+start.QueueTop()+","+startStack.StackTop()+")");

			}
			startStack=startStack.Push(start.QueueTop());
			start.dequeueStart();
		}
	}
}