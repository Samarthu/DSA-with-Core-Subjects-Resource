// i'th Palindromic number Bits

import java.util.*;
class palindromicBits{
	static int getRev(int n){
		int rev=0;
		while(n!=0)
		{
			int i=(n&1);
			rev|=i;
			rev<<=1;
			n>>=1;
		}
		rev>>=1;
		return rev;
	}
	static int palinNumberFunction(int n)
	{
		int cnt=1;
		int len=1;  
		while(cnt < n)
		{
			len++;
			int poweroFint = (1<<(len-1)/2);
			cnt +=poweroFint;
		} 
		cnt-=(1<<(len-1)/2);
		int offset = n-cnt-1;
		int ans = 1<<(len-1); // 10000...000
		ans|= offset<<( len/2);
		int valOF = (ans>>(len/2));
		int rev = getRev(valOF);
		ans|=rev;
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		System.out.println(palinNumberFunction(n));
		//System.out.println(getRev(n));
	}
}