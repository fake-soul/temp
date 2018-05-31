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
	public int TakeInputValue()
	{
		Scanner in = new Scanner(System.in);
		log("\tEnter req value");
		int num=in.nextInt();
		return num;
	}
	public Node PushToStart(int num)
	{
		Node start=this;
		Node newnode = new Node(num);
		newnode.next=start.next;
		start.next=newnode;
		return start;
	}
	public Node PushToStart(Node start,int num)
	{
		Node ptr=this;
		Node newnode = new Node(num);
		newnode.next=ptr.next;
		ptr.next=newnode;
		return start;
	}
	public Node PushToEnd(int num)
	{
		Node start=this;
		Node ptr=this;
		Node newnode = new Node(num);
		while(ptr.next!=null)
			ptr=ptr.next;
		ptr.next=newnode;
		return start;
	}
	public Node PushAtPos(int num)
	{
		Node start=this;
		Node ptr=this;
		log("position");
		int pos = TakeInputValue();
		if(pos<=0)
		{
			log("Not posible Numbering start at Pos=1");
			return start;
		}
		else
		{
			while(pos-1>0)
			{
				if(ptr.next==null)
				{
					log("not possible pos");
					return start;
				}
				ptr=ptr.next;
				pos--;
			}
			start=ptr.PushToStart(start,num);
			return start;
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
		else
		{
			start=start.next;
			while(start!=null)
			{
				log(start.data);
				start=start.next;
			}
		}
	}
	public Node RemoveFromStart()
	{
		Node start=this;
		if(start.next==null)
		{
			log("empty");
			return start;
		}
		else
		{
			start.next=start.next.next;
			return start;
		}
	}
	public Node RemoveFromStart(Node start)
	{
		Node ptr=this;
		if(ptr.next==null)
		{
			log("Not Possible Pos");
			return start;
		}
		else
		{
			ptr.next=ptr.next.next;
			return start;
		}
	}
	public Node RemoveFromEnd()
	{
		Node start=this;
		Node ptr=this;
		Node slow=this;
		if(start.next==null)
		{
			log("empty");
			return start;
		}
		else
		{
			ptr=ptr.next;
			while(ptr.next!=null)
			{
				slow=ptr;
				ptr=ptr.next;
			}
			slow.next=null;
			return start;
		}
	}
	public Node RemovePos()
	{
		Node start=this;
		Node ptr=this;
		if(start.next==null)
		{
			log("empty");
			return start;
		}
		else
		{
			log("position :");
			int pos=TakeInputValue();
			if(pos<1)
			{
				log("Not Possible Loc Must be >=1");
				return start;
			}
			else
			{
				while(pos-1>0)
				{
					if(ptr.next==null)
					{
						log("Not possible Loc");
						return start;
					}
					ptr=ptr.next;
					pos--;
				}
				start=ptr.RemoveFromStart(start);
				return start;
			}
		}
	}
	public Node NTh()
	{
		Node start=this;
		if(start.next==null)
		{
			log("empty");
			return start;
		}
		else
		{
			Node ptr=start.next;
			Node ptr2=ptr;
			log("which NOde ?");
			int num=TakeInputValue();
			if(num<=0)
			{
				log("Not Possible input");
				return start;
			}
			for(int i=0;i<num;i++)
			{
				if(ptr==null)
				{
					log("not Possible loc");
					return start;
				}
				ptr=ptr.next;
			}
			while(ptr!=null)
			{
				ptr=ptr.next;
				ptr2=ptr2.next;
			}
			log(ptr2.data);
			return start;
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
public class NewBasicLL
{
	public static void main(String args[]) 
	{
		Node list=LLOps();	
	}

	public static Node LLOps()
	{
		Node start=new Node(-99);
		int num;
		log(" 1 - insert top\n 2 - insert Last\n 3 - insert position \n 4 - delete top \n 5 - delete Last \n 6 - delete pos \n 7 - nthLastNode \n 8 - Print \n 9 - exit \n Enter Your Choice");
		int ch=TakeInput();
		while(ch!=-1)
		{
			if(ch==1)
			{
				log("Number to insert: ");
				num=TakeInput();
				start=start.PushToStart(num);
			}
			else if(ch==2)
			{
				log("Number to insert: ");
				num=TakeInput();
				start=start.PushToEnd(num);
			}
			else if(ch==3)
			{
				log("Number to insert: ");
				num=TakeInput();
				start=start.PushAtPos(num);
			}
			else if(ch==4)
				start=start.RemoveFromStart();
			else if(ch==5)
				start=start.RemoveFromEnd();
			else if(ch==6)
				start=start.RemovePos();
			else if(ch==7)
				start=start.NTh();
			else if(ch==8)
			{
				log("Your List");
				start.PrintList();
			}
			else if(ch==9)
				break;
			else
				log("wrong input");
			log("\n\n 1 - insert top\n 2 - insert Last\n 3 - insert position \n 4 - delete top \n 5 - delete Last \n 6 - delete pos \n 7 - nthLastNode \n 8 - Print \n 9 - exit \n Enter Your Choice");
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