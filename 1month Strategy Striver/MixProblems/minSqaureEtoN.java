// Minimum number square equal to N;

import java.util.*;

class minSqaureEtoN {
	static int N = 1000000;
	static int minsquare(int n)
	{
		int dp[] = new int[N];
		int MOD = Integer.MAX_VALUE;
		int ans = MOD;

		//for(int i=0;i<N;i++) dp[i]=MOD;
		if(n==0 || n ==1 || n ==2 || n ==3)
		{
			return n;
		}

		// if(dp[n]!=MOD)
		// {
		// 	return dp[n];
		// }


		for(int i=1;i*i<=n;i++)
		{
			ans = Math.min(ans,1+minsquare(n-i*i));boolean 
}