import java.io.*;
import java.util.*;
public class mergeSort
{
	public static void main(String[] args) 
	{
		int[] a=create();
		System.out.println("UnSorted >");
		printArray(a);
		sort(a,0,a.length-1);
		System.out.println("Sorted >");
		printArray(a);
	}
	public static void merge(int[] a,int low,int mid,int high)
	{
		int s1=mid-low+1;
		int s2=high-mid;
		int a1[]=new int[s1];
		int a2[]= new int[s2];
		for(int i=0;i<s1;i++)
			a1[i]=a[low+i];
		for(int j=0;j<s2;j++)
			a2[j]=a[mid+1+j];
		int i=0,j=0,k=low;
		while(i<s1 && j<s2)
		{
			if(a1[i]<=a2[j])
			{
				a[k++]=a1[i++];
			}
			else
			{
				a[k++]=a2[j++];
			}
		}
		while(i<s1)
		{
			a[k++]=a1[i++];
		}
		while(j<s2)
		{
			a[k++]=a2[j++];
		}
	}
	public static void sort(int[] a,int low,int high)
	{
		if(low<high)
		{
			int mid=(low+high)/2;
			sort(a,low,mid);
			sort(a,mid+1,high);
			merge(a,low,mid,high);
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