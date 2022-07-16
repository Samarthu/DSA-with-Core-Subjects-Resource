/// Reverse a Queue using Recursion

import java.util.*;
class ReverseQueueUsingRec{

	static void reverse(Queue<Integer> q)
	{
	    if(!q.isEmpty())
		{
			int x = q.poll();
			reverse(q);
			q.add(x);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer>  q = new LinkedList<>();
		for(int i=0;i<n;i++)
		{
			q.add(sc.nextInt());
		}
		System.out.println(q);
		System.out.println(q.poll());
		reverse(q);
		System.out.println(q);
		System.out.println(q.poll());
	}
}