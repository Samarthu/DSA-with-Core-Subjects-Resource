// wildcard pattern matching

import java.util.*;
class wildcardPatternMatching{
	public static boolean wildcardPatternMatching_fun(String s,String p)
	{
		boolean dp[][] = new boolean[p.length()+1][s.length()+1];
		System.out.println(Arrays.deepToString(dp));
		for (int i=dp.length-1;i>= 0 ;i-- ) {
			for (int j=dp[0].length-1;j>= 0 ;j-- ) {
				if(i == dp.length -1 && j == dp[0].length-1){
					dp[i][j] = true;
				}
				else if(i == dp.length-1)
				{
					dp[i][j] = false;
				}
				else if(j == dp[0].length-1)
				{
					if(p.charAt(i) == '*')
					{
						dp[i][j] = dp[i+1][j];
					} 
				}
				else{
					if(p.charAt(i) == '?')
					{
						dp[i][j] = dp[i+1][j+1];
					}
					else if(p.charAt(i) == s.charAt(j))
					{
					    dp[i][j] = dp[i+1][j+1];	
					}
					else if(p.charAt(i) == '*')
					{
						dp[i][j] = dp[i+1][j] || dp[i][j+1];
					}
					else{
						dp[i][j] = false;
					}
				}
			}			
		}
		System.out.println(Arrays.deepToString(dp));
		return dp[0][0];
	}
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 String str= sc.next();
		 String pat = sc.next();
		 boolean ans = wildcardPatternMatching_fun(str,pat);
		 System.out.println(ans);
	}
}