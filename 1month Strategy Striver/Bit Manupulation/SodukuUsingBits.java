// Soduku solver by Using bits
import java.util.*;
class SodukuUsingBits{
	static final int N = 9;
	static boolean solve(int grid[][],int r,int c,int rows[],int cols[],int gr[][]){
		if(r==N-1 && c == N)
		{
			return true;
		}
		if(c == N)
		{
			r++;
			c=0;
		}
		if(grid[r][c]!=0)
		{
			return solve(grid,r,c+1,rows,cols,gr);
		}
		for (int num=1;num<10 ;num++){
			if(((rows[r]&(1<<num)) == 0)&& ((cols[c]&(1<<num)) == 0) && 
			 ((gr[r/3][c/3]&(1<<num)) == 0))
			{
				grid[r][c] = num;
				rows[r]^= (1<<num);
				cols[c]^=(1<<num);
				gr[r/3][c/3]^=(1<<num);
				if(solve(grid,r,c+1,rows,cols,gr)== true) return true;
				grid[r][c] = 0;
				rows[r]^= (1<<num);
				cols[c]^=(1<<num);
				gr[r/3][c/3]^=(1<<num);
			}
		}
		return false;
	}
	static boolean isSafe(int grid[][],int r,int c,int n){

		int rCount = r / 3 * 3;
		int cCount = c / 3 *3;

		for(int i=0;i<=8;i++)
		{
			if(grid[r][i]==n) return false;
			if(grid[i][c]==n) return false;
			if(grid[rCount + (i / 3)][cCount + (i%3)]==n) return false;
		}
		return true;
	}
	static void print(int a[][])
	{
		 for (int i=0;i<a.length ;i++ ) {
	   	for (int j=0;j<a[0].length ;j++ ) {
	   		System.out.print(a[i][j]+" ");
	   	}
	   	System.out.println();
	   } 
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int grid[][] = new int[9][9]; 
		int rows[] = new int[9];
		int cols[] = new int[9];
		int gr[][] = new int[3][3];

		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++)
			{
			   int num = sc.nextInt();
			   grid[i][j]=num;
			   rows[i]|= (1<<num);
			   cols[j]|=(1<<num);
			   gr[i/3][j/3] |=(1<<num);

			}
		}
		boolean isSodukuSolve = solve(grid,0,0,rows,cols,gr);
		System.out.println(isSodukuSolve);
		print(grid);
	}
}