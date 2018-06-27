import java.io.*;
import java.util.*;
public class opt5
{
	public static void main(String[] args) {
		int[] a=create();
		printArray(a);
		SubArraySumGreat(a);
	}
	public static void SubArraySumGreat(int[] a)
	{
		Random rand =new Random();
		int k=50+rand.nextInt(300);
		System.out.println("k = "+k);
		int first=0,last=0,n=a.length;
		int len=n+1,sum=0;
		while(last<n)
		{
			while(sum<=k && last<n)
			{
				sum=sum+a[last];
				last++;
			}
			while(sum>k && first<n)
			{
				if(len>last-first)
					len=last-first;
				sum=sum-a[first];
				first++;
			}
		}
		System.out.println("len= "+len);
	}
	public static int[] create()
	{
		Scanner in =new Scanner(System.in);
		int n=in.nextInt();
		int[] a=new int[n];
		Random rand=new Random();
		for(int i=0;i<n;i++)
			a[i]=0+rand.nextInt(100);
		return a;
	}
	public static void printArray(int[] a)
	{
		System.out.println(Arrays.toString(a));
	}
}