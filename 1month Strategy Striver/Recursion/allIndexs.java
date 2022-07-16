 /// All index occurances of an element 
 import java.util.*;
 class allIndexs{
 	public static int[] allIndex_fun(int a[],int idx,int x ,int fst)
 	{
 		if(idx == a.length)
 		{
 			return new int[fst];
 		}
 		if(a[idx] == x)
 		{
 			int aiia[] = allIndex_fun(a,idx+1,x,fst+1);
 			aiia[fst] = idx;
 			return aiia; 
 		}    
 		else{
 		   return allIndex_fun(a,idx+1,x,fst);
 		}
 	}
 	public static void main(String[] args) {
 		Scanner sc= new Scanner(System.in);
     	int n = sc.nextInt();
     	int a[] = new int[n];
     	for(int i=0;i<n;i++)
     	{
     		a[i] = sc.nextInt();
     	}
     	int x = sc.nextInt();
     	int fst = 0;
     	int[] i_ans = allIndex_fun(a,0,x,fst);
     	System.out.println(Arrays.toString(i_ans));
 	}
 }