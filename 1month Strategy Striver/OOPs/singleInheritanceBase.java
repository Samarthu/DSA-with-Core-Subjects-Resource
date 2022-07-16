/// Here we start  Building the OOps concepts


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
   	    System.out.println("Derived class -------");
    	System.out.println(sal + " " +designation );
    	super.print();
   }
}
class singleInheritanceBase{
	public static void main(String[] args) {
       	 emp e = new emp(10,26,"sam", 1000000l, "SDE");
       	 e.print();
	}
} 
 