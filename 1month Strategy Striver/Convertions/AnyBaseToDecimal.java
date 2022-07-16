 //  Convertion of any base to Decimal Base


import java.util.*;
class AnyBaseToDecimal{
	static int convertTodecimal(int n,int b){
       int p=1;
       int rv =0;
       while(n > 0)
       {
       	  int d = n % 10;
       	  n/=10;
       	  d = d * p;
       	  p*=b;
       	  rv+= d;
       }  
       return rv;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();
		int num = sc.nextInt();
		int ans = convertTodecimal(num, type);
		System.out.println(ans);
	}
}