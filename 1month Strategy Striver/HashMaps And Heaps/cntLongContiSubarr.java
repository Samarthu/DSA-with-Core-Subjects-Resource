// cnt Longest contigous subarray
// TC = N2;
// space = N;
//Logic here is max - min == j - i;
import java.util.*;
class cntLongContiSubarr{
	static int  cntLongSubarraysfn(int a[],int n)
	{
		HashSet<Integer> hs = new HashSet<>();
		int ans = 0;
		for(int i = 0;i<n-1;i++)
		{
			int min = a[i];
			int max = a[i];
			hs.add(a[i]);
			for(int j = i+1;j<n;j++)
			{
				if(hs.contains(a[j])) break;
				min = min > a[j] ? a[j] : min;
				max = max < a[j] ? a[j] : max;
				if(max - min == j  - i)
				{
					int len = j - i + 1;
					if(len >  ans) ans = len;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i=0 ;i<n ; i++) {
			a[i] = sc.nextInt();
		}
		int ans = cntLongSubarraysfn(a,n);
		System.out.println(ans);
	}
}