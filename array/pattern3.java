import java.util.*;
public class pattern3
{
    public static void main(String[] args) {
        int[] array=create();
        log("Inputed Array =>");
        printArray(array);
        int[] newarray=reqPAttern(array);
        printArray(newarray);
    }
    public static int[] reqPAttern(int[] arr)
    {
       int i=0,j=arr.length-1,k=0;
       for(i=0,j=arr.length-1;i<arr.length;i++)
       {
            if(arr[i]==0)
            {
                while(arr[j]!=0)
                    j--;
                k=arr[j];
                arr[j]=arr[i];
                arr[i]=k;
            }
       }
        return arr;
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
            a[i]=-99+rand.nextInt(175);
        return a;
    }
    public static void printArray(int[] a)
    {
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
}