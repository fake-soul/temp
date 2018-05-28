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
public class BalancingBrace{
	public static void main(String[] args) 
	{
		
		Scanner in=new Scanner(System.in);
		String str = in.nextLine();
		// char ch = str.charAt(4);
		// log(ch);
		BraceBalance(str);
		// Node stack=create();
		// PrintList(stack);

		// log("1push");
		// stack=pushNode(stack);
		// log("new stack");
		// PrintList(stack);
		// log("two pop");
		// stack=popNode(stack);
		// stack=popNode(stack);
		// log("new stack");
		// PrintList(stack);
		// int size=StackSize(stack);
		// log("stack size="+size);
	}
	public static void BraceBalance(String str)
	{
		int len=str.length();
		Node start= new Node(0);
		for(int i=0;i<len;i++)
		{
			if(str.charAt(i) == '{' || str.charAt(i)== '(' || str.charAt(i)== '[')
			{
				start=start.push(1);
			}
			if(str.charAt(i)== '}' || str.charAt(i)== ')' || str.charAt(i)== ']')
			{
				if(start.stacksize()<=1)
				{
					log("Not Balanced");
					return;
				}
				start=start.pop();
			}
		}
		if(start.stacksize()==1)
		{
			log("Balanced");
		}
		else
			log("Not Balanced");
	}
	public static Node create()
	{
		Scanner in=new Scanner(System.in);
		int num=in.nextInt();
		Node start=new Node(num);
		log("more");
		num=in.nextInt();
		while(num!=-1)
		{
			log("more");
			start=start.push(num);
			num=in.nextInt();
		}
		return start;
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
	public static void log(char ch)
	{
		System.out.println(ch);
	}
}	