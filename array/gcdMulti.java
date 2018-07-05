import java.io.*;
import java.util.*;
public class gcdMulti
{
	public static void main(String[] args) {
		int[] a=create();
		printArray(a);
		maxlength(a);
	}
	public static void maxlength(int[] a)
	{
		int n=a.length;
		Scanner in =new Scanner(System.in);
		int k=in.nextInt();
		int count=0;
		for(int i=0;i<n;i++)
		{
			if(a[i]!=1 && a[i]>k)
			{
				count=count+min(a[i]%k,k-a[i]%k);
			}
			else
			{
				count=count+k-a[i];
			}
		}
		System.out.println("count "+count);
	}
	public static int min(int a,int b)
	{
		if(a>b)
			return b;
		else
			return a;
	}
	public static int[] create()
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] a=new int[n];
		Random r=new Random();
		for(int i=0;i<n;i++)
			a[i]=0+r.nextInt(100);
		return a;
	}
	public static void printArray(int[] a)
	{
		System.out.println(Arrays.toString(a));
	}
}