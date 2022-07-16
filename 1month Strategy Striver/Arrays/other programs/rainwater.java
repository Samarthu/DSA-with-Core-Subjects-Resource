// Rainwater Trapped Problem  
// Optimized Approach Time Complexity : O(n) && Space Complexity : O(1)
import java.util.*;
class rainwater{
	static int rainwater(int a[]){
		int n = a.length;
		int max=0;
		int leftmax=0;
		int water=0;
		int maxindex=0;
		for (int i=0; i<n;i++ ) {
			if(max < a[i])
			{
			 max = a[i];
			 maxindex=i;
			}	
		}
		for (int i=0;i<maxindex ;i++ ) {
			leftmax=Math.max(leftmax,a[i]);
			int w=Math.min(leftmax,max)-a[i];
			water+=w;
		}
		leftmax=0;
		for(int i=n-1;i>=maxindex;i--){
			leftmax = Math.max(leftmax,a[i]);
			int w= Math.min(leftmax,max)-a[i];
			water+=w;
		}
		return water;
	}
		public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int  i=0;i<n ;i++ ) {
			arr[i] = sc.nextInt();
		}
		int total_water =rainwater(arr);
		System.out.println("The total_water Gained :" + total_water);
	}
}