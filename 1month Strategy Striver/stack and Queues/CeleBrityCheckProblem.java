// celebrity Selection Problem using Stack
// simple Linear Approach...O(N) time Complexity
import java.util.*;
class CeleBrityCheckProblem{
	static int celebrityCheck_fn(int a[][],int n)
	{
		Stack<Integer> st = new Stack<>();

		for(int i =0 ;i<n ;i++)
		{
			st.push(i);
		}	
		while(st.size() >= 2)
		{
			int i = st.pop();
			int j = st.pop();

			if(a[i][j] == 1)	
			{
				st.push(j);
			}
			else{
				st.push(i);
			}
		}
		int pc = st.pop();
		for(int i = 0;i<n ;i++)
		{
			if(i!=pc)
			{
				if(a[pc][i] == 1 || a[i][pc] == 0)
				{
					return -1;
				}
			}
		}
		return pc;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =  sc.nextInt();
		int a[][] = new int[n][n];
		for(int i = 0; i<n ;i++)
		{
			for (int j=0;j< n ;j++ ) {
				a[i][j] = sc.nextInt();
			}
		}
		int ans = celebrityCheck_fn(a,n);
		System.out.println(ans);
	}
}