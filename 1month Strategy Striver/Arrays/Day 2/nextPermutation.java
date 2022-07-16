// Day 2.3 Next Permutation

import java.util.*;

// Optimized Approach
class nextPermutation{
	static void next_permutation(int a[]){

		if(a==null || a.length <=1 ) System.out.println("Next Permutation is The Number itself ");

      int i= a.length-2;

      while(i>=0 && a[i] >= a[i+1] ) i--;

      if(i>=0)
      {
      	int j=a.length-1;
      	while(a[j] <= a[i]) j--;
      	swap(a,i,j);
      } 
      reverse(a,i+1,a.length-1);
    }

    public static void swap(int a[], int i ,int j){
    	int temp=a[i];
    	a[i]=a[j];
    	a[j]=temp;
    }

    public static void reverse(int a[] ,int i, int j){
    	while(i < j )swap(a,i++,j--); 
    }


	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int n=sc.nextInt();
		 int a[] = new int[n];
		 for(int i=0;i<n;i++)
		 {
		 	a[i] = sc.nextInt();
		 }
		next_permutation(a);
		System.out.println(Arrays.toString(a));
	}
}