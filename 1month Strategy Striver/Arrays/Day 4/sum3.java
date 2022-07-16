 import java.util.*;
 class sum3{
	static List<List<Integer>> res = new ArrayList<>();
	static List<List<Integer>> threesum(int num[]){
		Arrays.sort(num);
		int lo,hi,sum; 
		for(int i=0 ;i<num.length-2 ;i++){
			if (i == 0 || ( i>0 && num[i] != num [i-1])){
				lo=i+1;
				hi=num.length-1;
				sum = 0-num[i];
				System.out.println(sum);
				while(lo < hi){
					if(num[lo]+ num[hi] == sum){
						System.out.println(num[lo] +" "+ num[hi]);
						res.add(Arrays.asList(num[i],num[lo],num[hi]));
						while( lo < hi && num[lo] == num[lo+1]) lo++;
						while( hi > lo && num[hi] == num[hi-1]) hi--;
						lo++;
						hi--;			 
					}
					else if(num[lo] + num [hi] < sum ) lo ++;
					else hi--;
				}				 
			}				
	  }
	return res;
	}
	public static void main(String[] args) {
		 int a[] = {1,0,-1,2,0,-2};
		 System.out.println(threesum(a));
	}
}