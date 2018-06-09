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
public class CheckMirrorImage
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
		// PrintPath(root1, array,len);
		Boolean res=AreMirrorEqual(root1,root2);
		if(res==true)
			System.out.println("MirrorImage ");
		else
			System.out.println("Not MirrorImage");

	} 
	public static Boolean AreMirrorEqual(Node root1,Node root2)
	{
		if(root1==null && root2==null)
			return true;
		if(root1==null || root2==null)
			return false;
		else
		{
			return (AreMirrorEqual(root1.left,root2.right) && AreMirrorEqual(root1.right,root2.left));
		}
	}
	public static void swap(Node root1,Node root2)
	{
		Node tempNode=root1;
		root1=root2;
		root2=tempNode;
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
