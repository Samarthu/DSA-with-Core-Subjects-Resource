// comparable and comparator interface 
import java.util.*;
class Node {
		int mark;
		int roll;
		String name;
		Node(int r,int m, String n)
		{
			this.mark = m;
			this.roll = r;
			this.name = n;
		}
		
	}
	class compartorFun implements Comparator<Node>
	{
		public int compare(Node n1,Node n2)
		{
			if(n1.mark < n2.mark){
				return -1;
			}
			else if(n1.mark > n2.mark){
				return 1;
			}else{
				return n1.roll - n2.roll;
			}
		}
	}

class ExComparatorAndComparable{
	
	static class nodu implements Comparable<nodu>
	{
		int m;
		int r;
		nodu(int r,int m)
		{
			this.m = m;
			this.r = r;
		}
		public int compareTo(nodu nu)
		{
			return nu.m - this.m;
		}
	}
	static void print1(ArrayList<nodu> data)
	{
		for(int i=0;i<data.size();i++)
		{
			System.out.println(data.get(i).r +"  " + data.get(i).m);
		}
	}
	static void print(ArrayList<Node> data)
	{
		for(int i=0;i<data.size();i++)
		{
			System.out.println(data.get(i).roll +"  " + data.get(i).mark +"  " + data.get(i).name);
		}
	}
	static void prin(nodu data)
	{
		System.out.println(data.r +"  " + data.m);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Node> data = new ArrayList<>();
		ArrayList<nodu> dat = new ArrayList<>();
		for (int i= 0 ;i < n ; i++) {
			int r = sc.nextInt();
			int m = sc.nextInt();
			String n1 = sc.next();
			data.add(new Node(r,m,n1));
			dat.add(new nodu(r,m));
		}
		System.out.println("----");
		print(data);	    
		System.out.println("----");
		compartorFun ne = new compartorFun();
		Collections.sort(data,ne);
		print(data);
	    System.out.println("----");
		System.out.println("----");	
		print1(dat);
		PriorityQueue<nodu> pq = new PriorityQueue<>();
		System.out.println("----");
		for(int i=0;i<n;i++)
        {
        	pq.add(dat.get(i));
        }
        Iterator<nodu> it = pq.iterator();
        while(it.hasNext())
        {
        	System.out.print(it.next().m +" ");
        }
        System.out.println("----");
        while(pq.size() > 0)
        {
        	nodu val = pq.poll();
        	prin(val);
        }
	}
}