// LRU cache
import java.util.*;
class LRUcache{
	 private Deque<Integer> dq;
	 private HashSet<Integer> mp = new HashSet<>();
	 int cache_size;
	 LRUcache(int capacity)
	 {
	 	dq=new LinkedList<>();
	 	mp=new HashSet<>();
	 	cache_size = capacity;
	 }
	 public int lru_algo(int arr[], int len)
	 {
	 	int pf=0,ph=0;// Page fautlt  and Page Hit 
	 	for(int i=0;i<len;i++)
	 	{
	 		if(!mp.contains(arr[i]))
	 		{
	 			if(dq.size() == cache_size){
	 				int last = dq.removeLast();
	 				mp.remove(last);
	 			}
	 		}
	 		else{ 			
	 		    if(dq.contains(arr[i]))ph++; pf-=1;
	 			dq.remove(arr[i]);
	 		}
	 		if(!dq.contains(arr[i])) pf++;
	 		 dq.push(arr[i]);
	 		 mp.add(arr[i]);
	 	}
	 	System.out.println("Page Hits are:"+ ph);
	 	return pf;

	 }


	 public void refer(int page)
	 {
	 	if(!mp.contains(page))
	 	{
	 		if(dq.size() == cache_size)
	 		{
	 			int last = dq.removeLast();
	 			mp.remove(last);
	 		}
	 	}
	 	else{
	 		  dq.remove(page);
	 		}

	 		dq.push(page);
	 		mp.add(page);	 			 		
	 }
	 public void display()
	 {
	 	Iterator<Integer> it = dq.iterator();
	 	while(it.hasNext())
	 	{
	 		System.out.print(it.next() +" ");
	 	}
	 }
	/*static boolean isFull(ArrayDeque<Integer> dq,int m)
	{
		if(dq.size() == m) return true;
	  return false;
	}
*/	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		LRUcache  obj = new LRUcache(m);
		int n =sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
			//obj.refer(arr[i]);
		}
	    
		int PageFaults = obj.lru_algo(arr,n);
		System.out.println("Page Faults are :"+ PageFaults);
		obj.display();
	}
}