/// Largest rectagle of 1's in matrix

import java.util.*;
class largestRect1inmat{
	static int maxHistrogram(int a[],int n)
	{
		int rs[] = new int[n];
		Stack<Integer>  st = new Stack<>();
		rs[n-1] = n;
		st.push(n-1);
		for(int i = n-2;i>=0;i--)
		{
			while(!st.isEmpty() && a[i] < a[st.peek()])
			{
				st.pop();
			}
			if(st.size() == 0)
			{
				rs[i] = n;
			}
			else{
				rs[i] = st.peek();
			}
			st.push(i);
		}
		int ls[] = new int[n];
		ls[0] = -1;
		st.push(0);
		for(int i=1;i<n;i++)
		{
			while(!st.empty() && a[i] < a[st.peek()])
			{
				st.pop();
			}
			if(st.size() == 0)
			{
				rs[i] = -1;
			}
			else rs[i] = st.peek();
			st.push(i);
		}
		int maxArea = 0;
		for(int i = 0; i< n;i++)
		{
			int len = rs[i] - ls[i] - 1;
			int area = len * a[i];
			maxArea = area > maxArea ? area : maxArea; 
		}
		return maxArea;
	}
	static int getMaxRectangleOf1s(int a[][],int n,int m)
	{
		int tp[] = a[0];
	    int max = maxHistrogram(a[0],m);
	    for(int i = 1;i < n ;i++)
	    {
	    	for(int j= 1;j < m;j++)
	    	{
	    		if(a[i][j] == 1)
	    		{
	    			tp[j] +=1;
	    		} else tp[j] = 0;
	    	}
	    	int nmax =maxHistrogram(tp, m);
	    	if(nmax > max)  max = nmax;
	    }
	    return max;
	}
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
		 int m = sc.nextInt();
		 int a[][] = new int[n][m];
		 for (int i =0;i<n ;i++ ) {
		 	for(int j=0;j<m;j++)
		 	{
		 		a[i][j] = sc.nextInt();
		 	}
		 }
		 int ans = getMaxRectangleOf1s(a,n,m);
		 System.out.println(ans);
	}
}