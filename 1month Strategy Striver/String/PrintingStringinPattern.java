// string compinies Question
import java.util.*;
class PrintingStringinPattern{	
	static String rev(String a)
	{
		int i = 0;
		int j = a.length()-1;
		char a1[] = a.toCharArray();
		while(i< j)
		{
		   char t = a1[i];
		   a1[i]=a1[j];
		   a1[j]=t;
		   i++;
		   j--;
		}
		return String.valueOf(a1 );
	}
	static void printString(String str,int n)
	{
		int m = 1;
		int i =0;
		while(i < n)
		{
			if(i == 0){
				System.out.println(str.charAt(i));
				i++;
			}
			else{
				m++;
				int l = m + i < n ? m+i:n;
				String ans = str.substring(i,l);
				ans = rev(ans);
				i = l;
				System.out.println(ans);
			}
		}	
	
	}
	//another approach
	static void printString1(String str, int n)
	{
		str = rev(str);
		int m=1;
		for(int i=n-1;i>=0;)
		{
		        for (int p=0;p<m;p++ ){
		        	System.out.print(str.charAt(i));
		        	i--;
		        }
		        m++;
		        System.out.println();
			}
		}
	

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		String str = sc.next();
		printString(str,str.length());
		printString1(str,str.length());
	}
}