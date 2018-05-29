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
		public void enqueue(int num)
		{
			Node start=this;
			if(start==null)
				return;
			else
			{
				Node newnode=new Node(num);
				while(start.next!=null)
					start=start.next;
				start.next=newnode;
			}
			return ;
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
				return 0;
			return start.next.data;
		}
		public void printlist()
		{
			Node start=this;
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
	public class qu
	{
		public static void main(String args[]) 
		{
			Node queue = create();
			PrintList(queue);	
		}
		public static Node create()
		{
			int num;
			Scanner in = new Scanner(System.in);
			// num=in.nextInt();
			Node start=new Node(99);
			// log("more ??");
			num=in.nextInt();
			while(num!=-1)
			{
				start.enqueue(num);
				log("enqueue "+num);
				log("more??");
				num=in.nextInt();
			}
			log("dequeue??");
			log("size "+start.queuesize());
			num=in.nextInt();
			while(num!=-1)
			{
				log("dequeue "+start.top());
				start=start.dequeue();
				log("more");
				num=in.nextInt();
			}
			return start;
		}
		public static void PrintList(Node start)
		{
			start.printlist();
		}
		public static void log(int data)
		{
			System.out.println(data);
		}
		public static void log(String data)
		{
			System.out.println(data);
		}
	}