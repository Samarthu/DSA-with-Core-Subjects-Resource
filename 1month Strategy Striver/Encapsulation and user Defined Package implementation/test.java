// client machine who codes the data

// Here the Abstraction that is Encapsulation takes place

import Student.*;
class test{
	public static void main(String[] args) {
		/*student st = new student();
		st.setName("samiksha");
		String str = st.getName();
		System.out.print(str);
*/
		girls g= new girls();
		g.putSizes("wrest" , 44);
		g.putSizes("chest", 55);
		g.putSizes("thigs", 55);
		g.putSizes("neck",10);
		int s1 = g.getSizes("chest");
		int s2 =g.getSizes("neck");
		System.out.println(s1+" "+s2);

	}
}