import java.io.*;
import java.util.*;
public class opt3
{
	public static void main(String[] args) {
		int[] a=create();
		printArray(a);
		leastavg(a);
	}
	public static void leastavg(int[] a)
	{
		 int min=999999;
        int sum=0;
        int index=0;
        Scanner in =new Scanner(System.in);
        int k=in.nextInt();
        for(int i=0;i<a.length;i++)
        {
            sum=0;
            
            // for(int j=i;j<i+k;j++)
            // {
            //     sum=sum+a[j];
            // }
            int j=i;
            while(j<i+k && i+k<=a.length)
            {
                sum=sum+a[j];
                j++;
            }
            if(min>sum && sum!=0)
             {
             	min=sum;
             	index=i;
             }   
        }
        System.out.println(" index from "+index+" to "+(index+k-1));
	}
	public static int[] create()
	{
		Scanner in =new Scanner(System.in);
		int n=in.nextInt();
		int[] a=new int[n];
		Random rand=new Random();
		for(int i=0;i<n;i++)
			a[i]=0+rand.nextInt(100);
		return a;
	}
	public static void printArray(int[] a)
	{
		System.out.println(Arrays.toString(a));
	}
}