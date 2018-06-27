import java.io.*;
import java.util.*;
public class opt4
{
	public static void main(String[] args) {
		int[] a=create();
		printArray(a);
		minDist(a);
	}
	public static void minDist(int[] a)
	{
		int min=99999;
		Scanner in =new Scanner(System.in);
		int f=in.nextInt();
		int s=in.nextInt();
		boolean sec=false;
		int count=0;
		for(int i=0;i<a.length;i++)
		{
			if(sec==true)
			{
				count++;	
			}
			if(a[i]==f)
			{
				count=0;
				sec=true;
			}
			if(a[i]==s && sec==true)
			{
				if(count<min)
					min=count;
				count=0;
				sec=false;
			}
		}
		System.out.println(min);
	}
	public static int[] create()
	{
		Scanner in =new Scanner(System.in);
		int n=in.nextInt();
		int[] a=new int[n];
		Random rand=new Random();
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		return a;
	}
	public static void printArray(int[] a)
	{
		System.out.println(Arrays.toString(a));
	}
}	