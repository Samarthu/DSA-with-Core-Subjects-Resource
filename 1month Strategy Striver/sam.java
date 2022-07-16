import java.util.*;
class sam{
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 /*String str = sc.next();
		 String ans = "";
		 String rem = "";
		 for(char ch : str.toCharArray())
		 {
		      int n = (int)ch;
		      if((n >= 65 && n <= 90) ||(n>=48 && n<=57))
		      {
		      	ans+=ch+"";
		      }
		      else{
		      	rem+=ch+"";
		      }
		 }
		 System.out.println(ans);*/
		 int no = sc.nextInt();
		 int rev = 0;
		 int temp = no;
		 while(temp > 0)
		 {
		 	int l = temp % 10;
		 	rev = rev * 10 + l;
		 	temp = temp / 10;
		 }
		 int diff = Math.abs(rev - no);
		 ArrayList<Integer> arr = new ArrayList<>();
		for(int i=2;;)
		{
			while(diff % i == 0)
			{
				arr.add(i);
				diff/=i;
			}
			break;
		}
		System.out.println(arr.size());

	}
}
