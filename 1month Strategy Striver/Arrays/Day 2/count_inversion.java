// Day2.4 Count inversion using Merge Sort
// Optimized Solution  time complexity: O(nLogn) Space Complexity : O(N)

import java.util.*;
class count_inversion{
    static int merge(int arr[],int l,int m,int r){
    	int[] left1 = Arrays.copyOfRange(arr,l,m+1);
    	int[] right1= Arrays.copyOfRange(arr,m+1,r+1);

    	int i=0,j=0,k=l,swaps=0; 
    	while(i<left1.length && j<right1.length){
    		if(left1[i]<=right1[j]){
    			arr[k++]=left1[i++];
    		}
    		else{
    			arr[k++]=right1[j++];
    			swaps+=(m+1)-(l+i);
    		}
    	}
    	while(i<left1.length)
    		arr[k++]=left1[i++];  
    	while(j<right1.length)
    		arr[k++]=right1[j++];
    	return swaps;
    }
    static int mergesortandcount(int arr[], int left,int right){
    	int count=0;
    	if(left<right)
         {
         	int m = (left+right )/2;
         	count+=mergesortandcount(arr,left,m);
         	count+=mergesortandcount(arr,m+1,right);
         	count+=merge(arr,left,m,right);
         }
         return count;
    }	
	public static void main(String[] args) {
		//int arr[]={5,4,6,3,1};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]= new int[n];
        for (int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
		System.out.println(mergesortandcount(arr,0,arr.length-1));
	}
}