

import java.util.Scanner;



public class swap {
	class Node
	{
		int data;
		Node next;
		Node(int val)
		{
			data=val;
			next=null;
		}
	}
	Node head;
	public static void main(String args[])
	{
		swap list1=new swap();
		list1.create();
		list1.print();
		list1.swap();	
	}
	private void swap() {
		// TODO Auto-generated method stub
		int num1,num2;
		Scanner in =new Scanner(System.in);
		num1=in.nextInt();
		num2=in.nextInt();
		if(num1==num2)
			return;
		Node ptrX1=null,ptrX2=null;
		Node ptrY1=null,ptrY2=null;
		ptrX1=ptrY1=head;
		while(ptrX1!=null || ptrX1.data!=num1)
		{
			ptrX2=ptrX1;
			ptrX1=ptrX1.next;
		}
		while(ptrY1!=null || ptrY1.data!=num2)
		{
			ptrY2=ptrY1;
			ptrY1=ptrY2.next;
		}
		if(ptrX1==null||ptrY1==null)
			return;
		Node temp=ptrX1;
		ptrX2.next=ptrY1;
		ptrX1.next=ptrY1.next;
		ptrY2.next=temp;
		ptrY1.next=temp.next;
		
	}
	private void print() {
		// TODO Auto-generated method stub
		Node ptr=head;
		while(ptr!=null)
		{
			System.out.println(ptr.data);
			ptr=ptr.next;
		}
	}
	private void create() {
		// TODO Auto-generated method stub
		int ch = 0;
		int val;
		while(ch!=-1)
		{
			Scanner in=new Scanner(System.in);
			System.out.print("enter value=");
			val=in.nextInt();
			Node ptr;
			Node newnode=new Node(val);
			System.out.println("1-insert in front   2-insert in end");
			ch=in.nextInt();
			if(ch==1)
			{
				newnode.next=head;
				head=newnode;
			}
			else
			{
				 if(head==null)
				 {
					 head=newnode;
				 }
				 else
				 {
					 ptr=head;
					 while(ptr.next!=null)
						 ptr=ptr.next;
					 ptr.next=newnode;
				 }
			}
			System.out.println("enter more??");
			ch=in.nextInt();
		}
	}
}

