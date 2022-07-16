// Multithreading and synchronization
// When we define method as a Synchronized then it does not affect 
import java.util.*;

class Table{
       void print(int n){
		for(int i=1;i<=5;i++)
		{
			System.out.println(i*n);
			try{
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(400);
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}
}
 class t1 extends Thread{
    Table t;
    t1(Table t)
    {
    	this.t = t;
    }
    public void run(){
    	t.print(5);
    }
}
class t2 extends Thread{
  Table t;
  t2(Table t)
  {
  	this.t = t;
  }
  public void run(){
  	t.print(10);
  }
}

 class Multithreading{
	public static void main(String[] args) {
		Table t = new Table();
		t1 ob = new t1(t);
		t1 ob1=new t1(t);
		t2 obj= new t2(t);	
    	ob.setPriority(1);
		obj.setPriority(10);
		ob.start();
		ob1.start();
		obj.start();
		ob1.stop();

	}
}

// Thread Programming
//Methods 
//

/* 1.setPriority
   2.sleep(int,long)
   3.wait()
   4.stop();
   5.destoy();

*/