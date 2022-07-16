 /// factorial of a number using recursion

 import java.util.*;
 class fact{
 	static int fact_fn(int n)
 	{
 		if(n == 0 || n == 1)
 		{
 			return n;
 		}
 		return n * fact_fn(n-1);
 	}
   public static void main(String[] args) {
   	 Scanner sc  = new Scanner(System.in);
   	 int n = sc.nextInt();
   	 int ans = fact_fn(n);
   	 System.out.println(ans);
   }
 }