import java.io.*;
import java.util.*;
public class rotate
{
	public static void main(String[] args) 
	{
		int[] array=inputArray();
		printArray(array);
		Scanner in = new Scanner(System.in);
		int rotateBY=in.nextInt();
		int[] rotatedArray=ROTATE(array,rotateBY);
		printArray(rotatedArray);
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