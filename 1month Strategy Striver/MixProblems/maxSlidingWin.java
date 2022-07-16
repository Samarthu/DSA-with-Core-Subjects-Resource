/// Maximum sliding window 

import java.util.*;
import java.io.*;
class maxSlidingWin{
	
	static void slidingWindowmax(int a[],int k)
	{

		// Next greater Element
		int nge[] =new int[a.length];
		Stack<Integer> st =new Stack<>();
		nge[a.length-1] =a.length;
		st.push(a.length-1);
		for(int i=a.length-2;i>=0;i--)
		{
			while(st.size() > 0 && a[i]>=a[st.peek()] )
			{
				st.pop();
			}
			if(st.size()==0){
				nge[i]=a.length;
			}
			else
			{
				nge[i]=st.peek();
			}
			st.push(i);
		}

		System.out.println(Arrays.toString(nge));

		int j=0;
		for(int i=0;i<=a.length-k;i++)
		{
			if(j<i)j=i;
			while(nge[j]<i+k)
			{
				j=nge[j];
			}
			System.out.print(a[j]+" ");
		}
}
	public static void main(String[] args)throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int arr[] =new int[n];
		//String s=br.readLine();
		//String[] s1 =s.split(" ");
		//int i=0;
		//while(n--!=0)
		for(int i=0;i<n;i++)
		{
			arr[i]=Integer.parseInt(br.readLine());
		}
		int k=Integer.parseInt(br.readLine());
		System.out.println(Arrays.toString(arr));
		slidingWindowmax(arr,k);
	}
}