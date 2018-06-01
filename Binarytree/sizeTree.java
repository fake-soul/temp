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
public class sizeTree
{
	public static void main(String args[])
	{
		Node root;
		root=create();
		System.out.println("preorder");
		preorder(root);	
		// Scanner in = new Scanner(System.in);
		// int num=in.nextInt();
		int num=size(root);
		// if(num==1)
			System.out.println("Size "+num);
		// else
			// System.out.println("Nope, Not there");
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
	public static int size(Node root)
	{
		int left=0,right=0;
		if(root==null)
			return 0;
		else
		{
			left=size(root.left);
			right=size(root.right);
			return left+right+1;
		}
	}
}
