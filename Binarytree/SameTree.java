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
public class SameTree
{
	public static void main(String[] args) 
	{
		System.out.println("1st tree");
		Node root1=create();
		System.out.println("2nd tree");
		Node root2=create();
		System.out.println("1st tree");
		preorder(root1);
		System.out.println("2nd tree");
		preorder(root2);	
		Boolean equality= AreEqual(root1,root2);
		if(equality==true)
			System.out.println("Equal");
		else
			System.out.println("Not Equal");	
	}
	public static Boolean AreEqual(Node root1, Node root2)
	{
		if(root1==null && root2==null)
			return true;
		if(root1==null || root2==null)
			return false;
		return(root1.data==root2.data && AreEqual(root1.left,root2.left) && AreEqual(root1.right,root2.right));
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
