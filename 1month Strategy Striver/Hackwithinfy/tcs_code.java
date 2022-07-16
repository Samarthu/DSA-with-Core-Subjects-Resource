// TCS code
import java.util.*;
class tcs_code{
	static int fun(int n,int cap,int v[],int w[],int idx,int dp[][])
	{
	   if(cap < 0) return Integer.MIN_VALUE;
	   if(idx ==n) return 0;
	   if(dp[idx][cap]!=-1) return dp[idx][cap];
	   int v1 = v[idx] + fun(n,cap-w[idx],v,w,idx+1,dp);
	   int v2 = 0 + fun(n,cap,v,w,idx+1,dp);
	   int ans = v1 > v2 ? v1 : v2;
	   dp[idx][cap] = ans;
	   return ans;
	}
	public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  int n = sc.nextInt();
	  int cap = sc.nextInt();
	  int V[] = new int[n];
	  int W[] = new int[n];
	  for (int i=0;i<n ;i++ ) {
	  	V[i] = sc.nextInt();
	  }
	   for (int i=0;i<n ;i++ ) {
	  	W[i] = sc.nextInt();
	  }
	  int dp[][] = new int[n+1][cap+1];
	  for(int a[] : dp) Arrays.fill(a,-1);
	  int ans = fun(n,cap,V,W,0,dp);
	  System.out.println(ans);
	}
}