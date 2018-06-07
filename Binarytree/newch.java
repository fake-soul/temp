import java.io.*;
import java.util.*;
class Node
{
	int data;
	Node right;
	Node left;
	Node(int num)
	{
		data=num;
		right=left=null;
	}
}
public class newch
{
	public static void main(String args[]) 
	{
		Node root=create();
		System.out.println();
		preorder(root);
		int max=FindMax(root);
		System.out.println();
		System.out.println(max);
		Scanner in =new Scanner(System.in);
		int val=in.nextInt();
		val=FindValue(root,val);
		if(val==1)
			System.out.println("Found it");
		else
			System.out.println("Not there");
		int height=FindHeight(root);
		System.out.println("heightTree "+height);
		int leaf=FindLeaf(root);
		System.out.println("number of leaf "+leaf);
	}	
	public static int FindLeaf(Node root)
	{
		int num=0;
		if(root==null)
			return 0;
		else if(root.left==null && root.right==null)
			return 1;
		else
		{
			return num+FindLeaf(root.left)+FindLeaf(root.right);
		}
	}
	public static int FindHeight(Node root)
	{
		int leftheight,rightheight;
		if(root==null)
			return 0;
		else{
			leftheight=FindHeight(root.left);
			rightheight=FindHeight(root.right);
			if(leftheight>rightheight)
				return leftheight+1;
			else
				return rightheight+1;
		}

	}
	public static int FindValue(Node root, int val)
	{
		int temp=0;
		if(root==null)
			return 0;
		else
		{
			if(root.data==val)
			{
				temp=1;
				return temp;
			}
			else
			{
				temp=FindValue(root.left,val);
				if(temp==1)
					return temp;
				else
				{
					temp=FindValue(root.right,val);
						return temp;
				}
			}
		}
	}
	public static int FindMax(Node root)
	{
		int temp=0,maxRight,maxLeft,rootVal;
		// if(root==null)
		// 	return 0;
		// else
		// {
		// 	rootVal=root.data;
		// 	maxLeft=FindMax(root.left);
		// 	maxRight=FindMax(root.right);
		// 	if(temp<maxLeft)
		// 		temp=maxLeft;
		// 	else
		// 		temp=maxRight;
		// 	if(rootVal>temp)
		// 		temp=rootVal;
		// 	return temp;
		// }
		if(root!=null)
		{
			rootVal=root.data;
			maxRight=FindMax(root.right);
			maxLeft=FindMax(root.left);
			if(maxRight>maxLeft)
				temp=maxRight;
			else
				temp=maxLeft;
			if(temp<rootVal)
				temp=rootVal;
		}
		return temp;
	}
	public static void preorder(Node root)
	{
		if(root!=null)
		{
			System.out.print(" "+root.data);
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
		newnode=new Node(num);
		System.out.println("Left child of "+num);
		newnode.left=create();
		System.out.println("Right child of "+num);
		newnode.right=create();
		return newnode;
	}
}