import java.util.*;
public class pattern8
{
    public static void main(String[] args) {
        int[] array=create();
        log("Inputed Array =>");
        printArray(array);
        int[] newarray=reqPAttern(array);
        log("Req number");
        printArray(newarray,1);
    }
    public static int[] reqPAttern(int[] a)
    {
        int n=a.length;
        for(int i=0;i<n-1;i++)
        {
            for(int j=i;j<n;j++)
            {
                int k=comp(a[i],a[j]);
                if(k==1)
                {
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        return a;
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
    public static void log(String str)
    {
        System.out.println(str);
    }
    public static int[] create()
    {
        Scanner in=new Scanner(System.in);
        Random rand=new Random();
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
    public static void printArray(int[] a,int x)
    {
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]);
        System.out.println();
    }
}