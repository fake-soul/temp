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
public class numLeaf
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
		System.out.println("leaf "+num);
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
		int num=0;
		if(root==null)
			return 0;
		else if(root.left==null && root.right==null)
		{
			return 1;
		}
		else
		{
			num=num+height(root.left);
			num=num+height(root.right);
			return num;
		}
	}
	
}
