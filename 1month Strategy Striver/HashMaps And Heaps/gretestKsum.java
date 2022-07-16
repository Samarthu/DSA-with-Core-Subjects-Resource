// Gretest k element in array and take sum of it
// time complexity is O(n) and space is O(k )
import java.util.*;
class gretestKsum{
	static int takingGretestKSum(int a[],int n ,int k)
	{
		int sum = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i=0; i<k;i++ ) {
			pq.add(a[i]);
		}
		for(int i=k;i<n;i++)
		{
			if(a[i] > pq.peek())
			{
				pq.poll();
				pq.add(a[i]);
			}	
		}
		System.out.println(pq);
		while(pq.size() > 0)
		{
			sum += pq.poll();
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i=0;i<n ;i++ ) {
			a[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		int ans = takingGretestKSum(a,n,k);
		System.out.println(ans);
	}
}