import java.util.*;
public class pattern
{
	public static void main(String[] args) {
		int[] array=create();
		printArray(array);
		int[] newarray=pat(array);
		printArray(newarray);
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
		int n=in.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		return a;
	}
	public static void printArray(int[] a)
	{
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
}