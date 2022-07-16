// minimum number of swaps required to sort and array

import java.util.*;
class minSwapsTosortA{
	/// simple sorting approach
	static class pair implements Comparable<pair>{
		int val;
		int idx;
		pair(int v,int i)
		{
			this.val = v;
			this.idx = i;
		}
		public int compareTo(pair o)
		{
			return this.val - o.val;
		}
	}

	static void swap(pair a[] , int i,int j)
	{
		pair tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	static void printPair(pair a[])
	{
		for (int i=0;i<a.length;i++){
			System.out.println(a[i].val +" " + a[i].idx);
		}
		System.out.println("---------");
	}

	static int getminswapsfun_graph(int a[],int n)
	{
		pair arr[] = new pair[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = new pair(a[i],i);
		}
		Arrays.sort(arr);
		int ans=0;
		boolean vis[] = new boolean[n];
		for(int i=0;i<n;i++){
			if(vis[i] == true || arr[i].idx == i)
			{
				continue;
			}
			int clen=0;
			int j = i;
			while(vis[j] == false)
			{
				vis[j] = true;
				clen++;
				j=arr[j].idx;
			}

			ans+=(clen-1);
		}
		return ans;
	}
	static int getMinSwapsFun(int a[],int n)
	{
		pair arr[] = new pair[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = new pair(a[i],i);
		}
		printPair(arr);
		Arrays.sort(arr);
		printPair(arr);
		int cntcyle=0;

		for(int i=0;i<n;i++){
			if(arr[i].idx == i) continue;
			else
			{	
				cntcyle++;
				swap(arr,i,arr[i].idx);
				i--;
			}
		}
		return cntcyle;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}
		int ans = getMinSwapsFun(a,n);
		int ans1 = getminswapsfun_graph(a,n);
		System.out.println(ans +" " + ans1);
	}
}