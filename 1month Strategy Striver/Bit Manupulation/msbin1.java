
/// find MSB in O(1)
import java.util.*;
class msbin1{
	// Normal Appoarch
	static int msb(int n)
	{
	    n = Math.abs(n);
		n |=n>>1;
		n |=n>>2;
		n |=n>>4;
		n |=n>>16;
		n=n+1;

		return (n>>1);

	}
	// another apporach is
	static int msb1(int n)
	{
		int x = power_of(n);
		return (1<<x);
	}
	static int power_of(int n)
	{
		int x=0;
		while((1<<x) <= n)
		{
			x++;
		}
		return x-1;
	}

	// Simple way
    static int msb2(int n){
    	int k= (int)(Math.log(n) / Math.log(2));

    	return 1<<k;
	}

	public static void main(String[] args) {
		System.out.println(msb(35));
		System.out.println(msb1(298));
		System.out.println(msb2(298));
	}
}