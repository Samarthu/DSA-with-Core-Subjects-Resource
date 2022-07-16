// Simple recursion problems to understand its concepts

import java.util.*;
class recPractice{
	static void swap(int a[],int i,int j){
		int temp = a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	static void reverseArray(int idx,int a[],int n){
		if(idx >= n/2)
		{
			return;
		}
		swap(a,idx,n-idx-1);
		reverseArray(idx+1,a,n);
	}

    static int subsetsWhoDivisibleByK(int a[],int n,int idx,int k,int sum,ArrayList<Integer> res)
	{
		if(idx == n)
		{
			if(res.size()!=0 && sum % k == 0)
			{
				return 1;
			}
			return 0;
		}
		res.add(a[idx]);
		sum+=a[idx];
		int l = subsetsWhoDivisibleByK(a,n,idx+1,k,sum,res);
		res.remove(res.size()-1);
		sum-=a[idx];
		int r = subsetsWhoDivisibleByK(a,n,idx+1,k,sum,res);
		return l+r;
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
		int cnt = subsetsWhoDivisibleByK(a,n,0,k,0,new ArrayList<>());
		System.out.println(cnt);
		//System.out.println(Arrays.toString(a));
		//reverseArray(0,a,n);
		//System.out.println(Arrays.toString(a));

	}
}