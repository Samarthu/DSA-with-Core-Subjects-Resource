 //// stock buy and sell if two transactions are allowed you just need to find max //profit
 import java.util.*;
 class stockBuyandSaleTwoTrans{
 	  public static int get_MaxProfit(int a[],int n)
 	  {
 	  	 int maxPr = 0;
 	  	 int mi = a[0];
 	  	 int dpmptt[] = new int[n];
 	  	 for (int i = 1;i< n ;i++ ) {
 	          if(mi > a[i])
 	          {
 	          	mi = a[i];
 	          }
 	          maxPr = a[i] - mi;
 	          dpmptt[i] = maxPr > dpmptt[i-1] ? maxPr : dpmptt[i-1];
 	  	 }
 	  	 int maxbt =0;
 	  	 int maxbta = a[n-1];
 	  	 int dpr[] = new int[n];
 	  	 for (int i=n-2;i>=0 ;i-- ) {
 	  	 	if(a[i] > maxbta)
 	  	 	{
 	  	 		maxbta = a[i];
 	  	 	}
 	  	 	 maxbt = maxbta - a[i];
 	  	 	 dpr[i] =  dpr[i+1] < maxbt ? maxbt : dpr[i+1];
 	  	 }
 	  	 int ans = 0;
 	  	 for (int i =0;i<n ;i++ ) {
 	  	 	if(dpmptt[i] + dpr[i] > ans)
 	  	 	{
 	  	 		ans = dpmptt[i] + dpr[i];
 	  	 	}
 	  	 }
 	  	 return ans;
 	  }
      public static void main(String[] args) {
       	 Scanner sc = new Scanner(System.in);
       	 int n = sc.nextInt();
       	 int a[] = new int[n];
       	 for (int i = 0;i<n ;i++ ) {
       	 	a[i] = sc.nextInt();
       	 }
       	 int ans = get_MaxProfit(a,n);
       	 System.out.println(ans);
       } 
 }