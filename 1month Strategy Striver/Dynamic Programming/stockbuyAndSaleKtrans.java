/// Stock Buy and Sale K transcation allowed .. Dynamic Programming
import java.util.*;
class stockbuyAndSaleKtrans{
	public static int get_MaxProfit_forKtranscation(int n,int a[],int k)
	{
		int dp[][] = new int[k+1][n];
		for (int t=1;t<=k;t++) {
			int max = Integer.MIN_VALUE;
			for (int d=1;d<n;d++) {
				if(dp[t-1][d-1] - a[d-1] > max)
				{
					max = dp[t-1][d-1] - a[d-1];
				}
				if(max + a[d] > dp[t][d-1])
				{
					dp[t][d] = max + a[d];
				}
				else{
					dp[t][d] = dp[t][d-1];
				}
			}
		}
		return dp[k][n-1];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i =0 ;i< n ;i++ ) {
			a[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		int MaxProfit = get_MaxProfit_forKtranscation(n,a,k);
		System.out.println(MaxProfit);
	}
}