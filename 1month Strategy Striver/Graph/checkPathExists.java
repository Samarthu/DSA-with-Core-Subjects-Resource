//check wheather the path is exists or not between vertices...
import java.util.*;
class checkPathExists{
	static class Edge{
		int s;
		int d;
		int wt;
     	Edge(int s, int d)
		{
		   this.s=s;
                   this.d=d;
		}
		Edge(int s,int d ,int w)
		{
			this.s=s;
			this.d=d;
			this.wt=w;
		}
	}
	static int tt=0;
	static void printGraph(ArrayList<Edge>[] graph)
	{
		for(ArrayList<Edge> g: graph)
		{
			for(Edge e:g)
			{
				System.out.println(e.s+"->"+e.d+"->"+e.wt);
			}
		}
	}
	static void hamilthonCycle(ArrayList<Edge>[] graph,int src,int dest,HashSet<Integer> visited,String psf,int osrc)
	{
		if(visited.size() == graph.length-1)
		{
			//System.out.println(tt++);
			System.out.print(psf);
			boolean isHamil = false;
			for(Edge e : graph[src])
			{
				if(e.d == osrc){
				   isHamil = true;
				 }
			}
			if(isHamil==true){
				System.out.println("@");
			}
			else{
       			System.out.println(".");
			}
		}
                visited.add(src);
		for(Edge e:graph[src])
		{
			if(visited.contains(e.d)== false)
			{
				hamilthonCycle(graph,e.d,dest,visited,psf+e.d,osrc);
			}
		}
		visited.remove(src);
	}
	static void printAllPath(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited,String psf){
		if(src == dest) 
		{
		  System.out.println(psf);
		  return;
		}
		visited[src] = true;
		for(Edge e:graph[src])
		{
			if(visited[e.d] == false)
			{
				printAllPath(graph,e.d,dest,visited,psf+e.d);
			}
		}
		visited[src] = false;
	}
	static boolean checkPath(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited)
	{
		if(src == dest) return true;
		visited[src] = true;
		for(Edge e:graph[src])
		{
			if(visited[e.d] == false)
			{
				boolean hasPath = checkPath(graph,e.d,dest,visited);
				if(hasPath == true)
				{
					return true;
				}
			}
		}
	  return false;
	}
	static class pair{
		int v;
     	        String psf;
     	pair(int v, String psf)
     	{
     		this.v=v;
     		this.psf = psf;
     	}
	}
	public static void bfs(ArrayList<Edge>graph[],int src,int dest,boolean[] visited){
	    Queue<Integer> q = new LinkedList<>();
 	    int parent[] = new int[graph.length];
	    parent[src]=-1;
	    q.add(src);
            visited[src]=true;
	    while(q.size() > 0)
	    {
	    	int curr = q.poll();
	    	if(curr == dest) continue;
	    	for(Edge e : graph[curr])
	    	{
	    		if(!visited[e.d]){
	    			visited[e.d]=true;
	    			q.add(e.d);
	    			parent[e.d] = curr;
	    		}
	    	}
	    }

	    int cur = dest;
	    int distance = 0;
	    System.out.println(Arrays.toString(parent));
	    while(parent[cur]!=-1)
	    {
	    	System.out.print(cur+"-->");
	    	cur=parent[cur];
	    	distance++;
	    }
	    System.out.println(cur);
	    System.out.println("\n"+ "distance is: "+ distance);	

	}

	static boolean isCyclicGraph_Fun(ArrayList<Edge>[] graph, int src,boolean[] visited)
	{
		// r m* w a*
		ArrayDeque<pair> q = new ArrayDeque<>();
		q.add(new pair(src,src+""));
		while(q.size()>0)
		{
			pair curr = q.removeFirst();

			if(visited[curr.v]==true) return true;
			visited[curr.v]=true;
			for(Edge e : graph[curr.v])
			{
				if(!visited[e.d])q.add(new pair(e.d ,curr.psf+e.d));
			}
		}
		return false;
	}

	static void iscycle_check(ArrayList<Edge>[] graph , int v,boolean visited[]) {
	for(int i=0;i<v;i++)
         {
         	if(visited[i]== false)
         	{
         	  boolean iscyclic = isCyclicGraph_Fun(graph,i,visited);
         	    if(iscyclic){
         			System.out.println("It is cyclic graph");
         			return;
         		}    		
         	}
         	 
         }
         System.out.println("It is Not cyclic graph");
	}


// This is plain dfs;
	public static void dfs(int node,ArrayList<Edge>[]graph , boolean[] visited)
	{
		visited[node] = true;
		for(Edge e : graph[node])
		{
			if(!visited[e.d])
			{
				dfs(e.d,graph,visited);
			}
		}
	}



   public static int minWireRequired(ArrayList<Edge>[] graph ,int vertices,int edges ,boolean[] visited)
   {
   	    if(edges < vertices-1)
   	    {
   	    	return -1;
   	    }
   	    int component = 0;

   	    for(int i=0;i<vertices;i++)
   	    {
   	    	if(visited[i]== false)
   	    	{
   	    		component++;
   	    		dfs(i,graph,visited);
   	    	}
   	    }
   	    return  component-1;
   }
public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v = sc.nextInt();
		ArrayList<Edge>[] graph = new ArrayList[v];
		for(int i=0;i<v;i++) graph[i] = new ArrayList<>();
		int e = sc.nextInt();
		for(int i=0;i<e;i++)
		{
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int wt = sc.nextInt();
			graph[v1].add(new Edge(v1,v2,wt));
			graph[v2].add(new Edge(v2,v1,wt));
		}
		int sou  = sc.nextInt();
		int dest = sc.nextInt();
		boolean visited[] = new boolean[v];
		//boolean pathExists = checkPath(graph,sou,dest,visited);
		//System.out.println(pathExists);
		//printAllPath(graph,sou,dest,visited,sou+"");
		//printGraph(graph);
		//<BFS FUNCTION >///
		 //bfs(graph,sou,dest,visited);
		hamilthonCycle(graph,sou,dest,new HashSet<>(),sou+"",sou);

		 //// Here is the code to check wheather the graph is cyclic or not
      
                iscycle_check(graph,v,visited);
         
         // Question is make connnection here  How many edges are required;

		/*int wire = minWireRequired(graph,v,e,visited);
		System.out.println(wire);  
*/
        // Normal BFS
        /*ArrayDeque<pair> q = new ArrayDeque<>();
        q.add(new pair(sou,sou+""));
        while(q.size() > 0)
        {
        	// r m* w a*
        	pair el = q.removeFirst();
        	visited[el.v] =true;
        	System.out.println(el.v +"@"+el.psf);
        	for( Edge em : graph[el.v])
        	{
        		if(visited[em.d] == false)
        		{
        			q.add(new pair(em.d, el.psf+em.d));
        		}
        	}
        }*/
	}
}