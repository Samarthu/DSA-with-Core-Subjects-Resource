 /// infix evaluation
import java.util.*;
class infixEvaluation {

	static int ex_evaluation(String str)
	{
		Stack<Integer> oprnd = new Stack<>();
		Stack<Character> oprtr = new Stack<>();
		for(int i=0;i<str.length();i++)
		{
			char ch = str.charAt(i);

			if(ch == '(')
			{
				oprtr.push(ch);
			}
			else if(Character.isDigit(ch))
			{
			   oprnd.push(ch -'0');
			}
			else if(ch == ')')
			{
			   while(oprtr.peek()!= '(')
			   {
			   	  char op=oprtr.pop();
			   	  int v2=oprnd.pop();
			   	  int v1=oprnd.pop();
			   	  int res=opration(v1,v2,op);
			   	  oprnd.push(res);
			   }
			   oprtr.pop();
			}
			else if(ch =='*'|| ch == '+' || ch== '/' || ch=='-'){
				while(oprtr.size() > 0 && oprtr.peek()!='(' && precedance(ch)<=precedance(oprtr.peek()))
				{
				  char op=oprtr.pop();
			   	  int v2=oprnd.pop();
			   	  int v1=oprnd.pop();
			   	  int res=opration(v1,v2,op);
			   	  oprnd.push(res);
				}
				oprtr.push(ch);
			}

			System.out.println(oprnd+" " +oprtr);
		}
		
   	        while(oprtr.size()!=0)
			   {
			   	  char op=oprtr.pop();
			   	  int v2=oprnd.pop();
			   	  int v1=oprnd.pop();
			   	  int res=opration(v1,v2,op);
			   	  oprnd.push(res);
			   }

		   return oprnd.peek();
	}
	static int precedance(char ch)
	{
		if(ch=='+') return 1;
		else if(ch == '-')return 1;
		else if(ch == '*')return 2;
		else return 2;
	}
	static int opration(int v1,int v2,char optr)
	{
		if(optr == '+')  return v1 + v2;
		else if(optr == '-') return v1-v2;
		else if(optr == '*') return v1*v2;
		else return v1/v2;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int ans=ex_evaluation(str);
		System.out.println(ans);
	}
}