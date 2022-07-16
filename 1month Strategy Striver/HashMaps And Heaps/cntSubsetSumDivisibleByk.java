// count subset sum whose sum is divisible by k
import java.util.*;
class cntSubsetSumDivisibleByk{
	static int cntSubsets(int a[],int n,int k)
	{
		Map<Integer,Integer> mp = new HashMap<>();
		mp.put(0,1);
		int i=0;
		int sum=0;
		int ans=0;
		while(i < n){
			sum+=a[i];
			int rem = sum % k;
			if(rem < 0)
			{
				rem+=k;
			}
			if(mp.containsKey(rem))
			{
				ans+=mp.get(rem);
				//System.out.println(ans);
				mp.put(rem,mp.get(rem) + 1);
			}
			else{
				mp.put(rem,1);
			}
			i++;
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
	    for (int i=0;i<n;i++ ) {
	    	a[i] = sc.nextInt();
	    }
	    int k= sc.nextInt();
	    int ans = cntSubsets(a,n,k);
	    System.out.println(ans);
	}
}