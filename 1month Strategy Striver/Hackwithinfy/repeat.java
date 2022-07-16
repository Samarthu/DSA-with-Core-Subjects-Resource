import java.util.*;
class repeat{

   static boolean isrepeat(int n)
   {
   	    String str = n+"";
   	    HashSet<Character> mp = new HashSet<>();
   	    for (int i=0;i<str.length() ;i++ ) {
   	    	char c = str.charAt(i);
   	    	if(mp.contains(c))
   	    	{
   	    		return true;
   	    	}else{
   	    		mp.add(c);
   	    	}
   	    }
   	    return false;
   }
   public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();

		if( n1 >= n2)
		{
			System.out.println("INVALID INPUT");
		}else{
			int cnt = 0;
			for(int i = n1 ; i<=n2;i++)
			{
				if(isrepeat(i) == false)
				{
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}	
}