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
	public Node enqueue(int num)
	{
		Node start=this;
		Node ptr=this;
		Node newnode = new Node(num);
		while(ptr.next!=null)
		{
			ptr=ptr.next;
		}
		ptr.next=newnode;
		return start;
	}
	public Node dequeue()
	{
		Node start=this;
		if(start.next==null)
		{
			log("empty");
			return start;
		}
		start.next=start.next.next;
		return start;
	}
	public int Qtop()
	{
		Node start=this;
		if(start.next==null)
		{
			// log("empty");
			return -99;
		}	
		return start.next.data;
	}
	public Node push(int num)
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
			log("empty");
			return start;
		}
		start=start.next;
		return start;
	}
	public int Stop()
	{
		Node start=this;
		if(start.next==null)
		{
			// log("empty");
			return -99;
		}
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

	public void PrintStack()
	{
		Node start=this;
		log("print");
		while(start.next!=null)
		{
			log(start.data);
			start=start.next;
		}
		return;
	}
	public void PrintQueue()
	{
		Node start=this;
		start=start.next;
		while(start!=null)
		{
			log(start.data);
			start=start.next;
		}
		return;
	}
}
public class revQueue
{
	public static void main(String args[]) 
	{
		// tempcreate();
		Node queue=create();
		Node revQueue=REV(queue);
	}
	public static Node REV(Node startQueue)
	{
		Node startStack=new Node(-99);
		while(startQueue.Qtop()!=-99)
		{
			startStack=startStack.push(startQueue.Qtop());
			startQueue=startQueue.dequeue();
		}
		while(startStack.Stop()!=-99)
		{
			startQueue=startQueue.enqueue(startStack.Stop());
			startStack=startStack.pop();
		}
		System.out.println("REvQueue is:");
		startQueue.PrintQueue();
		return startQueue;
	}
	public static Node create()
	{
		Node start=new Node(-99);
		Scanner in = new Scanner(System.in);
		int num=in.nextInt();
		while(num!=-1)
		{
			start=start.enqueue(num);
			num=in.nextInt();
		}
		System.out.println("Queue is:");
		start.PrintQueue();
		return start;
	}
	// public static void tempcreate()
	// {
	// 	// Node startQueue=new Node(-99);
	// 	Scanner in = new Scanner(System.in);
	// 	int num=in.nextInt();
	// 	// while(num!=-1)
	// 	// {
	// 	// 	startQueue=startQueue.enqueue(num);
	// 	// 	num=in.nextInt();
	// 	// }
	// 	// startQueue.PrintQueue();
		
	// 	// num=in.nextInt();
	// 	// while(num!=-1)
	// 	// {
	// 	// 	startQueue=startQueue.dequeue();
	// 	// 	top=startQueue.Qtop();
	// 	// System.out.println("Top ele"+top);
	// 	// 	num=in.nextInt();
	// 	// }
	// 	// startQueue.PrintQueue();
	// 	Node startStack=new Node(-99);
	// 	while(num!=-1)
	// 	{
	// 		startStack=startStack.push(num);
	// 		num=in.nextInt();
	// 	}
	// 	startStack.PrintStack();
	// 	int top=startStack.Stop();
	// 	System.out.println("Top ele"+top);
	// 	num=in.nextInt();
	// 	while(num!=-1)
	// 	{
	// 		startStack=startStack.pop();
	// 		top=startStack.Stop();
	// 	System.out.println("Top ele"+top);
	// 		num=in.nextInt();
	// 	}
	// 	startStack.PrintStack();
	// }
}