/// ASCII difference in String

import  java.util.*;
class AsciiDiff{
	static String getAsciiDiff(String str)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(str.charAt(0));
		for(int i=1;i<str.length();i++)
		{
			char curr = str.charAt(i);
			char prev = str.charAt(i-1);
			int diff = curr-prev;
			sb.append(diff);
			sb.append(curr);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String ans = getAsciiDiff(str);
		System.out.println(ans);
	}
}