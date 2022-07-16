///destructor

import java.io.*;
import java.util.*;
class destruct{
	public static void main(String[] args) {
      destruct  d = new destruct();
      d.finalize();
      d = null;
      System.gc();
      System.out.println("Inside the main() method");
	}

	protected void finalize(){
		System.out.println("Object is automatically destroyed by  GC automatically..!!");
	}
}