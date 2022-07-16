/// O(Nlogn)  + O(1)

// Longest SubArray who hving the sum as Zero Keep it mind that we want only Longest SubArray
import java.util.*;
class longestSubarrayWithZero{
	static int longSum(int arr[], int n)
	{
		int sum=0;
		int maxi=0;
		HashMap<Integer,Integer> mpp = new HashMap<>();
		for(int i=0;i<n;i++){
			sum+=arr[i];

			if (sum==0) {
				maxi= i+1;
			}
			if(mpp.get(sum)!=null){
				maxi=Math.max(maxi,i-mpp.get(sum));
			}
			else
			{
				mpp.put(sum,i);
			}

		}
		return maxi;
	}
    public static void main(String[] args) {
    	int arr[] ={1,-1,3,2,-2,-8,1,7,10,23};
    	int n=arr.length;
    	System.out.println(longSum(arr,n));
    }
}