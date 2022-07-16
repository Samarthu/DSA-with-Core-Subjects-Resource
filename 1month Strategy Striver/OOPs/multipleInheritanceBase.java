// Multiple Inheritance
import java.util.*;
class test{
	Scanner sc=new Scanner(System.in);
    int n1;
    int n2;
    int n3;
    test()
    {
    	System.out.println("ENter the 3 subjects marks:");
    	n1=sc.nextInt();
    	n2=sc.nextInt();
    	n3=sc.nextInt();
    }
    int[] marks()
    {
    	int a[] = new int[3];
    	a[0]=n1;
    	a[1]=n2;
    	a[2]=n3;
    	return a;
    }
}
interface sport{
   float sportwt = 6.0f;
   void putwt(); 
}
class result extends test implements sport {
	float mr;
	public void putwt(){
		System.out.println("Sports marks are :" +sportwt);
	}
	float final_result(){
		int a[] = super.marks();
		float res = (a[0] + a[1] + a[2] + sportwt )/ 4;
		this.putwt();
		return res;
	}
}
class multipleInheritanceBase{
	public static void main(String[] args) {
		result  rs = new result();
		float ans = rs.final_result();
		System.out.print("Result is :"+ans);
	}
}