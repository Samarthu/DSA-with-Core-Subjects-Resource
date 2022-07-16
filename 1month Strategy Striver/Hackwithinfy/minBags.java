 //  minimum bags
import java.util.*;
class minBags{
	public static int get_MinBags(int a[],int n,int cap)
	{
		int cnt = 1;
		int sum = a[0];
		for (int i = 1;i<n;i++ ) {
			if(sum + a[i] > cap)
			{
				cnt++;
				sum = a[i];
			}
			else{
				sum+=a[i];
			}
		}
		return cnt;
	}
	public static void BalacingFactor(String str)
	{
		Map<Character,Integer> mp = new HashMap<>();
		for(int i =0;i<str.length();i++)
		{
			char ch = str.charAt(i);
			if(mp.containsKey(ch))
			{
				mp.put(ch,mp.get(ch)+1);
			}
			else{
				mp.put(ch,1);
			}
		}
		boolean flg = true;
		for(char k : mp.keySet())
		{
			if(mp.get(k) %2 != 0)
			{
				flg = false;
			}
		}
		if(flg)
		{
			System.out.println("pair is possible");
		}
		else{
		    System.out.println("pair is not possible");	
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i=0;i<n ;i++ ) {
			a[i] = sc.nextInt();
		}
		int cap = sc.nextInt();
		int ans = get_MinBags(a,n,cap);
		System.out.println(ans);
	    String str = sc.next();
	    BalacingFactor(str);
	}
}