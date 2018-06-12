import java.io.*;
import java.util.*;
public class SearchINRotatedArray
{
	public static void main(String[] args) 
	{
		int[] array=inputArray();
		log("Array :>");
		printArray(array);
		int[] sortedArray = sort(array);
		log("sorted Array :>");
		printArray(sortedArray);
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		int rotateBY=1+rand.nextInt((sortedArray.length)-1);
		log("Roted BY :> "+rotateBY);	
		int[] rotatedArray=ROTATE(sortedArray,rotateBY);
		log("Roted array :>");
		printArray(rotatedArray);
		int search_value=in.nextInt();
		log("Search Result => "+search_function(rotatedArray,0,(rotatedArray.length)-1,search_value));
	}
	public static Boolean search_function(int[] a,int low,int high,int search_value)
	{
		if(low>high)
			return false;
		int mid=(low+high)/2;
		if(a[mid]==search_value)
			return true;
		if(a[low]<=a[mid])
		{
			if(search_value>=a[low] && search_value <= a[mid])
				return search_function(a,low,mid-1,search_value);
			return search_function(a,mid+1,high,search_value);
		}
		if(search_value>=a[mid] && search_value<=a[high])
			return search_function(a,mid+1,high,search_value);
		return search_function(a,low,mid-1,search_value);
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
	public static void log(String str)
	{
		System.out.println(str);
	}
	public static int[] ROTATE(int[] a,int rotateBY)
	{
		for(int i=0;i<rotateBY;i++)
			a=rotatebysingle(a);
		return a;
	}
	public static int[] rotatebysingle(int [] a)
	{
		int temp=a[0];
		for(int j=0;j<a.length-1;j++)
		{
			a[j]=a[j+1];
		}
		a[(a.length)-1	]=temp;
		return a;
	}
	public static int[] inputArray()
	{
		Scanner in = new Scanner(System.in);
		int n= in.nextInt();
		int[] a = new int[n];
		Random rand=new Random();
		for(int i = 0; i<n; i++)
			a[i]=1+rand.nextInt(500);
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