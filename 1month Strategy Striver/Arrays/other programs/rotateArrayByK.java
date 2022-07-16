// Rotate array By k
import java.util.*;
class rotateArrayByK{
	static void reverse(int arr[] , int i, int j)
	{
		int lp = i ;
		int rp = j ;
		while(lp<=rp)
		{
			int tmp = arr[lp];
			arr[lp] = arr[rp];
			arr[rp] = tmp;

			lp++;
			rp--;
		}
	}
	static int[] rotateArray(int arr[], int size, int k)
	{
		k = k%size;
		if(k < 0)
		{
			k = size + k ;
		}
		//reverse first half
		reverse(arr,0,size-k-1);
		// reverse second half
		reverse(arr,size-k,size-1);
      	// reverse All 
		reverse(arr,0,size-1);

		return arr;
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]= sc.nextInt();
		}
		int k = sc.nextInt();
		int arr1[] = rotateArray(arr,n,k);
		System.out.println(Arrays.toString(arr1));
	}
}