import java.util.Scanner;

class Node
{
	int data;
	Node right,left;
	Node(int num)
	{
		data=num;
		right=left=null;
	}
}
public class ch 
{
	public static void main(String args[])
	{
		Node root=create();
		preorder(root);
		int max=FindMax(root);
		System.out.println("Max value "+max);
		Scanner in = new Scanner(System.in);
		int sec=in.nextInt();
		int res=secNode(root,sec);
		if(res==1)
			System.out.println("Found it");
		else
			System.out.println("Nope, Not there");
	}
	public static int secNode(Node root,int val)
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
					temp=secNode(root.left,val);
					if(temp==1)
						return temp;
					else
					{
						temp=secNode(root.right,val);
						return temp;
					}
			}
		}
	}
	public static int FindMax(Node root)
	{
		int root_val,left,right,max=0;
		if(root!=null)
		{
			root_val=root.data;
			left=FindMax(root.left);
			right=FindMax(root.right);
			if(left>right)
				max=left;
			else
				max=right;
			if(root_val>max)
				max=root_val;
		}
		return max;
	}

	private static void preorder(Node root) {
		// TODO Auto-generated method stub
		if(root==null)
			return ;
		System.out.println(root.data);
		preorder(root.left);
		preorder(root.right);
	}

	private static Node create() {
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
}

