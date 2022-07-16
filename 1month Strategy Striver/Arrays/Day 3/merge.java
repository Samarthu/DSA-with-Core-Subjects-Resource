// Merge sort 
// its time complexity as usual O(nlogn) space complexity : O(n)
class merge{
    static void merge1(int arr[],int l, int mid ,int h){
    	int n1 = mid-l+1;
    	int n2=h-mid;
    	int a[] = new int[n1];
    	int b[] = new int[n2];
        for (int i=0;i< n1 ;i++ ) {
        	a[i]= arr[l+i];
        }
        for (int i=0;i< n2 ;i++ ) {
        	b[i]= arr[mid+1+i];
        }

    	int j=0,i=0,k=l;
    	while(i <n1&& j<n2 ){
    		if(a[i] < b[j]){
    			arr[k++]=a[i++];
    		}
    		else{
    			arr[k++]=b[j++];
    		}
    	}

    	while(i<n1){
    		arr[k++]=a[i++];
    	}
    	while(j<n2){
    		arr[k++]=b[j++];
    	}
    }
	static void mergefun(int arr[],int l,int h){    
        if(l<h){
             int mid=(l+h)/2;
             mergefun(arr, l ,mid);
             mergefun(arr, mid+1 ,h);
             merge1(arr,l,mid,h);
         }
         
	}
	public static void main(String[] args) {
		int arr[]= { 5,4,3,2,1};
		mergefun(arr,0,arr.length-1);
		System.out.println("The Array is :");
         for(int i=0;i<=arr.length-1;i++){
         	System.out.print(arr[i]+" ");
         }
	}
}