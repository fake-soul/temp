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
			Node start1=this;
			
				Node newnode=new Node(num);
				while(start.next!=null)
					start=start.next;
				start.next=newnode;
			
			return start1;
		}
		public Node dequeue()
		{
			Node start=this;
			if(start.next==null)
			{
				log("Error");
				return start;
			}	
			else
			{
				start.next=start.next.next;
				return start;
			}	
		}
		public int queuesize()
		{
			int count=0;
			Node start=this;
			while(start!=null)
			{
				count++;
				start=start.next;
			}
			return count-1;
		}
		public int top()
		{
			Node start=this;
			if(start.next==null)
				return -99;
			return start.next.data;
		}
		public void printlist()
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
		public void log(int data)
		{
			System.out.println(data);
		}
		public void log(String data)
		{
			System.out.println(data);
		}
	}
	public class StackUsingQueue
	{
		public static void main(String args[])
		{
			Node stack=create();	
			PrintList(stack);
			System.out.println("2 pop");
			stack.dequeue();
			stack.dequeue();
			PrintList(stack);
			int num;
			Scanner in = new Scanner(System.in);
			System.out.println("push vaule??");
			num=in.nextInt();
			stack=PushInStack(stack,num);
			System.out.println(">>");
			PrintList(stack);
		}
		public static Node PushInStack(Node stackqueue,int num)
		{
			Node start=new Node(-99);
			if(stackqueue.queuesize()==0)
			{
					// start=start.enqueue(num);
					// start=start.enqueue(num);
					stackqueue=stackqueue.enqueue(num);
					// System.out.println("final stack enqueue: "+num);
					return stackqueue;
			}
			else
			{
				while(stackqueue.top()!=-99)
					{
						start=start.enqueue(stackqueue.top());
						stackqueue=stackqueue.dequeue();
					}
					stackqueue=stackqueue.enqueue(num);
					while(start.top()!=-99)
					{
						stackqueue=stackqueue.enqueue(start.top());
						start=start.dequeue();
					}
				return stackqueue;
			}
		}
		public static Node create()
		{
			Node start=new Node(-99);
			Node stackqueue=new Node(-99);
			int num;
			Scanner in = new Scanner(System.in);
			num=in.nextInt();
			while(num!=-1)
			{
				if(stackqueue.queuesize()==0)
				{
					// start=start.enqueue(num);
					// start=start.enqueue(num);
					stackqueue=stackqueue.enqueue(num);
					// System.out.println("final stack enqueue: "+num);
				}
				else
				{
					
					while(stackqueue.top()!=-99)
					{
						start=start.enqueue(stackqueue.top());
						stackqueue=stackqueue.dequeue();
					}
					stackqueue=stackqueue.enqueue(num);
					while(start.top()!=-99)
					{
						stackqueue=stackqueue.enqueue(start.top());
						start=start.dequeue();
					}
				}
					num=in.nextInt();

			}
			// System.out.println("Stack:");
			// stackqueue.printlist();
			return stackqueue;
		}
		public static void PrintList(Node stackqueue)
		{
			stackqueue.printlist();
		}
	}