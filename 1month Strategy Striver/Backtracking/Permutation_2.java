// permutation with combination  
// Exploring the formula nPr = nCr * r!
import java.util.*;
class Permutation_2{
	static int i1=0,i2=0;
	static void permutation_fun(int a[], int ci, int ti,int r,int ssf,String psf){
		if(ci> ti)
		{
			i2++;
			if(ssf == r)
			{
				i1++;
				System.out.println(psf);
				return;
			}		
			return;
		}
		for(int i=0;i<r;i++)
		{ 
			if(a[i]==0)
			{
				a[i]=1;
				permutation_fun(a,ci+1,ti,r,ssf+1,psf+i+1);
				a[i]=0;
			}
		}	
      permutation_fun(a,ci+1,ti,r,ssf,psf+0);
	}
 	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p = sc.nextInt();
		permutation_fun(new int[p],1,n,p,0,"");
		System.out.println(i1+" "+i2);
	}
}