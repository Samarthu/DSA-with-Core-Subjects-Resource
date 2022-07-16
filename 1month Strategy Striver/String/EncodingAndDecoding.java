import java.util.*;
class EncodingAndDecoding{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		boolean flag = false;
		boolean icCh ;
		for (char s : str1.toCharArray()){
			int n = (int)s;
			if(Character.isDigit(s))
			{
			   flag = true;
			   break;	
			} 
			int type = Character.getType(s);
			int type2 = Character.getType(s+5);
			if(type == type2)
			{
				n+=5;
			    sb1.append((char)n +"");
			}
			else{
				sb1.append(s); 
			}
		}
	    for (char s : str2.toCharArray()){
	    	int n = (int) s;
	    	if(Character.isDigit(s))
			{
			   flag = true;
			   break;	
			} 
	    	int type = Character.getType(s);
			int type2 = Character.getType(s-5);
	    	if(type == type2)
	    	{
	    		n-=5;
	    		sb2.append((char)n+"");
	    	}
	    	else{
	    		sb2.append(s);
	    	}
	    }

	    if(flag)
	    {
	    	System.out.println("INVALID INPUT");
	    }
	    else{
	    	System.out.println(sb1.toString());
	    	System.out.println(sb2.toString());
	    }
	}
}