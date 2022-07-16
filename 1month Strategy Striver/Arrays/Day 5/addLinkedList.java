//Addtion of Two Linked List 
import java.util.*;
class Node{
	int data;
	Node next;
    Node(){}
	Node(int val)
	{
		data=val;
	    next=null; 
	}
}
class addLinkedList{
	Node head;
	void addNode(Node newnode)
	{
		if(head==null)
		{
			head=newnode;
		}
		else{
		Node last = head;
		while(last.next!=null)
		{
			last=last.next;
		}
		last.next = newnode;
	} 
	}
	void prinlist(Node h){
		while(h!=null){
			System.out.print(h.data+"->");
			h=h.next;
		}
		System.out.print("NULL");
		System.out.println();
	}
	static void prinlist1(Node h){
		while(h!=null){
			System.out.print(h.data+"->");
			h=h.next;
		}
		System.out.print("NULL");
		System.out.println();
	}
	static Node addLists(Node l1, Node l2)
	{
		Node dummy = new Node();
		Node temp=dummy;
		int carry=0;
		while(l1!=null || l2!=null || carry==1)
		{
			int sum=0;
			if(l1!=null) 
			{
				sum+=l1.data;
				l1=l1.next;
			} 
			if(l2!=null)
			{
				sum+=l2.data;
				l2=l2.next;
			}
			sum+=carry;
			carry=sum/10;
			Node re = new Node(sum%10);
			temp.next = re;
			temp=temp.next;
		} 

		return dummy.next;
	}

    static Node rev(Node h)
	{
		Node prev=null;
		Node curr=h;
		Node nextPtr;
		while(curr!=null)
		{
			nextPtr=curr.next;
			curr.next=prev;

			prev=curr;
			curr=nextPtr;
		}
		return prev;
	}

	static Node minusLists(Node l1, Node l2)
	{
		if(l2==null)  return l1;
		if(l1==null){ l2.data = -l2.data;return l2;}
		l1=rev(l1);
		l2=rev(l2);
		//prinlist1(l2);
    	Node dummy=new Node();
		Node tmp=dummy;
		int borrow=0;
		while(l1.next!=null)
		{
			int diff = borrow + l1.data - (l2!=null?l2.data:0);
			if(diff < 0) {
				borrow=-1;
				diff+=10;
			}
			else{
				borrow=0;
			}
			Node di = new Node(diff%10);
			tmp.next=di;
			tmp=tmp.next;
			l1=l1.next;
			if(l2!=null) l2=l2.next;
		}
		return dummy.next;
	}
    public static void main(String[] args) {

    	 addLinkedList list1 = new addLinkedList();
    	 addLinkedList list2 = new addLinkedList();
    	 // First LinkedList 
    	 list1.addNode(new Node(5));
    	 list1.addNode(new Node(6));
    	 list1.addNode(new Node(7));
    	 list1.addNode(new Node(10));
    	 list1.prinlist(list1.head);
    	 // Second LinkedList
    	 list2.addNode(new Node(5));
    	 list2.addNode(new Node(6));
    	 list2.addNode(new Node(7));
    	 list2.prinlist(list2.head);
    	 System.out.println("The addition is :");
    	 Node res = addLists(list1.head,list2.head);
    	 prinlist1(res);


    	 System.out.println("The Substration is :");
    	 Node res1 = minusLists(list1.head,list2.head);
    	 prinlist1(res1);




    }
}