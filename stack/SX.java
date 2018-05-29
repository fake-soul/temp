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
public class SX
{
	public static void main(String[] args) 
	{
		String str;
		Scanner in =new Scanner(System.in);
		str=in.nextLine();
		sx(str);
	}
	public static void sx(String str)
	{
		Node start=new Node('#');
		String reqpattern="123456";
		int j=0;
		String newstr="";
		int len=str.length();
		// S=> push X=>pop

		for(int i=0;i<len;i++)
		{
			if(str.charAt(i)=='S')
			{
				start=start.push(reqpattern.charAt(j));
				j++;
			}
			else
			{
				if(start.top()!='#')
				{
					newstr=newstr+start.top();
					start=start.pop();
				}
				else
				{
					log("error");
					return;
				}
			}
		}
		log("req string :"+newstr);
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