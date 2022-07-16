// anybaseMultiplication 
import java.util.*;
class anyBaseMultiplication{
	static int multiplication(int b,int n1,int n2)
	{
		int rv=0;
		int p=1;
		while(n2>0)
		{
			int d = n2 % 10;
			n2/=10;
			int onemultoallres = oneToallMul(b,n1,d);
			rv  = getSum(b,rv,onemultoallres * p);
			p*=10;
		}
		return rv;
	}
	static int oneToallMul(int b,int n1,int n2)
	{
		int c=0;
		int rv=0;
		int p=1;
		while(n1>0 || c > 0)
		{
			int d = n1 % 10;
			n1/=10;
			d = d * n2 + c;
		    c = d/b;
		    d = d % b;
		    rv+=d * p;
		    p*=10;
		}
		return rv;
	}

	static int getSum(int b,int n1,int n2)
	{
		int rv=0;
		int c=0;
		int p=1;
		while(n2>0 || n1 > 0 || c >0)
		{
			int d1  = n1 % 10;
			int d2 = n2%10;
			n1/=10;
			n2/=10;

			int d = d1 + d2 + c;
			c=d/b;
			d%=b;
			rv+= d*p;
			p*=10;
		}
		return rv;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();
		int n1 = sc.nextInt();
		int n2 =sc.nextInt();
		int ans = multiplication(type,n1,n2);
		System.out.println(ans);
	}
}