/// Merge K sorted Lists
import java.util.*;
class Node{
	int val;
	Node next;
	Node(){}
	Node(int val){
		this.val = val;
		this.next = null;
	}
}
class MergeKsortedLists{
	Node head;
	static Node getMergedList(Node[] li)
	{
		if(li == null || li.length == 0 ) return null;
		PriorityQueue<Node> pq = new PriorityQueue<>(li.length,new Comparator<Node>(){
			public int compare(Node n1,Node n2)
			{
				if(n1.val < n2.val)
				{
					return -1;
				}
				else if(n1.val == n2.val)return 0;
				else return 1;
			}
		});
		Node tmp = new Node();
	    Node dummy = tmp;
	    for (Node n : li) {
	    	if(n!=null)
	    	{
	    		pq.add(n);
	    	}
	    }
	    while(!pq.isEmpty()) {
	    	dummy.next = pq.poll();
	    	dummy = dummy.next;
	    	if(dummy.next != null)
	    	{
	    		pq.add(dummy.next);
	    	}
	    }
	    return tmp.next;
	}
	static Node addLast(ArrayList<Integer> list)
	{
		//System.out.println(list);
		Node nh = new Node(list.get(0));
		Node h = nh;
		for(int i=1;i<list.size();i++)
		{
			//System.out.print(list.get(i)+" ");
			h.next = new Node(list.get(i));
			h = h.next;
		}
		return nh;
	}
	static Node[] makesLinks(ArrayList<ArrayList<Integer>> li)
	{
		Node a[] = new Node[li.size()];
		int i = 0;
		for(ArrayList<Integer> l : li)
		{
			a[i++] = addLast(l);
		}
		return a;
	}
	static void print(Node h)
	{
		while(h!=null)
		{
			System.out.print(h.val +"->");
			h = h.next;
		}
		System.out.println("NULL");
	}
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int  n = sc.nextInt();
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		while(n--!= 0)
		{
		    int s = sc.nextInt();
			ArrayList<Integer> tmp = new ArrayList<>(s);
			for (int i = 0;i<s ;i++ ) {
				tmp.add(sc.nextInt());
			}
			list.add(new ArrayList<>(tmp));
		}
		//System.out.println(list);
		Node liArr[] = makesLinks(list);

		for (int i = 0 ;i<liArr.length;i++ ) {
			//System.out.println(liArr[i].val);
			print(liArr[i]);
		}
		Node ans = getMergedList(liArr);
		print(ans);
	}
}