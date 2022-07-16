import java.util.*;
class sortingAlgorithms{
	static void swap(int a[],int i,int j)
	{
		int temp = a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	static int[] merge_sort(int a[],int n)
	{
		merge(a,0,n-1);
		return a;
	}
	static void mergeFun(int a[],int l,int m,int h)
	{
		int n1 = m-l+1;
		int n2 = h-m;
		int a1[]=new int[n1];
		int b1[]=new int[n2];
		for (int i =0;i<n1 ;i++ ) {
			a1[i] = a[l+i];
		}
		for (int i=0;i<n2 ;i++ ) {
			b1[i] =a[m+i+1];
		}
		int i=0,j=0,k=l;
		while(i<n1 && j<n2)
		{
			if(a1[i] < b1[j])
			{
				a[k++] =a1[i++];
			}else{
				a[k++]=b1[j++];
			}
		}
		while(i<n1)
		{
			a[k++] =a1[i++];
		}
		while(j<n2)
		{
			a[k++]=b1[j++];
		}
	}
	static void merge(int a[],int l,int h)
	{
		if(l<h)
		{
			int mid = (l+h)/ 2;
			merge(a,l,mid);
			merge(a,mid+1,h);
			mergeFun(a,l,mid,h);
		}
	}
	static int[] quick_sort(int a[],int n)
	{
		quickSort(a,0,n-1);
		return a;
	}

	static void quickSort(int a[],int lo,int hi ){
		if(lo>=hi)
		{
			return;
		}
		int pivot = a[hi];
		int pi = partition(a,pivot,lo,hi);
		quickSort(a,lo,pi-1);
		quickSort(a,pi+1,hi);
	}

	static int partition(int a[],int p,int lo,int hi)
	{
		int i=lo,j=lo;
		while(i<=hi)
		{
			if(a[i]>p)
			{
				i++;
			}
			else{
				swap(a,i,j);
				i++;
				j++;
			}
		}
		return (j-1);
	}
	static int[] selection_sort(int a[],int n)
	{
		for (int i = 0;i<n ;i++ ) {
			int min = i;
			for (int j=i+1;j<n;j++ ) {
				if(a[min] > a[j])
				{
					min=j;
				}
			}

			if(min != i)
			{
				swap(a,min,i);
			}
		}
		return a;
	}
	static int[] insertion_sort(int a[],int n)
	{
		for(int i=1;i<n;i++ ) {
			int k = a[i];
			int j = i-1;
			while(j>-1 && a[j] > k)
			{
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = k;
		}
		return a;
	}
	static int[] bubble_sort(int arr[],int n)
	{
		for(int i=0;i<n;i++)
		{
			for (int j=0;j<n-i-1;j++ ) {
				if(arr[j] > arr[j+1])
				{
					swap(arr,j,j+1);
				}
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		 Scanner sc= new Scanner(System.in);
		 int n = sc.nextInt();
		 int a[] = new int[n];
		 for (int i=0;i<n;i++ ) {
		 	a[i] = sc.nextInt();
		 }
		
		 System.out.println("Enter how many algorithm you want to try:");
		 int times = sc.nextInt();
		 while(times-- > 0)
		 {
		 	System.out.println("select the sorting algorithm : 1.bubble\n2.insertion\n3.selection\n4.merge\n5.quick");
		 	int ch = sc.nextInt();
		 	switch(ch)
			 {
			 	case 1:int arrBubble[] = bubble_sort(a,n);
			 	       System.out.println(Arrays.toString(arrBubble));
			 	       System.out.println("time complexity is O(n^2)");
			 	       break;
			 	case 2:int arrInsertion[] = insertion_sort(a,n);
			 	       System.out.println(Arrays.toString(arrInsertion));
			 	       System.out.println("time complexity is O(n^2)");
			 	       break;
			 	case 3:int arrSelection[] = selection_sort(a,n);
			 	       System.out.println(Arrays.toString(arrSelection));
			 	       System.out.println("time complexity is O(n^2)");
			 	       break;             
		        case 4:int arrMerge[] = merge_sort(a,n);
			 	       System.out.println(Arrays.toString(arrMerge));
			 	       System.out.println("time complexity is O(n log n)");
			 	       break;
			 	case 5:int arrQuick[] = quick_sort(a,n);
			 	       System.out.println(Arrays.toString(arrQuick));
			 	       System.out.println("time complexity is O(n log n)");
			 	       break;
			   default:System.out.println("wrong choice");
			 	       break;	 
		 	}
		 }
		 
	}
}