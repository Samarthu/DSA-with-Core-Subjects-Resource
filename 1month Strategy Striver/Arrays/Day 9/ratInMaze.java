// rat in Maze
import java.util.*;

class ratInMaze{
	static boolean isSafe(int arr[][],int x,int y,int n)
	{
		if(x<n && y<n && arr[x][y] == 1) return true;
		return false;
	}
	static boolean ratintMze_fun(int arr[][],int x,int y,int ratarr[][],int n )
	{
		if(x==n-1 && y==n-1)
		{
			ratarr[x][y]=1;
			return true;

		}
		if(isSafe(arr,x,y,n))
		{
			ratarr[x][y]=1;
			if(ratintMze_fun(arr,x+1,y,ratarr,n))
				return true;
			if(ratintMze_fun(arr,x,y+1,ratarr,n))
				return true;

			ratarr[x][y]=0; // this line for backTrack
			return false; 
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("ENter the size of array :");
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				arr[i][j] =sc.nextInt();
			}
		}
		int ratarr[][]=new int[n][n];
		ratintMze_fun(arr,0,0,ratarr,n);
		System.out.println(Arrays.deepToString(ratarr));
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
			    System.out.print(ratarr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}

// Gfg Solution
/*/ Back-end complete function Template for Java

class Solution {
    public static int[][] visited = new int[5][5];
    public static ArrayList<String> result = new ArrayList<String>();

    public static void path(int[][] m, int x, int y, String dir, int n) {
        if (x == n - 1 && y == n - 1) {
            result.add(dir);
            return;
        }

        if (m[x][y] == 0 || visited[x][y] == 1) {
            return;
        }

        visited[x][y] = 1;
        if (x > 0) {
            path(m, x - 1, y, dir + 'U', n);
        }
        if (y > 0) {
            path(m, x, y - 1, dir + 'L', n);
        }
        if (x < n - 1) {
            path(m, x + 1, y, dir + 'D', n);
        }
        if (y < n - 1) {
            path(m, x, y + 1, dir + 'R', n);
        }
        visited[x][y] = 0;
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        try {
            Arrays.fill(visited, 0);
        } catch (ArrayStoreException ex) {
        }
        result.clear();
        if (m[0][0] == 0 || m[n - 1][n - 1] == 0) {
            return result;
        }

        path(m, 0, 0, "", n);
        Collections.sort(result);
        return result;
    }
}
*/