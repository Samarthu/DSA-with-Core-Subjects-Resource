/// Pattern5

/*
Pat 1
input : 7


                        1
                1       2       1
        1       2       3       2       1
1       2       3       4       3       2       1
        1       2       3       2       1
                1       2       1
                        1


Pat 2 :
input : 7

7
                        1
                2       3       2
        3       4       5       4       3
4       5       6       7       6       5       4
        3       4       5       4       3
                2       3       2
                        1

*/
import java.util.*;
class Pattern5{
   public static void main(String[] args) {
   		Scanner sc = new Scanner(System.in);
   		int n = sc.nextInt();
   		// Pat 2 Logic Here

   		int sp = n/2;
   		int st = 1;
   		int val =1;
   	    for (int i=1;i <= n ; i++) {   	    	
   	    	for (int j=1; j<=sp;j++ ) {
   	    		System.out.print("\t");
   	    	}
   	    	int cval = val;
   	    	for (int j=1; j<=st;j++ ) {
   	    		System.out.print(cval +"\t");
   	    		 if(j<=st/2)
   	    		 {
   	    		 	cval++;
   	    		 }
   	    		 else{
   	    		 	cval--;
   	    		 }	
   	    	} 
   	    	if(i <= n/2)
   	    	{
   	    		sp--;
   	    		st+=2;
   	    		val++;
   	    	}
   	    	else{
   	    		val--;
   	    		sp++;
   	    		st-=2;
   	    	}
   	    	System.out.println();
   	    }
   	}	
}



/*
Pat 1 code Logic


   		int sp = n/2;
   		int st = 1;
   	    for (int i=1;i <= n ; i++) {   	    	
   	    	for (int j=1; j<=sp;j++ ) {
   	    		System.out.print("\t");
   	    	}
   	    	int cval = 1;
   	    	for (int j=1; j<=st;j++ ) {
   	    		System.out.print(cval +"\t");
   	    		 if(j<=st/2)
   	    		 {
   	    		 	cval++;
   	    		 }
   	    		 else{
   	    		 	cval--;
   	    		 }	
   	    	} 
   	    	if(i <= n/2)
   	    	{
   	    		sp--;
   	    		st+=2;
   	    	}
   	    	else{
   	    		sp++;
   	    		st-=2;
   	    	}
   	    	System.out.println();
   	    }
   	}	

*/