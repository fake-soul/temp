import java.util.*;
import java.io.*;
public class stat3
{
	public static void main(String[] args) 
	{
		int[] a=create();
		printArray(a);	
		int reqnum=fun(a,a.length);
		System.out.println(reqnum);
	}
	public static int fun(int[] a,int n)
	{
		PriorityQueue <Integer> pq=new PriorityQueue<Integer>();
		for(int i=0;i<n;i++)
		{
			pq.add(new Integer (a[i]));
		}
		System.out.print("k =");
		Scanner in=new Scanner(System.in);
		int k =in.nextInt();
		int pro=1;
		for(int i=0;i<k;i++)
			pro=pro*pq.poll();	
		return pro;
	}
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