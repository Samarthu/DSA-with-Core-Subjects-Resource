import java.util.*;

class maxAtmwith{ 

	static int sumfun(int arr[])
	{
		int sumAdd=0;
		for(int i=0;i<arr.length;i++)
		{
			sumAdd+=arr[i];
		}
		return sumAdd;
	}
	static int sumfun(int arr[],int i,int j)
	{
		int sum=0;
		for(int p=i;p<=j;p++)
		{
			sum+=arr[p];
		}
		return sum;
	}
	static int minWithdraw(int arr[],int x)
	{
		int sum1 = sumfun(arr);
		int tar = sum1-x;
		int n = arr.length;
		if(x > sum1) return -1;
		int max_len=0,cur_len=0,cur_sum=0,i=0,j=1,ans=0;
		while(i<arr.length && j < arr.length)
		{
			cur_sum = sumfun(arr,i,j);
			if(cur_sum < tar)
			{
				j=j+1;
			}

			else if (cur_sum > tar)
			{
				i=i+1;
			}
			else {
				cur_len = j-i+1;
				max_len = Math.max(max_len,cur_len);
				j=j+1;
			}
		}

		if(max_len == 0)
		{
			if(n == sum1)
			{
				return n;
			}
			else{
				return -1;
			}
		}
     
     ans=n-max_len;
     return ans;  
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int arr[]= {1};
		System.out.println("Minimum withdraws are :" + minWithdraw(arr,x));
	}
}