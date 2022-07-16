///power of an number
/// Actually this program is of calculating the power operation of number mistakly
// i wrote the class name wrong
import java.util.*;
class square{
	static int square(int n,int d)
	{
		if(d == 0) return 1;
		int sq2 = square(n,d/2);
		//System.out.println(sq2+"  ");
		int ans = sq2 * sq2 ;
		if(d%2 == 1)
		{
			ans = ans * n;
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
	    int d = sc.nextInt();
	    int ans = square(n,d);
	    System.out.println(ans);
	}
}