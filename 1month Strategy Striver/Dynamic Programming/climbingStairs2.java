/// cliblling stairs 2 with minimum moves..

import java.util.*;
class climbingStairs2{

	static int climbingStairs2_minimumMoves_fn(int a[],int n)
	{
		n = n+1;
		Integer dp[] =  new Integer[n];
		dp[n-1] = 0;
		for(int i = n-2 ; i>= 0 ;i--)
		{
			if(a[i] > 0)
			{
				int min= Integer.MAX_VALUE;
				for(int j=1; j<= a[i] && j + i < dp.length ; j++)
				{
					if(dp[i+j]!=null){
						min = min > dp[j+i] ? dp[j+i] : min;
					}
				}
				if(min!= Integer.MAX_VALUE)
				{
					dp[i] = min + 1;
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[0];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++)
		{
			a[i] = sc.nextInt();
		}
		int ans = climbingStairs2_minimumMoves_fn(a,n);
		System.out.println(ans);
	}
}