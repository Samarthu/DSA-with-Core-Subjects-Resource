 // Day 1.4
 import java.util.*;


 class MergeTwoSortedArray{
 
   static int nextGap(int gap){
   	if(gap<= 1){
   		return 0;
   	}
   	else{
   	 return (gap/2) + (gap%2);
   	}
   }

   static void MergeTwoSortedArray_m(int arr1[],int arr2[],int n,int m){
 

     int i,j, gap=n+m;
     for(gap=nextGap(gap) ; gap > 0 ;gap=nextGap(gap)){
        // For First Array
        for(i=0;i+gap<n;i++){
        	if(arr1[i]> arr1[i+gap]){
        		int temp=arr1[i];
        		arr1[i]=arr1[i+gap];
        		arr1[i+gap]=temp;
        	}
        }

        // for Both Arrays

        for(j =gap > n ? gap - n:0; i<n && j<m ; i++,j++){
        	if(arr1[i]> arr2[j]){
        		int temp=arr1[i];
        		arr1[i]=arr2[j];
        		arr2[j]=temp;
        	}
        }
        // for Second Array

         if (j<m){
         	for (j=0;j+gap<m ;j++ ) {
         		if(arr2[j]>arr2[j+gap]){
         		int temp=arr2[j];
        		arr2[j]=arr2[j+gap];
        		arr2[j+gap]=temp;
         		}
         	}
         }


     }

   }

// Another  Method i.e Insertion Method for Merging Bt I requires O(n*m)
   static void merge(int arr1[],int arr2[],int n ,int m)
   {
   	  for (int i=0;i<n ;i++ ) {

   	  	if(arr1[i] > arr2[0])
   	  	{
   	  		int temp = arr1[i];
   	  		arr1[i]= arr2[0];
   	  		arr2[0]=temp;
   	  	}
   	  	Arrays.sort(arr2);
   	   }
   	  	
   	  }


 	public static void main(String[] args){
 	  int arr1[]={1,3,5,6,7};
 	  int arr2[]={2,4,8};
 	  int n=arr1.length;
 	  int m=arr2.length;
 	  //MergeTwoSortedArray_m(arr1,arr2,n,m);

 	  merge(arr1,arr2,n,m);

 	  System.out.println("The First Array :");
 	  for ( int i=0;i<n ;i++ ) {
 	  	System.out.print(arr1[i] + " ");
 	  }
 	  System.out.println("\nThe Second Array :");
 	  for ( int i=0;i<m ;i++ ) {
 	  	System.out.print(arr2[i] + " ");
 	  }

 	}

 }