import java.io.*;
import java.util.*;
class Node
{
	int data;
	Node right,left;
	Node(int num)
	{
		data=num;
		right=null;
		left=null;
	}
}
public class deepestNode
{
	public static void main(String[] args) 
	{
		Node root=create();
		preorder(root);
		System.out.println();
		deep(root);
	}
	public static void deep(Node root)
	{
		Node tempNode=new Node(0);
		Queue<Node> queue= new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			 tempNode=queue.poll();
			if(tempNode.left!=null)
				queue.add(tempNode.left);
			if(tempNode.right!=null)
				queue.add(tempNode.right);
			
		}
		System.out.println("Deep "+tempNode.data);
	}
	public static void preorder(Node root)
	{
		if(root!=null)
		{
			System.out.println(root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public static Node create()
	{
		Node newnode;
		Scanner in = new Scanner(System.in);
		int num=in.nextInt();
		if(num==-1)
		{
			return null;
		}
		newnode = new Node(num);
		System.out.println("Left Child of "+num);
		newnode.left=create();
		System.out.println("Right Child of "+num);
		newnode.right=create();
		return newnode;
	}
}