import java.util.Scanner;
class Node 
{
	int data;
	Node right;
	Node left;
	Node(int num)
	{
		data=num;
		right=null;
		left=null;
	}
}
public class heightTree
{
	public static void main(String args[])
	{
		Node root;
		root=create();
		System.out.println("preorder");
		preorder(root);	
		Scanner in = new Scanner(System.in);
		int num;
		num=height(root);
		System.out.println("height "+num);
	}
	public static Node create()
	{
		Node newnode;
		Scanner in = new Scanner(System.in);
		int num=in.nextInt();
		if(num==-1)
			return null;
		newnode = new Node(num);
		System.out.println("left child of "+ newnode.data);
		newnode.left=create();
		System.out.println("right child of "+ newnode.data);
		newnode.right=create();
		return newnode;
	}
	public static void preorder(Node root)
	{
		if(root!=null)
		{
			System.out.println("\t"+root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}
	public static int height(Node root)
	{
		int leftheight,rightheight;
		if(root==null)
			return 0;
		else
		{
			leftheight=height(root.left);
			rightheight=height(root.right);
			if(leftheight>rightheight)
			{
				leftheight++;
				return leftheight;
			}
			else
			{
				rightheight++;
				return rightheight;
			}
		}
	}
	
}
