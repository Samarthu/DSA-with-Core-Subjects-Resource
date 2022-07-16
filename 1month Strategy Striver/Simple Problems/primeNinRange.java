// prime between the range
import java.util.*;
import java.io.*;
class primeNinRange{
	static void isPrime(int n1,int n2)
	{
		for (int i=n1;i<=n2;i++) {
			int n=i;
			boolean isFlag = false;
			for(int di = 2 ;  di * di <= n ;di++ )
			{
				if(n%di == 0)
				{
					isFlag = true;
					break;
				}
			}
			if(!isFlag){
				System.out.println(n);
			}
		}
	} 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		isPrime(n1,n2);
	}
}