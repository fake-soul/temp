import java.io.*;
import java.util.*;
public class opt2
{
	public static void main(String[] args) {
		int[] a=create();
		printArray(a);
		test(a);
	}
	public static void test(int[] a)
	{
		int k=0,i,j;
		int[] sell;
		int[] buy;
		if(a.length%2==0){
		sell=new int[(a.length)/2];
		buy=new int[(a.length)/2];
		i=-1;j=-1;
		while(k!=a.length)
		{
			if(k%2==0)
				buy[++i]=a[k++];
			else
				sell[++j]=a[k++];
		}}
		else
		{
			sell=new int[((a.length)/2)+1];
		buy=new int[(a.length)/2];
		i=-1;j=-1;
		while(k!=a.length-1)
		{
			if(k%2==0)
				buy[++i]=a[k++];
			else
				sell[++j]=a[k++];
		}	
		sell[++j]=a[k];
		}
		int[] aa=new int[sell.length];
		printArray(buy);
		printArray(sell);
		 k=0;
		for(i=0;i<buy.length-2;i++)
		{
			int max=0;
			for(j=i;j<sell.length-2;j++)
			{
				if(max<sell[j]-buy[i])
				{
					max=sell[j]-buy[i];
					k=j;
				}
			}
			int max2=0;
			for(int l=k+1;l<buy.length;l++)
			{
				for(int m=l;m<sell.length;m++)
				{
					if(max2<sell[m]-buy[l])
					{
						max2=sell[m]-buy[l];
					}
				}
			}
			aa[i]=max+max2;
		}
		printArray(aa);
		Arrays.sort(aa);
		System.out.println(aa[sell.length-1]);

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