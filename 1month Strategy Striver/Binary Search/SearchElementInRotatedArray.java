/// Its is simpli iterative approacho 

import java.util.*;
class SearchElementInRotatedArray{
	static boolean searchElement(int a[], int n, int key)
	{
		int lo=0, hi=n-1;
		while(lo<=hi)
		{
			int mid = (lo + hi)/2;
			if(a[mid]==key) return true;
			// here i check the either right or left is sorted
			if(a[mid] > a[lo])
			{
				// left part is sorted
				if(key<a[mid] && key>=a[lo])
				{			
					hi = mid-1;
				}
				else{
					lo = mid+1;				
				}

			} 
			else{
				// right part is sorted
				if(key> a[mid] && key<a[hi])
				{
					lo=mid+1;
				}
				else{
					 hi=mid-1;
					
				}
			}
		}
		return false;
	}

	static int rotationRequiredInCircularArray(int a[], int size)
	{
		int lo = 0 , hi=size-1;
		while(lo<= hi)
		{
			 int mid =(lo+hi)/2;
			 if(mid < hi && a[mid+1] < a[mid]) return mid+1;
			 if(mid >lo && a[mid-1] > a[mid])  return mid;
			 if(a[mid] < a[hi]) hi=mid-1;
			 else lo=mid+1;
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i=0;i<n ;i++ ) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		boolean ans = searchElement(arr,n,k);
		int ans1 = rotationRequiredInCircularArray(arr,n);
		int ansO = n-ans1;
		System.out.println(ans +" "+ ansO);
	}
}