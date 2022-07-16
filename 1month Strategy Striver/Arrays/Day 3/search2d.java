// Day 3.2  Search Array in 2D matrix
import java.util.*;
class search2d{

	static boolean search2darray(int matrix[][], int target){
        if(matrix.length == 0) return false;
		int n = matrix.length;
		int m= matrix[0].length;
		int lo=0;
		int hi=(n*m)-1;
		while(lo<= hi){
		    int mid = (lo + (hi-lo) / 2);
			if(matrix[mid/m][mid%m]== target){
				System.out.println(" The element is present at index matrix["+(mid/m) +"]"+ "["+(mid%m)+"]");
				return true;
			} 
			if (matrix[mid/m][mid%m] < target) {
				lo = mid+1;
			}
			else{
				hi= mid -1;
			}
		}
      return false;
	}
	public static void main(String[] args) {
		int arr[][]={{1,3,6},{10,19,20},{22,30,55}};
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the target element you want to search :");
		int target = sc.nextInt();
		System.out.println("The target element is Present :"+ search2darray(arr,target)); 
	}
}