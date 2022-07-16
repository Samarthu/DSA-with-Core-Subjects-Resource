/// maximum element in Array using recursion 
import java.util.*;
class maxel{
	static int maxel_fun(int a[],int idx)
	{
		if(idx == a.length-1)
		{
			return a[idx];
		}
		int pans = maxel_fun(a,idx+1);
	    return pans < a[idx] ? a[idx] : pans;  // and for the minimum element in the array u simply
	    // change the condition here is that "pans > a[idx] ?  a[idx] : pans;"
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
     	int n = sc.nextInt();
     	int a[] = new int[n];
     	for(int i=0;i<n;i++)
     	{
     		a[i] = sc.nextInt();
     	}
     	int max_el = maxel_fun(a,0);
     	System.out.println(max_el);
	}
}