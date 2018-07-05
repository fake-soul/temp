import java.io.*;
import java.util.*;
public class pry
{
	public static void main(String[] args) {
		int[] a=create();
		printArray(a);
		maxlength(a);
	}
	public static void maxlength(int[] a)
	{
		int n=a.length;
		Arrays.sort(a);
		int height=0;
		int currwidth=0,reqwiddht=0,blocknum=0,prevBlock=1;
		Boolean res=false;
		height=1;
		currwidth=0;
		reqwiddht=a[0];
		int i=1;
		while(i<n)
		{
				if(currwidth<=reqwiddht && blocknum<=prevBlock)
				{
					currwidth=currwidth+a[i];
					blocknum++;
				}
				else
				{
					height++;
					reqwiddht=currwidth;
					prevBlock=blocknum;
				}
				i++;
		}
		System.out.println("nviv >"+height);
	}
	public static int[] create()
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] a=new int[n];
		Random r=new Random();
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		return a;
	}
	public static void printArray(int[] a)
	{
		System.out.println(Arrays.toString(a));
	}
}