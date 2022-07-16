// Simple problem series 
import java.util.*;
class Nthroot{
 /// We finding the square root using binary search....
	static int nSqrt(int x)
	{
		int lo=1,hi=x,ans=-1;
		while(lo<=hi)
		{
		    int mid = (lo+hi)/2;
			int sq = mid*mid;
			if(sq == x)
			{
			     return mid;
			}
		   else if(sq < x){
				 ans=mid;
				 lo=mid+1;
			}
		   else
			{
				hi=mid-1;
			}
		}
		return ans;
	}
	static int ncubroot(int x)
	{
		int lo=1,hi=x,ans=-1;
		while(lo<=hi)
		{
			int mid = lo +(hi-lo) / 2;
			if(mid*mid*mid == x)
			{
				return mid;
			}
			else if(mid*mid*mid < x)
			{
				ans = mid;
				lo = mid+1;
			}
			else{
				hi = mid-1;
			}
		}
		return ans;
	}
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int x = sc.nextInt();
    	//int ans = nSqrt(x);
    	int cudeAns =ncubroot(x);
    	//System.out.println(ans);
    	System.out.println(cudeAns);
    }
}
