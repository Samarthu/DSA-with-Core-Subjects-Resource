import java.util.*;

class soduku
{
     static int N=9;

    static boolean sodukufu(int grid[][],int row,int col)
    {
    	if(row==N-1 && col == N)
    	{
    		return true;
    	}

    	if(col == N)
    	{
    		row++;
    		col=0;
    	}
    	if(grid[row][col]!=0)
    	{
    		return  sodukufu(grid,row,col+1);
    	} 
    	for(int num=1;num<10;num++)
    	{
    		if(isSafe(grid,row,col,num))
    		{
    			grid[row][col] = num;

    			if(sodukufu(grid,row,col+1))
    			{
    				return true;
    			}
                grid[row][col] = 0; 	
    		}
    	}
    	return false;

    }
  static boolean isSafe(int grid[][], int row,int col,int n)
	{
        // row checking here...
		for(int i=0;i<=8;i++)
		{
			if(grid[row][i]==n)
				return false;
		}
        /// column checking here...
		for(int i=0;i<=8;i++)
		{
			if(grid[i][col]==n)
				return false;
		}

        /// 3 X 3 matrix check 
		int strRow = row - row % 3;
		int strCol = col - col % 3;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(grid[i+strRow][j+strCol] == n)
				{
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int grid[][] = new int[9][9];

		System.out.println(sodukufu(grid,0,0)+" so we can implement soduku");

		/*System.out.println(Arrays.deepToString(grid));*/
		 for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                  if(grid[i][j] == 1)
                  {

                  }
                 System.out.print(grid[i][j]+" ");
            }
             System.out.println();
        }
	}
	
}

/*/Back-end complete function Template for Java


Optimized Code 

class Solution
{
    //Function to find a solved Sudoku. 
    public static boolean SolveSudoku(int[][] board)  
    { 
        int row = -1; 
        int col = -1; 
        boolean isEmpty = true; 
        for (int i = 0; i < 9; i++) 
        { 
            for (int j = 0; j < 9; j++)  
            { 
                if (board[i][j] == 0)  
                { 
                    row = i; 
                    col = j; 
                      
                    //we still have some remaining missing values in Sudoku.
                    isEmpty = false;  
                    break; 
                } 
            } 
            if (!isEmpty) 
            { 
                break; 
            } 
        } 
      
        // no empty space left 
        if (isEmpty)  
        { 
            return true; 
        } 
      
        //else for each-row backtrack 
        for (int num = 1; num <= 9; num++) 
        { 
            if (isSafe(board, row, col, num)) 
            { 
                board[row][col] = num; 
                if (SolveSudoku(board))  
                { 
                    return true; 
                }  
                else
                { 
                    //replacing it.
                    board[row][col] = 0; 
                } 
            } 
        } 
        return false; 
    }
    
    
    public static boolean isSafe(int[][] board,int row, int col, int num)  
    { 
        //row has the unique numbers(row-clash).
        for (int d = 0; d < board.length; d++)  
        { 
            //if the number we are trying to place is already present 
            //in that row, we return false. 
            if (board[row][d] == num)  
            { 
                return false; 
            } 
        } 
          
        //column has the unique numbers (column-clash).
        for (int r = 0; r < board.length; r++) 
        { 
            //if the number we are trying to place is already present 
            //in that column, we return false.
            if (board[r][col] == num) 
            { 
                return false; 
            } 
        } 
      
        //corresponding square has unique number (box-clash).
        int sqrt = (int) Math.sqrt(board.length); 
        int boxRowStart = row - row % sqrt; 
        int boxColStart = col - col % sqrt; 
      
        for (int r = boxRowStart; 
                 r < boxRowStart + sqrt; r++)  
        { 
            for (int d = boxColStart;  
                     d < boxColStart + sqrt; d++)  
            { 
                if (board[r][d] == num)  
                { 
                    return false; 
                } 
            } 
        } 
      
        // if there is no clash, it's safe.
        return true; 
    } 
    
    //Function to print grids of the Sudoku.
    static void printGrid(int grid[][])
    {
        for (int r = 0; r < 9; r++) 
        { 
            for (int d = 0; d < 9; d++) 
            { 
                System.out.print(grid[r][d]); 
                System.out.print(" "); 
            } 
           
        } 
    }
    
}*/
/// Another Optimized
/*
class Solution {
    int M=0, N=0;
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        M = board.length;
        N = board[0].length;
        solveSudoku(board, 0, 0);
    }
    
    private boolean solveSudoku(char[][] board, int startRow, int startColumn) {
        boolean colFlag = true;
        
        for (int row=startRow; row<M; row++) {
            int col = 0;
            if(colFlag) {
                col = startColumn;
                colFlag = false;
            }
            for (; col<N; col++) {
                if(board[row][col] == '.') {
                    //Try solution 1 - 9 
                   for (char ch = '1'; ch <= '9' ; ch++) {
                       if(canPlace(board, ch, row, col)) {
                           board[row][col] = ch;
                           if(solveSudoku(board, row, col+1)) return true; 
                           else {
                               board[row][col] = '.';
                           }
                       }
                    }
                    //if we cannot place 1 to 9, this mean curent solution is not feasible
                    return false;
                }
                
            }
        }
        return true;
    }
    
    private boolean canPlace(char[][] board, char ch, int row, int col) {
        
        //find box possition
        int boxR = row / 3 * 3;
        int boxC = col / 3 *3;
        
        for(int i=0; i<9; i++) {
            if(board[row][i] == ch) return false; //check in row
            if(board[i][col] == ch) return false; //check in column
            if(board[boxR + (i/3)][boxC + (i%3)] == ch) return false; //check in box
        }
        
        return true;    
    }*/