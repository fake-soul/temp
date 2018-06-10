import java.util.*;
class Node
{
	int data;
	Node left;
	Node right;
	Node(int num)
	{
		data=num;
		left=null;
		right=null;
	}
}

public class Basic
{
	Node root;
	Basic()
	{
		root=null;
	}
	void insert(int key)
	{
		root=insertRec(root,key);
	}
	void preoder()
	{
		preoderRec(root);
	}
	void preoderRec(Node root)
	{
		if(root!=null)
		{
			System.out.print(root.data+" ");
			preoderRec(root.left);
			preoderRec(root.right);
		}
	}
	Node insertRec(Node root,int key)
	{
		if(root==null)
		{
			root= new Node(key);
			return root;
		}
		if(key<root.data)
			root.left=insertRec(root.left,key);
		if(key>=root.data)
			root.right=insertRec(root.right,key);
		return root;
	}
	public static void main(String[] args) 
	{
		Random rand = new Random();
		// for(int i=0;i<20;i++)
		// System.out.println(1+rand.nextInt(100));
		Basic bst = new Basic();
		for(int i=0;i<10;i++)
			bst.insert(1+rand.nextInt(100));
		bst.preoder();
	}
}	