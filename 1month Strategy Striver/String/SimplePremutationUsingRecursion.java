 // Simple Permutation Using Recursion 
 import java.util.*;
 class SimplePremutationUsingRecursion{
 	static void premuteUsingRec(String str,String asf)
 	{
 		if(str.length() == 0)
 		{
 			System.out.println(asf);
 			return;
 		}
 		for (int i=0;i<str.length() ; i++) {
 			 char ch = str.charAt(i);
 		     String part1 = str.substring(0,i);
 		     String part2 = str.substring(i+1);
 		     String ros=part1+part2;
 		     premuteUsingRec(ros,asf + ch);
 		}
 	}
 	static void wordPremutation1(int ci,int ti,Map<Character,Integer>mp,String asf,String str)
 	{
 		if(ci > ti)
 		{
 			System.out.println(asf);
 			return;
 		}
 		for(char ch : mp.keySet())
 		{
 			if(mp.get(ch) > 0){
	 			mp.put(ch, mp.get(ch) - 1);
	 			wordPremutation1(ci+1,ti,mp,asf+ch,str);
	 			mp.put(ch, mp.get(ch) + 1);
 			}
 		}
 	}
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String str = sc.next();
    	Map<Character,Integer> mp = new HashMap<>();
    	//premuteUsingRec(str,"");
    	for(char ch :str.toCharArray()){
    	   if(mp.containsKey(ch))
    	   {
    	   	mp.put(ch,mp.get(ch) + 1);
    	   }else{
    	   	mp.put(ch,1);
    	   }
    	}
    	//System.out.println(mp);
    	wordPremutation1(1,str.length(),mp,"",str);
    }
 }