import java.io.*;
import java.util.*;
public class TypeQ
{
	public static void main(String[] args) 
	{
		int[] array=inputArray();
		log("Array :>");
		printArray(array);
		// int[] sortedArray = sort(array);
		// log("sorted Array :>");
		// printArray(sortedArray);
		Scanner in = new Scanner(System.in);
		// Random rand = new Random();
		// int rotateBY=1+rand.nextInt((sortedArray.length)-1);
		// log("Roted BY :> "+rotateBY);	
		// int[] rotatedArray=ROTATE(sortedArray,rotateBY);
		// log("Roted array :>");
		// printArray(rotatedArray);
		int q=in.nextInt();
		int qu[][]=new int[q][3];
		for(int i=0;i<q;i++)
		{
			qu[i][0]=in.nextInt();
			qu[i][1]=in.nextInt();
			if(qu[i][0]==3)
				qu[i][2]=in.nextInt();
			else
				qu[i][2]=0;
		}
		int sum=0;
		for(int i=0;i<q;i++)
		{
			if(qu[i][0]==2)
			{
				for(int j=0;j<qu[i][1];j++)
					array=rotatebysingle(array);
				log("After Querry "+(i+1));
				printArray(array);
			}	
			if(qu[i][0]==1)
			{
				for(int j=0;j<array.length-qu[i][1];j++)
					array=rotatebysingle(array);
				log("After Querry "+(i+1));
				printArray(array);
			}
			if(qu[i][0]==3)
			{
				sum=0;
				for(int j=qu[i][1];j<=qu[i][2];j++)
				{
					sum=sum+array[j];
				}
				log("Sum > "+sum);
			}
		}
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