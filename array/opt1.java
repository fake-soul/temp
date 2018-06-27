import java.io.*;
import java.util.*;
public class opt1
{
	public static void main(String[] args) {
		int[] a=create();
		printArray(a);
		maxSumSubArray(a);
	}
	public static void maxSumSubArray(int[] a)
	{
		int max=0;
		int max_end=0;
		for(int i=0;i<a.length;i++)
		{
			max_end=max_end+a[i];
			if(max<max_end)
				max=max_end;
			if(max_end<0)
				max_end=0;
		}
		System.out.print(max);
	}
	public static int[] create()
	{
		Scanner in =new Scanner(System.in);
		int n=in.nextInt();
		int[] a=new int[n];
		Random rand=new Random();
		for(int i=0;i<n;i++)
			a[i]=-50+rand.nextInt(100);
		return a;
	}
	public static void printArray(int[] a)
	{
		System.out.println(Arrays.toString(a));
	}
}