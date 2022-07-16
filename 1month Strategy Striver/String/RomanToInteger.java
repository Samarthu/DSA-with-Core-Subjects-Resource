// Roman to Integer

import java.util.*;

class RomanToInteger{
	static int generateIntger(String s)
	{
		// We adding the ROman Numral Stacks
		Map<Character,Integer> mp= new HashMap<>();
		mp.put('I',1);
		mp.put('V',5);
		mp.put('X',10);
		mp.put('L',50);
		mp.put('C',100);
		mp.put('D',500);
		mp.put('M',1000);

		int res=0;
		for(int i=0;i<s.length();i++)
		{
			if(i>0 && mp.get(s.charAt(i)) > mp.get(s.charAt(i-1)))
			{
				res+=mp.get(s.charAt(i)) - 2*mp.get(s.charAt(i-1)); 
			}
			else{
				res+=mp.get(s.charAt(i));
			}
			//System.out.print(res+ " ");
		}
		return res;
	}
	public static void main(String[] args) {
	 Scanner sc= new Scanner(System.in);
	 String str=sc.next();
	 int n=generateIntger(str);
	 System.out.println(n);
	}
}