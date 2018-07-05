import java.io.*;
import java.util.*;
public class coin
{
	public static void main(String[] args) {
		int a[]=create();
		printArray(a);
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		System.out.println(minproduct(a,a.length,n));
	}
	public static int minproduct(int[] a,int m,int n)
	{
		if(n==0)
			return 1;
		if(n<0)
			return 0;
		if(m<=0 && n>=1)
			return 0;
		return minproduct(a,m-1,n)+minproduct(a,m,n-a[m-1]);
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