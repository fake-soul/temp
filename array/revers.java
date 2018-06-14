import java.util.*;
public class revers
{
	public static void main(String[] args) {
		int[] array=create();
		log("Inputed Array =>");
		printArray(array);
		reverse(array,0,array.length-1);
		printArray(array);
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