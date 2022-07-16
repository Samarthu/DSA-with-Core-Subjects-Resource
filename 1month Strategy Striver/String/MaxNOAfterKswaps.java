 // maximum number after k swaps;
import java.util.*;
class MaxNOAfterKswaps{
	public static String swap(String str,int i, int j)
	{
		char ith = str.charAt(i);
		char jth =str.charAt(j);
		String start=str.substring(0,i);
		String mid = str.substring(i+1,j);
		String last = str.substring(j+1);
		return start+jth+mid+ith+last;
	}
	public static String max;
	public static void MaxNOAfterKswaps_fun(String str,int k)
	{
	    if(Integer.parseInt(str) > Integer.parseInt(max)){
		   max = str;	
		}
		if(k==0) return;
		for(int i=0;i<str.length()-1;i++)
		{
			for(int j=i+1;j<str.length();j++)
			{
				if(str.charAt(i) < str.charAt(j))
				{
					str=swap(str,i,j);
					MaxNOAfterKswaps_fun(str,k-1);
					str=swap(str,i,j);
				}
			}
		}

	}
	public static String swap1(String str, int i, int j)
	{
		char str1[] = str.toCharArray();
		char tmp = str1[i];
		str1[i]=str1[j];
		str1[j]=tmp;
		System.out.println(Arrays.toString(str1));
		return String.valueOf(str1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int k = sc.nextInt();
		//max = swap1(str,2,3);
		max=str;
		///System.out.println(max);
		MaxNOAfterKswaps_fun(str,k);
		System.out.println(max);
	}	
}