import java.util.*;
class fibo{
	static void fibo_fun(int n)
	{
		int a = 0;
		int b = 1;
		while(n > 0)
		{
			n--;
			int c = a + b;
			a=b;
			b=c;
			System.out.println(c);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    fibo_fun(n);
	}
}