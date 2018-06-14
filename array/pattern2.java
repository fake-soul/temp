import java.util.*;
public class pattern2
{
	public static void main(String[] args) {
		int[] array=create();
		log("Inputed Array =>");
		printArray(array);
		int[] a=reqpattern(array);
		printArray(a);
	}
	public static int[] reqpattern(int[] a)
	{
		int[] b=new int[a.length];
		for(int i=0;i<a.length;i++)
			b[i]=-1;
		Arrays.sort(a);
		if(a.length%2==0)
		{
			int t=a.length-1;
			int j=a.length-1;
			while(t>=0)
			{
				b[t]=a[j];
				t=t-2;
				j--;
			}
			for(t=0;t<a.length;t++)
			{
				if(b[t]==-1)
				{
					b[t]=a[j];
					j--;
				}
			}
		}
		else
		{
			int t=a.length-2;
			int j=a.length-1;
			while(t>=0)
			{
				b[t]=a[j];
				t=t-2;
				j--;
			}
			for(t=0;t<a.length;t++)
			{
				if(b[t]==-1)
				{
					b[t]=a[j];
					j--;
				}
			}
		}

		return b;
	}
	public static void log(String str)
	{
		System.out.println(str);
	}
	public static void reverse(int[] a,int low,int high)
	{
		if(low>=high)
		{
			return;
		}
		int temp=a[low];
		a[low]=a[high];
		a[high]=temp;
		reverse(a,low+1,high-1);
	}
	public static int[] pat(int[] a)
	{
		int[] b=new int[a.length];
		for(int i=0;i<a.length;i++)
		{
			if(a[i] ==i )
				b[i]=a[i];
			else
			{
				boolean res=search(a,i);
				if(res==true)
					b[i]=i;
				else
					b[i]=-1;
			}
		}
		return b;
	}
	public static Boolean search(int[] a,int x)
	{
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==x)
			{
				return true;
			}
		}
		return false;
	}
	public static int[] create()
	{
		Scanner in=new Scanner(System.in);
		Random rand=new Random();
		int n=in.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=1+rand.nextInt(100);
		return a;
	}
	public static void printArray(int[] a)
	{
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
}