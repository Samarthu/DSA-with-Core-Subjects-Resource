// day3 Majority element II

import java.util.*;
class majorityelem2{
	static List<Integer> majorityelem2_fn(int a[],int n){
		int num1 =-1,num2 =-1, el1=0, el2=0, ct1=0,ct2=0;

		for (int i=0;i<n ;i++ ) {

			if(a[i] == num1){
				ct1++;		
			}
			else if(a[i]== num2){
				ct2++;
			}
			else if (ct1==0){
				num1 = a[i];
				ct1=1;
			}
			else if(ct2 ==0){
				num2 = a[i];
				ct2 =1;
			}
			else{
				ct1--;
				ct2--;
			}
		 } 

		 List<Integer> ls = new ArrayList<>();
         ct1 =0;
         ct2=0;
         for( int i: a){
         	if(i == num1){
         		ct1++;
         	}
         	else if(i == num2){
         		ct2++;
         	}
         }
		 if( ct1 > n/3 ){
		 	ls.add(num1);
		 } 
		 if(ct2 > n/3){
		 	ls.add(num2);
		 }

		 return ls;

	}
	static List<Integer> majorityelem2_fn1(int a[],int n){

		HashMap<Integer,Integer> hs = new HashMap<>();
		List<Integer> ls =new ArrayList<>();
		int n1= n/3;
		for ( Integer i : a) {
			if (hs.containsKey(i)) {
				int cnt= hs.get(i);
				if(cnt+1> n1) 
					ls.add(i);
				hs.replace(i,cnt+1);		
			}
			else{
				hs.put(i,1);
			}
		}
		return ls;
	}
	public static void main(String[] args) {
		int a[]={1,1,1,3,3,2,2,2};
		int n = a.length;
		System.out.println(majorityelem2_fn1(a,n));

	}
}