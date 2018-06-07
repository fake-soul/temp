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
public class LevelOrder
{
	public static void main(String[] args) 
	{
		Node root=create();
		preorder(root);
		System.out.println();
		leveloder(root);

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
	public static void leveloder(Node root)
	{
		Queue<Node> queue= new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			Node tempNode=queue.poll();
			System.out.print(tempNode.data+" ");
			if(tempNode.left!=null)
				queue.add(tempNode.left);
			if(tempNode.right!=null)
				queue.add(tempNode.right);
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