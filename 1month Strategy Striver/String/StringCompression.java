/// String compression 
import java.util.*;
class StringCompression{
  static String getCompressedString(String str){
  	String s =str.charAt(0)+"";
  	int cnt = 1;
  	for (int i=1;i<str.length();i++ ) {
  		char curr = str.charAt(i);
  		char prev = str.charAt(i-1);
  		if(curr == prev)
  		{
  			cnt++;
  		}
  		else{
  			if(cnt > 1)
  			{
  				s+=cnt;
  				cnt = 1;
  			}
  			s+=curr +"";
  		}
  	 }
  		if(cnt > 1)
  		{  	
  			s+=cnt;
  			cnt = 1;
  		}
    return s;		
  }
  public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String ans = getCompressedString(str);
		System.out.println(ans);
  }
}