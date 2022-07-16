// Permutation


import java.util.*;

class permutation{

     public  static Vector<Vector<Integer>> ans=new Vector<Vector<Integer>>();
    
    static void permute(Vector<Integer>x, int idx){

    	if(idx == x.size())
    	{
    		ans.add(x);
    		return;
    	}

    	for (int i=idx;i<x.size();i++) {
    		Collections.swap(x,i,idx);
    		permute(x,idx+1);
    		Collections.swap(x,i,idx);
    	}
    }
    

	public static void main(String[] args) {
	
		Vector<Integer> v= new Vector<Integer>(3);
		 

		 v.add(1);
		 v.add(2);
		 v.add(3);

	    permute(v,0);

	   ans.forEach((s) -> System.out.println(s +" "));


	}

// public static void main(String[] args) {
// 	Vector<Integer> v = new Vector<Integer>();
// 	v.add(1);
// 	v.add(2);
// 	v.add(3);
// 	v.forEach((c) -> System.out.print(c + " "));

// 	Collections.swap(v,0,2);
// 	System.out.println();
// 	v.forEach((c) -> System.out.print(c + " "));

// }
}