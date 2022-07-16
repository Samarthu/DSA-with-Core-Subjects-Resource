import java.util.*;
class findSmallestMissingNoinUnsortedArray{
	static int getSmallestMissingNumber(int arr[],int n)
	{
		// make that the number  to n+1 who is less than 0 or greater than n
		for(int i = 0 ;i<n;i++)
		{
			if(arr[i] <= 0 || arr[i] > n)
			{
				arr[i] = n+1;
			}
		}
		// make that number negative who has value 0<v<n
		for (int i=0;i<n ;i++ ) {
			int num = Math.abs(arr[i]);
			if(num > n) continue;
			num--;
			if(arr[num] > 0)
			{
				arr[num] = -1 * arr[num];
			}
		}
		/// find the number who is still remain possive that index is our
		/// smallest positive missing number.
		for (int i=0;i<n;i++ ) {
			if(arr[i] >= 0)
			{
				return i+1;
			}
		}
		return n+1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i=0;i<n ;i++ ) {
			arr[i] = sc.nextInt();
		}
		int smallestMissingNumber = getSmallestMissingNumber(arr,n);
		System.out.println(smallestMissingNumber);
	}
}