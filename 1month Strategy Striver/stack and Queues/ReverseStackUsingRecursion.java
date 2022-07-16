// Reversing a Stack using recursion
import java.util.*;
class ReverseStackUsingRecursion{
	public static void insert_at_bottom(Stack<Integer>st, Integer top)
	{
		if(st.size() == 0)
		{
			st.push(top);
		}else{
			int ntop = st.pop();
			insert_at_bottom(st,top);
			st.push(ntop);	
		}
	}
	public static void reverse(Stack<Integer> st)
	{
		if(st.size() > 0)
		{
			Integer top = st.pop();
			//System.out.print(top+" ");
			reverse(st);
			insert_at_bottom(st,top);
		}
		return;
	}

	static void normalPriting(Stack<Integer>st)
	{
		Iterator it = st.iterator();
		while(it.hasNext())
		{
			System.out.print(it.next()+" ");
		}
		System.out.println();

	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
	    int n = sc.nextInt();
	    Stack<Integer> st = new Stack<>();
	    while(n--!=0)
	    {
	    	st.push(sc.nextInt());
	    }
	    normalPriting(st);
	    reverse(st);
	    normalPriting(st);
	}
}