import java.io.*;
import java.util.*;
public class maxSum
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t!=0)
		{
			int n=in.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++)
			{
				a[i]=in.nextInt();
			}
			Arrays.sort(a);
			// System.out.println("input "+Arrays.toString(a));
			int i=n-2;
			int sum=a[n-1];
			for(i=n-2;i>=0;i--)
			{
				if(a[i]<0)
					break;
				sum=sum+a[i];
			}
			System.out.println(sum);
			t--;
		}
	}
}