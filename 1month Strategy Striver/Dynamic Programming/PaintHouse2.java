 // Paint House 2 
 import java.util.*;
 class PaintHouse2{
  static int paintHouse_fun(int[][] a)
 	{

 		int dp[][] = new int[a.length][a[0].length];
 		int least = Integer.MAX_VALUE;
 		int sleast  = Integer.MAX_VALUE;
 		for(int i=0;i<a[0].length;i++)
 		{
 			dp[0][i] = a[0][i];
 			if(a[0][i] <= least)
 			{
 				sleast = least;
 				least  = a[0][i];

 			} else if(a[0][i] <= sleast)
 			{
 				sleast = a[0][i];
 			}
 		}
 		//System.out.println(least);
 		//System.out.println(sleast);

 		for(int i=1;i<dp.length;i++)
 		{
 			int nleast = Integer.MAX_VALUE;
 			int nsleast = Integer.MAX_VALUE;
 			for(int j=0;j<dp[0].length;j++)
 			{
 				if(least == dp[i-1][j])
 				{
 					dp[i][j] = a[i][j]+sleast;
 				}
 				else{
 					dp[i][j] = a[i][j]+least;
 				}
 				if(dp[i][j]<= nleast)
 				{
 					nsleast = nleast;
 					nleast = dp[i][j]; 
 				}
 				else if(dp[i][j]<= nsleast){
 					nsleast =dp[i][j];
 				}
 			}
 			least = nleast;
 			sleast= nsleast;
 			//System.out.print(least+" "+sleast);
 		    //System.out.println();

 		}

 		return least;
 	}
 	public static void main(String[] args) {
 		Scanner sc=new Scanner(System.in);
 		int n=sc.nextInt();
 		int m=sc.nextInt();
 		int a[][] = new int[n][m];
 		for(int i=0;i<a.length;i++){
 			for(int j=0;j<a[0].length;j++){
 				a[i][j] = sc.nextInt();
 			}
 		}
        System.out.println(Arrays.deepToString(a));
 		int ans = paintHouse_fun(a);
 		System.out.println(ans);
 	}
 }