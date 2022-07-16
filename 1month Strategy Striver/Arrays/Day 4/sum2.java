// Day 4 2Sum
import java.util.*;
class sum2{
	public static void main(String[] args) {

		int arr[] ={2,11,15,15};
		int n=arr.length;
		int target = 17;
		ans obj = new ans(n,target);
		int anss[] =Arrays.copyOf(obj.sum_ans(arr),2);
		for (int i :anss ) {
			System.out.print(i+" ");
		}

	}
}
class ans{
	int n;
	int tar;
	ans(int n,int tar){
		this.n=n;
		this.tar=tar;
	}

	int[] sum_ans(int a[]){
     
      HashMap<Integer,Integer> map = new HashMap<>();
      //List<Integer> ll = new ArrayList<>();
	  for(int i=0 ;i< n ;i++){
	  	map.put(a[i],i);

	 }
	 for (int i=0; i<n ;i++ ) {
	 	int num= a[i];
	 	int rem = tar - a[i];
	 	if (map.containsKey(rem)){
	 		 int idx = map.get(rem);
	 		 if(idx == i) continue;
	 		 return new int[]{i,idx};
	 	}
	 	
	 }
	 return new int[]{};
	}


}