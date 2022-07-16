import java.util.*;
class cntMinandEqElement{
  static int[] getAllElement_optimized(int a[],int a1[],int n)
  {
  	int max = 0;
  	for(int el : a )
  	{
  	    max = max < el ? el : max; 
  	}
  	for (int el : a1 ) {
  		 max = max < el ? el : max;
  	}
  	int farr[] = new int[max +1 ];
  	int psarr[] = new int[max +1 ];
  	for (int i =0;i< n;i++){
  		farr[a1[i]]++;
  	}
  	psarr[0] = farr[0];
  	for (int i=1 ;i<=max ;i++ ) {
  		psarr[i] = psarr[i-1] + farr[i];
  	}
  	for(int i=0;i<n;i++)
  	{
  		int k = a[i];
  		a[i] = psarr[k];
  	}
  	System.out.println(Arrays.toString(psarr));
  	System.out.println(Arrays.toString(farr));
  	return a;
  }
  // this is done using the binary Search and time complexity is n * logm 
  // so obtimized  solution is given above.. 
	static int[] getAllElement(int a[],int a1[],int n)
	{
	  Arrays.sort(a1);
	  for(int i = 0;i<n;i++)
	  {
	  	int key = a[i];
	  	int cnt = getTheCnt(key,a1,n);
	  	a[i] = cnt;
	  }
	  return a;
	}
	static int getTheCnt(int key ,int a[],int n)
	{
		int lo =  0;
		int hi = n-1;
		int cnt = 0;
		while(lo<=hi)
		{
			int mid = (lo + hi)/2;

			if(a[mid]<= key)
			{
				cnt+= mid-lo +1;
				lo= mid +1;
			}
			else
			{
				hi = mid - 1;
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  int n = sc.nextInt();
	  int a[] = new int[n];
	  int a1[] = new int[n];
	  for (int i=0;i<n ;i++ ) {
	  		a[i] = sc.nextInt();
	  		a1[i] = sc.nextInt();
	  	}	
	  	//int ans[] = getAllElement(a,a1,n);
	  	int ans2[] = getAllElement_optimized(a,a1,n);
	  	//System.out.println(Arrays.toString(ans));
	  	System.out.println(Arrays.toString(ans2));
	}
}