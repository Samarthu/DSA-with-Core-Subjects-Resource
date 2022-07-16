//Count the digit who has number  1 4  9 accenture question
import java.util.*;
class cntDigit149{
	static int getCnt(int m,int n)
	{
		int flag = 1;
		int cnt = 0;
		if(m > n)  return -1;
		for (int num=m;num<=n;num++){
			int n1 = num;
			while(n1 > 0)
			{
				int d = n1 % 10;
				n1/=10;
				if(d == 1 || d == 4 || d == 9)
				{
					flag = 1;
					continue;
				}
				else{
					flag = 0;
					break;
				}
			}	
			if(flag == 1){
               cnt++;
			}		
		}
		return cnt;
     }
   public static void main(String[] args) {
   	Scanner sc = new Scanner(System.in);
   	int n = sc.nextInt();
   	int m = sc.nextInt();
    System.out.println(getCnt(n,m));
   }
}