///Indexing the lables
import java.util.*;
class IndexingLable{
	static String[] getProperIndexing(String[] str,int n)
	{
		int id  = 0;
		int sid = 0;
		for(int i = 0 ;i< n; i++)
		{
			String dumm = str[i];
			String[] a = dumm.split(",");
			if(a[0].charAt(0) == '#' && a[0].length()>1 ? false:true){
				id++;
				str[i] =  id +"." +" "+a[1];
			}
			else{
			     sid++;
			     str[i] = id +"."+ sid+"."+" " +a[1];
			}
		}
		return str;
	}
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int n = sc.nextInt();
		String[]  str = new String[n];
		for (int i = 0;i<n ;i++ ) {
			str[i] = sc.next();
		}
		String ans[] = getProperIndexing(str,n);
		for(int i =0;i<n;i++)
		{
			System.out.println(ans[i]);
		}
	}
}