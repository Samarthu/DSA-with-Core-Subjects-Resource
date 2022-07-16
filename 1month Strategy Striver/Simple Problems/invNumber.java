// Inverse a number 

import java.util.*;
class invNumber{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int inv=0;
		int op = 1;
		while(n>0)
		{
		    int od = n%10;
		    int id =op;
		    int ip =od;
		    // now to create the inverted digit 
		    inv = inv + id *(int)Math.pow(10,ip-1);
		    op++;
		    n/=10;
		}
		System.out.println(inv);
	}
}