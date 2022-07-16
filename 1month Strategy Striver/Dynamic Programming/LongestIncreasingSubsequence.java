// Longest Incresing subsequence
/// Another Problem is  MaxSum increasing subsequence
import java.util.*;
class LongestIncreasingSubsequence{
	static int LIS(int a[],int n)
	{
		int oMax = 0;
		int dp[] = new int[n];
		for (int i=0;i<n;i++){
			int max= 0;
			for(int j=0;j<i;j++){
				if(a[j]<=a[i])
				{
				  int num = dp[i] + dp[j];
				  if(num>max)
				  {
				  	max = num;
				  }
				}
			}
			dp[i] = max+1;
			if(max+1 > oMax)
			{
				oMax=max+1;
			}
		}
		System.out.println(Arrays.toString(dp));
		return oMax;
	}
	static int binarySearch(int[] a,int s,int e, int key)
	{
		if(key > a[e])  return e+1; // it Should be Placed At End;
		while(s<e)
		{
		  int mid = (s+e)/2;
		  if(a[mid] == key) return mid;
		  else if(a[mid] > key) e=mid;
		  else s=mid+1;
		}
		return e;	
	}
	// Optimized Solution 
	static int LISOptimized(int a[],int n)
	{
		int dp[] = new int[n];
		dp[0]=a[0];
		int lastIndex = 0;
		for(int i=1;i<n;i++)
		{
			int idx = binarySearch(dp,0,lastIndex,a[i]);
			/*int p =Arrays.binarySearch(dp,a[i]);
			System.out.println(idx +" " + p);*/
			dp[idx] = a[i];
			lastIndex = lastIndex > idx ? lastIndex : idx;
		}
		return lastIndex+1;
	}

	static int MaxSumOfIncreasingSequence(int a[],int n)
	{
		int Omax = Integer.MIN_VALUE;
		int dp[] = new int[n];
		for(int i=0;i<dp.length;i++)
		{
			Integer max = null;
			for(int j=0;j<i;j++)
			{
				if(a[j] <= a[i])
				{
					if(max == null)
					{
						max = dp[j];
					}
					else if(dp[j] > max)
					{
					    max = dp[j];
					}
				}
			}
			if(max == null)
			{
				dp[i] = a[i];
			}
			else 
			{
			 dp[i] = max + a[i];
			}
			if(dp[i] > Omax) Omax = dp[i];
		}
		System.out.println(Arrays.toString(dp));
		return Omax;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int a[]= new int[n];
		for (int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}
		// Tabulation with n2 TC..
		int ans = LIS(a,n);
		int ans2 = LISOptimized(a,n);
		System.out.println(ans+" " + ans2);
		int MaxSum = MaxSumOfIncreasingSequence(a,n);
		System.out.println(MaxSum);
	}
}