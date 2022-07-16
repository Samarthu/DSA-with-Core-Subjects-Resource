// count all anargams present int the string
import java.util.*;
class cntAnagarms{
	static boolean isAnar(Map<Character,Integer> mp1,Map<Character,Integer> mp2)
	{
		for ( char ch: mp2.keySet()) {
			if(mp1.getOrDefault(ch,0) != mp2.get(ch))
			{
				return false;
			}
		}
		return true;
	}
	static int cntAnagarms_fn(String mstr , String rstr)
	{
		int ans = 0;
		String idxs ="";
		Map<Character,Integer> rmp = new HashMap<>();
		Map<Character,Integer> mmp = new HashMap<>();
		for(int i = 0 ; i< rstr.length();i++)
		{
			char ch = rstr.charAt(i);
			rmp.put(ch,rmp.getOrDefault(ch,0)+1);
		}
		for(int i = 0 ; i< rstr.length();i++)
		{
			char ch = mstr.charAt(i);
			mmp.put(ch,mmp.getOrDefault(ch,0)+1);
		}
		int i = rstr.length();
		while(i < mstr.length())
		{
			if(isAnar(rmp,mmp))
			{
				ans += 1;
				idxs+= i - rstr.length();
			}
			char nch = mstr.charAt(i);
			mmp.put(nch,mmp.getOrDefault(nch,0) + 1);
			char ch = mstr.charAt(i - rstr.length());
			if(mmp.get(ch) == 1)
			{
				mmp.remove(ch);
			}
			else{
				mmp.put(ch,mmp.get(ch) - 1);
			}
			i++;
		}
		if(isAnar(rmp,mmp))
			{
				ans += 1;
				idxs+= i - rstr.length();
			}
		System.out.println(idxs);
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String str2= sc.next();
		int noofanargam = cntAnagarms_fn(str,str2);
		System.out.println(noofanargam);
	}
}