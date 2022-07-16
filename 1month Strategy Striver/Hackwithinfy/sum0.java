// Tcs Code

import java.util.*;
class sum0{
	static int sum0fn(int a[],int n)
	{
		int sum=0;
		HashSet<Integer> hs = new HashSet<>();
		for (int i=0;i<n ;i++ ) {
			sum+=a[i];
			if(sum == 0 || a[i] == 0 || hs.contains(sum)) return 1;
			hs.add(sum);
		}
		return 0;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i=0;i<n ;i++ ) {
			a[i] = sc.nextInt();
		}
		System.out.println(sum0fn(a,n));
	}
}