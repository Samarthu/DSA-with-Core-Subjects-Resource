// combination
import java.util.*;
class combination{
	static int di=0;
	static void combination_fun(int ci, int ti,int ssf , int ts,String psf){
		if(ci > ti)
		{
			if(ssf == ts)
			{
				di++;
				System.out.println(psf);
			}
			return;	
		}
		combination_fun(ci+1,ti,ssf+1,ts,psf+"i");
		combination_fun(ci+1,ti,ssf,ts,psf+"_");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		combination_fun(1,n,0,r,"");
		System.out.println(di);
	}
}