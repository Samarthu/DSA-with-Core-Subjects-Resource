// check cycle in graph using DFS

import java.util.*;
class  checkCycleUsingDFS{
	static class Edge{
		int s;
		int d;
		int wt;
		Edge(int s,int d)
		{
			this.s = s;
			this.d = d;
		}
		Edge(int s,int d,int wt)
		{
			this.s = s;
			this.d = d;
			this.wt = wt;
		}
	}
	static boolean isCyclicGraph_Fun_undirected(int s,ArrayList<Edge>[] graph,boolean vis[],int par){
		vis[s] = true;
		Integer i;
		for(Edge e:graph[s])
		{
			i = e.d;
			if(!vis[e.d])
			{
				if(isCyclicGraph_Fun_undirected(e.d,graph,vis,s))
				{
					return true;
				}
			}
			else if(i!=par)
			{
				return true;
			}
		}
		return false;
	}
	// only for directed
	static boolean checkForCycle(int i,ArrayList<Edge>[] graph,boolean vis[], boolean[] revS)
	{ 
		if(revS[i]) return true;
		if(vis[i]) return false;
		vis[i] = true;
		revS[i] = true;
		for(Edge e :graph[i])
		{
			if(checkForCycle(e.d,graph,vis,revS))
			{
				return true;
			}
		}
		revS[i] = false;
		return false;
	}
	static void checkCycleDirectedUsingDfs(ArrayList<Edge>[] graph,boolean vis[],int v)
	{
		boolean revS[] = new boolean[v];
		boolean cycle = false;
		for (int i=0;i<v;i 			if(!vis[i])
			{
				cycle = checkForCycle(i,graph,vis,revS);
				if(cycle)
				{
					System.out.println("cycle Exits");
					return;
				}
			}
		}
		if(!cycle)
		{
			System.out.println("cycle is not exists");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		ArrayList<Edge>[] graph = new ArrayList[v];
		for(int  i=0;i<v;i++)
		{
			graph[i] = new ArrayList<>();
		}
		int e = sc.nextInt();
		for(int i=0;i<e;i++)
		{
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			graph[v1].add(new Edge(v1,v2));
			//graph[v2].add(new Edge(v2,v1));
		}
	 	boolean isCyclic=false;
		boolean vis[] = new boolean[v];
		// All this for Check for Cycle in Graph using Dfs in undirected
		/*for(int vr=0;vr<v ;v++){
			if(!vis[vr])
			{
			    isCyclic = isCyclicGraph_Fun_undirected(vr,graph,vis,-1);
				if(isCyclic)
				{
					System.out.println("cycle exits");
					return;
				}
			}
		}
		if(!isCyclic)
		{
			System.out.println("cycle is not exits");
		}*/
		checkCycleDirectedUsingDfs(graph,vis,v);
	}
}