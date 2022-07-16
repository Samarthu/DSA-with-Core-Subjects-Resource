
import java.util.regex.Pattern;
import java.util.*;

class anargam{
	static boolean isAnar(String a,String b)
	{
		int al[] = new int[256];
		boolean isAnargram = true;
		for (char c : a.toCharArray()) {
			int i =(int)c;
			System.out.println(i );
			al[i]++;
		}
		//System.out.println(Arrays.toString(al));

        for (char c : b.toCharArray()) {
			int i =(int)c;
			al[i]--;
		}

		for(int i=0;i<256;i++)
		{
			if(al[i]!=0)
			{
				isAnargram=false;
				break;
			}
		}

		if(!isAnargram)
		{
		  return false;
		}

		return true;
	}
	static String reverseword(String str)
	{
		Pattern pat =Pattern.compile("\\s");
		String[] tmp = pat.split(str);
		System.out.println(Arrays.toString(tmp));
		String res ="";
		for(int i=0;i<tmp.length;i++)
		{
			if(i==tmp.length-1)
			{
				res = tmp[i] + res;
			}
			else{
				res = " "+ tmp[i] + res;
			}
		}
		return res.trim();
	}
	public static void main(String[] args) {
		String str1 = "abcabsb";
		String str2 = "acbabsb";
		System.out.println(isAnar(str1,str2));

		String str = "I Love Programming";
		System.out.println(reverseword(str));
	}
}