// fibonacci series 

import java.util.*;
class fibonacci{
	static void fib(int n)
	{
		int a=0;
		int b=1;
		int ans=0;
		for(int i=2;i<=n;i++)
		{
			System.out.print(a+"  ");
			int c = a+b;
			ans=c;
			a=b;
			b=c;
		}
		System.out.println(ans);
	}
	static int fibr(int n )
	{
		if(n == 0 || n == 1)
		{
			return n;
		}
		return fibr(n-1) + fibr(n-2);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		fib(n);
		int ans = fibr(n);
		System.out.println(ans);
	}
}