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
public class EemoveAdjDup
{
	public static void main(String[] args) 
	{
		String str;
		Scanner in =new Scanner(System.in);
		str=in.nextLine();
		RemoveAdjDup(str);
	}
	public static void RemoveAdjDup(String str)
	{
		Node start = new Node('#');
		int len=str.length();
		int i=0;
		char justpop='#';
		String newstr="";
		start=start.push(str.charAt(i));
		i++;
		while(i!=len)
		{
			if(str.charAt(i)==start.top())
			{
				i++;
				justpop=start.top();
				// log("pop  value"+justpop);
				start=start.pop();
			}
			else if(str.charAt(i)==justpop)
			{
				i++;
				// log("pop with justpop "+start.top());
				// start=start.pop();
			}
			else
			{
				start=start.push(str.charAt(i));
				// log("just push "+str.charAt(i));
				i++;
			}
		}
		if(start.top()=='#')
		{
			log("empty");
			return;
		}
		while(start.top()!='#')
		{
			newstr=start.top()+newstr;
			start=start.pop();
		}
		log(newstr);
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