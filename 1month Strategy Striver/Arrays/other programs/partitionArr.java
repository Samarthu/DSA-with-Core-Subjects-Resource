// Partitioning an array
import java.util.*;
class partitionArr{
	public static void swap (int a[],int i,int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;		
	}
	public static int partition_fn(int a[], int s,int e)
	{
		int pivot = a[e];
		int i = s-1;
		for(int j = s;j<e;j++)
		{
			if(a[j] < pivot)
			{
				i++;
				swap(a,i,j);
			} 
		}
		swap(a,i+1,e);
		return i+1;
	}

	static void quicksort(int a[],int s ,int e)
	{
		if(s<e)
		{
			int p = partition_fn(a,s,e);
			quicksort(a,s,p-1);
			quicksort(a,p+1,e);
		}
	}

	public static void MergeTwoSortedArray(int a[],int b[])
	{
		int ans[] = new int[a.length + b.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < a.length  && j < b.length)
		{
			if(a[i] < b[j])
			{
				ans[k++] = a[i++];
			}
			else{
				ans[k++] = b[j++];
			}
		}
		while(i < a.length)
		{
			ans[k++] = a[i++];
		}
		while(j < b.length)
		{
			ans[k++] = b[j++];
		}
	}

	public static void MergeTwoSortedArray1(int a1[] , int lo , int mid , int hi)
	{
		int n1 = mid-lo+1;
		int n2 = hi-mid;
		int a[] = new int[n1];
   	  	int b[] = new int[n2];
   	  	for(int i=0;i<n1;i++){
   	  		a[i] = a1[lo +i];
   	  	}
   	  	for(int i=0;i<n2;i++){
   	  		b[i] = a1[mid + 1 + i];
   	  	}
   	  	int i = 0;
		int j = 0;
		int k = lo;
		while(i < a.length  && j < b.length)
		{
			if(a[i] < b[j])
			{
				a1[k++] = a[i++];
			}
			else{
				a1[k++] = b[j++];
			}
		}
		while(i < a.length)
		{
			a1[k++] = a[i++];
		}
		while(j < b.length)
		{
			a1[k++] = b[j++];
		}
	}

   public static void merge(int a[] ,int lo,int hi)
   {
   	  if(lo < hi){
   	  	int mid=(lo + hi)/2;
   	  	merge(a,lo,mid);
   	  	merge(a,mid+1,hi);
   	  	MergeTwoSortedArray1(a,lo,mid,hi);
   	 } 
   }
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i =0;i<n;i++)
		{
			a[i] = sc.nextInt();
		}
		//int partition_index = partition_fn(a,0,n-1);
		//System.out.println(partition_index);
		System.out.println(Arrays.toString(a));
		//quicksort(a,0,n-1);
		merge(a,0,n-1);
		System.out.println(Arrays.toString(a));
	}
}