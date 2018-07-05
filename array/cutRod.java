import java.io.*;
import java.util.*;
public class cutRod
{
	public static void main(String[] args) {
		int a[]=create();
		printArray(a);
		System.out.println(minproduct(a,a.length));
	}
	public static int minproduct(int[] a,int n)
	{
		if(n<=0)
			return 0;
		int max=-9999;
		for(int i=0;i<n;i++)
			max=maxm(max,a[i]+minproduct(a,n-i-1));
		return max;
	}
	public static int maxm(int a,int b)
	{
		if(a>b)
			return a;
		return b;
	}
	public static int[] create()
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] a=new int[n];
		Random r=new Random();
		for(int i=0;i<n;i++)
			a[i]=1+r.nextInt(10);
		return a;
	}
	public static void printArray(int[] a)
	{
		System.out.println(Arrays.toString(a));
	}
}