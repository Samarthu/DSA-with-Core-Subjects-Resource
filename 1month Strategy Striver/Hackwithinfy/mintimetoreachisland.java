// minimum time required to reach island
import java.util.*;
class mintimetoreachisland{
	
	static int getMintime(int a[],int b[],int n, int m)
	{
		int tm = 0;
		Arrays.sort(a);
		Arrays.sort(b);
		int dp[] = new int[n];
		if(n < m)
		{
			 int i = 0;
		     while(i< n)
		     {
		     	if(a[i] > b[i])
		     	{

		     	}
		     	else{
		     		dp[i] = 1;


		     	}
		     	i++;
		     }

		}
		else{
			int i = 0;
			int j = -1;
			int cnt = 1;
			while(true)
			{
			  while(i < m){
				j++;
				 if(a[j] <= b[i] && dp[j] == 0)
				 { 
					dp[j] = 1;
				 }
				}	
				if(isRemaining(dp,n)){
					cnt+=1;
					i=0;
				}			
			 }
			
			}
	}
   
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	int a[] = new int[n];
    	int b[] = new int[m];
    	for(int i=0;i<n;i++)
    	{
    		a[i] = sc.nextInt();
    	}
    	for(int i=0;i<m;i++)
    	{
    		b[i] = sc.nextInt();
    	}
    	int ans = getMintime(a,b,n,m);
    	System.out.println(ans);
    }
}