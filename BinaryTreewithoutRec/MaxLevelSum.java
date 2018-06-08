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
public class MaxLevelSum
{
	public static void main(String[] args) 
	{
		System.out.println("1st tree");
		Node root1=create();
		// System.out.println("2nd tree");
		// Node root2=create();
		System.out.println("1st tree");
		preorder(root1);
		// System.out.println("2nd tree");
		// preorder(root2);	
		levelSum(root1);	
	}
	public static void levelSum(Node root)
	{
		if(root==null)
			return;
		int sum=0,maxSum=0;
		int level=0,maxlevel=0;
		//level count starts from 0
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty())
		{
			Node tempNode= queue.poll();
			if(tempNode==null)
			{
				if(sum>maxSum)
				{
					maxSum=sum;
					maxlevel=level;
				}
				sum=0;
				if(!queue.isEmpty())
				{
					queue.add(null);
				}
				level++;
			}
			else
			{
				sum=sum+tempNode.data;
				if(tempNode.left!=null)
					queue.add(tempNode.left);
				if(tempNode.right!=null)
					queue.add(tempNode.right);
			}
		}
		System.out.println("Max sum is "+maxSum+" @ level "+maxlevel);

	} 
	public static Node create()
	{
		Scanner in= new Scanner(System.in);
		int num=in.nextInt();
		if(num==-1)
			return null;
		Node newnode= new Node(num);
		System.out.println("Left Child of "+num);
		newnode.left=create();
		System.out.println("Right Child of "+num);
		newnode.right=create();
		return newnode;
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

}
