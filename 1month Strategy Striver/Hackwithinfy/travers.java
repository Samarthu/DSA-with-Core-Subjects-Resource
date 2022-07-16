import java.util.*;
class travers{ 
	static int st = 0;
	static int getPath1(int i,int j,int n,int m)
	{
		if( i == n && j == m)
		{
			return 1;
		}
		int v=0,h=0;
	   if(j < m)
	   {
	   	 h = getPath1(i,j+1,n,m);
	   }
	   if(i < n)
	   {
	     v = getPath1(i+1,j,n,m);
	   }
	   return h+v;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int ans = getPath1(1,1,n,m);
		System.out.print(ans);
	}
}