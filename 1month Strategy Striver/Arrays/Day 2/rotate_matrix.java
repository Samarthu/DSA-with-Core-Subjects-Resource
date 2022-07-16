// Day 2.6 Rotate Matrix 
// Time complexity is:O(n+n/2)
import java.util.*;

class rotate_matrix{
	static void rotate(int a[][]){
		for (int i=0;i<a.length ;i++ ) {
			for (int j=i;j<a[0].length;j++) {
				int temp = 0;
				temp=a[i][j];
				a[i][j]=a[j][i];
				a[j][i]=temp; 
			}
			
		}

		for (int i=0;i<a.length ;i++ ) {
			for (int j=0;j<a.length/2;j++) {
				int temp = 0;
				temp=a[i][j];
				a[i][j]=a[i][a.length-1-j];
				a[i][a.length-1-j]=temp;
			}
			
		}
	}
	public static void main(String[] args) {
		int a[][]={{1,2,3},{4,5,6},{7,8,9}};
		for(int i=0; i<a.length;i++){
			for (int j=0;j<a[0].length ;j++ ) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("---------------------");

		rotate(a);
		for(int i=0; i<a.length;i++){
			for (int j=0;j<a[0].length ;j++ ) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}

	}
}