// ko ko eating bannanas.. By using simple binary Search . ..... 
import java.util.*;
class KoKoEatingBananas{
	static int getEatingBananacntPerHour(int a[],int n,int hr)
    {
    	int max = Integer.MIN_VALUE;
    	for(int el : a)
    	{
    	   max = max < el ? el : max; 
    	}
    	if(hr == n)
    	{
    		return max;
    	}
    	int lo = 0;
    	int hi = max;
    	int speed = Integer.MAX_VALUE;
    	while(lo <= hi)
    	{
    		int sp= lo + (hi-lo) / 2;
    		if(isFine(a,n,sp,hr)){
    			speed = sp;
    			hi =sp-1; 
    		}else{
    			lo = sp+1;
    		}
    	}
    	return speed;
    }
    static boolean isFine(int a[],int n,int sp, int hr)
	{
		int sum=0;
		for (int i=0;i<n;i++ ) {
			sum+= (int)Math.ceil( a[i]*1.0 / sp);
		}
		return sum <= hr;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i=0;i<n ;i++ ) {
			a[i] = sc.nextInt();
		}
		int hr = sc.nextInt();
		int ans = getEatingBananacntPerHour(a,n,hr);
		System.out.println(ans);
	}
}