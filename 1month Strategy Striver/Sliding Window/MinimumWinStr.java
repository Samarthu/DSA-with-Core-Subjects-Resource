// Minimum window substrings with all the element present inside  that window..
import java.util.*;
class MinimumWinStr{
	static int minimumWindowString_fn(String str)
	{
		int len = str.length();
		HashSet<Character> hs = new HashSet<>();
		for (int i=0;i<str.length() ;i++ ) {
			hs.add(str.charAt(i));
		}
		Map<Character,Integer> mp = new HashMap<>();
		int i=-1;
		int j=-1;
		while(true)
		{
			boolean fc = false;
			boolean sc = false;
			while(i < str.length() - 1 && mp.size() < hs.size())
			{
				i++;
				char ch = str.charAt(i);
				mp.put(ch,mp.getOrDefault(ch,0) + 1);
				fc = true;
			}
			while(j < i && mp.size() == hs.size())
			{
				int pslen = i - j;
				if(pslen < len) len = pslen;
				j++;
				char ch=str.charAt(j);
				if(mp.get(ch) == 1)
				{
					mp.remove(ch);
				}
				else{
					mp.put(ch,mp.get(ch) - 1);
				}
				sc = true;
			}
			if(sc  == false && fc == false)  break;
		}
		return len;
	}
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		String str = sc.next();
		int len = minimumWindowString_fn(str);
		System.out.println(len);
	}
}