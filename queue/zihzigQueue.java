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
	public void enqueueStart(int num)
	{
		Node start=this;
		Node newnode= new Node(num);
		newnode.next=start.next;
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
	public void enqueueEnd(int num)
	{
		Node start=this;
		Node newnode= new Node(num);
		while(start.next!=null)
			start=start.next;
		start.next=newnode;
	}
	public void dequeueEnd()
	{
		Node start=this;
		if(start.next==null)
		{
			log("Underflow");
			return ;
		}
		while(start.next.next!=null)
			start=start.next;
		start.next=null;
	}
	public int QueueSize()
	{
		Node start=this;
		if(start.next==null)
			return 0;
		else
		{
			start=start.next;
			int count=0;
			while(start!=null)
			{
				count++;
				start=start.next;
			}
			return count;
		}
	}
	public int Top()
	{
		Node start=this;
		if(start.next==null)
		{
			// log("Empty");
			return -99;
		}
		return start.next.data;
	}
	public int Last()
	{
		Node start=this;
		if(start.next==null)
		{
			log("Empty");
			return 0;
		}
		while(start.next!=null)
		{
			start=start.next;
		}
		return start.data;
	}
	public Node halflist()
	{
		Node start=this;
		if(start.next==null)
		{
			log("Empty");
			return start;
		}
		else if(start.next.next==null)
		{
			log("Single Element");
			return start;
		}
		else
		{
			Node midstart=new Node(-99);
			int midlen=start.QueueSize()/2;
			start=start.next;
			for(int i=1;i<midlen;i++)
				start=start.next;
			if(midlen%2==0)
			{
				while(midlen>=0)
				{
					midstart.enqueueEnd(start.Top());
					start.dequeueStart();
					midlen--;
				}
			}
			else
			{
				while(midlen>0)
				{
					midstart.enqueueEnd(start.Top());
					start.dequeueStart();
					midlen--;
				}
			}
			return midstart;
		}
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
		public void Zig(Node start,Node midstart)
		{
			Node zigstart=this;
			while(start.Top()!=-99 || midstart.Top()!=-99)
			{
				zigstart.enqueueEnd(start.Top());
				start.dequeueStart();
				zigstart.enqueueEnd(midstart.Top());
				midstart.dequeueStart();
			}
			while(start.Top()!=-99)
			{
				zigstart.enqueueEnd(start.Top());
				start.dequeueStart();
			}
			while(midstart.Top()!=-99)
			{
				zigstart.enqueueEnd(midstart.Top());
				midstart.dequeueStart();
			}
		}
}
public class zihzigQueue
{
	public static void main(String args[]) 
	{
		Node queue=create();	
	}
	public static Node create()
	{
		Node start=new Node(-99);
		int num;
		log(" 1 - insert Front\n 2 - insert Last\n  3 - delete top \n 4 - delete Last \n 5- top \n 6 - last\n 7 - Print \n 8 - exit \n 9- Zigzig \nEnter Your Choice");
		int ch=TakeInput();
		while(ch!=-1)
		{
			if(ch==1)
			{
				log("Number to insert: ");
				num=TakeInput();
				start.enqueueStart(num);
			}
			else if(ch==2)
			{
				log("Number to insert: ");
				num=TakeInput();
				start.enqueueEnd(num);
			}
			else if(ch==3)
			{
				start.dequeueStart();
			}
			else if(ch==4)
				start.dequeueEnd();
			else if(ch==5)
				log("Top=> "+start.Top());
			else if(ch==6)
				log("Last=> "+start.Last());
			else if(ch==7)
			{
				log("Your List");
				start.PrintList();
			}
			else if(ch==8)
				break;
			else if(ch==9)
			{
				Node partQueue=start.halflist();
				Node newQueue=new Node(-99);
				newQueue.Zig(start,partQueue);
				newQueue.PrintList();
			}
			else
				log("wrong input");
			log(" 1 - insert Front\n 2 - insert Last\n  3 - delete top \n 4 - delete Last \n 5- top \n 6 - last\n 7 - Print \n 8 - exit \n9- Zigzig \n Enter Your Choice");
			ch=TakeInput();
		}
		return start;
	}
	public static int TakeInput()
	{
		Scanner in = new Scanner(System.in);
		log("\t Input Req Value:");
		int num=in.nextInt();
		return num;
	}
	public static void log(int num)
    {
        System.out.println(num);
    }
    public static void log(String string)
    {
        System.out.println(string);
    }
}