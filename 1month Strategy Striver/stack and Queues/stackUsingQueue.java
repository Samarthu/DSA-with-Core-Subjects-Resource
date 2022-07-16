// Stack using Queue

import java.util.*;

class stack{
	Queue<Integer>q1=new LinkedList<Integer>();
	Queue<Integer>q2=new LinkedList<Integer>();
    public void push(int n){
    	q2.add(n);
    	while(!q1.isEmpty())
    	{
    		q2.add(q1.poll());
    	}
    	Queue<Integer> tmp = q1;
    	q1=q2;
    	q2=tmp;
    }
    public void pop()
    {
    	System.out.println("The deleted Element is :" +q1.poll());
    }
    public void display(){
    	System.out.println(q1);
    }

}
class stackUsingQueue{
	
	public static void main(String[] args) {
		stack st = new stack();
		Scanner sc= new Scanner(System.in);
        System.out.println("Enter the operation you want to perform");
		int n=sc.nextInt();

		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the Choice:");
			System.out.println("1.PUSH\n2.POP\n3.Display");
			int ch = sc.nextInt();
			switch(ch)
			{
					case 1:System.out.println("Insert th element --> ");
			       		st.push(sc.nextInt());
			       		break;
					case 2:st.pop();
			       		break;
					case 3:st.display();
			      		break;
					default: System.out.println("You have  entered wrong choice");             
			}
		}
		

	}
}