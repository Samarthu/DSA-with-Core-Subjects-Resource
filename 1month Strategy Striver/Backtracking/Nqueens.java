///N Queens

import java.util.*;
class Nqueens{
	static void solve(int[][] a,int row,int n, int cols, int ndia , int rdia ,String asf){
		if(row == a.length)
		{
			print(a);
			System.out.println(asf);
			return;
		}
		for(int col=0;col<n;col++){
			if(((cols&(1<<col)) == 0) && ((ndia&(1<<(row+col)))==0) && ((rdia&(1<<(row-col+a.length-1)))==0))
			{
				a[row][col]=1;
				cols^=(1<<col);
				ndia^=(1<<(row+col));
				rdia^=(1<<(row-col+a.length-1));
				solve(a,row+1,n,cols,ndia,rdia,asf+row+"-"+col+",");
				a[row][col]=0;
				cols^=(1<<col);
				ndia^=(1<<(row+col));
				rdia^=(1<<(row-col+a.length-1));
			}
		}
		
	}
	static void print(int a[][])
	{
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[0].length;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int a[][] = new int[n][n];
		int cols=0;
		int ndia=0;
		int rdia=0;
	    solve(a,0,n,cols,ndia,rdia,"");
	    
	}
}