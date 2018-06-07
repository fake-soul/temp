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
public class leafNode
{
	public static void main(String[] args) 
	{
		Node root=create();
		preorder(root);
		System.out.println();
		leafNodes(root);
	}
	public static void leafNodes(Node root)
	{
		int count=0;
		if(root==null)
		{
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			Node tempNode=queue.poll();
			if(tempNode.left==null && tempNode.right==null)
				count++;
			if(tempNode.left!=null)
				queue.add(tempNode.left);
			if(tempNode.right!=null)
				queue.add(tempNode.right);
		}
		System.out.println("Total "+count);
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