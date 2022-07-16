// Matrix Chain Multiplication 
import java.util.*;
class MatrixChainMul{
	static int matrixChainMulfn(int a[],int n)
	{
		int dp[][] = new int[n-1][n-1];
		for (int g = 0; g<dp.length; g++ ) {
			for (int i=0 ,j=g; j < dp.length ;i++, j++) {
				if(g == 0){
					dp[i][j] = 0;
				}
				else if(g == 1)
				{
					dp[i][j] = a[i] * a[j] * a[j+1];
 				}
 				else{
 					int min = Integer.MAX_VALUE;
 					for (int k=i;k<j;k++) {
 						int lc = dp[i][k];
 						int rc = dp[k+1][j];
 						int mc = a[i]  * a[k+1] * a[j+1];
 						int ans = lc + rc +mc;
 						if(ans < min)
 						{
 							min = ans;
 						}
 					}
 					dp[i][j] = min;
 				}
			}
		}
		print(dp);
		return dp[0][dp.length - 1];
	}
	static void print(int  [][] dp)
	{
		for(int  a[] : dp)
		{
			for(int  i : a)
			{
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	static int recursive_sol(int a[],int i,int j,int[][] dp)
	{
		if(i >= j)
		{
			return 0;
		}
		if(dp[i][j]!=-1)
		{
			return dp[i][j];
		}
		int min = Integer.MAX_VALUE;
		for (int k = i; k < j ;k ++ ) {
		    int pans = recursive_sol(a,i,k,dp) + recursive_sol(a,k+1,j,dp) +
		           a[i-1] * a[k] * a[j];
		     if(pans < min)  min =  pans;             	
		}
		return dp[i][j] = min;		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int a[] = new int[n];
	    for(int i = 0;i<n ;i++)
	    {
	    	a[i] =sc.nextInt();
	    }
	    int dp[][] = new int[n][n];
	    for (int a1[] : dp){
	    	Arrays.fill(a1,-1);
	    }
	    int ans = matrixChainMulfn(a,n);
	    int ans2 = recursive_sol(a,1,n-1,dp);
	    System.out.println(ans+ " " + ans2 );
	    print(dp);
	}
}