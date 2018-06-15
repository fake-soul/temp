import java.util.*;
public class pattern10
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
        Arrays.sort(a);
        int j=a.length-1;
        int i=0;
        int len=0;
        while(len!=a.length)
        {
            if(len%2==0)
            {
                b[len]=a[j];
                j--;
            }
            else
            {
                b[len]=a[i];
                i++;
            }
            len++;
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