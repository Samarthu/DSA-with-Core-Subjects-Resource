// Median of two sorted Arrray
import java.util.*;
/// In tbis problem we are using the Binary search  to get Optimized Solution   \
//the tc == O(min(log n1, log n2));
 class medianOftwosortedArray{
 	static int median_fun(int arr1[],int n1,int arr2[],int n2)
 	{
 		int lo=0,hi=n1,cut1,cut2;
 		while(lo<=hi)
 		{
 			cut1 = lo + (hi-lo) /2;
 			cut2 = ((n1+n2)/2)-cut1;
 			int l1 = cut1==0?Integer.MIN_VALUE:arr1[cut1-1];
 			int l2 = cut2==0?Integer.MIN_VALUE:arr2[cut2-1];
 			int r1 = cut1==n1?Integer.MAX_VALUE:arr1[cut1]; 
 			int r2 = cut2==n2?Integer.MAX_VALUE:arr2[cut2];
 			if(l1 > r2 )
 			{
 				hi = cut1-1;
 			}
 			else if(l2 > r1)
 			{
 				lo = cut1+1;
 			}
 			else{
                //System.out.println(Math.max(l1,l2) +" "+ Math.min(r1,r2)); 
 				return (n1+n2)%2==0? (Math.max(l1,l2) + Math.min(r1,r2))/2:Math.min(r1,r2);
 			}
 		}
 		return 0;
 	}
 	public static void main(String[] args) {
 		int arr1[] = {1,5,8,10,18};
 		int arr2[] ={2,3,6,7,20};
 		int n1=arr1.length;
 		int n2=arr2.length;
		int median = median_fun(arr1,n1,arr2,n2); 
 		System.out.println(median);
 	}
 }