// Longest Commmon Subsequence
import java.util.*;


class LCS{
	// Tabulation form..
	static int LCS_fn(String s1,String s2)
	{
		int dp[][]=new int[s1.length()+1][s2.length()+1];
		for(int i=dp.length-2;i>=0;i--)
		{
			for(int j=dp[0].length-2;j>=0;j--)
			{
				char ch  = s1.charAt(i);
				char ch1 = s2.charAt(j);
				if(ch==ch1)
				{
					dp[i][j]=dp[i+1][j+1]+1;
				}
				else{
					dp[i][j] = dp[i+1][j] > dp[i][j+1] ? dp[i+1][j]:dp[i][j+1];
				}
			}
		}
		System.out.println(Arrays.deepToString(dp));
		return dp[0][0];
	}
	/// memoization in dp...
	static int lcs_recursion(String s1,String s2,int l1,int l2,int dp[][]){
	   if(l1 < 0 || l2 < 0)
	   {
	   	return 0;
	   }
	   if(dp[l1][l2]!=-1)
	   {
	   	 return dp[l1][l2];
	   }
	   if(s1.charAt(l1) == s2.charAt(l2))
	   {
	   	  return dp[l1][l2] = 1 + lcs_recursion(s1,s2,l1-1,l2-1,dp);
	   }
	   else{
	   	return dp[l1][l2] = lcs_recursion(s1,s2,l1-1,l2,dp) > lcs_recursion(s1,s2,l1,l2-1,dp) ?
	   	        lcs_recursion(s1,s2,l1-1,l2,dp) :lcs_recursion(s1,s2,l1,l2-1,dp);  
	   }
	}
	public static void main(String[] args) {
	    Scanner sc= new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		int ans = LCS_fn(s1,s2);
		System.out.println(ans);
		int dp[][]=new int[s1.length()][s2.length()];
		for(int[] a : dp){Arrays.fill(a,-1);}
		int ans1 = lcs_recursion(s1,s2,s1.length()-1,s2.length()-1,dp);
		System.out.println(ans1);
		System.out.println(Arrays.deepToString(dp));		
	}
}