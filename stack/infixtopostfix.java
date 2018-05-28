import java.util.Scanner;

class Node
{	
	char data;
	Node next;
	Node(char num)
	{
		data=num;
		next=null;
	}
	public char top()
	{
		Node start=this;
		return start.data;
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
	public Node push(char num)
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
	public void log(char num)
	{
		System.out.println(num);	
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
public class infixtopostfix{
	public static void main(String[] args) 
	{
		
		Scanner in=new Scanner(System.in);
		String str = in.nextLine();
		// char ch = str.charAt(4);
		// log(ch);
		postfix(str);
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
	public static void postfix(String str)
	{
		int len=str.length();
		int StackTopPriority=0,StringPriority=0;
		Node start= new Node('X');
		for(int i=0;i<len;i++)
		{
			if((str.charAt(i)>=65 && str.charAt(i)<=90) || (str.charAt(i)>=97 && str.charAt(i)<=122))
			{
				log(str.charAt(i));	
			}
			else
			{
				if(start.stacksize()==1)
				{
					start=start.push(str.charAt(i));
				}
				else if(start.stacksize()<1)
				{
					log("error");
					return;
				}
				else
				{
					StackTopPriority=getpriorty(start.top());
					StringPriority=getpriorty(str.charAt(i));
					if(StackTopPriority>=StringPriority)
					{
						log(start.top());
						start=start.pop();
						start=start.push(str.charAt(i));
					}
					else{
						log(str.charAt(i));
					}
				}
			}
		}
		while(start.stacksize()!=1)
		{
			log(start.top());
			start=start.pop();
		}
	}
	public static int getpriorty(char ch)
	{
		// Only for * / % + -

		if(ch=='*' || ch=='/' || ch=='%')
			return 2;
		else {
			return 1;
		}
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