// stock buy and sale problems 3 problems included here..
import java.util.*;
class stockBuyandSaleProblems{
	public static int get_MaxProfit_forOneTran(int n,int a[])
	{
		int least = Integer.MAX_VALUE;
		int op = 0;
		for (int i=0;i<n ;i++ ) {
			if(least > a[i])
			{
				least = a[i];
			}
			int cp = a[i] - least;
			if(cp > op)
			{
				op = cp;
			}
		}
		return op;
	}
	public static int get_MaxProfit_forINTran(int n,int a[])
	{
		int pr = 0;
		int sd = 0;
		int bd = 0;
		for (int i = 1;i<n ;i++ ) {
			if(a[i] >=a[i-1]){
				sd++;
			}
			else{
				pr+=a[sd]-a[bd];
				sd = bd = i;
			}
		}
		pr+=a[sd]-a[bd];
		return pr;
	}
	static int get_MaxProfit_forINTranWithFee(int a[],int n,int fee)
	{
		int obst = -a[0];
		int osst = 0;
		for (int i=1;i<n;i++) {
			int nbst = 0;
			int nsst = 0;
			if(obst < osst-a[i])
			{
				nbst = osst - a[i]; 
			}
			else{
				nbst = obst;
			}

			if(obst + a[i]- fee > osst)
		    {
		    	nsst = obst + a[i] - fee;
		    }
		    else{
		    	nsst = osst;
		    }
		    obst = nbst;
		    osst = nsst;
	   }
	   return osst;
	}
	static int get_MaxProfit_forINTranWithOT(int a[],int n)
	{
		int obst = -a[0];
		int osst = 0;
		int ocst = 0;
		for (int i = 1;i<n ;i++ ) {
			int nbst = 0;
			int nsst = 0;
			int ncst = 0;
			nbst = ocst - a[i] > obst ? ocst - a[i] : obst;
			nsst = obst + a[i] > osst ? obst + a[i] : osst;
			ncst = osst > ocst ? osst  : ocst;
			obst = nbst;
			osst = nsst;
			ocst = ncst;
		}
		return osst;
	}
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0;i< n ;i++ ) {
			a[i] = sc.nextInt();
		}
		int fee = sc.nextInt();
		int ansOneT = get_MaxProfit_forOneTran(n,a);
		System.out.println(ansOneT);
		int ansInT = get_MaxProfit_forINTran(n,a);
		System.out.println(ansInT);
		int ansInTWF = get_MaxProfit_forINTranWithFee(a,n,fee);
		System.out.println(ansInTWF);
		int ansInTCP = get_MaxProfit_forINTranWithOT(a,n);
		System.out.println(ansInTCP);
	}
}