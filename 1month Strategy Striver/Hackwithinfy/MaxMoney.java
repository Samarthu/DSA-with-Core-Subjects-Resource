// congizant maximize the money 

import java.util.*;
class MaxMoney{
	static int getMaxMoney(int n,int a[],int a1[],int l1,int l2)
	{
		Arrays.sort(a);
		Arrays.sort(a1);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(a1));
		int n1,nl2;
		if(l1 == 0 || l2 == 0 )
		{
			int an = 0;
			if(l1 == 0)
			{
				n1 = nl2 = l2;
				for(int i=0;i<a1.length;i++)
	   			{
	    		  an += a1[i];
	    		}
	    		return an;
			}
			else{
				n1= nl2 = l1;
				for(int i=0;i<a1.length;i++)
	   			{
	    		  an += a[i];
	    		}
	    		return an;
			}
		}
		else{
			if(n % 2 == 1)
			{
		       n1 = n/2 + 1;
		       nl2 = n/2;
			}
			else{
			n1 = nl2 = n/2;
		   	}
			if( n1 > l1 && l1!=0) n1 = l1;
		    if(nl2 > l2 && l2!=0)  nl2 = l2;
		    int ans=0;
		    int ans2=0;
		    for(int i=n-1;i>=n1 ; i--)
		    {
		    	ans += a[i];
		    } 
		    for(int i=n-1;i>=nl2 ;i--)
		    {
		    	ans +=a1[i];
		    }
		    for(int i=n-1;i>=nl2 ; i--)
		    {
		    	ans2 += a[i];
		    } 
		    for(int i=n-1;i>=n1 ;i--)
		    {
		    	ans2+=a1[i];
		    }
		    return ans > ans2 ? ans : ans2;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		int a1[] = new int[n];
		for (int i =0;i<n ;i++ ) {
			a[i]=sc.nextInt();
			a1[i]=sc.nextInt();
		}
		int l1 = sc.nextInt();
		int l2 = sc.nextInt();
		int maxMoney = getMaxMoney(n,a,a1,l1,l2);
		System.out.println(maxMoney);
	}
}