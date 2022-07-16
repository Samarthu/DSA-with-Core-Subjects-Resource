
// Day 1.6 Find Duplicate Number for i+1 size 
import java.util.*;

class duplicateno
{

   // Solve By using Hashmap  O(n) and  space :O(n) 
	static int duplicate(int arr[])
	{

		Map<Integer,Boolean> mp =new HashMap<>();

		for(Integer i : arr){

			if(mp.get(i) == null){
				mp.put(i,true);
			}
			else{
				return i;
			}
		}
		return 0;

	}

	// solve by using tortoize linked list tortoise method

	static int duplicate1(int arr[])
	{

		int fast=0;
		int slow=0;
		do{

		 slow=arr[slow];
		 fast=arr[arr[fast]];
		}
		while(slow!=fast);


		  fast = 0;
		  while(slow!=fast)
		  {
		  	slow=arr[slow];
		  	fast=arr[fast];
		  }
		  return slow;

	}
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,3};
		// System.out.println("The duplicate No is :" + duplicate(arr));
		System.out.println("The duplicate No is :" + duplicate1(arr));
	}
}