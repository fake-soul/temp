import java.util.*;
public class pattern6
{
    public static void main(String[] args) {
        int[] array=create();
        log("Inputed Array =>");
        printArray(array);        
        int[] order=create();
        log("inputed Order");
        printArray(order);
        int[] newarray=reqPAttern(array,order);
        printArray(newarray);
    }
    public static int[] reqPAttern(int[] arr,int[] order)
    {
      int[] newarr=new int[arr.length];
      for(int i=0;i<arr.length;i++)
        newarr[order[i]]=arr[i];
      return newarr;
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
}