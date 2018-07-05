import java.io.*;
import java.util.*;
public class rodCutting
{
	public static void main(String[] args) 
	{
		Scanner in =new Scanner(System.in);
		int len=in.nextInt();
		int temp=1;
		Random rand=new Random();
		int[] a=new int[len];
		for(int i=0;i<len;i++)
		{
			temp=temp+rand.nextInt(10);
			a[i]=temp;
		}	
		System.out.println("Rod prices");
		System.out.println(Arrays.toString(a));
		int out=maxOutput(a);
		System.out.println("OutPut = "+out);
	}
	public static int maxOutput(int[] a)
	{
		int maxarray[]=new int[a.length+1];
		for(int i=1;i<maxarray.length;i++)
		{
			maxarray[i]=a[i-1];
		}
		for(int i=1;i<maxarray.length;i++)
		{
			for(int j=1;j<i;j++)
				maxarray[i]=Math.max(maxarray[i],maxarray[i-j]+maxarray[j]);
		}
		return maxarray[maxarray.length-1];
	}
}