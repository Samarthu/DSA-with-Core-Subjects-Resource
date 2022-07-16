 // climibing stairs 

 import java.util.*;
 class ClimbingStairs{

     // memoization
     static int climb_fn_rec(int n,int dp[])
     {
     	if(n < 0)
     	{
     		return 0;
     	}
     	if(n == 0)
     	{
     		return 1;
     	} 
     	if(dp[n] > 0)
     	{
     		return dp[n];
     	}
     	int f = climb_fn_rec(n-1,dp);
     	int m = climb_fn_rec(n-2,dp);
     	int l = climb_fn_rec(n-3,dp);
     	int ans = f + m + l;
     	return dp[n] = ans;
     }
     static int climbStairswithtabu(int n)
     {
     	int dp[] = new int[n+1];
     	dp[0] = 1;
     	for(int i =1 ; i<dp.length ; i++)
     	{
     		if(i == 1)
     		{
     			dp[i] = dp[i-1];
     		}
     		else if(i == 2)
     		{
     			dp[i] = dp[i-1]+dp[i-2];
     		}
     		else{
     			dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
     		}
     	}
     	return dp[n];
     }
     public static void main(String[] args) {
     	Scanner sc = new Scanner(System.in);
     	int n = sc.nextInt();
     	int dp[] = new int[n+1];
     	int ways = climb_fn_rec(n,dp);
     	int ways2 = climbStairswithtabu(n);
     	System.out.println(ways +" " + ways2);
     }
 }