// Implement Queue USing Linked List
import java.util.*;
class Node{
	Node next;
	int data;
	Node(int d)
    {
    	this.data=d;
    	this.next=null;
    }
}

class QueueUsingLinkedList{
	  static public Node head =null;
	  static public Node tail =null;
	  static int size = 0;
	  static void addLast(Node n){
		if(head==null)
		{
			head=tail=n;
		}
		else{
			tail.next=n;
			tail=n;
		}
	  }
	/*static void addFirst(Node n)
	{
		if(head==null)
		{
			head=tail=n;
		}
		else{
			n.next= head;
			head=n;
		}
	}*/
	static Node removeFirst()
	{
		if(head==null ||head.next == null)
		{
			head = null;
			return head;
		}
		else{
			Node p=head;
			head=head.next;
			return p;
		}
	}
	static void print()
	{
		Node n=head;
		while(n!=null)
		{
			System.out.print(n.data+"->");
			n=n.next;
		}
		System.out.println("NULL\n size of Queue is:" + size);
	}
	public void insert(int n)
	{
		Node new_node = new Node(n);
		if(size == limit)
		{
			System.out.println("Queue is Full..!! \t insertion is not possible");
		}
		else{
			addLast(new_node); 
			size++;
		}
	}
	public Node delete(){
		if(head==null)
		{
			System.out.println("deletion is not possible here ");
		}
		else if(head.next== null)
		{
			if(size == 0)
			{
				System.out.println("Queue is Empty");
			}
		}
		else{
			Node n = removeFirst();
			size--;
			return n;
		}
		return null;
	}
	public boolean isEmpty()
	{
		return size == 0;
	}
	public boolean isFull()
	{
		return size == limit;
	}
	static int limit;
	static void setlimit(int n)
	{
		limit = n;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		QueueUsingLinkedList q = new QueueUsingLinkedList();
		System.out.println("Enter the size of queue");
		int limit = sc.nextInt();
		setlimit(limit);
		System.out.println("Enter How much u want to do ");
		int ops = sc.nextInt();
		System.out.println("Enter the choice");
		System.out.println("1.insert\n2.delete\n3.display\n4.isFull\n5.isEmpty");
		for(int i=0;i<ops;i++)
		{
		int ch = sc.nextInt();
		switch(ch)
		{
			case 1: System.out.println("Enter the element you want to insert:");
			        int el = sc.nextInt();
			        q.insert(el);
			        break;
			case 2: Node e=q.delete();
			        System.out.println(e!=null ? "Deleted element is :" + e.data : "..");
			        break;
			case 3: print();
			        System.out.println("Front of Queue :" + head.data);
			        System.out.println("rear of Queue :" + tail.data);
			        break;
			case 4: System.out.println(q.isFull());
			        break;
			case 5: System.out.println(q.isEmpty());
			        break;  
			default:
			        System.out.println("Wrong choice");
			        break;
		}
	  }
	}
}