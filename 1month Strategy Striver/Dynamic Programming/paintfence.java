// paint fence 
import java.util.*;
class paintfence{
	static long paintfence_fn(int n,int k){
		long same = k*1;
		long diff = k * (k-1);
		long total = same+diff;
		for(int i=3;i<=n;i++)
		{
			same = diff*1;
			diff = total*(k-1);
			total = same+diff;
		}
		return total;
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		 long ans = paintfence_fn(n,k);
		System.out.println(ans);
	}
}