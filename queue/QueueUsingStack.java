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
	public int stacksize()
	{
		int num=0;
		Node start=this;
		while(start!=null)
		{
			start=start.next;
			num++;
		}
		return num;
	}
	public Node push(int num)
	{
		Node start=this;
		Node newnode=new Node(num);
		newnode.next=start;
		return newnode;
	}
	public Node pop()
	{
		Node start=this;
		if(start.top()==-99)
			return start;
		return start.next;
	}
	public void printlist()
	{
		Node start=this;
		log("Queue is");
		while(start.data!=-99)
		{
			log(start.data);
			start=start.next;
		}
	}
	public int top()
	{
		Node start=this;
		return start.data;
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
public class QueueUsingStack
{
	public static void main(String args[]) 
	{
		Node queue=create();
		PrintList(queue);
		int num;
		Scanner in = new Scanner(System.in);
		num=in.nextInt();
		queue=enqueue(queue,num);
		queue=dequeue(queue);
		queue=dequeue(queue);
		PrintList(queue);
	}
	public static Node create()
	{
		Node start=new Node(-99);
		int num;
		Scanner in = new Scanner(System.in);
		num=in.nextInt();
		while(num!=-1)
		{
			start=start.push(num);
			num=in.nextInt();
		}
		Node queuestack=new Node(-99);
		while(start.top()!=-99)
		{
			queuestack=queuestack.push(start.top());
			start=start.pop();
		}
		return queuestack;
	}
	public static Node enqueue(Node queuestack,int num)
	{
		Node start=new Node(-99);
		while(queuestack.top()!=-99)
		{
			start=start.push(queuestack.top());
			queuestack=queuestack.pop();
		}
		start=start.push(num);
		while(start.top()!=-99)
		{
			queuestack=queuestack.push(start.top());
			start=start.pop();
		}
		return queuestack;
	}
	public static Node dequeue(Node queuestack)
	{
		queuestack=queuestack.pop();
		return queuestack;
	}
	public static void PrintList(Node queuestack)
	{
		queuestack.printlist();
	}
	public static void log(String str)
	{
		System.out.println(str);
	}
}
