 // Day 4 Longest SubString for non repeating  
import java.util.*;
class LongestSubstringNonRepeat{
	static int LongestSubstringNonRepeat_fun(String str){
		int n = str.length();
		int left=0,right=0,len=0;
		HashMap<Character,Integer> mpp = new HashMap<Character,Integer>();
		while(right<n){
			if(mpp.containsKey(str.charAt(right)))
				left=Math.max(mpp.get(str.charAt(right))+1, left);
			mpp.put(str.charAt(right),right);
			len = Math.max(len,right - left +1);
			right++;
		}
		return len;
	}
	public static void main(String[] args) {
	   String str = "abcabcdeacd";
	   int len = LongestSubstringNonRepeat_fun(str);
	   System.out.println(len);
	}
}

