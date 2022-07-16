// pair divible by k 
import java.util.*;
class PairDivisiblebyK{
	static boolean PairDivisiblebyKfunction(int a[],int k)
	{
	    Map<Integer,Integer> mp = new HashMap<>();

	    for(int i : a)
	    {
	    	int rem = i % k;
	    	mp.put(rem,mp.getOrDefault(rem,0) + 1);    	
	    }
	     for (int i :a) {
	     	int rem = i %k;
	     	if(rem == 0)
	        {
	        	int v = mp.get(rem); 
	        	if(v%2== 1)
	        	{
	        		return false;
	        	}
	        }
	        else if(2 * rem == k)
	        {
	        	int v = mp.get(rem); 
	        	if(v%2== 1)
	        	{
	        		return false;
	        	} 
	        }
	        else{
	        	int v1 = mp.get(rem);
	        	int v2 = mp.getOrDefault(k - rem,0);
	        	if(v1 != v2) return false;
	        }
	     }
	     System.out.println(mp);
/*
	     for(Integer i : mp.keySet())
	     {
	     	System.out.println(i+":" + mp.get(i));
	     }*/
	     return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++)
		{
			a[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		boolean AllPairDivibleByK = PairDivisiblebyKfunction(a,k);
		System.out.print(AllPairDivibleByK);
	}
}