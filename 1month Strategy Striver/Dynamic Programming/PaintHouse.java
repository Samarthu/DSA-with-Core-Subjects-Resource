 // Paint House
 import java.util.*;
 class PaintHouse{
 	static long paintHmincost(int a[][]){
 		long dp[][]= new long[a.length][a[0].length];
 		dp[0][0] = a[0][0];
 		dp[0][1] = a[0][1];
 		dp[0][2] = a[0][2];
 		for(int i=1;i<a.length;i++)
 		{
 			dp[i][0] = a[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
 			dp[i][1] = a[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
 			dp[i][2] = a[i][2] + Math.min(dp[i-1][0],dp[i-1][1]);
 		}
 		System.out.println(Arrays.deepToString(dp));
 		return Math.min(dp[a.length-1][0],Math.min(dp[a.length-1][1],dp[a.length-1][2]));
 	    }
 	 	public static void main(String[] args) {
 		Scanner sc = new Scanner(System.in);
 		int n = sc.nextInt();
 		int m = sc.nextInt();
 		int a[][] = new int[n][m];
 		for(int i=0;i<n;i++)
 		{
 			for (int j=0;j < m ; j++) {
 				a[i][j] = sc.nextInt();
 			}
 		}
 		long MinCost = paintHmincost(a);
 		System.out.println(MinCost);
 	}
 }