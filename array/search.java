import java.io.*;
import java.util.*;
public class search
{
	public static void main(String[] args) 
	{
		int[] array=inputArray();
		printArray(array);
		Scanner in = new Scanner(System.in);
		int[] sortedArray = sort(array);
		printArray(sortedArray);
		int search=in.nextInt();
		SEC(array,0,array.length-1,search);
	}
	public static int[] sort(int[] a)
	{
		int n= a.length;
		for(int i=1;i<n;i++)
		{
			int key = a[i];
			int j =i-1;
			while(j>=0&&a[j]>key)
			{
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=key;
		}
		return a;
	}
	// public static int[] sort(int[] a,int low,int high)
	// {
	// 	int len=high-low;
	// 	if(len<=1)
	// 		return a;
	// 	int mid= low + len/2;
	// 	a=sort(a,low,mid);
	// 	a=sort(a,mid+1,high);

	// 	int[] temp = new int[len];
	// 	int i=low,j=mid;
	// 	for(int k=0;k<len;k++)
	// 	{
	// 		if(i==mid)
	// 			temp[k]=a[j++];
	// 		else if(j==high)
	// 			temp[k]=a[i++];
	// 		else if(a[j]<a[i])
	// 			temp[k]=a[j++];
	// 		else
	// 			temp[k]=a[i++];
	// 	}
	// 	for(int k=0;k<len;k++)
	// 		a[low+k]=temp[k];
	// 	return a;

	// }
	public static void SEC(int[] a, int low, int high, int key)
	{
		int mid = (low+high)/2;
		while(low<=high)
		{
			if(a[mid]<key)
				low=mid+1;
			else if(a[mid]==key)
			{
				System.out.println("Yes");
				break;
			}
			else
			{
				high=mid-1;
			}
			mid=(low+high)/2;
			if(low>high)
				System.out.println("NOPE");
		}
	}
	public static int[] inputArray()
	{
		Scanner in = new Scanner(System.in);
		int n= in.nextInt();
		int[] a = new int[n];
		Random rand=new Random();
		for(int i = 0; i<n; i++)
			a[i]=1+rand.nextInt(100);
		return a;
	}
	public static void printArray(int[] a)
	{
		System.out.println();
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
}