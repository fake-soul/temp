import java.util.Scanner;
class Node
{
	int data;
	Node left;
	Node right;
	Node(int num)
	{
		data=num;
		left=null;
		right=null;
	}
	public Node Push(int num)
	{
		Node start=this;
		Node newnode=new Node(num);
		newnode.next=start;
		return newnode;
	}
	public Node Pop()
	{
		Node start=this;
		if(start.next==null)
		{
			return start;
		}
		return start.next;
	}
	public int Top()
	{
		Node start=this;
		if(start.next==null)
		{
			return -99;
		}
		return start.data;
	}
}
public class BasicTreeNonRecursive
{
	public static void main(String args[]) 
	{
		Node root =  create();
	}
	public static Node create()
	{
		Node newnode;
		Scanner in = new Scanner(System.in);
		int num=in.nextInt();
		if(num=-1)
			return null;
		newnode = new Node(num);
		System.out.println("left child of "+ newnode.data);
		newnode.left=create();
		System.out.println("Right child of "+ newnode.data);
		newnode.right=craete();
		return newnode;
	}
	public static void preorderNonRec(Node root)
	{
		Node stack=new Node(-99);
		while(1)
		{
			while(root!=null)
			{
				System.out.println("=>"+root.data);
				stack=stack.Push()
			}
		}
	}
}