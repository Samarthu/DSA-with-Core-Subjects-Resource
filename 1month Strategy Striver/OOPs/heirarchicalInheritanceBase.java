/// Herarchical Inheriatance
import java.util.*;
class Person{
	int r;
	String name;
	int age;
	Person(int r,int a ,String n)
	{
		this.r =r;
		this.age =a;
		this.name = n;
	}
	String get_person_details()
	{
		String str= "[" + r +","+ name+","+ age+ "]";
		return str;
	}
	String Get_Skills_info(int a){
		String str="";
		switch(a)
		{ 
			case 1: str = "Verbale Skills and 5 certificates";
			        break;
			case 2: str ="Logical Skillks with 4 certificates";
			        break;
			case 3: str ="Technical skills with 10 certificates";
			        break;
			default:
			        str="Wrong choice";
			        break;
		}
		return str;
	}

}
class school extends Person{
	int sid;
	String name;
	Scanner sc;
	school(int r,int a,String n,Scanner sc)
	{
	  super(r,a,n);
	  this.sc = sc;
	  System.out.println("Enter the Schools Details here :");
	  this.sid  = sc.nextInt();
	  this.name = sc.next();
	}
	void print()
	{
		System.out.println("Schools Details Are :"); 
	    System.out.println("Sid is :" + sid +"\n" + "Class name"+name);
	    super.get_person_details();
	    super.Get_Skills_info(2);
	}
}
class work extends Person{
   int eid;
   long sal;
   String deptName;
   String designation;
   Scanner sc;
   work(int r,int a,String n , Scanner sc)
   {
   	  super(r,a,n);
   	  System.out.println("Enter Works details here :");
   	  eid = sc.nextInt();
   	  sal = sc.nextLong();
   	  deptName = sc.next();
   	  designation = sc.next();
   }
   void print(){
   	    System.out.println("Work Details Are :"); 
	    System.out.println("eid is :" + eid +"\n" + "sal: "+sal +"\n" + "Dept name: "+deptName 
	    	+"\n" + "designation: "+designation);
	    super.get_person_details();
	    super.Get_Skills_info(2);
   }
}
class heirarchicalInheritanceBase{
	public static void main(String[] args) {
		 school sh = new school(10,22,"John",new Scanner(System.in));
         sh.print();
         work w = new work(10,22,"John",new Scanner(System.in));
         w.print();
	}
}