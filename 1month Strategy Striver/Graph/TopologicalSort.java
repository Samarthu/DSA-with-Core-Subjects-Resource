// Topological sort  using DfS

import java.util.*;

class Edge{
	int v;
	int nbr;
	Edge(int v, int nbr)
	{
		this.v =v;
		this.nbr = nbr;
	}
}
class TopologicalSort{

	static void topologicalsort_fun(ArrayList<Edge>[] graph, int src, Stack<Integer>  st, boolean[] visited)
	{
		visited[src] = true;
		for(Edge e:graph[src])
		{
			if(visited[e.nbr] == false)
			{
				topologicalsort_fun(graph,e.nbr,st,visited);
			}
		 }
		st.push(src);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		ArrayList<Edge>[] graph = new ArrayList[v];
		for(int i=0;i<v;i++)
		{
			graph[i] = new ArrayList<>();
		}

		int e = sc.nextInt();
		for(int i=0;i<e;i++)
		{
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			graph[v1].add(new Edge(v1,v2));
		}
		Stack<Integer> st = new Stack<>();
		boolean[] visited = new boolean[v];
		for(int i=0;i<v;i++)
		{
			if(visited[i] == false)
			{
				topologicalsort_fun(graph,i,st,visited);
			}
		}

		while(st.size() > 0)
		{
			System.out.print(st.pop()+"  ");
		}

	}
}