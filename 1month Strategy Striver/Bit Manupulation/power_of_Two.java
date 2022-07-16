// check if a number is power of n or not


import java.util.*;
class power_of_Two{
	static boolean power_of_Two_fun(int n)
	{
		if(n==1)
			return true;
		if(n%2==1 || n==0)return false;

		return power_of_Two_fun(n/2);
	}
	public static void main(String[] args) {
		int n=10,n1=64;
	 	System.out.println(power_of_Two_fun(94));	
	 	System.out.println(power_of_Two_fun(n1));
	}
}
