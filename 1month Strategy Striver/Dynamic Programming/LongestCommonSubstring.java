// Longest common substring
import java.util.*;
class LongestCommonSubstring{
	// Tabulation
	static int lcsubstring(String s1,String s2)
	{
		int max=0;
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		for(int i=1;i<dp.length;i++){
			for(int j=1;j<dp[0].length;j++){
			     char c1 = s1.charAt(i-1);
			     char c2 = s2.charAt(j-1);
			     if(c1!=c2)
			     {
			     	dp[i][j]=0;
			     }
			     else
			     {
			     	dp[i][j]=dp[i-1][j-1]+1;
			     }
			     if(dp[i][j] > max)
			     {
			     	max = dp[i][j];
			     }
			}
		}
		for(int a[] : dp)
		{
			for(int i : a)
			{
				System.out.print(i+" ");
			}
		   System.out.println();
		}
		return max;
	}
	static int lcsubstring_rec(String s1,String s2,int l1,int l2,int [][]dp)
	{
		if(l1<0  || l2< 0)
		{
			return 0;
		}
		if(s1.charAt(l1) == s2.charAt(l2))
		{
		   if(dp[l1][l2]==-1)
		   {
		   	   dp[l1][l2] = 1+lcsubstring_rec(s1,s2,l1-1,l2-1,dp);
		   }	
		}
		else 
		{
			dp[l1][l2]=0;
		}
		if(l1-1>0 && dp[l1][l2]==-1) lcsubstring_rec(s1,s2,l1-1,l2,dp);
		if(l2-1>0 && dp[l1][l2]==-1) lcsubstring_rec(s1,s2,l1,l2-1,dp);
		return dp[l1][l2];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		int ans = lcsubstring(s1,s2);
		System.out.println(ans);
		int dp[][] = new int[s1.length()][s2.length()];
		for(int a[] : dp) Arrays.fill(a,-1);
		int ans2 = lcsubstring_rec(s1,s2,s1.length()-1,s2.length()-1,dp);
		System.out.println(ans2);
		for(int a[] : dp)
		{
			for(int i : a)
			{
				System.out.print(i+" ");
			}
		   System.out.println();
		}
	}
}