/// Dp DieHard
//   h amount of health and a amour
// we live either of this state and you can choose the only once and you cannot 
// revisit that state...states are Fire, Air, Water
// Air +3h +2a
// water -5h -10a
// fire -20h+5a
// 1 Air 2 Water 3 Fire
import java.util.*;
class DieHard{
	static int dp[][] = new int[1001][1001];
	static int solve(int h,int a,int s)
	{
		if(h<=0 || a<=0)
		{
			return 0;
		}
		if(dp[h][a] !=-1)
		{
			return dp[h][a];
		}
		int x,y,z;
		x=y=z=0;
		// validity check for visiting only ones
		if(s!=1) x = 1 + solve(h+3,a+2,1);
		if(s!=2) y = 1 + solve(h-5,a-10,2);
		if(s!=3) z = 1 + solve(h-20,a+5,3);
		return dp[h][a] = Math.max(x,Math.max(y,z));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n--!=0)
		{
			int h = sc.nextInt();
			int a = sc.nextInt();
			for(int o[] : dp)Arrays.fill(o,-1);
			int ans = Math.max(solve(h+3,a+2,1) , Math.max(solve(h-5,a-10,2),solve(h-20,a+5,3)));
			System.out.println(ans);	
		}
	}
}