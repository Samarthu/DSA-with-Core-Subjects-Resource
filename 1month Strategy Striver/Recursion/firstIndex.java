 // first index occurance of an array

 import java.util.*;
 class firstIndex{
 	public static int firstIndex_fun(int a[],int idx,int x)
 	{
 		if(idx == a.length)
 		{
 			return -1;
 		}
 		if(a[idx] == x)
 		{
 			return idx;
 		}
 		else{
 			return firstIndex_fun(a,idx+1,x);
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
     	int i_ans = firstIndex_fun(a,0,x);
     	System.out.println(i_ans);
     } 
 }
