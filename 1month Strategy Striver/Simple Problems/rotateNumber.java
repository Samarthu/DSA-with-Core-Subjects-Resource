// Rotate a number
import java.util.*;
class rotateNumber{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int temp = n;
		int nod = 0;
		while(temp!= 0)
		{
			temp/=10;
			nod++;
		}
		// this line is very crushial so we all have to understand it very carefully.....
		k = k % nod;
		if(k < 0) {
			k = k + nod;
		}
		int div=1,mul=1;
		for(int i=1;i<=nod;i++){
			if(i<=k)
			{
				div*=10;
			}else{
				mul*=10;
			}
		}
		//System.out.print(div +" "+ mul+".");
		int q = n / div;
		int r = n % div;
		//System.out.print(q +" "+ r+".");
		int ans = r * mul + q;
		System.out.println(ans); 
	} 
}
