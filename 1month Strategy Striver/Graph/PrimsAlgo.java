// prims algorithm
import java.util.*;
import java.util.*;
class Edge{
	int s;
	int nbr;
	int wt;
	Edge(){}
	Edge(int s, int nbr){ this.s = s; this.nbr = nbr;}
	Edge(int s, int nbr, int wt){
		this.s = s;
		this.nbr = nbr;
		this.wt = wt;
	}
}
class PrimsAlgo{
	static class pair implements Comparable<pair>
	{
		int v;
		int wt;
	    String psf;
	    pair(int v,int wt, String psf)
	    {
	    	this.v=v;
	        this.wt=wt;
	        this.psf=psf;
	    }
	    public int compareTo(pair o)
	    {
	    	return this.wt - o.wt;
	    }
	}
   static void prims(ArrayList<Edge>[] graph, int src,int wt,boolean[] visited )
   {
   	   PriorityQueue<pair> q = new PriorityQueue<>();
	   q.add(new pair(src,-1,src+""));
	   while(q.size() > 0){

	   	  // r m* w a*
	   	  pair rem=q.poll();
	   	  if(visited[rem.v] == true)
	   	  {
	   	  	continue;
	   	  }
	   	  visited[rem.v] =true;
	   	  if(rem.wt !=-1)
	   	  {
	   	    System.out.println("["+rem.v+ "  @"+rem.wt+ "  via  "+rem.psf+"]");	
	   	  }
	   	  for(Edge e : graph[rem.v])
	   	  {
	   	  	  if(visited[e.nbr] == false)
	   	  	  {
	   	  	     q.add(new pair(e.nbr,e.wt,e.nbr+""));
	   	  	  }
	   	  }
	   }
   }
	static void print(ArrayList<Edge>[] graph)
	{
		for(ArrayList<Edge> g: graph)
		{
			for(Edge e:g)
			{
				System.out.println(e.s+"->"+e.nbr+"->"+e.wt);
			}
		}
	} 
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int v = sc.nextInt();
		ArrayList<Edge> graph[] = new ArrayList[v];
		for(int i=0;i<v;i++){
			graph[i] = new ArrayList<>();
		}
		int e = sc.nextInt();
		for(int i=0;i<e;i++){
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			int wt=sc.nextInt();
			graph[v1].add(new Edge(v1,v2,wt));
			graph[v2].add(new Edge(v2,v1,wt));
		}
		boolean[] visited = new boolean[v];
		//print(graph);
		prims(graph,0,0,visited);		
	}

}

