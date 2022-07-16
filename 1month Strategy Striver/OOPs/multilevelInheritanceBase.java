import java.util.*;

class Person{
	int roll;
	int age;
	String name;
	Person(int r,int a , String n)
    {
    	this.roll = r;
    	this.age = a;
    	this.name = n;
    }
    void print()
    {
    	System.out.println("Base class -------");
    	System.out.println(roll + "  " + age + "  " + name );
    }
}
class emp  extends Person{
   long sal;
   String designation;	
   emp(int r,int a,String n, long s, String deg)
   {
   	 super(r,a,n);
   	 this.sal = s;
   	 this.designation= deg;
   }
   void print(){
   	    super.print();
   	    System.out.println("Intermediate class -------");
    	System.out.println(sal + " " +designation );
   }
}
class dept extends emp{
    int deptID=0;
    String deptName="";
    Scanner sc;
    dept(int r,int a,String n, long sal,String deg, Scanner sc)
    {
       super(r,a,n,sal,deg);
       this.sc = sc;
    }

    void print()
    {
    	super.print();
    	System.out.println("Derived class ------");
    	deptID = sc.nextInt();
    	deptName = sc.next();
    	System.out.println(deptID + "  " + deptName);
    }

}
class multilevelInheritanceBase{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int age = sc.nextInt();
        String name = sc.next();
        long sal = sc.nextLong();
        String desig = sc.next();
        dept d = new dept(r,age,name,sal,desig,sc);
        d.print();
	}
}

