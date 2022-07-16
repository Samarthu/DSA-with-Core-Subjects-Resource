// Connect N ropes with minimum cost 

import java.util.*;
class Nropes{

	static int minCostForConnectingRope(int[] costs,int ropesLength)
	{
		PriorityQueue<Integer> pq =new PriorityQueue<>();
		for(int i : costs){
			pq.add(i);
		}
		int ans=0;
		/*
		while(pq.size()>0)
		{
			System.out.print(pq.poll() +" ");
		}
		*/
		while(pq.size() > 1)
		{
			int v1 = pq.poll();
			int v2 = pq.poll();
			int sum= v1 + v2;
		    ans+= sum;
			pq.add(sum);
		}
		System.out.println(pq.peek());
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ropesLength = sc.nextInt();
		int costs[] = new int[ropesLength];
		for (int i=0;i<ropesLength ;i++ ) {
			costs[i]=sc.nextInt();
		}
		int mincost = minCostForConnectingRope(costs,ropesLength);
		System.out.println(mincost);
	}
}