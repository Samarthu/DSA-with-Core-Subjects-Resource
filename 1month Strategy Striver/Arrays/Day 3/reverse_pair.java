// Day 3.6 Reverse a pair


import java.util.*;

public class reverse_pair{

static	private int merge(int a[],int lo,int mid ,int hi){

        int nums[]=new int[hi-lo+1];
 		int p=lo, q=mid+1,cnt=0,index=0;
 		for(int i=lo;i<=mid;i++)
        {
            while(q<=hi && a[i] > (2*(long) a[q]))
            {
                q++;
            }
            cnt+=(q-(mid+1));
        }
 		p=lo;
 		q=mid+1;
 		while(p<=mid && q <= hi){
 			if (a[p] < a[q]) {
 				nums[index++]=a[p++];			
 			}
 			else{
 			   nums[index++]=a[q++];	
 			}
 		}

 		// for remaining elements 

 		while(p<=mid){
 			nums[index++]=a[p++];
 		}
 		while(q<=hi){
 			nums[index++]=a[q++];
 		}
 		System.arraycopy(nums, 0 ,a ,lo, (hi-lo)+1);
 		return cnt;
	}

    
    static int mergesort(int a[],int lo,int hi){
    	if(lo>=hi) return 0;
    	int count =0;
    	int mid = lo + (hi-lo)/2;
    	count+=mergesort(a,lo,mid);
    	count+=mergesort(a,mid+1,hi);
    	count+=merge(a,lo,mid,hi);
    	return count;
    }
    static int reverse_P(int arr[]){
    	int n=arr.length;
    	return mergesort(arr,0,n-1);
    }
	public static void main(String[] args) {
		int arr[] ={2,4,3,5,1};
		int pair = reverse_P(arr);
		System.out.println("The reverse pair is  :" +  pair);
	}
}