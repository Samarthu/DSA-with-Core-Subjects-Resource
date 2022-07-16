// rod cutting
import java.util.*;
class rodCutting{
	static int getMaxPriceForRodcutting(int arr[],int n)
	{
		int np[] = new int[n+1];
		for (int i=0;i< n;i++) {
			np[i+1] = arr[i];
		}
		int dp[] = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i=2;i<dp.length;i++) {
			dp[i] = np[i];
			int li = 1;
			int ri = i-1;
			while(li<=ri)
			{
				if(dp[li] + dp[ri] >  dp[i] )
				{
					dp[i] = dp[li] + dp[ri];
				}
				li++;
				ri--;
			}
		}
		return dp[n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		 int arr[] = new int[n];
		 for (int i=0;i<n;i++) {
		 	arr[i] = sc.nextInt();
		 }
		 int ans = getMaxPriceForRodcutting(arr,n);
		 System.out.println(ans);
	}
}