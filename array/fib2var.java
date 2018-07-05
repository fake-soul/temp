import java.util.*;
public class fib2var
{
	public static void main(String[] args) {
		Random in =new Random();
		fib(0+in.nextInt(50));
	}
	public static void fib(int n)
	{
    int a = 0, b = 1, c;
    if (n >= 0)
        System.out.println(a+" ");
    if (n >= 1)
        System.out.println(b+" ");
    for (int i = 2; i <= n; i++) {
        c = a + b;
        System.out.println(c+" ");
        a = b;
        b = c;
    }
}

}