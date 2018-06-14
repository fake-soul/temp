import java.util.*;
public class upanddown
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
		// The following few lines are similar to partition
        // process of QuickSort.  The idea is to consider 0
        // as pivot and divide the array around it.
        int i = -1, temp = 0,n=arr.length;
        for (int j = 0; j < n; j++)
        {
            if (arr[j] < 0)
            {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // Now all positive numbers are at end and negative numbers at
        // the beginning of array. Initialize indexes for starting point
        // of positive and negative numbers to be swapped
        int pos = i+1, neg = 0;
 
        // Increment the negative index by 2 and positive index by 1, i.e.,
        // swap every alternate negative number with next positive number
        while (pos < n && neg < pos && arr[neg] < 0)
        {
            temp = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp;
            pos++;
            neg += 2;
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