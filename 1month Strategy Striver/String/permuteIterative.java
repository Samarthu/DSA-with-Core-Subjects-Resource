// permutation of String using iterative method 
import java.util.*;
class permuteIterative{
	public static int fact(int n)
	{
		int le = 1;
		for(int i=2;i<=n;i++)
		{
			le *= i;
		}
		return le;
	}
	static void permutation_fun(String str)
	{
		int n = str.length();
		int fa = fact(n);
		System.out.println(fa);
		for(int i=0;i<fa;i++)
		{
			StringBuilder sb = new StringBuilder(str);
			int temp = i;
			for(int div=n ; div>=1;div --)
			{
				int q = temp / div;
				int r = temp % div ;
				System.out.print(sb.charAt(r));
				sb.deleteCharAt(r);
				temp = q;
			}
			System.out.println();
		}
	}

	static ArrayList<ArrayList<Integer>> permuateInterative_another_soln(int a[])
	{
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> p = new ArrayList<>();
        p.add(a[0]);
        res.add(p);
		//System.out.println(res);
		for(int i=1;i<a.length;i++)
		{
			ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
			for(int j=0;j<res.size();j++)
			{
				List<Integer> y=res.get(j);
				int len = y.size();
				for(int k=0;k<=len;k++)
				{
					//System.out.println("--"+y);
					y.add(k,a[i]);
					temp.add(new ArrayList<>(y));
					y.remove(k);
					//System.out.println("+" + y);
				}
				//System.out.println("ttt"+temp);
			}
			res=temp;
		}
		System.out.println(res.size());
		return res;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		//permutation_fun(str);
		int arr[] = new int[str.length()];
		char a[] = str.toCharArray();
		int id=0;
		for(char i:a)
		{
			arr[id++]=i-'0';
		}
		ArrayList<ArrayList<Integer>> ans = permuateInterative_another_soln(arr);
		System.out.println(ans);
 	}

}