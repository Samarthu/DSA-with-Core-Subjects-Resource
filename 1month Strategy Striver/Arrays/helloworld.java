import java.util.*;
class helloworld{
	static int fact(int n)
	{
		if(n == 1 || n == 0) return n;
		return n * fact(n-1);
	}
	static int getFact(int m,int n)
	{
		int res= 0;
		if(m == n)
		{
			return 1;
		}
		res = (int) fact(m) /(fact(n) * fact(m-n));
	    return res;
    }
	static int getCombination(int m,int n)
	{
	   int ans = 0;
	   for(int i=1;i<=n;i++)
	   {
	   	  ans+=getFact(m,i);
	   }
	   return ans;	
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int ans = getCombination(m,n);
		System.out.print(ans);
	}
}	