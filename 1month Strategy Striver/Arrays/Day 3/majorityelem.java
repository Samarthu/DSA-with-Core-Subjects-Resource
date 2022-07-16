// Day 3.3 Majority Element 
import java.util.*;
class majorityelem{
	// most optimized approach using moore's method
	static int majority(int[] nums){
		int cnt =0;
		int candidate= 0;
		for (int num  : nums ) {

			 if(cnt == 0) candidate = num;

			 if(num == candidate){
			 	 cnt+=1;
			 }
			 else
			 { 
			 	cnt-=1;
			 }
		}
		return candidate;
	}
	// Its time Complexity is O(Nlogn)

	static int majority1(int[] nums){
          
       HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
       for (int i  : nums) {
       	 if(hs.containsKey(i)){
       	 	int cnt = hs.get(i);
       	 	//System.out.println(cnt);
       	 	if(cnt+1 >= nums.length/2) return i;
       	 	hs.replace(i, cnt+1);
       	 }
       	 else{       	 	 
       	 	hs.put(i,1);
       	 }
       	
       } 
		 return 0;
	}
	public static void main(String[] args) {
	 int nums[]= {4,4,3,3,4,4,4,4};
	  System.out.println("The Majority element is  :"+ majority1(nums));	
	}
}
        