import java.util.*;
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
}
class RecTree
{
	public static void main(String args[]) 
	{
		Node root;
		root=create();
		System.out.println("Without rec");	
		inorder(root);
		System.out.println("With Rec");
		inorderRec(root);
	}
	public static void inorder(Node root)
	{
		if(root==null)
			return ;
		Stack<Node> stack= new Stack<Node>();
		Node node =root;
		while(node!=null)
		{
			stack.push(node);
			node=node.left;
		}
		while(stack.size()>0)
		{
			node=stack.pop();
			System.out.println(node.data+ " ");
			if(node.right!=null)
			{
				node= node.right;
				while(node!=null)
				{
					stack.push(node);
					node=node.left;
				}
			}
		}
	}
	public static void inorderRec(Node root)
	{
		if(root!=null)
		{
			inorderRec(root.left);
			System.out.println("\t"+root.data);
			inorderRec(root.right);
		}
	}
	public static Node create()
	{
		Node newnode;
		Scanner in = new Scanner(System.in);
		int num=in.nextInt();
		if(num!=-1)
			return null;
		newnode = new Node(num);
		System.out.println("left child of "+ newnode.data);
		newnode.left=create();
		System.out.println("Right child of "+ newnode.data);
		newnode.right=create();
		return newnode;
	}
}