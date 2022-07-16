 // Book Allocation Google interview Question
 // in this Question We have to minimize the maximum pages read by student 
///in this we going to use binary search rather we can able to solve it by using simple recursion 
// bt we have to reduce the time complexity of code to exponential to lograthmic 
import java.util.*;
class bookAllocation{
	static int maxOf(int a[]){
		int max=0;
		for(int p: a)
		{
			if(p > max) max = p;
		}
		return max;
	}
	static int sumOf(int a[])
	{
		int sum=0;
		for(int p:a)
		{
			sum+=p;
		}
		return sum;
	}
	static int minMaxPages(int pages[],int student, int n)
	{
		int min = maxOf(pages);
		int max = sumOf(pages);
		//System.out.println(min +" "+max);
		int res=0;
		while(min<=max)
		{
			int mid = min+ (max-min) /2 ;
		    if(isFeasible(pages,student,mid))
		    {
		    	res=mid;
		    	max = mid-1;
		    }
		    else{
		    	min = mid+1;
		    }
		}
		return res;
	}
	static boolean isFeasible(int a[],int student, int res)
	{
		int st=1,sum=0;
		for(int i=0;i<a.length;i++)
		{
			if(sum + a[i] > res)
			{
				st++;
				sum =a[i];
			}
			else{
				sum+=a[i];
			}
		}
	  // boolean an = st<=student ? true : false;
	   return st<=student;
	}
	public static void main(String[] args) {
	  Scanner sc= new Scanner(System.in);
	  int n=sc.nextInt();
	  int pages[] = new int[n];
	  for(int i=0;i<n;i++)
	  {
	  	pages[i] = sc.nextInt();
	  }
	  int student = sc.nextInt();
	  int ans = minMaxPages(pages,student,n);
	  System.out.println(ans);
	}
}