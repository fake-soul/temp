import java.io.*;
import java.util.*;
public class minPro
{
	public static void main(String[] args) {
		int a[]=create();
		printArray(a);
		minproduct(a,a.length);
	}
	public static void minproduct(int[] a,int n)
	{
		int numberZer=0,numberPos=0,numberNeg=0;
		int bigNeg=-99999,smallPos=999999;
		int bigNegIndex=0,smallPosIndex=0;
		for(int i=0;i<n;i++)
		{
			if(a[i]==0)
				numberZer++;
			else if(a[i]>0)
			{
				numberPos++;
				if(smallPos>a[i])
				{
					smallPos=a[i];
					smallPosIndex=i;
				}	
			}
			else
			{
				numberNeg++;
				if(bigNeg<a[i])
				{
					bigNeg=a[i];
					bigNegIndex=i;
				}
			}
		}
		double pro=1;
		System.out.println("Zero >"+numberZer+" Pos >"+numberPos+" neg >"+numberNeg+" smallPos >"+smallPos+" bigNeg >"+bigNeg);
		if(numberNeg==0)
		{
			if(numberZer!=0)
			{
				System.out.println("min pro > 0");
			}
			else
			{
				System.out.println("min pro > "+smallPos);
			}
		}
		else
		{
			if(numberNeg%2==0)
			{
				for(int i=0;i<n;i++)
				{
					if(i!=bigNegIndex)
					{
						pro=pro*a[i];
					}
				}
			}
			else{
				for(int i=0;i<n;i++)
				{
					pro=pro*a[i];
				}
			}
			System.out.println("min pro > "+pro);
		}
	}
	public static int[] create()
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] a=new int[n];
		Random r=new Random();
		for(int i=0;i<n;i++)
			a[i]=-20+r.nextInt(50);
		return a;
	}
	public static void printArray(int[] a)
	{
		System.out.println(Arrays.toString(a));
	}
}