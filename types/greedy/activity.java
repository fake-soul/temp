import java.io.*;
import java .util.*;
public class activity
{
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		Random rand=new Random();
		int n=in.nextInt();
		int name[]=new int[n];
		int start[]=new int[n];
		int end[]=new int[n];
		for(int i=0;i<n;i++)
		{
			name[i]=i;
			start[i]=0+rand.nextInt(20);
			end[i]=start[i]+1+rand.nextInt(30);
		}
		for(int i=0;i<n;i++)
		{
			System.out.println("job "+name[i]+" start > "+start[i]+" end > "+end[i]);
		}
		System.out.println("<><><><><><><><><><><>");
		maxAct(name,start,end,n);
	}
	public static void maxAct(int name[],int start[],int end[],int n)
	{
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(end[i]>end[j])
				{
					int temp=start[i];
					start[i]=start[j];
					start[j]=temp;

					temp=end[i];
					end[i]=end[j];
					end[j]=temp;

					temp=name[i];
					name[i]=name[j];
					name[j]=temp;
				}
			}
		}
		for(int i=0;i<n;i++)
		{
			System.out.println("job "+name[i]+" start > "+start[i]+" end > "+end[i]);
		}

		System.out.println("<><><><><><><><><><><><><>");

		int i=0,j=0,count=0;
		System.out.print("job "+name[i]+"  ");
		count++;
		for(j=1;j<n;j++)
		{
			if(start[j]>=end[i])
			{
				System.out.print("job "+name[j]+"  ");
				count++;
				i=j;
			}
		}
		System.out.println();
		System.out.println("<><><><><><><><><><><><><>");
		System.out.println("count =="+count);
	}
}