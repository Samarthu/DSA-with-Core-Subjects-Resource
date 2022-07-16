/// implementation of stack and Queue
import java.util.*;

class stack{
	//Scanner sc=new Scanner(System.in);
    int size;
    private int stackel[];
    private int top;
    stack(int n)
    {
    	stackel=new int[n];
    	top=-1;
    	size=n;
    }
    public void push(int n)
    {
    	if(isFull()){System.exit(1);}
    	stackel[++top]=n;
    	//size++;
    }
    public int pop(){
    	if(isEmpty()) {
     		    	System.exit(1);
     		    }
     		   // size--;
     		    int el=stackel[top--];
     		    return el;
    }
  /* public void opr(){
   	 System.out.println("Choose the Following choice:");
   	 System.out.println("1.PUSH\n2.POP\n3.Display");
     int ch=sc.nextInt();
     switch(ch){
     	case 1: {
     		    
     		    System.out.println("Enter the element you want to PUSH :");
     	        int e=sc.nextInt();
     	        stackel[]=10;
     	        break;
     	        }

     	case 2:{
     		    if(isEmpty()) {
     		    	System.exit(1);
     		    }
     		    int el=stackel[top--];
     		    System.out.println("The Popped element is : "+el);
     	        break;
           	   }        

        case 3:printStack();break;
        default:
        System.out.println("You Have entered wrong choice");
      }
   }*/
   public boolean isFull(){
   	return top == size-1;
   }
   public int size(){
   	return top ==-1?0:top+1;
   }
   public boolean isEmpty(){return top ==-1;}
   public void printStack()
	{
		System.out.print("[");
		for (int i=0; i<=top;i++ ) {
			System.out.print(stackel[i]);
			System.out.print(i!=top ? ",":"");		
		}
		System.out.print("]");
		System.out.println();

   /// System.out.println(Arrays.toString(stackel));
	}
}
class queue{
	int size;
	int rear;
	int front;
	int que[];
	queue(int n)
	{
		size=n;
		rear=-1;
		front=-1;
		que=new int[size];
	}

	public void insert(int el)
	{
		if(isQueueFull())
		{
			System.out.println("Queue is full insertion is not possible");
			System.exit(1);
		}
		else{
			if(front==-1)
			{
				front=0;
			}
            rear++;
		    que[rear]=el;
		}
	}
	public int delete()
	{
		if(queEmpty())
		{
			System.out.println("Queue is Empty.. deletion is not possible");
			//System.exit(1);
			return -1;

		}
		else{
			int el = que[front];
		   if (front >= rear) {
	  			front=-1;
	  			rear=-1;
	  		}
	  		else{
	  			front++;
	  		}		
	  		System.out.println("The deleted element is -->" + el);
	  		return el;
		}

	}

	public boolean queEmpty(){
		if(front == -1) return true;
		return false;
	}
	public boolean isQueueFull(){
		if(front==0 && rear==size-1) return true;
		return false;
	}
	public void printQueue(){
		int i;
		if(queEmpty()) System.out.println("Queue is Empty");
		else{
			System.out.println("Rear element a index-> "+rear);
	  	 	System.out.println("Queue element : ");
	  	 	for(i=front;i<=rear;i++)
	  	 	{
	  	 		System.out.print(que[i] + ",");
	  	 	}
	  	 	System.out.println();
	  	 	System.out.println("front element at index -> "+front);
		}
	}
}

class Implementation{
	public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the size of stack and queue:");
        int n=sc.nextInt();
        stack stk = new stack(n);
        stk.push(10);
        stk.push(13);
        stk.push(14);
        stk.push(20);
        stk.printStack();
        System.out.println(stk.pop());
        stk.printStack();
        System.out.println(stk.isEmpty());
        System.out.println(stk.size());
        stk.push(50);
        stk.printStack();
        System.out.println(stk.size());
           
/*
        queue q= new queue(n);
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        q.printQueue();
        int q1=q.delete();
        //System.out.print(q.delete());
        q.insert(5);
        q.printQueue();
        q.insert(6);
        q.printQueue();
        int q2=q.delete();
        q.printQueue();
  */      
	}
}