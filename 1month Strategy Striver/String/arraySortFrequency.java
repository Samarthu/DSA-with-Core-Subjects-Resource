//Sort the Array According to frequency DescOrder 
import java.util.*;
class arraySortFrequency{
	static int x=0;
	static void sort(int a[])
	{
		a=sort1(a);
		//System.out.println(Arrays.toString(a));
		int b[][]=new int[a.length][2];
		b[x][0]=a[0];
		b[x][1]=1;
		for(int i=1;i<a.length;i++)
		{
			if(a[i]==a[i-1])
			{
				b[x][1]=b[x][1]+1;
			}
			else
			{
				x++;
				b[x][0]=a[i];
				b[x][1]=1;
			}
		}
		x++;
		System.out.println(Arrays.deepToString(b));
		 b=sort2(b);
		 //System.out.println(Arrays.deepToString(b));       
       for (int i=0;i<x ;i++ ) {
      	System.out.println(b[i][0]+" " +b[i][1]);      	
       }
		
	}
	static int[][] sort2(int a1[][])
	{
		int c[]=new int[2];
		for(int i=0;i<x;i++)
		{
			for(int j=i;j<x;j++)
			{
				if(a1[i][1] < a1[j][1])
				{
					c=a1[i];
					a1[i]=a1[j];
					a1[j]=c;
				}
			}
		} 
		//System.out.println(Arrays.deepToString(a1));
		return a1;
	}
	static int[] sort1(int a[])
	{
		for(int i=0;i<a.length;i++)
		{
			for(int j=i;j<a.length;j++)
			{
				if(a[i] > a[j])
				{
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		return a;
	}
	public static void main(String[] args) {
		int arr[] ={4,3,1,6,3,6,4,4};
		sort(arr);
	}
}