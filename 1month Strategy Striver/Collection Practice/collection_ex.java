 // Collection practice class here ...

import java.util.*;

class collection_ex{
	public static void main(String[] args) {
		/// ArrayList
/*
		ArrayList<Integer> list=new ArrayList<>();
		ArrayList<Integer> l2=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);

		l2.add(19);
		l2.add(20);
	    l2.add(21);
		//list.addAll(l2);
		list.add(2,20);
	    Object p =l2.clone(); 

	    System.out.println(p);
		//
		System.out.println(list + "index is " + list.indexOf(20));
		System.out.println(l2);
*/
		// LinkedList

/*
		LinkedList<Integer> list = new LinkedList<>();
	    LinkedList<Integer> l2 = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.addFirst(3);
		list.addLast(3);

		l2.add(19);
		l2.add(20);
	    l2.add(21);
		list.addAll(l2);
		list.addLast(3);
		list.remove(0);
		list.add(2,20);
		//ArrayLis l3 = new ArrayList<>(); 
		//l3.clone(list)
		System.out.println(list + "index is " + list.indexOf(20));
		System.out.println(l2);
		l2.clear();
		System.out.println(l2);

*/

 /// ArrayDqueue

  //   	ArrayDeque<Integer> dq = new ArrayDeque<>(2);
		// dq.offer(24);
		// dq.offer(25);
		// dq.offerLast(26);
		// dq.offer(22);
		// dq.offerFirst(1);
		// //dq.offerLast(10);
		// //dq.pollLast();
		// System.out.println(dq + "Peek Element " + dq.peekLast() + " " + dq.size());


/// TreeSet
/*
		TreeSet<Integer> t1 = new TreeSet<>();
		TreeSet<String> t2 = new TreeSet<>();
		t1.add(50);
		t1.add(57);
		t1.add(3);
		t1.add(24);

		Iterator it=t1.iterator();
		while(it.hasNext())
		{
			System.out.print(it.next()+",");
	    }
	    System.out.println();

	    t1.forEach(w -> System.out.print(w+" "));
	    System.out.println();
	    System.out.println(t1);
	    t2.add("sbb");
		t2.add("abs");
		t2.add("iur");
		t2.add("rbrb");
		Iterator i1t=t2.iterator();
		while(i1t.hasNext())
		{
			System.out.print(i1t.next()+",");
	    }
	    System.out.println();

	    t2.forEach(w -> System.out.print(w+" "));
	    System.out.println();
	    System.out.println(t2);



*/

	    // Maps
/*	    Scanner sc= new Scanner(System.in);
	    Map<Integer,List<Integer>> mp  = new HashMap<>();
	    for(int i=0;i<6;i++)
	    {
	    	mp.put(i,new ArrayList<Integer>());
	    }
	    int p[][] = new int[7][2];
	    for(int i=0;i<7;i++)
	    {
	    	String str = sc.next();
	    	String a[] = str.split(",");

	    	p[i][0] = Integer.parseInt(a[0]);
	    	p[i][1] = Integer.parseInt(a[1]);
	    }
	    for(int pair[] : p)
	    {
	    	mp.get(pair[0]).add(pair[1]);
	    	mp.get(pair[1]).add(pair[0]);

	    	/*mp.put(pair[0] , mp.get(pair[1]));
	    	mp.put(pair[1] , mp.get(pair[0]));*/

	    /*}
	    System.out.println(mp);*/
/*
	    Map<Integer,Integer>  mp = new HashMap<>();
	    mp.put(1,0);
	    mp.put(2,4);
	    System.out.println(mp);
	    mp.put(1,4);
	    System.out.println(mp);

*/
/*	    HashSet<Integer>mp =new HashSet<>();
	    mp.add(2);
	    mp.add(5);
	    mp.add(3);
	    mp.add(9); 
	    mp.add(7);
	    mp.add(8);
	    System.out.println(mp);
	    System.out.println(mp.remove(2));
	    System.out.println(mp);
	    Deque<Integer> q = new LinkedList<>();
	    q.add(2);
	    q.add(5);
	    q.add(3);
	    q.add(9); 
	    q.add(7);
	    q.add(8);
	   System.out.println(q);
	   System.out.println(q.removeFirst());
	   q.push(15);
	   System.out.println(q);
	   System.out.println(q.removeLast());
	   System.out.println(q);
*/
	   TreeSet<Integer> ts = new TreeSet<>();
	   ts.add(10);
	   ts.add(2);
	   ts.add(1);
	   ts.add(45);
	   ts.add(4);
	   ts.add(28);
	   System.out.println(ts.higher(4));
	   System.out.println(ts.lower(10));
	   System.out.println(ts);
	   System.out.println(ts.tailSet(3));

	}
	
}