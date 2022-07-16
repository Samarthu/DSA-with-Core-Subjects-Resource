 // coin change Problem 
 //TC = n*m;
import java.util.*;
class coinchange{
	//// this is recursive with memoization solution....
	static int minCoins(int a[] ,int n , int dp[])
	{
		if(n== 0) return 0;
		int ans = Integer.MAX_VALUE;
		for(int i =0 ;i<a.length ;i++)
		{
			if(n-a[i]>= 0)
			{
				int subans=0;
				if(dp[n-a[i]] !=-1)
				{
					subans = dp[n-a[i]];
				}
				else{
					subans = minCoins(a,n-a[i],dp);
				}
				if(subans!=Integer.MAX_VALUE && subans + 1 < ans)
				{
					ans = subans+1;
				}
			}
		}
		return dp[n]=ans;
	}
	static int minCoincombination(int a[],int n){
		int dp[]= new int[n+1];
		dp[0]=1;
		for(int i=0;i<a.length;i++)
		{
			for(int j=a[i];j<dp.length;j++){
		        dp[j]+=dp[j-a[i]]; 			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[n];
	}
	static int minPermutation(int a[],int n)
	{
		int dp[] = new int[n+1];
		dp[0]=1;
		for(int i=1;i<dp.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				if(i >= a[j])
				{
					dp[i]+=dp[i-a[j]];
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[n];
	}
	public static void main(String[] args) {
		int a[] = {2,3,5};
		int n=7;
		int dp[] =new int[n+1];
		Arrays.fill(dp,-1);
		int ans=minCoins(a,n,dp);
		System.out.println(ans);
		System.out.println(minCoincombination(a,n));
		System.out.println( minPermutation(a,n));
	}
	
}


 //gfg coin change
/*
 public long count(int S[], int m, int n) 
    { 
        long table[] = new long[n + 1];
        for(int i = 0;i<n+1;i++)
            table[i] = 0;
        table[0] = 1;
        for(int i=0; i<m; i++)
            for(int j=S[i]; j<=n; j++)
                table[j] += table[j-S[i]];
     
        return table[n];
       
    } */