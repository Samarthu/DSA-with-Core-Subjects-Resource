// Largest subarraySum Kadane's Algo

import java.util.*;
class LargestSubArraySum{
	static int lSS(int a[],int n)
	{
		int ans[] = new int[n];
		int csum =a[0];	
		int osum =a[0];
		ans[0] = a[0];
		for(int i=1;i<n;i++)
		{
			if(csum >= 0)
			{
				csum+=a[i];
			}
			else{
				csum=a[i];
			}
			ans[i] = csum;
			if(osum < csum) osum = csum;
		}
		System.out.println(Arrays.toString(ans));
		return osum;
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int a[]= new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		int sum = lSS(a,n);
		System.out.println(sum);
	}
}