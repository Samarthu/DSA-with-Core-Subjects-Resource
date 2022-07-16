
// This program includes all the operations without using that specific operator

import java.util.*;
class withoutUsingOpr{

	static int multiply(int x,int y)
	{
		if(x==0 || y==0) return 0;
		if(y==1) return x;
		if(x==1) return y; 
		return x+multiply(x,y-1);

	} 
	static int multiplyWi(int x,int y)
	{
		int m=multiply(x,Math.abs(y));
		return (y<0) ? -m:m;
	}

	static int sqaureN(int n)
	{
		if(n<2) return n;
		n = Math.abs(n);
		int i =n>>1; // divide by two..
		if((n&1)==1) return((sqaureN(i)<<2)+(i<<2) +1);
		return(sqaureN(i)<<2);
	}
    // multiplication of two number using binary
    static int multiplyBY(int x,int y)
    {
    	boolean isNegative = false;
    	if(x < 0 && y<0){x=-x; y=-y;}
    	if(x<0) {x=-x;isNegative=true;}
    	if(y<0) {y=-y;isNegative=true;}
    	int res=0;
    	while(y!=0){
    		if((y&1)==1) res+=x;
    		x<<=1;
    		y>>=1;
    	}
    	return isNegative? -res:res;
    }

    // Divide a number without using any operator
    static int divideWi(int x,int y)
    {
    	if(y > x )  return 0;
    	if(y==0) return 0;
    	int sign = 1;
    	if(x*y < 0) sign=-1;
    	x=Math.abs(x);
    	y=Math.abs(y);
    	int q=0;
    	while(x>=y)
    	{
    		x=x-y; q++;
    	} 
    	System.out.println("The remainder is :" + x);
    	return sign*q;
    }
    static int divideBy(int x,int y)
    {
    	if( y > x ) return 0;
    	if(y == 0) return 0;
    	int sign=1;
    	if(x*y<0) sign=-1;
    	int mask=1,q=0;
    	while(y<=x)
    	{
    		mask<<=1;
    		y<<=1;
    	} 
    	while(mask >1)
    	{
    		mask>>=1;
    		y>>=1;
    		while(x>=y)
    		{
    			x-=y;
    			q|=mask;
    		}
    	}
    	System.out.println("The remainder is :" + x);
    	return sign*q;	
    }
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n1=sc.nextInt();
		int n2=sc.nextInt();
		System.out.println("Multiplication of number without using '*'  is :" + multiplyWi(n1,n2));
		System.out.println("Multiplication of number without using '*'  Using BinaryOperator :" + multiplyBY(n1,n2));
		System.out.println("Square of number without using any operator:" + sqaureN(n1));
		System.out.println("Dividation of number without using '/'  is :" + divideWi(n1,n2));
		System.out.println("Dividation of number without using '/' Using Bits is :" + divideBy(n1,n2));

	}
	
}