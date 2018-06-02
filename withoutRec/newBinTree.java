import java.util.Scanner;
import java.util.*;
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
public class newBinTree
{
	public static void main(String args[]) 
	{
		Node root;
		root=create();
		inorder(root);
		// System.out.println("Geekodgeeks");
		// withotRecInoder(root);
		System.out.println("book version");
		inorderNoRec(root);
	}
	public static void inorderNoRec(Node root)
	{
		Stack<Node> stack=new Stack<Node>();
		while(true)
		{
			while(root!=null)
			{
				stack.push(root);
				root=root.left;
			}
			if(stack.size()==0)
				break;
			root=stack.pop();
			System.out.println("\t"+root.data);
			root=root.right;
		}
	}
	// public static void withotRecInoder(Node root)
	// {
	// 	if(root==null)
	// 		return;
	// 	Stack<Node> stack = new Stack<Node>();
	// 	Node start= root;
	// 	while(start!=null)
	// 	{
	// 		stack.push(start);
	// 		start=start.left;
	// 	}
	// 	while(stack.size()>0)
	// 	{
	// 		start=stack.pop();
	// 		System.out.println("\t"+start.data);
	// 		if(start.right!=null)
	// 		{
	// 			start=start.right;
	// 			while(start!=null)
	// 			{
	// 				stack.push(start);
	// 				start=start.right;
	// 			}
	// 		}
	// 	}
	// }
	public static void inorder(Node root)
	{
		if(root!=null)
		{
			inorder(root.left);
			System.out.println("\t"+root.data);
			inorder(root.right);
		}

	}
	public static Node create()
	{
		Node newnode;
		Scanner in =  new Scanner(System.in);
		int num=in.nextInt();
		if(num==-1)
			return null;
		newnode= new Node(num);
		System.out.println("Left child of "+newnode.data);
		newnode.left=create();
		System.out.println("Right child of "+newnode.data);
		newnode.right=create();
		return newnode;
	}
}