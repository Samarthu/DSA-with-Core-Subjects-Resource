//CPLVL1
import java.util.*;
class simplecutPossible{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int no=0;
		if(n <100 || n > 200)
		{
			System.out.println("INVALID INPUT");
		}else{
			no=n/4;
		}
		System.out.println(no);
	}
}


/*
		int k = sc.nextInt();
		int ans = -1;
		if(n%k == 0)
		{
			ans= n/k;
		}
		System.out.print(ans);*/