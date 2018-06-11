import java.util.*;
import java.io.*;
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

public class kTHnode
{
	Node root;
	kTHnode()
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
	void kthMIN()
	{
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		int min=KTHMIN(root,k);
		System.out.println("Min => "+min);
	}
	int KTHMIN(Node root,int k)
	{
		Stack<Node> stack= new Stack<Node>();
		int res=0;
		if(root==null)
			return 0;
		while(!stack.isEmpty() || root!=null)
		{
			if(root!=null)
			{
				stack.push(root);
				root=root.left;
			}
			else
			{
				Node tempNode= stack.pop();
				k--;
				if(k==0)
				{
					res=tempNode.data;
				}
				root=tempNode.right;
			}
		}
		return res;
	}
	void validBST()
	{
		boolean res=BST_valid(root);
		if(res==true)
			System.out.println("Valid BST");
		else
			System.out.println("Not valid BST");
	}
	Boolean BST_valid(Node root)
	{
		if(root==null)
			return true;
		if(root.left!=null && root.data<MAXVALUE(root.left))
			return false;
		if(root.right!=null && root.data>MINVALUE(root.right))
			return false;
		if(BST_valid(root.left)==false || BST_valid(root.right)==false)
			return false;
		return true;
	}
	// void DELETEfun(int key)
	// {
	// 	root=DELETE_FUN(root,key);
	// }
	// Node DELETE_FUN(Node root,int key)
	// {
	// 	if(root==null)
	// 	{
	// 		System.out.println("Not there");
	// 	}
	// 	else if(key<root.data)
	// 	{
	// 		DELETE_FUN(root.left,key);
	// 	}
	// 	else if(key>root.data)
	// 	{
	// 		DELETE_FUN(root.right,key);
	// 	}
	// 	else
	// 	{
	// 		if(root.left!=null && root.right!=null)
	// 		{
	// 			//repalce with largest in left Sub tree
	// 			int temp=MAXVALUE(root.left);
	// 			root.data=temp;
	// 			root.left=DELETE_FUN(root.left,root.data);
	// 		}
	// 		else
	// 		{
	// 			//Single child
	// 			Node temp2=root;
	// 			if(root.left==null)
	// 				root=root.left;
	// 			if(root.right==null)
	// 				root=root.right;

	// 		}
	// 	}
	// 	return root;
	// }
	 // This method mainly calls deleteRec()
    void deleteKey(int key)
    {
        root = deleteRec(root, key);
    }
 
    /* A recursive function to insert a new key in BST */
    Node deleteRec(Node root, int key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)  return root;
 
        /* Otherwise, recur down the tree */
        if (key < root.data)
            root.left = deleteRec(root.left, key);
        else if (key > root.data)
            root.right = deleteRec(root.right, key);
 
        // if key is same as root's key, then This is the node
        // to be deleted
        else
        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.data = MINVALUE(root.right);
 
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }
 
        return root;
    }
	int MINVLAUE_fun()
	{
		int value=MINVALUE(root);
		return value;
	}
	int MINVALUE(Node root)
	{
		if(root==null)
			return -99;
		else if(root.left==null)
			return root.data;
		else
			return MINVALUE(root.left);
	}
	int MAXVALUE_fun()
	{
		return MAXVALUE(root);
	}
	int MAXVALUE(Node root)
	{
		if(root==null)
			return -99;
		else if(root.right==null)
			return root.data;
		else
			return MAXVALUE(root.right);
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
		kTHnode bst = new kTHnode();
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
		if(ch==2) //BST Method
		{
			int findval=in.nextInt();
			Boolean res= bst.FINDFunBST(findval);
			if(res==true)
				System.out.println("Found it");
			else
				System.out.println("Nope Not there");
		}
		if(ch==3)   // MIn value
		{
			int min_value=bst.MINVLAUE_fun();
			System.out.println("min_value = "+min_value);
		}
		if(ch==4)
		{
			int max_value=bst.MAXVALUE_fun();
			System.out.println("max_value => "+max_value);
		}
		if(ch==5)
		{
			int deletevalue=in.nextInt();
			bst.deleteKey(deletevalue);
			System.out.println();
			bst.preoder();
		}
		if(ch==6)
		{
			bst.validBST();
		}
		if(ch==7)
		{
			bst.kthMIN();
		}
	}
}	