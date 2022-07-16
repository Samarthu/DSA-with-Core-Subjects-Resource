// blanced cost
// Accenture question. .....
import java.util.*;
class BalanceApple{
	static int balanceFun(int a,int m, int rs)
	{
		if(a > m) return rs-(a-m);
		else if(a < m) return rs+(m-a);
		else return rs;
	}
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int a = sc.nextInt();
		int m = sc.nextInt();
		int rs = sc.nextInt();
		int ans  = balanceFun(a,m,rs);
		System.out.print(ans);
	}
}