// Pattern 6
/*
     input :5


                *
                *       *
*       *       *       *       *
                *       *
                * 

*/
import java.util.*;
class Pattern6{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();

	    int sp=n/2;
	    int st=1;
	    for (int i=1;i<=n ;i++ ) {
	    	for (int j=1;j<=sp;j++ ){
	    	  System.out.print(i==n/2+1 ? "*\t" : "\t");
	    	}
	    	for (int j=1;j<=st;j++ ){
	    	  System.out.print("*\t");
	    	}
	    	if(i<= n/2)
	    	{
	    		st++;
	    	}
	    	else{
	    		st--;
	    	}
	    	System.out.println();
	    }
	}
}