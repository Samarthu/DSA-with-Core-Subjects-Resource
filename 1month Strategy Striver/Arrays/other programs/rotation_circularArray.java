// Rotation in circular array
// time complexity is O(logn)

class rotation_circularArray{

	static int rotation_carray(int a[],int l, int h){
		if (l>h) return 0;
		if(l==h) return l;

		int mid = l + (h-l) /2 ; 
		//check if mid is greater 
		if (mid < h  && a[mid+1] < a[mid] ) {
			return mid+1;
		}
		// check for smaller mid

		if (mid > l && a[mid] < a[mid-1])  {
			return mid;
		}

		if (a[h] > a[mid]) {

			return rotation_carray(a,l,mid-1);

		}
		return rotation_carray(a, mid+1, h);
	}
    
    public static void main(String[] args) {
    	int arr[] ={5,4,1,2,3};

    	System.out.println("The total Rotation is  :" + rotation_carray(arr,0,arr.length-1));

    }



}