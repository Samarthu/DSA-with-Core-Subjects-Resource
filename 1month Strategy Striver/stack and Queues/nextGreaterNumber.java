// nextGreaterNumber

import java.util.*;
class nextGreaterNumber{
	static int[] NGM(int[] v)
	{
		Stack<Integer> st = new Stack<>();
		//ArrayList<Integer> res=new ArrayList<>(v.size());
		int res[] = new int[v.length];
		for(int i=0;i<v.length;i++)
		{
			while(!st.isEmpty() && v[i]>=v[st.peek()])
			{
				//res.get(st.peek()).add(i);
				//res.set(st.peek(),i);
				res[st.peek()] = i;
				st.pop();
			}
			st.push(i);
		} 

		while(!st.isEmpty())
		{
			res[st.peek()] = -1;
			//res.set(st.peek(),-1);
			st.pop();
		}
		return res;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(); 
		int v[] = new int[n];
	    int j=0;
	    while(n--!=0)
		{
			v[j]=sc.nextInt();
			j++;
		}
		System.out.println(Arrays.toString(v));
		int res[]=NGM(v); 
		System.out.println(Arrays.toString(res));
		for(int i=0;i<res.length;i++)
		{
			int p = res[i]==-1?-1:v[res[i]];
		  System.out.println(v[i]+" "+ p);
		  //System.out.println();

		}		
	}
}