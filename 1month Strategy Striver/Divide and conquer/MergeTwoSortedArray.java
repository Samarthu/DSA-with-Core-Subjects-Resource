// Merge two Sorted Arrray 
// We have to solve this in O(1)
import java.util.*;
class MergeTwoSortedArray{ 
  static int[] merge(int a[],int b[],int n,int n1)
   {
   	  int i=0;
   	  int j=0;
   	  int k=0;
   	  int ans[] = new int[n+n1];
   	  while(i <n && j < n1)
   	  {
   	  	if(a[i] < b[j])
   	  	{
   	  		ans[k] = a[i];
   	  		i++;
   	  		k++;
   	  	}
   	  	else{
   	  		ans[k]=b[j];
   	  		j++;
   	  		k++;
   	  	}
   	  }
   	  while(i<n)
   	  {
   	  	  ans[k] = a[i];
   	  		i++;
   	  		k++;
   	  }
   	  while(j<n1)
   	  {
   	  	  ans[k] = b[j];
   	  		j++;
   	  		k++;
   	  }
      System.out.println(Arrays.toString(ans));
   	  return ans;
   }

   public static void main(String[] args) {
   		Scanner sc= new Scanner(System.in);
   		int n1 = sc.nextInt();
   		int a[] = new int[n1];
   		for(int i=0;i<n1;i++)
   		{
   			a[i] = sc.nextInt();
   		}
   		int n2 = sc.nextInt();
   		int a2[] = new int[n2];
   		for(int i=0;i<n2;i++)
   		{
   			a2[i] = sc.nextInt();
   		}
   		int ans[] = merge(a,a2,n1,n2);
   		System.out.println(Arrays.toString(ans));
   	}	
}