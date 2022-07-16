import java.util.*;
class CntPalindromicSubstr{
	static int cntPalindromicSubstr_fn(String str)
	{
		int cnt = 0;
		boolean dp[][] = new boolean[str.length() ][str.length()];
		for(int g=0;g<str.length();g++)
		{
			for(int i=0,j=g ; j < dp.length ; i++,j++)
			{
				if(g == 0)
				{
					dp[i][j] = true;
				}
				else if(g ==  1)
				{
					if(str.charAt(i) == str.charAt(j))
					{
						dp[i][j] = true;
					}
				}
				else{
					if(str.charAt(i) == str.charAt(j)  && dp[i+1][j-1] == true)
					{
						dp[i][j] = true;
					}
				}

				if(dp[i][j] == true)
				{
					cnt+=1;
				}
			}
		}
		print(dp);
		return cnt;
	}

	static void print(boolean [][] dp)
	{
		for(boolean a[] : dp)
		{
			for(boolean i : a)
			{
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		String str = sc.next();
		int cnt = cntPalindromicSubstr_fn(str);
		System.out.println(cnt);
	}
}