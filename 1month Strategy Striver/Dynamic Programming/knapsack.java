
import java.util.*;

class knapsack{
    // static int robber_knapsack_fn(int [] wts,int money[],int n,int cap,int dp[][])
	// {
	// 	int dp[][]= new int[n+1][cap+1];

	// 	for(int i=1;i<dp.length;i++)
	// 	{
	// 		for(int j=1;j<dp[0].length;j++)
	// 		{
	// 			if(j>= wts[i-1])
	// 			{
	// 			   if(dp[i-1][j- wts[i-1]] + money[i-1] > dp[i-1][j]) // when go for bat and make
	// 			   {                                                 // maxruns 
	// 			   	dp[i][j] = dp[i-1][j- wts[i-1]] + money[i-1]; 
	// 			   }	
	// 			   else{
	// 			   	 dp[i][j] = dp[i-1][j];
	// 			   }
	// 			}else{
	// 				dp[i][j] = dp[i-1][j];
	// 			}			
	// 		}
	// 	}
	// 	//System.out.println(Arrays.deepToString(dp));
	// 	return dp[n][cap];
	// }

    static int Solution2(int wts[],int vals[],int n, int cap)
    {
        int dp[] = new int[cap+1];
	    dp[0]=0;
	    for(int i=1;i<dp.length ;i++ ) {
	    	int max = 0;
	    	for (int j=0;j<wts.length ;j++ ){
	    		if(i>=wts[j])
	    		{
	    			int idx = i - wts[j];
	    			int rdata= dp[idx];
	    			int tval = rdata + vals[j];
	    			if(tval > max)
	    			{
	    				max = tval;
	    			}  
	    		}
	    	}
	    	dp[i]= max;
	   	 }
	   	 //System.out.println(Arrays.toString(dp));
	     return dp[cap];
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int wts[] = new int[n];
		int money[] = new int[n];
		for(int i = 0;i<n;i++)
		{
			wts[i] = sc.nextInt();
			
		}
        for(int i=0;i<n;i++)
        {
            money[i] = sc.nextInt();
        }
		int cap = sc.nextInt();
        //int MaxProfit= robber_knapsack_fn(wts,money,n,cap);
        int MaxProfit= Solution2(wts,money,n,cap);
        System.out.println(MaxProfit);
    }
}




// import java.util.*;
 
// public class knapsack
// {

// static void sort(int a[])
// {
//     for(int i=1 ;i<a.length;i++){
// 			 int key = a[i];
// 			 int j = i-1;
// 			 while(j > -1 && a[j] > key){
// 			 	a[j+1]=a[j];
// 			 	j--;
// 			 }	
// 			 a[j+1] = key;
// 		}
// }

// static int Solution(int []A,int n)
// {
//     int ans = 2;
    
//     if (n <= 2)
//         return n;
 
//     int []llap = new int[n];
//     for(int i = 0; i < n; i++)
//         llap[i] = 2;

//      //sort(A);
//      Arrays.sort(A);

//     for (int j = n - 2; j >= 0; j--)
//     {
//         int i = j - 1;
//         int k = j + 1;
//         while (i >= 0 && k < n)
//         {
//             if (A[i] + A[k] == 2 * A[j])
//             {
//                 llap[j] = Math.max(llap[k] + 1, llap[j]);
//                 ans = Math.max(ans, llap[j]);
//                 i -= 1;
//                 k += 1;
//             }
//             else if (A[i] + A[k] < 2 * A[j])
//                 k += 1;
//             else
//                 i -= 1;
//         }
//     }
//     return ans;
// }
// static int Solution2(int set[])
// {
//     int n = set.length;
//     if (n <= 2) return n;
// 		int L[][] = new int[n][n];
// 		int llap = 2;
// 		for (int i = 0; i < n; i++)
// 			L[i][n - 1] = 2;
//         for (int j = n - 2; j >= 1; j--)
// 		{
// 			int i = j -1 , k = j + 1;
// 			while (i >= 0 && k <= n - 1)
// 			{
// 			if (set[i] + set[k] < 2 * set[j])
// 				k++;
// 			else if (set[i] + set[k] > 2 * set[j])
// 			{
// 				L[i][j] = 2; i--;	
// 			}
// 			else
// 			{
// 				L[i][j] = L[j][k] + 1;
// 				llap = Math.max(llap, L[i][j]);
// 				i--; k++;
// 			 }
// 			}		
// 			while (i >= 0)
// 			{
// 				L[i][j] = 2;
// 				i--;
// 			}
// 		}
// 		return llap;
// }

//   public static void main(String[] args)
//   {
//     Scanner sc = new Scanner(System.in);
//     int n = sc.nextInt();
//     int a[] = new int[n];
//     for(int i=0;i<n;i++)
//     {
//         a[i] = sc.nextInt();
//     }
//     int ans = Solution2(a);
//     System.out.println(ans);
//   }
// }
