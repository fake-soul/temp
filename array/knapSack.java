import java.io.*;
import java.util.*;
public class knapSack
{
	public static void main(String[] args) 
	{
		Scanner in= new Scanner(System.in);
		int n=in.nextInt();
		int[] wt=create1(n);
		int[] price=create1(n);
		System.out.println("Wt ");
		System.out.println(Arrays.toString(wt));
		System.out.println("prices ");
		System.out.println(Arrays.toString(price));
		int size=in.nextInt();
		maxOutput(wt,price,size);
	}
	public static void maxOutput(int[] wt,int[] val,int W)
	{
		int K[][] = new int[val.length+1][W+1];
        for(int i=0; i <= val.length; i++){
            for(int j=0; j <= W; j++){
                if(i == 0 || j == 0){
                    K[i][j] = 0;
                    continue;
                }
                if(j - wt[i-1] >= 0){
                    K[i][j] = Math.max(K[i-1][j], K[i-1][j-wt[i-1]] + val[i-1]);
                }else{
                    K[i][j] = K[i-1][j];
                }
            }
        }
        System.out.println("output "+K[val.length][W]);
	}
	public static int[] create1(int n)
	{
		int[] a=new int[n];
		Random rand=new Random();
		for(int i=0;i<n;i++)
			a[i]=1+rand.nextInt(40);
		return a;
	}
	public static int[] create2(int n)
	{
		int[] a=new int[n];
		Random rand=new Random();
		for(int i=0;i<n;i++)
			a[i]=1+rand.nextInt(40);
		return a;
	}
}