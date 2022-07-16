// Substring of String
import java.util.*;
class substringOfString{
	static ArrayList<String> getSubstring(String str)
	{
		ArrayList<String> ans = new ArrayList<>();
		for(int i = 0; i < str.length() ;i++)
		{
			for(int j= i;j<str.length();j++)
			{
				String s = str.substring(i,j+1);
				ans.add(s);
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		ArrayList<String> ans = getSubstring(str);
		System.out.println(ans);
	}
}