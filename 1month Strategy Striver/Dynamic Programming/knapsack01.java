/// 0/1 knapsack using dynamic programming

import java.util.*;
class knapsack01{
	/// Tabulation Method;	
	static int robber_knapsack_fn(int [] wts,int money[],int n,int cap)
	{
		int dp[][]= new int[n+1][cap+1];

		for(int i=1;i<dp.length;i++)
		{
			for(int j=1;j<dp[0].length;j++)
			{
				if(j>= wts[i-1])
				{
				   if(dp[i-1][j- wts[i-1]] + money[i-1] > dp[i-1][j]) // when go for bat and make
				   {                                                 // maxruns 
				   	dp[i][j] = dp[i-1][j- wts[i-1]] + money[i-1]; 
				   }	
				   else{
				   	 dp[i][j] = dp[i-1][j];
				   }
				}else{
					dp[i][j] = dp[i-1][j];
				}			
			}
		}
		System.out.println(Arrays.deepToString(dp));
		return dp[n][cap];
	}
	// memozaition  method which is optimazation over a recursion
    static int calls = 0;
	static int knapsack01_recursion(int [] wts,int money[],int n,int idx,int cap ,int dp[][])
	{
		calls++;
		// base cases
		if(cap<0)
		{
			return Integer.MIN_VALUE;
		}
		if(idx== n)
		{
			return 0;
		}
		if(dp[idx][cap] != 0)
		{
			return dp[idx][cap];
		}
		int n1 = 0 + knapsack01_recursion(wts,money,n,idx+1,cap,dp);
		int n2 = money[idx] + knapsack01_recursion(wts,money,n,idx+1 , cap - wts[idx],dp);
		int ans = n1 > n2 ? n1 : n2;
		dp[idx][cap] = ans;
		return ans;
	}

	static int knapsackunbounded_recursion(int wts[],int vals[],int n,int idx,int cap,int[][]dp)
	{
		if(cap<0)
		{
			return Integer.MIN_VALUE;
		}
		if(idx== n)
		{
			return 0;
		}
		if(dp[idx][cap]!=0)
		{
			return dp[idx][cap];
		}
	    int v1 = 0 + knapsackunbounded_recursion(wts,vals,n,idx+1,cap,dp);
	    int v2 = vals[idx] + knapsackunbounded_recursion(wts,vals,n,idx,cap-wts[idx],dp);
	    int ans = v1 > v2 ? v1 : v2;
	    dp[idx][cap] = ans;
	    return ans;
	}
	// It is Knapsack in which repeatation is allowed here..
    static int unboundedKnapSack(int wts[],int vals[], int cap){
	    int dp[] = new int[cap+1];
	    dp[0]=0;
	    for(int i=1;i<dp.length ;i++ ) {
	    	int max = 0;
	    	for (int j=0;j<wts.length ;j++ ){
	    		if(i>=wts[j])
	    		{
	    			int idx = i - wts[j];
	    			int rdata= dp[idx];
	    			int tval = rdata + vals[j];
	    			if(tval > max)
	    			{
	    				max = tval;
	    			}  
	    		}
	    	}
	    	dp[i]= max;
	   	 }
	   	 System.out.println(Arrays.toString(dp));
	     return dp[cap];
	   } 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int wts[] = new int[n];
		int money[] = new int[n];
		for(int i = 0;i<n;i++)
		{
			wts[i] = sc.nextInt();
			money[i] = sc.nextInt();
		}

		int cap = sc.nextInt();
		int dp[][] = new int[n+1][cap+1];
		int MaxProfit= robber_knapsack_fn(wts,money,n,cap);
		System.out.println("-"+ knapsack01_recursion(wts,money,n,0,cap,dp));
		System.out.println(Arrays.deepToString(dp)+"\n " + calls);
		System.out.println(MaxProfit);
		System.out.println(unboundedKnapSack(wts,money,cap));
		int dp1[][] = new int[n+1][cap+1];
		System.out.println("--" + knapsackunbounded_recursion(wts,money,n,0,cap,dp1));
	}
}