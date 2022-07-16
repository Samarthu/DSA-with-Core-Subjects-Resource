import java.util.*;
class StringSimpleOPR{
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 String str  = sc.next();
		 char a[] = str.toCharArray();
		 System.out.println(str);
		 System.out.println(Arrays.toString(a));
		 System.out.println("index of a:" + str.indexOf('a'));
		 System.out.println("Character at 2 " + str.charAt(2));
		 String str2 = "Payu";
		 str = str.concat(str2);
		 System.out.println(str);
		 StringBuilder sB = new StringBuilder(str);
		 sB.reverse();
		 System.out.println(sB.toString());
		 System.out.println(str2.substring(1,3));
		 System.out.println(str2.toUpperCase());
		 System.out.println(str2.toLowerCase());
		 System.out.println("Ascci value of String 2");
		 char as[] = str2.toCharArray();
		 for(char ch: as)
		 {
		 	int n = (int) ch;
		 	System.out.print(n+" ");
		 }
	}
}