//  Minimum subarray sum length...
import java.util.*;
class MinSubArraySumLength{
	static int getMinimumSubarrayLength_fn(int a[],int n,int k)
	{
		int len = Integer.MAX_VALUE;
		int val_sum = 0;
		int l = 0;
		for (int i=0;i<n;i++){
			val_sum += a[i];
			while(val_sum >= k)
			{
				len = Math.min(len,i+1-l);
				val_sum -=a[l];
				l++;
			}
		}
		return len==Integer.MAX_VALUE ? 0 : len;
	}
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
	    int n = sc.nextInt();
	    int a[] = new int[n];
	    for (int i=0;i<n;i++) {
	    	a[i] = sc.nextInt();
 	    }
 	    int k = sc.nextInt();
 	    int ans = getMinimumSubarrayLength_fn(a,n,k);
 	    System.out.println(ans);
	}
}