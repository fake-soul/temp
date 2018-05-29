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
		if(start==null)
			return null;
		return start.next;
	}
		public int top()
	{
		Node start=this;
		return start.data;
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
public class minValueStack{
	public static void main(String[] args) 
	{
		Node stack=create();
		PrintList(stack);
	}
	public static Node create()
	{
		Scanner in=new Scanner(System.in);
		int num=in.nextInt();
		Node start=new Node(num);
		int minvalue=0;
		Node sizestart=new Node(num);
		log("more");
		num=in.nextInt();
		while(num!=-1)
		{
			log("more");
			start=start.push(num);
			minvalue=getminvalue(num,sizestart.top());
			sizestart=sizestart.push(minvalue);
			num=in.nextInt();
		}
		log("min value="+sizestart.top());
		return start;
	}
	public static int getminvalue(int a, int b)
	{
		if(a<=b)
			return a;
		else
			return b;
	}
	public static Node pushNode(Node start)
	{
		Scanner in=new Scanner(System.in);
		int num=in.nextInt();
		start=start.push(num);
		return start;
	}
	public static Node popNode(Node start)
	{
		start=start.pop();
		return start;
	}
	public static void log(String str)
	{
		System.out.println(str);
	}
	public static void PrintList(Node start)
	{
		start.printlist();
	}
	public static int StackSize(Node start)
	{
		return start.stacksize();
	}
}