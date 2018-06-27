import java.io.*;
import java.util.*;
public class insertionSort
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
		int n=a.length,sortedindex=0,val=0;
		for(int i=0;i<n;i++)
		{
			sortedindex=i;
			while(sortedindex>0 && a[sortedindex-1]>a[sortedindex])
			{
				val=a[sortedindex];
				a[sortedindex]=a[sortedindex-1];
				a[sortedindex-1]=val;
				sortedindex--;
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