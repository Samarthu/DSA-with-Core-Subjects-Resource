// Minimum number of operation is required to make an array palindrome

//Expected tc: O(n)
import java.util.*;
class MinnoOps{
	static int MinnoOps_fun(int a[],int n)
	{
		int ans = 0;
		for(int i=0,j=n-1;i<=j;)
		{
			if(a[i]==a[j])
			{
				i++;
				j--;
			}
			else if(a[i] > a[j])
			{
				j--;
				a[j] = a[j] + a[j+1];
				ans++;
			}
			else if(a[i]<a[j])
			{
				i++;
				a[i]+=a[i-1];
				ans++;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		int minOps = MinnoOps_fun(arr,n);
		System.out.println(minOps);
	}
}