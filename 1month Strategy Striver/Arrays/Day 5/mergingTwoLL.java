// Day 5 Merging the Intervals
import java.util.*;
class Node{
		int data;
		Node next;
		Node(int val){
			data=val;
			next=null;
		}
	}
class mergingTwoLL
{ 	
	Node head;
	public void appendList(Node newnode){
	    if(head == null){
	    	head=newnode;
	    }
        else{
	    Node last=head;
	    while(last.next!=null){
	    	last=last.next;
	    }
	    last.next=newnode;
	  }
	}
	static Node mergeLl(Node l1,Node l2){
		if(l1==null) return l2;
		if(l2==null)  return l1;

		// Always take l1 as a smaller linkedList

		if(l1.data > l2.data){
			Node temp=l1;
			l1=l2;
			l2=temp;
		}
		Node res=l1;
		while(l1!=null && l2!= null){

			Node temp=null;
			while(l1!=null && l1.data<l2.data){
				temp=l1;
				l1=l1.next;
			}
			temp.next=l2;
         //swapping lists 
			Node tmp=l1;
			l1=l2;
			l2=tmp;

		}

		return res;
	}
	 public void printList(){
	 	Node h=head;
	 	while(h!=null){
	 		System.out.print(h.data+"->");
	 		h=h.next;
	 	}
	 	System.out.print("NULL");
	 	System.out.println();
	 }
	public static void main(String[] args) {
		mergingTwoLL list1 = new mergingTwoLL();
		mergingTwoLL list2 = new mergingTwoLL();
		mergingTwoLL list3 = new mergingTwoLL();

		//Create a linked list1 10,15,20

		list1.appendList(new Node(10));
		list1.appendList(new Node(15));
		list1.appendList(new Node(20));
		list1.printList();

		// Now We create Linked List2 9,12,17,30
	    list2.appendList(new Node(9));
	    list2.appendList(new Node(12));
	    list2.appendList(new Node(17));
	    list2.appendList(new Node(30));
	    list2.printList();
	    // Without using extra space
	     //list1.head=mergeLl(list1.head,list2.head);
	     //using extra space
        list1.head=new extraspace().mergeLl1(list1.head,list2.head);
	    list1.printList();
	    // merge sort()
	   // list3.printList();
	}
}

class extraspace{
// This  Approach is using extra Space..
public Node mergeLl1(Node l1,Node l2)
{
    if(l1==null || l2==null) return (l2!=null ? l1 :l2);
	Node dummy = new Node(0);
	Node tail= dummy;
	while(l1!=null && l2!=null){

		if(l1.data<l2.data){

			tail.next=l1;
			l1=l1.next;
		}
		else{
			tail.next=l2;
			l2=l2.next;
		}
		tail=tail.next;
	}
     tail.next=(l1!=null?l1:l2);
	return dummy.next;
  }
}
