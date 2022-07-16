/// Chocalate candy
import java.util.*;
class ChocalateCandy{
	static int getMinimumDifference(int a[],int n,int m)
	{
		Arrays.sort(a);
		int min = Integer.MAX_VALUE;
		for(int i=0;i<n-m;i++){
			int min = a[i];
			int max = a[i+m-1];
			int diff = max - min;
	        if(diff < min)
	        {
	        	min = diff;
	        }
		}
		return min;
	}
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
		 int a[] = new int[n];
		 for (int i=0;i<n;i++){
		 	a[i] = sc.nextInt();
		 }
		 int m = sc.nextInt();
		 int candyCount = getMinimumDifference(a,n,m);
		 System.out.println(candyCount);
 	}
}