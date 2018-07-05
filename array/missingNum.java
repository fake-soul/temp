import java.io.*;
import java.util.*;
public class missingNum
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t!=0)
		{
			int n=in.nextInt();
			int[] a=new int[n];
			int sum=0;
			for(int i=0;i<n-1;i++)
			{
				a[i]=in.nextInt();
				sum=sum+a[i];
			}
			int actSum=n*(n+1)/2;
			// System.out.println("actSum "+actSum+" sum "+sum);
			System.out.println("missing "+(actSum-sum));
			t--;
		}
	}
}