/// Egg Drop Problem Hard
// step 1. select  worst max and step2. select the Better of that worst


import java.util.*;
class EggDrop{
	// tabulation..
	
	static int sol_egg_drop_fn(int f , int e)
	{
		int dp[][] = new int[e+1][f+1];

		for(int i=1;i<=e;i++)
		{
			for(int j=1;j<=f;j++)
			{
				if(i == 1)
				{
					dp[i][j] = j;
				}
				else if(j == 1)
				{
					dp[i][j] = 1;
				}
				else{
				    int min = Integer.MAX_VALUE;
					for(int mj = j-1,oi=0 ;mj>=0;mj--,oi++)
					{
						int v1 = dp[i][mj]; // egg survive
						int v2 = dp[i-1][oi];// egg Drop
						int max = v1 >  v2 ? v1 : v2; // max value
						min = min > max? max : min;
					}
					dp[i][j] = min + 1;
				 }
				}
			}
			System.out.println(Arrays.deepToString(dp));
			return dp[e][f];
		}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int floors = sc.nextInt();
		int eggs   = sc.nextInt();
		int c_point= sol_egg_drop_fn(floors,eggs);
		// c is critical point where egg will not survive
		System.out.println(c_point);
	}

} 




/* for(int i = 1;i<n;i++)
{
int max = max < a[i] ? a[i] : max;
}
*/
/* for(int i = 1;i<n;i++)
{
int min = min  > a[i] ? a[i] : min;
}
*/