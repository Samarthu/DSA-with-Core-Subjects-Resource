// Bipertite graph
import java.util.*;
class Bipertite_graph{
	static public class Edge{
		int v;
		int nbr;
	    Edge(int v,int nbr)
	    {
	    	this.v = v;
	    	this.nbr = nbr;
	    }
	}

	static class pair{
		int v;
		int level;
		String psf;
		pair(int v,String psf,int level)
		{
			this.v=v;
			this.psf = psf;
			this.level=level;
		}
	}
	static boolean checkBipertiteGraph(ArrayList<Edge>[] graph, int src,int[]vis)
	{
		Queue<pair> q = new LinkedList<>();
	    q.add(new pair(src,src+"",0));
	    while(q.size()> 0)
	    {
	    	pair rem = q.poll();
	    	if(vis[rem.v] !=-1)
	    	{
	    		if(rem.level!= vis[rem.v])
	    		{
	    			return false;
	    		}
	    	}
	    	else{
	    		vis[rem.v] = rem.level;
	    	}
	    	System.out.println(rem.v +"  via    " + rem.psf+" @" + rem.level);
         	for(Edge e : graph[rem.v])
	    	{
	    		if(vis[e.nbr]==-1)
	    		{
	    			q.add(new pair(e.nbr , rem.psf + e.nbr , rem.level + 1));
	    		}
	    	}

        }
	  return true;
	} 

	public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  int v=sc.nextInt();
	  ArrayList<Edge> graph[] = new ArrayList[v];
	  for(int i=0;i<v;i++)
	  {
	  	graph[i] = new ArrayList<>();
	  }
	  int e = sc.nextInt();
	  for(int i=0;i<e;i++){
	  	int v1 = sc.nextInt();
	  	int v2 = sc.nextInt();
	  	graph[v1].add(new Edge(v1,v2));
	  	graph[v2].add(new Edge(v2,v1));
	  }
	  
	  int vis[] = new int[v];
	  Arrays.fill(vis,-1);
	  for(int i=0;i<v;i++)
	  {
	  	if(vis[i]==-1)
	  	{
	  		boolean isBipertite = checkBipertiteGraph(graph,i,vis);
	  		if(isBipertite == false)
	  		{
	  			System.out.println(false);
	  			return;
	  		}
	  	} 	
	  }
	  System.out.println(true);
	}
}