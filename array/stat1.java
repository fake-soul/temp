import java.util.*;
public class stat1
{
    public static void main(String[] args) {
        int[] array=create();
        log("Inputed Array =>");
        printArray(array);
        reqstat(array);
        reqstat2(array);
    }
    public static void reqstat2(int[] a)
    {
        int maxFirst=0,maxsec=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>maxFirst)
            {
                maxsec=maxFirst;
                maxFirst=a[i];
            }
            else if(a[i]>maxsec)
                maxsec=a[i];
            else{

            }
        }
        log("Min 2 elements Greater");
        for(int i=0;i<a.length;i++)
        {
            if(a[i]<maxsec)
                System.out.print(a[i]+" ");
        }
    }
    public static void reqstat(int[] a)
    {
        int f=0,s=0,t=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>f)
            {
                t=s;
                s=f;
                f=a[i];
            }
            else if(a[i]>s)
            {
                t=s;
                s=a[i];
            }
            else if(a[i]>t)
            {
                t=a[i];
            }
            else
            {

            }
        }
        log("max1 => "+f+" max2 => "+s+" max3 => "+t);
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