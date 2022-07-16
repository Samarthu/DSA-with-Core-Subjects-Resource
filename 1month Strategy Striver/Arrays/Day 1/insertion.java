// Insertion sort having the TIME COMPLEXITY O(N*N)
import java.util.*;
class insertion {

	static void print_sortList(int a[]){
		for (int i=0;i<a.length ;i++ ) {
			System.out.print(a[i]+" ");	
		}
	}
	static void insertion_sort(int a[]){
		for(int i=1 ;i<a.length;i++){
			 int key = a[i];
			 int j = i-1;
			 while(j > -1 && a[j] > key){
			 	a[j+1]=a[j];
			 	j--;
			 }	
			 a[j+1] = key;
			 System.out.print("Iteration"+i+"= ");
			 print_sortList(a);
			 System.out.println();
		}
		 print_sortList(a);
		
	} 
		public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[]=new int[n];
		for (int i=0;i<n ;i++ ) {

			a[i]=sc.nextInt();
		}
		insertion_sort(a);		
	}
}
