import java.util.*;
public class pattern13
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
      int i=0,j=0,key=0;
      for(i=1;i<arr.length;i++)
      {
        key=arr[i];
        if(key%2==0)
            continue;
        j=i-1;
        while(j>=0 && arr[j]%2==0)
        {
            arr[j+1]=arr[j];
            j--;
        }
        arr[j+1]=key;
      }
      return  arr;
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