 // Count the set Bits from 1 to n..

// Formula = 2^(x-1)*x + n-2^x +1 + n-2^x 
import java.util.*;
class countBits{
	static int setBitsCount(int n)
	{
	   if(n==0) return 0;
		int x = powerofn(n);
		int part1 = x * (1<<(x-1));
		int part2 = n-(1<<x)+1;
		int rest = n-(1<<x);
	    int ans= part1+ part2 + setBitsCount(rest);
	    return ans; 
	}
	static int powerofn(int n)
	{
		int x=0;
		while((1<<x)<=n)
		{
			x++;
		}

		return (x-1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("the number of set Bits are :" + setBitsCount(n));
	}	
}