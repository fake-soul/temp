/**
 *    Java Program to Implement Karatsuba Multiplication Algorithm
 **/
 
import java.util.Scanner;
 
/** Class Karatsuba **/
public class Karatsuba
{
    /** Function to multiply two numbers **/
    public double multiply(long x, long y)
    {
        int size1 = getSize(x);
        int size2 = getSize(y);
        /** Maximum of lengths of number **/
        int N = Math.max(size1, size2);
        /** for small values directly multiply **/        
        if (N < 10)
            return x * y;
        /** max length divided, rounded up **/    
        N = (N / 2) + (N % 2);    
        /** multiplier **/
        double m = (long)Math.pow(10, N);
 
        /** compute sub expressions **/        
        double b = x / m;
        double a = x - (b * m);
        double d = y / m;
        double c = y - (d * N);
        /** compute sub expressions **/
        double z0 = multiply(a, c);
        double z1 = multiply(a + b, c + d);
        double z2 = multiply(b, d);          
 
        return z0 + ((z1 - z0 - z2) * m) + (z2 * (double)(Math.pow(10, 2 * N)));        
    }
    /** Function to calculate length or number of digits in a number **/
    public int getSize(long num)
    {
        int ctr = 0;
        while (num != 0)
        {
            ctr++;
            num /= 10;
        }
        return ctr;
    }
    /** Main function **/
    public static void main (String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Karatsuba Multiplication Algorithm Test\n");
        /** Make an object of Karatsuba class **/
        Karatsuba kts = new Karatsuba();
 
        /** Accept two integers **/
        System.out.println("Enter two integer numbers\n");
        double n1 = 3141592653589793238462643383279502884197169399375105820974944592;
        double n2 = 2718281828459045235360287471352662497757247093699959574966967627;
        /** Call function multiply of class Karatsuba **/
        double product = kts.multiply(n1, n2);
        System.out.println("\nProduct : "+ product);
    }
}
