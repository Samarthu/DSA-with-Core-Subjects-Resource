/// simple program to reverse a number
import java.io.*;
class revNum{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int rev=0;
		int rem;
		while(n!=0)
		{
			rem = n%10;
			rev = rev*10 + rem;
			n/=10;
		}
		System.out.println(rev);
	}
}
