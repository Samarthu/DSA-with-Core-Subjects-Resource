// count number of element and write it to front of it Like mAP

import java.util.*;
class countFrq{


	static void countFr(int a[],int n){
		
		Map<Integer,Integer> mp = new HashMap<>();
		for(int i=0;i<n;i++)
		{
		 if(mp.containsKey(a[i]))
		{
			mp.put(a[i],mp.get(a[i] )+1);
		}
		else{
			mp.put(a[i],1);
		}
		}
		System.out.println(mp);
		
	}
	static int[] sort(int a[],int n)
	{
		for(int i=1;i<n;i++)
		{
			int key = a[i];
			int j = i-1;
			while(j>-1 && a[j] > key)
			{
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = key;
		}
		return a;
	}

	static void countfrNormalWay(int a[],int n)
	{
		a = sort(a,n);
        //System.out.println(Arrays.toString(a));
        int cnt[][] = new int[n][2];
        int x=0;
        cnt[x][0]=a[0];
        cnt[x][1]=1;
           for(int i=1;i<n;i++)
        	{
        		if(a[i-1]==a[i])
        		{
        			cnt[x][1]+=1;]9.0
        		}
        		else{
        			x++;
        			cnt[x][0] = a[i];
        			cnt[x][1] = 1;
        		}
        	}
        	x++;
        	for(int i=0 ;i<x;i++)
        	{
        		System.out.println(cnt[i][0] +"="+cnt[i][1]);
        	}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i = 0;i<n;i++)
		{
			a[i] = sc.nextInt();
		}
		// Using HashMAP
		countFr(a,n);

		// Without Using HashMAp

		countfrNormalWay(a,n);
	}
}