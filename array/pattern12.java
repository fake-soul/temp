import java.util.*;
public class pattern12
{
    public static void main(String[] args) {
        int[] array=create();
        log("Inputed Array =>");
        printArray(array);
        int[] newarray=reqPAttern(array);
        printArray(newarray);
    }
    public static int[] reqPAttern(int[] a)
    {
        int[] b=new int[a.length];
        for(int i=0;i<a.length;i++)
        {
            if(i==0)
            {
                b[i]=a[i]*a[i+1];
            }
            else if(i==a.length-1)
            {
                b[i]=a[i]*a[i-1];
            }
            else
            {
                b[i]=a[i-1]*a[i+1];
            }
        }
        return b;
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