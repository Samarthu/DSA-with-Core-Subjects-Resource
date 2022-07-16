import java.util.*;

class pattern1{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int k,j;
		for (int i=1; i<= n ;i++ ) {
			for (j=1; j<=n-i;j++ ) {
				System.out.print(" ");		
			}
			k=i;
			for (;j<=n ;j++ ) {

				System.out.print(k--);
			}
			k=2;
			for (;j<= n+i-1 ;j++) {
			    System.out.print(k++);	
				
			}
		System.out.println();	
		}
		
	}
}