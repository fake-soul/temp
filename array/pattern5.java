import java.util.*;
public class pattern5
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
      int zero=0;
      for(int i=0;i<arr.length;i++)
      {
        if(arr[i]!=0)
        {
            arr[zero]=arr[i];
            zero++;
        }
      } 
      while(zero<arr.length)
      {
        arr[zero]=0;
        zero++;        
      }
      for(int i=0;i<arr.length;i++)
      {
        if(i!=arr.length-1)
        {
            if(arr[i]==arr[i+1])
            {
                arr[i]=2*arr[i];
                arr[i+1]=0;
                i++;
            }

        }
      }

      zero=0;
      for(int i=0;i<arr.length;i++)
      {
        if(arr[i]!=0 )
        {
            arr[zero]=arr[i];
            zero++;
        }
      } 
      while(zero<arr.length)
      {
        arr[zero]=0;
        zero++;        
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