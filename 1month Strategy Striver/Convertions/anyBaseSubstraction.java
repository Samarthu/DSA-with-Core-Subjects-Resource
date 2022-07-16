//AnyBase substraction

import java.util.*;
class anyBaseSubstraction{

	static int anyBaseSubstraction_fn(int b,int n1,int n2)
	{
		int c = 0 ;
		int rv = 0;
		int p=1;
		while(n1 > 0)
		{
			int d1 = n1%10;
			int d2 = n2%10;
			n1/=10;
			n2/=10;
			int d=0;
			d1 = d1 + c;
			if(d1>=d2)
			{
				c=0;
				d = d1 - d2;
			}
			else{
				c=-1;
				d= d1 + b - d2;
			}
			rv+=d*p;
			p*=10;
		}
		return rv;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int base = sc.nextInt();
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int ans = anyBaseSubstraction_fn(base,n1,n2);
		System.out.println(ans);
	}
}