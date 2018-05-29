import java.util.*;
public class NormalSpan
{
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int n=in.nextInt();
		int[] array=new int[n];
		for(int i=0;i<n;i++)
			array[i]=in.nextInt();
		int [] spanarray=SPAN(array,n);
		for(int i=0;i<n;i++)
			System.out.println(spanarray[i]);
	}
	public static int[] SPAN(int[] array,int n)
	{
		int[] spanarray=new int[n];
		int j=0;
		for(int i=0;i<n;i++)
		{
			j=1;
			while(j<=i && array[i]>array[i-j])
			{
				j=j+1;
			}
			spanarray[i]=j;
		}
		return spanarray;
	}
}