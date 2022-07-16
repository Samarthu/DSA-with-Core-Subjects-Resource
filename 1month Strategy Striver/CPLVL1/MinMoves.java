import java.util.*;
class MinMoves{
	
	static int minmove(int n)
	{
		int min = 0;
		if(n == 0 || n == 1) return n;
		while(true)
		{
			if(n % 2 == 0)
			{
			min++;
			n = (int) n >> 1;
			}
		  else  return min + 1 + minmove(n-1);
		}
		
	}
    public static void main(String[] args) {
    	 Scanner sc = new Scanner(System.in);
    	 int n = sc.nextInt();
    	 for (int i = 0;i<n ;i++ ) {
    	     System.out.println(minmove(sc.nextInt()));    	 	
    	 }
    }
}