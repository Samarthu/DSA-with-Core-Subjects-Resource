/// print the digits of a number is it very important for understanding the code
import java.util.*;
class DigitOfNumber{
	static void printDigitsofNumber(int n)
	{
		/// here we just count the number of digit in a number
		int cnt = 0;
		int temp =n;
		while(temp!= 0)
		{
			temp /= 10;
			cnt++;
		}
		int div = (int)Math.pow(10,cnt-1);
		while(div!=0)
		{
			int q = n / div;
		    System.out.println(q);
		    n = n % div;
		    div/=10;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printDigitsofNumber(n);
	}
}
