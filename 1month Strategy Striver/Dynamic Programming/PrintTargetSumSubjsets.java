/// Dp Print Target sum subsets

// with reduced Time Complexities....

import java.util.*;
class PrintTargetSumSubjsets{

	static class Pair{
		int i,j;
		String psf;
		Pair(int i,int j,String psf)
		{
			this.i = i;
			this.j = j;
			this.psf = psf;
		}
	}
	static void PrintTargetSumSubjsets_fun(int a[],int n, int t)
	{
	    boolean dp[][] = new boolean[n+1][t+1];
	    for(int i=0;i<dp.length;i++)
	    {
	    	for(int j=0;j<dp[0].length;j++)
	    	{
	    		if(i== 0 && j == 0)
	    		{
	    			dp[i][j] = true;
	    		}
	    		else if(i==0)
	    		{
	    			dp[i][j] = false;
	    		}
	    		else if(j==0)
	    		{
	    			dp[i][j] = true;
	    		}
	    		else{
	    			if(dp[i-1][j] == true)
	    			{
	    				dp[i][j] = true;
	    			}else if(j>=a[i-1] && dp[i-1][j- a[i-1]] == true){
	    				dp[i][j] = true;
	    			}
	    		}
	    	}
	    }
	    System.out.println(dp[n][t]);
	    // its looks like a horrable but trust its not it is just bfs nothing else.....
	    ArrayDeque<Pair> q = new ArrayDeque<>();
	    q.add(new Pair(n,t,""));
	    while(q.size() > 0)
	    {
	    	Pair rem = q.removeFirst();
	    	if(rem.i==0 || rem.j == 0)
	    	{
	    		System.out.println(rem.psf);
	    	}
	    	else{
	    		if(rem.j >=a[rem.i-1])
	    		 {
	    			boolean inc = dp[rem.i-1][rem.j-a[rem.i-1]];
			    	if(inc)
			    	{
			    		q.add(new Pair(rem.i-1, rem.j - a[rem.i-1] , (rem.i-1) +" "+rem.psf));
			    	}
	    		 } 
			    	boolean exc = dp[rem.i-1][rem.j];
			    	if(exc)
			    	{
			    		q.add(new Pair(rem.i-1,rem.j,rem.psf));
			    	}
	    	}
	    }
	}

	static void PrintTargetSumSubjsets_fun_nrec(int a[], int idx , int len, String psf,int ssf,int tar)
	{
		if(idx == a.length){

			if(ssf == tar)
				{
					System.out.println(psf);
					return;
				}

				return;
		}

		PrintTargetSumSubjsets_fun_nrec(a,idx+1,len,psf,ssf,tar);
		PrintTargetSumSubjsets_fun_nrec(a,idx+1,len,psf+","+a[idx],ssf+a[idx],tar);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++)
		{
			a[i] = sc.nextInt();
		}
		int tar = sc.nextInt();
		PrintTargetSumSubjsets_fun(a,n,tar);

		/// Normal recursion

		PrintTargetSumSubjsets_fun_nrec(a,0,n,"",0,tar);

	}
}