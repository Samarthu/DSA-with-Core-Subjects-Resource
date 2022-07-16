// add element in another array with single varible

import java.util.*;
class addElementWithSingleVariable{
	static int[] getMergedArray(int a[],int a1[],int n)
	{
		int ans[] = new int[n+n];
		for (int i=0;i<n;i++ ) {
			ans[2 * i]   = a[i];
			ans[2 * i+1] = a1[i];
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		int a1[] = new int[n];
		for (int i=0;i<n;i++) {
			a[i] = sc.nextInt();
			a1[i]= sc.nextInt();
		}
		System.out.println(Arrays.toString(a) +" " + Arrays.toString(a1));
		int ans[] = getMergedArray(a,a1,n);
		System.out.println(Arrays.toString(ans));
	}
}