import java.io.*;
import java.util.*;
public class selectionSort
{
	public static void main(String[] args) 
	{
		int[] a=create();
		System.out.println("UnSorted >");
		printArray(a);
		sort(a);
		System.out.println("Sorted >");
		printArray(a);
	}
	public static void sort(int[] a)
	{
		int min=0,k=0,n=a.length;
		Boolean minFound=false;
		for(int i=0;i<n-1;i++)
		{
			min=a[i];
			for(int j=i+1;j<n;j++)
			{
				if(min>a[j])
				{
					min=a[j];
					k=j;
					minFound=true;
				}
			}
			if(minFound==true)
			{
				a[k]=a[i];
				a[i]=min;
			}
		}
	}
	public static void printArray(int[] a)
	{
		System.out.println(Arrays.toString(a));
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
}