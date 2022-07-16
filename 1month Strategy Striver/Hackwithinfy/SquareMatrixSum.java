import java.util.*;

class SquareMatrixSum{
	static int getAns(int a[][],int n,int m)
	{
		int sum = 0;
		if(n!=m)
		{
		   if(n > m)
		   {
		   	  for(int i=0;i<n;i++)
		   	  {
		   	  	a[i][m] = 1;
		   	  }
		   }
		   else{
		   	  for (int i=0;i<m ; i++) {
		   	  	a[n][i] = 1;
		   	  }
		   }
		}
		Map<Integer,Integer> mp = new HashMap<>();
		for(int i=0,j=0;i<a.length;i++,j++)
		{
			if(mp.containsKey(a[i][j]))
			{
				mp.put(a[i][j],mp.get(a[i][j]) + 1);
			}else{
				mp.put(a[i][j],0);
			}
		}

		for(int i = 0 ;i< a.length;i++)
		{
			for (int j=0;j<a[0].length ;j++ ) {
				if(i!=j)
				{
				   if(mp.containsKey(a[i][j]))
				   {
				      mp.put(a[i][j],mp.get(a[i][j]) + 1); 	   
				   }
				}
			}
		}
		for(int k :mp.keySet())
		{
			if(mp.get(k) % 2 == 1)
			{
				sum+= k;
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		 Scanner sc= new Scanner(System.in);
		 int n = sc.nextInt();
		 int m = sc.nextInt();
		 int l = n > m ? n : m;
		 int a[][] = new int[l][l];
		 for (int i=0;i<n;i++ ) {
		    for (int j=0;j<m ; j++) {
		    	a[i][j] = sc.nextInt();
		    }
		 }
		 int ans = getAns(a,n,m);
		 System.out.print(ans);
	}
}