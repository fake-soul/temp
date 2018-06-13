import java.io.*;
import java.util.*;
public class Hamming
{
	public static void main(String[] args) 
	{
		int[] array=inputArray();
		log("Array :>");
		printArray(array);
// 		int[] sortedArray = sort(array);
// 		log("sorted Array :>");
// 		printArray(sortedArray);
// 		Scanner in = new Scanner(System.in);
// 		Random rand = new Random();
// 		int rotateBY=1+rand.nextInt((sortedArray.length)-1);
// 		log("Roted BY :> "+rotateBY);	
// 		int[] rotatedArray=ROTATE(sortedArray,rotateBY);
// 		log("Roted array :>");
// 		printArray(rotatedArray);
		log("HammingDist > "+HammingDist(array));
		// int sum_value=in.nextInt();
		// log("Search Result => "+search_function(rotatedArray,rotatedArray.length,sum_value));
		// int min_value=minValue(rotatedArray,0,(rotatedArray.length)-1);
		// log("Min value > "+min_value);
	}
	public static int HammingDist(int[] rotatedArray)
	{
		int count=0;
		int a[]=rotatedArray.clone();
		for(int i=1;i<rotatedArray.length;i++)
		{
			a=rotatebysingle(a);
			if(Arrays.equals(a,rotatedArray))
			{
				break;
			}
			count++;
			if(count==rotatedArray.length)
				break;
		}
		return count++;
	}
	public static Boolean search_function(int[] a,int len,int sum_value)
	{
		int i;
		for(i=0;i<len-1;i++)
			if(a[i+1]<a[i])
				break;
		int low=(i+1)%len;
		int high=i;
		while(low!=high)
		{
			if(a[low]+a[high]==sum_value)
			{
				log("Pair is :>"+a[low]+"+"+a[high]);
				return true;
			}	
			if(a[low]+a[high]<sum_value)
				low =(low+1)%len;
			else
				high=(len+high-1)%len;
		}
		return false;
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
			a[i]=in.nextInt();
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
