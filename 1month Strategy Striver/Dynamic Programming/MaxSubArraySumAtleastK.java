 // Maximum subarray Sum atleast k

import java.util.*;
class MaxSubArraySumAtleastK{
	public static int MaxSubArraySumAtleastK_fun(int a[], int n,int k)
	{
		// Kadane's Alogrithm
		int ans=0;
		int csum=a[0];
		int maxSum[] = new int[n];
		maxSum[0]=csum;
		for(int i=1;i<n;i++)
		{
			if(csum >= 0)
			{
				csum+=a[i];
			}
			else{
				csum=a[i];
			}
			maxSum[i] = csum;
		}
		System.out.println(Arrays.toString(maxSum));
		int exctK =0;
		for(int i=0;i<k;i++) exctK+=a[i];
		if(ans < exctK)  ans = exctK;
		for(int i=k;i<n;i++)
		{
			exctK+=a[i] - a[i-k];
			if(ans < exctK)  ans = exctK;
			int moreThanKsum = maxSum[i-k] + exctK;
			if(moreThanKsum > ans ) ans = moreThanKsum;
		}	
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int a[]= new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		int k = sc.nextInt();
		int ans=MaxSubArraySumAtleastK_fun(a,n,k);
		System.out.println(ans);
	}
}