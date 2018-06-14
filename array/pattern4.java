import java.util.*;
public class pattern4
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
      int[] a=new int[arr.length];
      Arrays.sort(arr);
      int k=arr.length-1,j=0;
      for(int i=0;i<arr.length;i++)
      {
        if(i%2==0)
        {
            a[i]=arr[k];
            k--;
        }
        else
        {
            a[i]=arr[j];
            j++;
        }
      }
      return  a;
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