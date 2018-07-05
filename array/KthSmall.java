import java.io.*;
import java.util.*;
public class KthSmall
{
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		int testCase=in.nextInt();
		while(testCase!=0)
		{
			int n=in.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++)
			{
				a[i]=in.nextInt();
			}
			Arrays.sort(a);
			int i=in.nextInt();
			System.out.println(a[i-1]);
			testCase--;
		}	
	}
}