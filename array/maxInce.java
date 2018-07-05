import java.io.*;
import java.util.*;
public class maxInce
{
	public static void main(String[] args) {
		int a[][]=create();
		printArray(a);
		// minproduct(a,a.length);
	}
	
	public static int[][] create()
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[][] a=new int[n][n];
		Random r=new Random();
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				a[i][j]=0+r.nextInt(50);
		return a;
	}
	public static void printArray(int[][] a)
	{
		System.out.println(Arrays.toString(a));
	}
}