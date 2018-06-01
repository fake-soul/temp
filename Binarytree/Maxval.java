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
public class Maxval
{
	public static void main(String args[])
	{
		Node root;
		root=create();
		System.out.println("preorder");
		preorder(root);	
		int max=FindMax(root);
		System.out.println("Max value "+max);
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
	public static int FindMax(Node root)
	{
		int root_val,left,right,max=0;
		if(root!=null)
		{
			root_val=root.data;
			left=FindMax(root.left);
			right=FindMax(root.right);
			if(left>right)
				max=left;
			else
				max=right;
			if(root_val>max)
				max=root_val;
		}
		return max;
	}
}
