// Count the Subarray whos sum is equal to zero 
import java.util.*;
class cntSubArraySumIsZero{
	static int cntsubarrays(int a[] , int n)
	{
		int cnt = 0;
		Map<Integer,Integer>  mp = new HashMap<>();
		int i=-1;
		mp.put(0,1);
		int sum = 0;
		while(i<n-1)
		{
			i++;
			sum+=a[i];
			if(mp.containsKey(sum))
			{
				cnt+=mp.get(sum);
				mp.put(sum,mp.get(sum)+1);
			}
			else{
				mp.put(sum,1);
			}
		}
		System.out.println(mp);
		return cnt;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i = 0 ; i< n ;i++)
		{
			a[i] = sc.nextInt();
		}
		int cnta = cntsubarrays(a,n);
		System.out.println(cnta);
	}
}