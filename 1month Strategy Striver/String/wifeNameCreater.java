import java.util.*;
class wifeNameCreater{
	public static String getWifesFullName(ArrayList<String>a, ArrayList<String>b)
	{
		String ans="";
		ans +=b.get(0);
		ans +=(" "+a.get(0));
		ans +=(" "+a.get(2));
		return ans;
	}
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 ArrayList<String> a = new ArrayList<>();
		 ArrayList<String> b = new ArrayList<>();
		 System.out.println("Enter the First Name:");
		 int i = 0;
		 while(i<3)
		 {
		 	a.add(sc.next());
		 	i++;
		 }
		 System.out.println("Enter the Second Name:");
		 i = 0;
		 while(i<3)
		 {
		 	b.add(sc.next());
		 	i++;
		 }
		 System.out.println("Wifes full Name is:");
		 String wifeName = getWifesFullName(a,b);
		 System.out.println(wifeName);
	}
}