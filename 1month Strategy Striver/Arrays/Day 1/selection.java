// selection sort  having the TIME COMPLEXITY O(N*N)
import java.util.*;

class selection{

	static void print_sortList(int a[]){
		for (int i=0;i<a.length ;i++ ) {
			System.out.print(a[i]+" ");	
		}
	}
   static void swap(int a[],int i,int j){
    int tmp = a[i];
    a[i]=a[j];
    a[j]=tmp;	
   }
	static void selection_sort(int a[],int l){
		for(int i=0;i<l;i++){
			int min = i;
			for (int j = i+1; j< l ;j++ ){
				if(a[j]<a[min]){
					min = j;
					
				}	
			}
			swap(a,i,min);
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
		int len = a.length;
		for (int i=0;i<n ;i++ ) {

			a[i]=sc.nextInt();
		}
		selection_sort(a,len);
	}
}

