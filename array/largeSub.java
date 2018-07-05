import java.io.*;
import java.util.*;
public class largeSub
{
	public static void main(String[] args) {
		int a[]=create();
		printArray(a);
		System.out.println(minproduct(a,a.length));
	}
	public static int minproduct(int[] a,int m)
	{
		Arrays.sort(a);
		int[] aa=new int[m];
		aa[m-1]=1;
		for(int i=m-2;i>=0;i--)
		{
			int max=0;
			for(int j=i+1;j<m;j++)
				if(a[j]%a[i]==0)
					max=maxm(max,aa[j]);
			aa[i]=1+max;
		}
		Arrays.sort(aa);
		return aa[m-1];
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