// Iterative DfS we dp it by using stack and bfs
import java.util.*;
class Edge{
  int v;
  int nbr;
  int wt;
  Edge(int v, int nbr,int wt)
  {
  	this.v = v;
  	this.nbr = nbr;
  	this.wt = wt;
  }
}
class pair{
	int v;
	String psf;
	int wt;

	pair(int v,String psf,int wt)
	{
		this.v = v;
		this.psf = psf;
		this.wt = wt;
	}
}
class IterativeDfs{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int v = sc.nextInt();
		ArrayList<Edge>[]  graph = new ArrayList[v];
		for(int i=0;i<v;i++){
			graph[i] = new ArrayList<>();
		}
		int e = sc.nextInt();
		for (int i=0;i<e ;i++ ) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int wt = sc.nextInt();
			graph[v1].add(new Edge(v1,v2,wt));
			graph[v2].add(new Edge(v2,v1,wt));
		}
		int src = sc.nextInt();
		int dest = sc.nextInt();
		boolean vis[] = new boolean[v];
		Stack<pair> st = new Stack<>();
		st.push(new pair(src, src +"" ,0));
		while(st.size() > 0 )
		{
			pair rem = st.pop();
			if(vis[rem.v]==true)
			{
				continue;
			}
			vis[rem.v] = true;
			System.out.println(rem.v+"-> via..$" + rem.psf +"->"+rem.wt);
		    //this step is optional 
		    if(rem.v  == dest) break;
		    ....///
			for(Edge e1:graph[rem.v])
			{
                  if(vis[e1.nbr] == false)
                  {
                     	st.push(new pair(e1.nbr , rem.psf + e1.nbr , rem.wt + e1.wt));
                  }
			}
		}
	}
}n