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
public class RootToLeaf
{
	public static void main(String[] args) 
	{
		System.out.println("1st tree");
		Node root1=create();
		// System.out.println("2nd tree");
		// Node root2=create();
		System.out.println("1st tree");
		preorder(root1);
		int[] array=new int[100];
		int len=0;
		// System.out.println("2nd tree");
		// preorder(root2);	
		PrintPath(root1, array,len);	

	} 
	public static void PrintPath(Node root,int[] array,int len)
	{
		if(root==null)
			return;
		array[len]=root.data;
		len++;
		if(root.left==null && root.right==null)
			printArray(array,len);
		else
		{
			PrintPath(root.left,array,len);
			PrintPath(root.right,array,len);
		}
	}
	public static void printArray(int[] array,int len)
	{
		for(int i=0;i<len;i++)
			System.out.print(array[i]+"\t");
		System.out.println();		
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
