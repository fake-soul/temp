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
public class sec
{
	public static void main(String[] args) 
	{
		Node root=create();
		preorder(root);
		System.out.println();
		Scanner in = new Scanner(System.in);
		int value=in.nextInt();
		search(root,value);
	}
	public static void search(Node root,int val)
	{
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(root);
		if(root==null)
		{
			System.out.println("Error");
			return;
		}
		
			while(!queue.isEmpty())
			{
				Node tempNode=queue.poll();
				if(val==tempNode.data)
				{
					System.out.println("Found it");
					return;
				}
				else
				{
					if(tempNode.left!=null)
						queue.add(tempNode.left);
					if(tempNode.right!=null)
						queue.add(tempNode.right);
				}
			}
			System.out.println("NOt FoUnD");
			return;
		
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