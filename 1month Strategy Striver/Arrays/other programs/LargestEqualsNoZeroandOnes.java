 // Largest count of equal number of 0's and 1's
 import java.util.*;
 class LargestEqualsNoZeroandOnes{
 	public static int findCountOfZerosandOnes(int a[],int n)
 	{
 		int sum = 0;
 		int start=0;
 		int end = -1;
 		int max_indx=0;
 		Map<Integer,Integer>  mp = new HashMap<>();
 		for(int i=0;i<n;i++)a[i]=a[i]==0?-1:1;
 		for(int i=0;i<n;i++)
 		{
 			sum+=a[i];
 			if(sum==0)
 			{
 				max_indx=i+1;
 				end=i;
 			}
 			if(mp.containsKey(sum)){
 				if(max_indx < i - mp.get(sum))
 				{
 				   max_indx= i-mp.get(sum);
 				   end = i;
 				}
 			}
 			else{
 				mp.put(sum,i);
 			}
 		}
        System.out.println(mp );
 		for(int i=0;i<n;i++) a[i]=a[i]==-1?0:1;
 		int en = end - max_indx +1;	
 		System.out.println( (end==-1? " no equal 1 and 0's found" : en + " "+end));
 		return max_indx;
 	}
 	// Other n2 apporach
 	public static int findCountOfZerosandOnes1(int a[], int n)
 	{
 		int sum=0;
 		int start=0;
 		int end=0;
 		int max_size=-1;
 		for(int i=0;i<n-1;i++)
 		{
 			sum = (a[i]==0)?-1:1;
 			for(int j=i+1;j<n;j++)
 			{
 				if(a[j] == 0)
 				{
 					sum+= -1;
 				}else{
 					sum+= 1;
 				}

 				if(sum==0 && max_size < j - i + 1)
 				{
 					max_size  =  j-i+1;
 					start = i;
 				}
 			}
 		} 
 		end = start + max_size - 1;
 		System.out.println(( max_size==-1 ? "No subarray Found" :start + " "+ end));
 		return max_size;
 	}
 	public static void main(String[] args) {
 		Scanner sc = new Scanner(System.in);
 		int n = sc.nextInt();
 		int a[] = new int[n];
 		for(int i=0;i<n;i++)
 		{
 			a[i] = sc.nextInt();
 		}
 		int ans = findCountOfZerosandOnes(a,n);
 		//int ans = findCountOfZerosandOnes1(a,n);
 		System.out.println(ans);
 	}
 }