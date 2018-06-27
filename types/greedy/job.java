import java.io.*;
import java .util.*;
public class job
{
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		Random rand=new Random();
		int n=in.nextInt();
		int name[]=new int[n];
		int profit[]=new int[n];
		int end[]=new int[n];
		for(int i=0;i<n;i++)
		{
			name[i]=i;
			profit[i]=10+rand.nextInt(100);
			end[i]=1+rand.nextInt(10);
		}
		for(int i=0;i<n;i++)
		{
			System.out.println("job "+name[i]+" profit > "+profit[i]+" end > "+end[i]);
		}
		System.out.println("<><><><><><><><><><><>");
		maxPro(name,profit,end,n);
	}
	public static void maxPro(int name[],int profit[],int end[],int n)
	{
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(profit[i]<profit[j])
				{
					int temp=profit[i];
					profit[i]=profit[j];
					profit[j]=temp;

					temp=end[i];
					end[i]=end[j];
					end[j]=temp;

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
				if(profit[i]<profit[j])
				{
					if(end[i]>end[j])
					{
						int temp=profit[i];
					profit[i]=profit[j];
					profit[j]=temp;

					temp=end[i];
					end[i]=end[j];
					end[j]=temp;

					temp=name[i];
					name[i]=name[j];
					name[j]=temp;
					}
				}
			}
		}
		for(int i=0;i<n;i++)
		{
			System.out.println("job "+name[i]+" profit > "+profit[i]+" end > "+end[i]);
		}

		System.out.println("<><><><><><><><><><><><><>");
		int count=0,total=0;
		for(int i=0;i<n;i++)
		{
			if(end[i]>count)
			{
				total+=profit[i];
				System.out.println("\n");
            	System.out.print("job " + name[i]+"  ");
            	System.out.print("profit > " + profit[i]+"  ");
            	System.out.print("end > " + end[i]+"  ");
            	count++;
			}
		}
		 System.out.println("\nTotal Profit > " + total);    


	}
}