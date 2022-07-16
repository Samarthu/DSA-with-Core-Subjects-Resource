/// Graph maxfuns 

import java.util.*;
class maxFunds{

    static ArrayList<Integer> dfs(ArrayList<Integer> temp,int node,Map<Integer,ArrayList<Integer>> graph,boolean visited[])
    {
    	temp.add(node);
    	visited[node] = true;
    	for(int neighbour : graph.get(node))
    	{
    		if(!visited[neighbour])
    		{
    			temp = dfs(temp,neighbour,graph,visited);
    		}
    	}
    	return temp;
    }

	static int maxfund(int arr[],int n, int pairs[][],int p)
	{
		Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
		for(int i=1;i<=n;i++)
		{
			graph.put(i,new ArrayList<>());
		}
		for(int pair[]:pairs)
		{
			graph.get(pair[0]).add(pair[1]);
			graph.get(pair[1]).add(pair[0]);

			graph.put(pair[0], graph.get(pair[0]));
			graph.put(pair[1], graph.get(pair[1]));
		}

		boolean visited[] = new boolean[n+1];
		ArrayList<ArrayList<Integer>> components = new ArrayList<>();
		for(int v=1;v<=n;v++)
		{
			if(graph.get(v).size() > 0 && !visited[v])
			{
				ArrayList<Integer> temp = new ArrayList<>();
				components.add(dfs(temp,v,graph,visited));
			}
			else if(graph.get(v).size()==0){
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(v);
				components.add(temp);
			}
		}

		int totalFunds=0;

		for(ArrayList<Integer>  component : components)
		{
			int total=0;
			for(Integer i : component)
			{
				total+= arr[i-1];
			}
			totalFunds = Math.max(totalFunds,total);
		}
		return totalFunds;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		int p=sc.nextInt();
		int pairs[][]=new int[p][2];
		for(int i=0;i<p;i++)
		{
			pairs[i][0]=sc.nextInt();
			pairs[i][1]=sc.nextInt();
		}
		int ans= maxfund(arr,n,pairs,p);
		System.out.println("The maxfunds are :" + ans);
	}
	
}