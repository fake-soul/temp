import java.io.*;
import java.util.*;
public class maxSumCon
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
			int maxcurr=a[0];
			int maxnow=a[0];
			for(int i=1;i<n;i++)
			{
				maxcurr=Math.max(maxcurr+a[i],a[i]);
				maxnow=Math.max(maxnow,maxcurr);
			}
			System.out.println(maxnow);
			t--;
		}
	}
}