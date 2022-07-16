//Factorial of Big number like 100 using BigInteger in Java

import java.util.*;
import java.math.*;

class factHighNumberUsingBigInteger{

	static BigInteger factBig(int n)
	{
		BigInteger b = new BigInteger("1");
		for(int i=2;i<=n;i++)
		{
			b=b.multiply(BigInteger.valueOf(i));
		}
		return b;
	}
	static int multiplyWithoutOp(int n,int p)
	{
		if(n==0)
		{
			return 0;
		}
	    if(n >0)
		{
			return (p+multiplyWithoutOp(n-1,p));
		}
		if(n<0)
		{
			return -multiplyWithoutOp(-n,p);
		}

     return -1;
	}
  

    static int[] addOne(int[] a)
    {
    	//preProcess(arr);

    	a[a.length-1] =a[a.length-1] +1;
    	int carry = a[a.length-1]/10;
    	a[a.length-1]=a[a.length-1]%10;
    	for(int i=a.length-2;i>=0;i--)
    	{ 
    		if(carry==1)
    		{
    			int num = a[i];
    		    num++;

    		    a[i] = num%10;
    		    carry= num/10;
    		}
    		
    	}
    	if(carry == 1)
    	{
    		a[0] = carry;
    	}
    	return a;
    }
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		// System.out.println("Enter the Big number which you want a Factorial:");
		// int n = sc.nextInt();
		//System.out.println(factBig(n));

		// Multiplication without using * 
		//int p= 5;
		int arr[]={9,9,9};
		int a[];
		a=addOne(arr);

		//System.out.println(multiplyWithoutOp(n,p));
		for (int i=0;i<a.length ;i++ ) {

			System.out.print(a[i]+" ");
		}
		

	}
}