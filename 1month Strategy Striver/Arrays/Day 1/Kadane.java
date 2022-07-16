//Kadane Algo for maxSubarray Sum

// Time complexity is O(n)..
class Kadane
{
	static int maxSubarray(int nums[])
	{
		int max = nums[0];
		int sum = 0;
		for(int i=0;i<nums.length;i++){
			sum+=nums[i];
			if(sum > max)max = sum;
			if(sum <0) sum =0;
		}
		return max;
	}
	public static void main(String[] args) {
		int nums[]={-2,-3,4,-1,-2,1,5,-3};
		System.out.print("The  maxSubarray sum is : " +maxSubarray(nums));
	}
}


