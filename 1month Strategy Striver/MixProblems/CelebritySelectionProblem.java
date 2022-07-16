// Celebrity Selection Problem..
import java.util.*;
class CelebritySelectionProblem{
	// Simple n2 TC and N SC approach
	static int celebrityExistCheck(int a[][],int n)
	{
		System.out.println(Arrays.deepToString(a));
		int in[] = new int[n];
		int out[] = new int[n];
		for (int i=0;i<n;i++ ) {
		  for (int j=0;j<n ;j++ ) {
		  	  if(a[i][j]==1)
		  	  {
		  	  	in[j]+=1;
		  	  	out[i]+=1;
		  	  }
		  }
		}
		System.out.println(Arrays.toString(in) +" "+Arrays.toString(out));
		for (int i=0;i<n;i++) {
			if(in[i]==n-1 && out[i]==0)
			{
				return i;
			}
		}
		
		return -1;
	}

	// Optimized Approach

	static int celebrityExistCheckOptimized(int a[][],int n)
	{
		int c=0;
		for (int i=1;i<n ;i++ ) {
			if(a[c][i]==1)
			{
				c=i;
			}
		}
		System.out.println("--"+c);
		for (int i=0;i<n ;i++ ) {
			if((i!=c  && (a[c][i] == 1 || a[i][c] == 0)))
			 {
			 	return -1;
			 }
		}
		return c;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int a[][] = new int[n][n];
		for (int i=0;i<n;i++ ) {
			for (int j=0;j<n ;j++ ) {
			    a[i][j] = sc.nextInt();
			}
		}

		int ans = celebrityExistCheck(a,n);
		System.out.println(ans);
		int ans2 = celebrityExistCheckOptimized(a,n);
		System.out.println(ans2);

	}
}