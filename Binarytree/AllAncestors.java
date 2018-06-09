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
public class AllAncestors
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
		// // PrintPath(root1, array,len);
		// Boolean res=AreMirrorEqual(root1,root2);
		// if(res==true)
		// 	System.out.println("MirrorImage ");
		// else
		// 	System.out.println("Not MirrorImage");
		Scanner in = new Scanner(System.in);
		int val = in.nextInt();
		Boolean a=checkAncestors(root1,val);

	} 
	public static Boolean checkAncestors(Node root,int val)
	{
		if(root==null)
			return false;
		if( root.left==null || root.right==null || checkAncestors(root.left,val) || checkAncestors(root.right,val))
		{
			System.out.println(root.data+" ");
			return true;
		}
		return false;
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
