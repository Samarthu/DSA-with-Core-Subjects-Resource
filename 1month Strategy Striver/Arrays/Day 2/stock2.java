import java.util.*;
class stock2{
   static int stock(int arr[]){
		int profit=0;
		for(int i=1;i<arr.length;i++){
			if (arr[i]>arr[i-1]) {	
				profit+= (arr[i]-arr[i-1]);
			}	
		}
		return profit;
	}
	public static void main(String[] args) {
	 int arr[] = {5,2,6,1,4,8};
	 int n = stock(arr);
	 System.out.println("The Maximum Profit is:" + n);
	}
} 