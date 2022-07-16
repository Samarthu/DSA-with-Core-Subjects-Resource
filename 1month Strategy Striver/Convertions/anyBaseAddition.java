// anyBaseAddition

import java.util.*;
class anyBaseAddition{
	static int anyBaseAddition_fn(int b, int n1,int n2)
	{
		int p =1;
		int rv=0;
		int c =0;
		while(n1> 0 || n2 > 0 || c > 0)
		{
			// getting the last digits
			int d1 = n1 % 10;
			int d2 = n2 % 10;
			// reducing the number
			n1/=10;
			n2/=10;
			// performing addition here
			int d = d1 + d2 + c;
			c = d/b;
			d = d % b;
			rv+=d * p;
			p*=10;
		}
		return rv;
	}
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int type = sc.nextInt();
		int n1 = sc.nextInt();
		int n2 =sc.nextInt();
		int ans = anyBaseAddition_fn(type,n1,n2);
		System.out.println(ans);
	}
}