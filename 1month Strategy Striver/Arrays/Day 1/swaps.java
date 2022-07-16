import java.util.*;
// this is program in which we swap the numbers without using 3rd varible

class swaps{

static void swap(int a,int b){
	a=a^b;
	//System.out.println(a);
	b=b^a;
	a=a^b;
	System.out.println("Numbers  After Swaps : a=" + a + " b="+ b);
}
static void swap1(int a ,int b,int arr[]){
	a= a+b;
	b=a-b;
	a=a-b;
	System.out.println("Numbers  After Swaps : a=" + a + " b="+ b);

	int xor1=arr[0];
	for (int i=1;i<arr.length;i++ ) {
		System.out.print(xor1 + "^" +arr[i]+"=");
		xor1^=arr[i];
		System.out.print(xor1);
		System.out.println();		
	}
	System.out.println(xor1);


}
	public static void main(String[] args) {

		int a,b;
		Scanner sc = new Scanner(System.in);
		System.out.println("ENter the numbers");
		a=sc.nextInt();
		b=sc.nextInt();
		System.out.println("Numbers  Before Swaps : a=" + a + " b="+ b);
		int a1[]={3,4,5,2,1,1};
		swap1(a,b,a1);
	
		
	}
}