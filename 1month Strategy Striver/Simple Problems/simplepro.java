import java.util.*;
class add{
	int n,m;
	add(int a,int b)
	{
		this.n = a;
		this.m = b;
	}
	int add()
	{
		return n+m;
	}
	String name()
	{
		return "sam";
	}
	double fv()
	{
		return 10.3;
	}
	boolean br(){
		return true;
	}
}
class simplepro{
	public static int multiplyValue(int n,int m)
	{
		return n * m;
	} 
     public static void main(String arg[])
     {  
     	Scanner sc = new Scanner(System.in);
     	/*int n = sc.nextInt();
     	int ans = multiplyValue(n,2);
     	System.out.println(ans);
     	add a = new add(5,5 );
     	int addition =  a.add();
     	System.out.println(a.name());
     	System.out.println(addition);
*/
 /*    	sc.next(); sc.nextInt(); sc.nextDouble(); sc.nextFloat(),sc.nextCharacter()*/
 	     int n =sc.nextInt();
 	     int b = sc.nextInt();
 	     int a[] = new int[10];
 	     for (int i = 0;i<10 ;i++ ) {
 	     	a[i] = sc.nextInt();
 	     }
 	     System.out.println(n+b);
     }
}