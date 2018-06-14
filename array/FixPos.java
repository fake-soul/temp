import java.io.*;
import java.util.*;
public class FixPos
{
	public static void main(String[] args) 
	{
		int[] array=inputArray();
		log("Array :>");
		printArray(array);
		int[] newarray=rearrange(array);
		printArray(newarray);
	}
	public static int[] rearrange(int[] array)
	{
		for(int i=0;i<array.length;i++)
		{
			if(array[i]!=-1 || array[i]!=i)
			{
				int j=0;
				boolean match=false;
				int value=array[i];
				for(j=i+1;j<array.length;j++)
				{
					
					if(j==array.length)
						break;
					if(array[j]==i)
					{
						match=true;
						break;
					}
				}
				if(match==true)
				{
					array[i]=array[j];
					array[j]=value;
				}
				if(match==false)
					array[i]=-1;
			}
		}
		return array;
	}
	public static void log(String str)
	{
		System.out.println(str);
	}
	public static int[] inputArray()
	{
		Scanner in = new Scanner(System.in);
		int n= in.nextInt();
		int[] a = new int[n];
		Random rand=new Random();
		for(int i = 0; i<n; i++)
			a[i]=0+rand.nextInt(n);
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