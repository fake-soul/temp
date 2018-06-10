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

public class BasicOper
{
	Node root;
	BasicOper()
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
	Boolean FIND_BST(Node root,int key)
	{
		Boolean res=false;
		if(root==null)
			return res;
		if(key<root.data)
			return FIND_BST(root.left,key);
		else if(key>root.data)
			return FIND_BST(root.right,key);
		return true;
	}
	boolean FINDFunBST(int key)
	{
		Boolean res=FIND_BST(root,key);
		return res;
	}
	Boolean FIND(Node root,int key)
	{
		Boolean res=false;
		if(root==null)
		{
			return res;
		}
		else
		{
			if(root.data==key)
				return true;
			else
			{
				res=FIND(root.left,key);
				if(res==true)
					return res;
				else
				{
					res=FIND(root.right,key);
					return res;
				}
			}
		}

	}
	Boolean FINDFun(int key)
	{
		Boolean res=FIND(root,key);
		return res;
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
		BasicOper bst = new BasicOper();
		for(int i=0;i<10;i++)
			bst.insert(1+rand.nextInt(100));
		bst.preoder();
		System.out.println();
		Scanner in = new Scanner(System.in);
		int ch=in.nextInt();
		if(ch==1) // Basic Method
		{
			int findval=in.nextInt();
			Boolean res=bst.FINDFun(findval);
			if(res==true)
				System.out.println("Found it");
			else
				System.out.println("Nope Not there");
		}
		if(ch==2)
		{
			int findval=in.nextInt();
			Boolean res= bst.FINDFunBST(findval);
			if(res==true)
				System.out.println("Found it");
			else
				System.out.println("Nope Not there");
		}
	}
}	