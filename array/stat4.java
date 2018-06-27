import java.util.*;
import java.io.*;
public class stat4
{
	public static void main(String[] args) 
	{
		int[] a=create();
		printArray(a);	
		int[] b= create();
		printArray(b);
		fun(a,a.length,b,b.length);
	}
	public static void fun(int[] a,int n1,int[] b,int n2)
	{
		// PriorityQueue <Integer> q1=new PriorityQueue<Integer>();
		// PriorityQueue <Integer> q2=new PriorityQueue<Integer>();
		Arrays.sort(a);
		Arrays.sort(b);
		printArray(a);
		printArray(b);

		System.out.println(a[n1-1]+" "+b[n2-1]);
		if(a[n1-1]>b[n2-1])
		{
			if(n2!=1)
				n2--;
			System.out.println(a[n1-1]+" "+b[n2-1]);
			if(n2!=1)
				n2--;
			System.out.println(a[n1-1]+" "+b[n2-1]);
		}
		else
		{
			if(n1!=1)
				n1--;
			System.out.println(a[n1-1]+" "+b[n2-1]);
			if(n1!=1)
				n1--;
			System.out.println(a[n1-1]+" "+b[n2-1]);
		}
		


	}
	// public static int fun()
	// {
	// 	PriorityQueue <Integer> pq=new PriorityQueue<Integer>();
	// 	for(int i=0;i<n;i++)
	// 	{
	// 		pq.add(new Integer (a[i]));
	// 	}
	// 	System.out.print("k =");
	// 	Scanner in=new Scanner(System.in);
	// 	int k =in.nextInt();
	// 	int pro=1;
	// 	for(int i=0;i<k;i++)
	// 		pro=pro*pq.poll();	
	// 	return pro;
	// }
	public static void printArray(int[] a)
	{
		System.out.println();
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	public static int[] create()
	{
		Scanner in=new Scanner(System.in);
		int n =in.nextInt();
		int[] a=new int[n];
		Random rand=new Random();
		for(int i=0;i<n;i++)
			a[i]=0+rand.nextInt(100);
		return a;
	}
}