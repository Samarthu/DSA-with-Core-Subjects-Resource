// Max SUm
import java.util.*;
class Congi{

	static int money(int n,int a[])
	{
		int sum = 0;
		try{
			for (int i=1;i<=n ;i++ ) {
			int tmp=0; 
			//if(a[i] > 0) throws e;
			if( !(a[i] >= 0))
			{
		      tmp = a[i]* i;
			}
			sum+=tmp;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return sum;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i=0;i<n ;i++ ) {
			a[i]=sc.nextInt();
		}
		int ans = money(n,a);
		System.out.println(ans);
	}
}