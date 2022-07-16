// Game theory Question That we have build in the Recursion  We can optimize that solution 
// BY using Dynamic Programming\

// Optimal strategy for game
import java.util.*;
class OptimalMaxCoinsProfit{

	static int OptimalMaxCoinsProfit_fn(int a[],int n)
	{
		int dp[][]=new int[n][n];		
		for(int g =0;g<n;g++)
		{
			for(int i=0,j=g;j<a.length;i++,j++)
			{
				if(g==0)
				{
					dp[i][j] = a[i];
				}
				else if(g==1){
					dp[i][j] = Math.max(a[i],a[j]);
				}
				else{
					int val1 = a[i]  + Math.min(dp[i+2][j],dp[i+1][j-1]);
					int val2 = a[j] + Math.min(dp[i+1][j-1],dp[i][j-2]);
					int val = Math.max(val1,val2);
					dp[i][j] = val;
				}
			}
		}
	  for (int i=0;i<dp.length;i++) {
	  	 for (int j=0;j<dp[0].length;j++) {
	  	 	if(i==0) System.out.print(" "+dp[i][j]+" ");
	  	 	else System.out.print("  "+dp[i][j]+" ");
	  	 }
	  	System.out.println();
	  }
		return dp[0][n-1];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++)
		{
			a[i] = sc.nextInt();
		}
		int MaxProfit = OptimalMaxCoinsProfit_fn(a,n);
		System.out.println(MaxProfit);
	}
}