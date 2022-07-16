// Longest commnon prefix;

import java.util.*;

class LCPrefix{
	static int LCP(List<String> li)
	{
		int mi=Integer.MAX_VALUE;
		String v=li.get(0);
		for(int i=1;i<li.size();i++)
		{
			int a=0,k=0,j=0;
			while(j<v.length() && k < li.get(i).length())
			{
				if(v.charAt(j) == li.get(i).charAt(k)) a++;
				else break;
				k++;
				j++;
			}
			mi=Math.min(mi,a);
		}
		return mi;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
		   list.add(sc.next());
		}
		int ans=LCP(list);
		System.out.println("Length is:"+ans+" "+list.get(0).substring(0,ans));
	}
}