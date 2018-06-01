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
public class BasicTree
{
	public static void main(String args[])
	{
		Node root;
		root=create();
		System.out.println("preorder");
		preorder(root);	
		System.out.println("inorder");
		inorder(root);
		System.out.println("postorder");
		postorder(root);
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
	public static void inorder(Node root)
	{
		if(root!=null)
		{
			inorder(root.left);
			System.out.println("\t"+root.data);
			inorder(root.right);
		}
	}
	public static void postorder(Node root)
	{
		if(root!=null)
		{
			postorder(root.left);
			postorder(root.right);
			System.out.println("\t"+root.data);
		}
	}
}
