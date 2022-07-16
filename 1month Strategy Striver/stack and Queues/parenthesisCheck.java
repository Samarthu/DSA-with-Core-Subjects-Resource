// Balanced parenthesis check 

import java.util.*;
class parenthesisCheck{
	static int cnt = 0;
	static Stack<Character> st = new Stack<>();
	static Map<Character,Integer> mp = new HashMap<>(){{put('{',-1);
	put('[',-2);put('(',-3);put('}',1);put(']',2);put(')',3);}};

	static boolean check(String str){
		//char ar[] = str.toCharArray();
		for(char c:str.toCharArray())
		{
		  if(mp.get(c) < 0)
		  {
		  	st.push(c);
		  }
		  else{
		  	 if(st.isEmpty()) return false;
		  	 char to = st.pop();
		  	 if(mp.get(to) + mp.get(c)!=0) return false;
		  }
		}
		if(st.isEmpty()) 
		{
			cnt+=2;
		    return true;
		}	
	 return false;
	}
	public static int cnt_parenthesis(String str)
	{
		int c = 0;
		int r = 0;
		for(char ch : str.toCharArray())
		{
			if(mp.get(ch) < 0)
			{
				c++;
			}
			else{
				r++;
			}
		}
		if(r == 0 || c==0)
		{
			return -1;
		}
		else if(r > c)
		{
			return c * 2;
		}
		else{
			return r * 2;
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		//boolean res = check(str);
		int ans = cnt_parenthesis(str);
	    System.out.println(ans);
	}
}