/// target sum subsets with repeating elements
import java.util.*;
class targetSUmRepeats{
	static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	static int targetSUmRepeats(int a[],int n,int idx,int tar,ArrayList<Integer> psf)
	{
		if(idx == n)
		{
			if(tar == 0)
			{
				res.add(new ArrayList<>(psf));
				return 1;
			}		
			return 0;
		}
		int l=0,r=0;
		if(a[idx]<= tar)
		{
			tar-=a[idx];
			psf.add(a[idx]);
	 		l=targetSUmRepeats(a,n,idx,tar,psf);
			psf.remove(psf.size()-1);
			tar+=a[idx];
		}
		r=targetSUmRepeats(a,n,idx+1,tar,psf);
		return l+r;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n   = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		int cnt = targetSUmRepeats(a,n,0,target,new ArrayList<>());
		System.out.println("Total cnt is:" + cnt);
		System.out.println(res);
	}
}