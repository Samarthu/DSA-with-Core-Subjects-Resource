// subarraymaxconsequtive Element

import java.util.*;
class subarraymaxconsequtiveElement{
	static int maxConseqElement_fun(int arr[]){
		Set<Integer> nums = new HashSet<Integer>();
		for(int num : arr){
			nums.add(num);
		}
		int longstreak=0;
		for(int num: arr){
			if(!nums.contains(num-1)){
				int currnum = num;
				int currcnt = 1;
				while(nums.contains(currnum+1)){
					currcnt+=1;
					currnum+=1;
				}
				longstreak=Math.max(longstreak, currcnt);
			}
			
		}
		return longstreak;
	}
	public static void main(String[] args) {
		int arr[]= {101,102,2,3,4,1,6,103};
		int longStreak = maxConseqElement_fun(arr);
		System.out.println(longStreak);
		
	}
}