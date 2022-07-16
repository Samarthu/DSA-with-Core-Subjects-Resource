// Pattern 3
/*
  
  *
 ***
*****
 ***
  *

*/


import java.util.*;
class Pattern3{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sp=n/2;
		int st=1;
		for(int i = 1;i<= n;i++)
		{
			for(int j=1;j<=sp;j++)
			{
				System.out.print(" ");
			}

			for(int j=1;j<=st;j++)
			{
				System.out.print("*");
			}
			for(int j=1;j<=sp;j++)
			{
				System.out.print(" ");
			}

           if(i<= n/2)
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
} 