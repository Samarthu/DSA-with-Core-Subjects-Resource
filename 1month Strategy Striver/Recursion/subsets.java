// Subsets of lists using recursion very very easiest steps ever..........

import java.util.*;
class subsets{
   //static List<Integer> res = new ArrayList<>();
	static void subsets_fn(int a[],int n,int idx,String psf)
	{
		if(idx == n)
		{

			System.out.println(psf+",");
			return;
		}
		subsets_fn(a,n,idx+1,psf+a[idx]);
		subsets_fn(a,n,idx+1,psf);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++)
		{
			a[i] = sc.nextInt();
		}
		subsets_fn(a,n,0,"");
	}
	
}