import java.util.*;
class minAsciidiff_Sumof_2strgs{
     static void print(int dp[][])
	{
		for (int i =0;i<dp.length ;i++ ) {
			for (int j=0;j<dp[0].length ;j++ ) {				
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int minAsciiDiff_fun(String s1,String s2)
	{
		int dp[][] = new int[s1.length()+1][s2.length()+1];
		for (int i = dp.length-1;i>=0 ;i-- ) {
			for (int j =dp[0].length-1;j>=0 ;j-- ) {
				if(i ==  dp.length-1 && j == dp[0].length-1)
				{
					dp[i][j] = 0;
				}else if(i == dp.length-1)
				{
					dp[i][j] = (int)s2.charAt(j) + dp[i][j+1];

				}else if(j == dp[0].length-1)
				{
					dp[i][j] = (int)s1.charAt(i) + dp[i+1][j];
				}else{
					if(s1.charAt(i) == s2.charAt(j))
					{
						dp[i][j] = dp[i+1][j+1];
					}
					else{
					dp[i][j] = Math.min(s2.charAt(j) + dp[i][j+1],s1.charAt(i) + dp[i+1][j]);
					}
				}
			}
		}
		print(dp);
		return dp[0][0];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		int ans = minAsciiDiff_fun(s1,s2);
		System.out.print(ans);
	}
}