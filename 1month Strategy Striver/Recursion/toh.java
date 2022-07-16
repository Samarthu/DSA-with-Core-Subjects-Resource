// Tower of honoi..
import java.util.*;
class toh{
	public static void tohf(int n, char d1,char d2,char d3)
	{
		if(n == 0) return;
		tohf(n-1,d1,d3,d2);
		System.out.println( n +" [" + d1 +"==>"+d2 + "]");
		tohf(n-1,d3,d2,d1);
	} 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
	    String disks = sc.next();
	    char[] di = disks.toCharArray();
	    char d1 = di[0];
	    char d2 = di[1];
	    char d3 = di[2];
		tohf(n,d1,d2,d3);
	}
}