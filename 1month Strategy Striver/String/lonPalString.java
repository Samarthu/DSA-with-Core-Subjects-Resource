// longest Palindromic in a string
import java.util.*;
class lonPalString{
	static void printString(String s, int i,int j)
	{
		for(int p=i;p<=j;p++){
			System.out.print(s.charAt(p)+" ");
		}
		System.out.println();
	}
	static int lonPalString_fun(String str)
	{
		int start=0,end=1,l,h;
		for(int i=1;i<str.length();i++)
		{
			// for even len string
		  l=i-1;
		  h=i;
		  while(l>=0 && h<str.length() && str.charAt(l) == str.charAt(h))
		  {
		  	 if(h-l+1> end)
		  	 {
		  	 	start=l;
		  	 	end=h-l+1;
		  	 }
		  	 l--;
		  	 h++;
		  }
           // For odd length string
		  l=i-1;
		  h=i+1;
		  while(l>=0 && h<str.length() && str.charAt(l) == str.charAt(h))
		  {
		  	 if(h-l+1> end)
		  	 {
		  	 	start=l;
		  	 	end=h-l+1;
		  	 }
		  	 l--;
		  	 h++;
		  }
		}
		printString(str,start,start+end-1);
		System.out.println(str.substring(start,start+end));
		return start+end-1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int len = lonPalString_fun(str);
		System.out.println(len);
	}	
}