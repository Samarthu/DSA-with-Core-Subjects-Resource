/// merge intervals using stack
import java.util.*;
class pair implements Comparable<pair>
{
	int st;
	int en;
	pair(int s,int e)
	{
		this.st =s;
		this.en = e;
	}
	public int compareTo(pair o)
	{
		if(this.st != o.st)
		{
			return this.st - o.st;
		}else{
			return this.en - o.en;
		}
	}
}
class mergeIntervalStk{
	static int cnt=0;
	public static List<List<Integer>> mergeInterval_Fun(int a[][],int n,int m)
	{
		pair[] data = new pair[n];
		for (int i=0;i<n ;i++ ) {
			data[i] = new pair(a[i][0] ,a[i][1]);
		}
		Arrays.sort(data);
		Stack<pair> st = new Stack<>();
		st.push(data[0]);
		for (int i=1;i<n;i++) {
			pair top = st.peek();
			if(top.en >= data[i].st)
			{ 
				cnt++;
				top.en = Math.max(top.en,data[i].en);
			}
			else{
				st.push(data[i]);
			}
		}
		List<List<Integer>> res = new ArrayList<>();
		while(st.size() > 0)
		{
			pair el = st.pop();
			res.add(Arrays.asList(el.st,el.en));
		}
		return res;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a[][] = new int[n][m];
		for (int i=0;i<n;i++ ) {
			for (int j=0;j<m ;j++ ) {
				a[i][j] = sc.nextInt();
			}
		}
		List<List<Integer>> ans = mergeInterval_Fun(a,n,m);
		System.out.println(ans);
		System.out.println(cnt);
	}
}