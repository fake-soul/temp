import java.io.*;
import java .util.*;
public class hotal
{
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		Random rand=new Random();
		int n=in.nextInt();
		int name[]=new int[n];
		int inTime[]=new int[n];
		int outTime[]=new int[n];
		for(int i=0;i<n;i++)
		{
			name[i]=i;
			inTime[i]=10+rand.nextInt(100);
			outTime[i]=1+rand.nextInt(10);
		}
		for(int i=0;i<n;i++)
		{
			System.out.println("job "+name[i]+" inTime > "+inTime[i]+" outTime > "+outTime[i]);
		}
		System.out.println("<><><><><><><><><><><>");
		maxPro(name,inTime,outTime,n);
	}
	public static void maxPro(int name[],int inTime[],int outTime[],int n)
	{
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(inTime[i]>inTime[j])
				{
					int temp=inTime[i];
					inTime[i]=inTime[j];
					inTime[j]=temp;

					temp=outTime[i];
					outTime[i]=outTime[j];
					outTime[j]=temp;

					temp=name[i];
					name[i]=name[j];
					name[j]=temp;
				}
			}
		}
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(inTime[i]==inTime[j])
				{
					if(outTime[i]>outTime[j])
					{
						int temp=inTime[i];
					inTime[i]=inTime[j];
					inTime[j]=temp;

					temp=outTime[i];
					outTime[i]=outTime[j];
					outTime[j]=temp;

					temp=name[i];
					name[i]=name[j];
					name[j]=temp;
					}
				}
			}
		}
		for(int i=0;i<n;i++)
		{
			System.out.println("job "+name[i]+" inTime > "+inTime[i]+" outTime > "+outTime[i]);
		}

		System.out.println("<><><><><><><><><><><><><>");
		int count=0,total=0;
		for(int i=0;i<n;i++)
		{
			if(outTime[i]>count)
			{
				total+=inTime[i];
				System.out.println("\n");
            	System.out.print("job " + name[i]+"  ");
            	System.out.print("inTime > " + inTime[i]+"  ");
            	System.out.print("outTime > " + outTime[i]+"  ");
            	count++;
			}
		}
		 System.out.println("\nTotal Profit > " + total);    


	}
}