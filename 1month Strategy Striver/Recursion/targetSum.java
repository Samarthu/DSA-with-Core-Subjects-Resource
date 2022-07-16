// Target sum.....
import java.util.*;
class targetSum{
static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
 public static void targetSum_fun(int a[],int idx, String set,int sos , int tar)
  {
  	if(a.length == idx)
  	{
  		if(sos == tar)
  		{
  			System.out.println(set+".");
  			return;
  		}
  	   return;		
  	}
  	targetSum_fun(a,idx+1,set+a[idx],sos+a[idx],tar);
  	targetSum_fun(a,idx+1,set,sos,tar);
  }
  // Target Sum All subsets using DP
  static boolean notinres(ArrayList<Integer> in)
  {
  	   for(ArrayList<Integer> a : res){
  	   	  if(a.equals(in))  return false;
  	   }
  	   return true;
  }
  static ArrayList<Integer> inv_List = new ArrayList<>();
   public static void tSS_DP(int a[] ,int idx, int tar,ArrayList<Integer> set,int dp[][])
   {
   	   if(tar < 0) {
   	   	inv_List.add(tar);
   	   	return;
   	   }
   	  if(idx == a.length)
   	  {
   	  	if(tar == 0)
   	  	{
   	  		if(notinres(set))
   	  		{
             res.add(new ArrayList<>(set));
   	  		} 
   	  		inv_List.add(tar);
   	  		return; 
   	  	}
   	  	return;
   	  }
   	  if(dp[idx][tar] != -1)
   	  {
   	    tSS_DP(a,idx+1,tar,set,dp);
   	  }
   	  dp[idx][tar] = tar;
   	  set.add(a[idx]);
   	  tSS_DP(a,idx+1,tar - a[idx],set,dp);
   	  set.remove(set.size()-1);
   	  tSS_DP(a,idx+1,tar,set,dp);
   } 
   static void print(int dp[][])
   {
   	  for(int a[] : dp)
   	  {
   	  	 for(int i : a)
   	  	 { 
   	  	 	  if( i != -1)
   	  	 	  {
   	  	 	      System.out.print( i +" ");	
   	  	 	  }
   	  	 	  else{
   	  	 	  	System.out.print( "_ ");
   	  	 	  }
   	  	 }
   	  	 System.out.println();
   	  }
   }
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   int n = sc.nextInt();
	   int arr[] = new int[n];
	   for(int i=0;i<n;i++)
	   {
	   	arr[i] = sc.nextInt();
	   }	
	   int tar = sc.nextInt();
	   //targetSum_fun(arr,0,"",0,tar);
	   int dp[][] = new int[arr.length+1][tar+1];
	   for(int a1[]:dp) Arrays.fill(a1,-1);
	   tSS_DP(arr,0,tar,new ArrayList<>(),dp);
	   print(dp);
	   System.out.println(inv_List);
	   System.out.println(res);
	}	
}