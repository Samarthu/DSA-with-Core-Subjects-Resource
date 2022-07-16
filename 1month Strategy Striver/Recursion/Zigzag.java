///Print zigzag
import java.util.*;
class Zigzag{
	static void printZigzag_function(int n){
		if(n == 0)
		{
			return;
		}
		System.out.println("pre ==>" + n);
		printZigzag_function(n-1);
		System.out.println("in ==>" + n);
		printZigzag_function(n-1);
		System.out.println("post ==>" + n);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printZigzag_function(n);
	}
}