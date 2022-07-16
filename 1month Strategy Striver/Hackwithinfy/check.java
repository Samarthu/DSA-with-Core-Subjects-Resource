// same string or not

import java.util.*;
class check{
	static int[] getReplacedArray(int a[],int n)
	{
		for(int i=0;i<n;i++)
		{
			if(i > 0 && i+1 != n)
			{
			  a[i] = a[i-1] > a[i+1] ? a[i-1] : a[i+1];	
			}
			else if(i+1 == n)
			{
				a[i] = a[i-1] > a[i] ?a[i-1] : a[i];

			}else{
				a[i] = a[i+1] > a[i] ? a[i+1] : a[i];
			}
		}
		return a;
	}
	static void DoubleElement(int ans[])
	{
		for(int i=0;i<ans.length;i++)
		{
			ans[i] = ans[i] * 2;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*String str = sc.next();
		String str2 = sc.next();
		boolean flag = false;
		HashSet<Character> ht = new HashSet<>();
		if(str.length()!= str2.length())
		{
			flag = true;
		}
		else{
			for (int i=0;i<str.length();i++ ) {
     			ht.add(str.charAt(i));
	    	}
	    	for (int i=0;i<str2.length() ;i++ ) {
	    		if(!ht.contains(str2.charAt(i))) flag= true;
	    	}
		}
		
		if(flag) System.out.println("no");
		else System.out.println("yes");*/

		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i =0;i<n ;i++ ) {
			a[i] = sc.nextInt();
		}
		int ans[] = getReplacedArray(a,n);
		DoubleElement(ans);
		System.out.println(Arrays.toString(ans));
	}
}