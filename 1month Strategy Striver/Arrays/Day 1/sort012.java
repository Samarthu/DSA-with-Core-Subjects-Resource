// dutch  national flag algo..

// Day1.1 Problem of sort an array of 0,1 and 2's
// Time complexity = O(N)
// Space complexity = O(1)


class sort012{

    static void sort_m(int nums[])	
    {
    	int lo=0;
    	int mid=0;
    	int high=nums.length-1;
    	int temp;

    	while(mid<=high)
    	{
    		switch(nums[mid])
    		{
    			case 0:{
    				temp=nums[lo];
    				nums[lo]=nums[mid];
    				nums[mid]=temp;
    				
    				mid++;
    				lo++;
    				break;
    			       }
    			case 1: 
    			        mid++;
    					break;
    			case 2: temp=nums[high];
    			        nums[high]=nums[mid];
    			        nums[mid]=temp;
    			        high--;
    			        
    			        break;
    		}

    	}

    	System.out.println("Sorted Array is:");
    	for(int n=0;n<nums.length;n++){
    		System.out.print(nums[n]);
    	}

    }
	public static void main(String[] args) {
		int nums[]={0,0,2,1,2,0,2,1,1,0,1};
		sort_m(nums);
	}
}

