import java.io.*;
import java.util.*;
public class cmp1
{
	public static void main(String[] args) {
		// Random rand=new Random();
		// int num1=1+rand.nextInt(1000);
		// int num2=1+rand.nextInt(100);
		Scanner in =new Scanner(System.in);
		int num1=in.nextInt();
		int num2=in.nextInt();
		System.out.println("num1 = "+num1+" num2 = "+num2);
		int k=comp(num1,num2);
		if(k==0)
			System.out.println("Big "+num1);
		else if(k==1)
			System.out.println("Big "+num2);
		else
			System.out.println("Equal");
	}
	public static int comp(int num1,int num2)
	{
		int length1 = String.valueOf(num1).length();
		int length2 = String.valueOf(num2).length();
		int[] a1=new int[length1];
		int[] a2=new int[length2];
		String str1=Integer.toString(num1);
		String str2=Integer.toString(num2);
		int i=0,j=0;
		int k=0;
		Boolean res=false;
		while(i<length1 && j<length2)
		{
			if(Character.getNumericValue(str1.charAt(i))>Character.getNumericValue(str2.charAt(j)))
			{
				res=true;
				k=0;
				break;
			}
			else if(Character.getNumericValue(str1.charAt(i))<Character.getNumericValue(str2.charAt(j)))
			{
				
				res=true;
				k=1;
				break;
			}
			else
			{
				i++;
				j++;
			}
		}
		if(res==false)
		{
			while(i<length1)
			{
				if(Character.getNumericValue(str1.charAt(i))>Character.getNumericValue(str2.charAt(0)))
				{
					res=true;
					k=0;
					break;
				}
				else if(Character.getNumericValue(str1.charAt(i))<Character.getNumericValue(str2.charAt(0)))
				{
					res=true;
					k=1;
					break;
				}
				else
					i++;
			}
			while(j<length2)
			{
				if(Character.getNumericValue(str1.charAt(0))>Character.getNumericValue(str2.charAt(j)))
				{
					res=true;
					k=0;
					break;
				}
				else if(Character.getNumericValue(str1.charAt(0))<Character.getNumericValue(str2.charAt(j)))
				{
					res=true;
					k=1;
					break;
				}
				else
					j++;
			}
			if(res==false)
			{
				k=3;
			}
		}
		return k;
	}

}