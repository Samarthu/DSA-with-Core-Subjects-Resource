// rottem oranges 
import java.util.*;
class pair{
	int row;
	int col;
	pair(int r,int c)
	{
		this.row = r;
		this.col = c;
	}
}
class rotten_Orange{
   static int rotten_orange_fun(int a[][])
	{
		int n = a.length;
		int m = a[0].length;
		Queue<pair> q = new LinkedList<>();
		int fresh=0;
		for (int i=0;i<n ;i++){
	   	   for (int j=0;j<m ;j++){
	   	   	   if(a[i][j] == 2)
	   	   	   {
	   	   	   	  q.add(new pair(i,j));
	   	   	   }
	   	   	   else if(a[i][j] == 1 ){
	   	   	   	 fresh++;
	   	   	   }
	   	   }
	   	}
	   	if(fresh == 0)
	   	{
	   		return -1;
	   	}
	   	int level=-1;
	   	int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	   	while(q.size() > 0)
	   	{
	   		int size = q.size();
	   		level++;
	   		//System.out.println(Arrays.deepToString(a));
	   		while(size-- > 0)
	   		{
	   			pair rem = q.poll();
	   			for(int i=0;i<dir.length;i++)
	   			{
	   				int rdash = rem.row + dir[i][0];
	   				int cdash = rem.col + dir[i][1];
	   				if(rdash >= 0 && cdash >=0  && rdash < n &&  cdash < m && a[rdash][cdash] == 1)
	   				{
	   					q.add(new pair(rdash,cdash));
	   					a[rdash][cdash] = 0 ;
	   					fresh--;
	   				}
	   			}
	   		}
	   	}
	   	System.out.println(Arrays.deepToString(a));
	   	return fresh == 0 ? level:-1;
	}
	public static void main(String[] args) {
	   Scanner sc =  new Scanner(System.in);
	   int n = sc.nextInt();
	   int m = sc.nextInt();
	   int a[][]= new int[n][m];
	   for (int i=0;i<n ;i++ ) {
	   	   for (int j=0;j<m ;j++ ) {
	   	   	   a[i][j] = sc.nextInt();
	   	   }
	   	}	
	   	int ans = rotten_orange_fun(a);
	   	System.out.println(ans);
	}
}