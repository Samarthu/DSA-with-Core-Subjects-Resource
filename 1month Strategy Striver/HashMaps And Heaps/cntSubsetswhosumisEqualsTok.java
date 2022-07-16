 // count subsets who sum is equal to k

 import java.util.*;
 class cntSubsetswhosumisEqualsTok{

 	static int cntSubarrays(int a[],int n,int k)
 	{
 		int ans =0;
 		Map<Integer,Integer> mp = new HashMap<>();
 		mp.put(0,1);
 		int sum =0 ;
 		for (int i=0;i<n ;i++ ) {
 			// Optional part it being considered when the element isself having value
 			// Equals to K...
 	    //	if(a[i] == k) ans+=1; 
 			sum+=a[i];
 			if(mp.containsKey(sum - k))
 			{
 				ans+=mp.get(sum - k);
 			} 
 			mp.put(sum,mp.getOrDefault(sum,0) + 1);
 		}
 		System.out.println(mp);
 		return ans;
 	}
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int a[] = new int[n];
    	for (int i=0;i<n;i++){
    		a[i] = sc.nextInt();
    	}
    	int k=sc.nextInt();
    	int ans = cntSubarrays(a,n,k);
    	System.out.println(ans);
    }
 }