//// perfect cube root check 
import java.util.*;
class perfectCube{

	static boolean checkPerfectCube(int n)
	{
		int d = (int)Math.cbrt(n);
		if(d * d * d == n)
		{
			return true;
		}
	  return false;
	}
	static int get_ans(int a[],int n)
	{
		int sum = 0;
		for(int i = 0;i<n;i++)
		{
			if(checkPerfectCube(a[i]))
			{
				sum+=1;
			}
		}
		return sum;
	}

	static int digitCnt(String str)
	{
		int cnt=0; 
		for(int i = 0;i<str.length();i++)
		{
			char c = str.charAt(i);
			if(Character.isDigit(c))
			{
				cnt+=1;
			}
		}
		return cnt;
	}
	static void get_ans2(int a[],int n){
		for (int i = 1;i< n; i++ ) {
			a[i] =  a[i-1] + a[i];
		}
		System.out.println(Arrays.toString(a));

	}
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
		 int a[] = new int[n];
		 for (int i = 0;i< n ; i++) {
		 	a[i] = sc.nextInt();
		 }
		 int asum = Arrays.stream(a).sum();
		 System.out.println(asum);
		 String str = sc.next();
		 int cnt = digitCnt(str);
		 System.out.println("Digits are :" + cnt);
		 int ans = get_ans(a,n);
		 System.out.println(ans);
		 get_ans2(a,n);
	}
}