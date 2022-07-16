/// NQueen Optimized Solution by using bits..
import java.util.*;
class NQueenBits{
	static void solve(int[][]grid ,int x,int n,int col0, int rdig,int ldig, String psf)
	{
		if(x==n)
		{
			print(grid);
			System.out.println(psf+".");
			return;
		}
		for (int col=0;col<n;col++) {
	     	if(((col0&(1<<col))==0)&&((ldig&(1<<x+col))== 0) && ((rdig&(1<<x-col+n-1))== 0))  
			{
				grid[x][col]=1;
				col0^=(1<<col);
				ldig^=(1<<(x+col));
				rdig^=(1<<x-col+n-1);
				solve(grid,x+1,n,col0,rdig,ldig,psf + x+"-"+col+",");
				grid[x][col]=0;
				col0^=(1<<col);
				ldig^=(1<<(x+col));
				rdig^=(1<<x-col+n-1);
			}
		}
	}

	static void print(int a[][]){
	  for (int i=0;i<a.length ;i++ ) {
	   	for (int j=0;j<a[0].length ;j++ ) {
	   		System.out.print(a[i][j]+" ");
	   	}
	   	System.out.println();
	   } 
	}
	static boolean isSafe(int grid[][],int r,int c,int n)
	{
		int i,j;
		// left diagonal
		for(i=r-1,j=c-1;i>=0 && j>=0;i--,j--) if(grid[i][j] == 1) return false;
		// right diagonal
		for(i=r-1,j=c+1; i>=0 && j<n;i--,j++) if(grid[i][j] == 1) return false;
		// vertical check....
		for(i=r-1,j=c;i>=0;i--)if(grid[i][j] == 1) return false;	
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int grid[][] = new int[n][n];
		int col0 = 0;
		int ldig = 0;
		int rdig = 0;
		solve(grid,0,n,col0,rdig,ldig,"");
  }
}