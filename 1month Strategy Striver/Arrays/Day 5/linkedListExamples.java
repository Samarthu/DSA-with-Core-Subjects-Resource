// Day 5  Linked List Implementation
import java.io.*;
import java.util.*;
class linkedListExamples{
	     Node head;
		class Node{
			int data;
			Node next;
			
			Node(int n){
				data=n;
				next=null;
			}
		}

// Add element begining of the linkedList
public void push(int new_data){
	Node  new_node = new Node(new_data);
	new_node.next= head;
	head=new_node;
}

public void insertAfter(Node prev, int data){
	if(prev == null){
		System.out.println("Insertion is Not possible");
		return;
	}

	Node new_node = new  Node(data);
	new_node.next=prev.next;
	prev.next=new_node;

}
// Appending Node to the end of the LinkedList
public void append(int data){
	Node new_node = new Node(data);
	if(head== null)
	{
		head = new_node;
		return;
	}
	Node last=head;
	while(last.next!=null){
		last=last.next;
	}
	last.next=new_node;
}

public void createCycle(Node head , int pos)
{
	Node startNode=null;
	int cnt=1;
	while(head!=null && head.next!=null){
		
		if(cnt== pos){
			startNode = head;
		}
		head=head.next;
		cnt++;
	}
	head.next= startNode;
}

public boolean detectCycle(Node head){
	Node slow=head, fast=head;

	while(fast!=null && fast.next!=null){
		slow=slow.next;
		fast=fast.next.next;
		if(slow== fast){
			return true;
		}
	}
	return false;
}

public void removeCycle(Node head){
	Node slow=head, fast=head;
	do{
		slow=slow.next;
		fast=fast.next.next;
	}while(slow!=fast);

	fast =head;
	while(slow.next!=fast.next){
		slow=slow.next;
		fast=fast.next;
	} 
	slow.next=null;
}



public Node deleteStart(Node head){
	if(head== null || head.next == null)
	{
		return null;
	}

   Node dete=head;
  head=head.next;
//  delete(dete);
  return head;
   
}


public Node deleteNode(Node head, int key){
	Node temp=head;
	Node prev = null;
 ///  for LinkedList in Empty
	if(head==null)
		return null;
	// If only One ELment in the LinkedList and it not equal to Key
	if(head.next== null){
		return head;
	}
	// if only one element and == key 
	if(temp!=null && temp.data== key){
		head=temp.next;
		return head;
	}
	

	while(temp!=null && temp.data!= key){
		prev=temp;
		temp=temp.next;
	}

	prev.next = temp.next;

	return head;

}


public Node deleteEnd(Node head){
  
  Node temp=head;
  if (head== null || head.next == null) {
    return head; 
  	
  }

  while(temp!=null && temp.next.next!=null){
  	temp=temp.next;
  }
  temp.next = null;
  return head;

}

public void printList(){
	Node h = head;
	while(h!=null){
		System.out.print(h.data+"->");
		h=h.next;
	}
	System.out.print("NULL");
	System.out.println();	
}

 static Node revereListRecursion(Node head){

	if(head== null || head.next==null){
		return head;
	}

	Node new_node = revereListRecursion(head.next);
	head.next.next=head;
	head.next=null;
	return new_node;

}

public void printReverseList(Node h){
	while(h!=null){
		System.out.print(h.data+"->");
		h=h.next;
	}
	System.out.print("NULL");
}

public void revereList(){
	Node prev= null;
	Node currPtr=head;
	Node nextPtr;
	while(currPtr!=null){
		nextPtr = currPtr.next;
		currPtr.next = prev;
		prev=currPtr;
		currPtr=nextPtr;
	}
	while(prev!=null){
		System.out.print(prev.data+"->");
        prev=prev.next;
	}
	System.out.print("NULL");
}

public Node findMiddleOfLinkedList(){
	Node slow = head , fast = head;
	while(fast!=null && fast.next!=null){
		slow=slow.next;
		fast=fast.next.next;
	}
	return slow;
}

	public static void main(String[] args)throws IOException {
		linkedListExamples li = new linkedListExamples();
		li.push(2); 
		li.push(1);
		li.insertAfter(li.head.next,3);
		li.append(4);
		li.append(5);
		li.push(0);
		li.printList();
		//li.revereList();
		/*Node middle = li.findMiddleOfLinkedList();

		System.out.println("The middle of Linked List is :" + middle.data);

	*//*
		Node pt =li.revereListRecursion(li.head);
		li.printReverseList(pt);
*/
		/*li.createCycle(li.head,3);
		//li.printList();

	     boolean isCyclePresent=li.detectCycle(li.head); 
	     System.out.println(isCyclePresent);
	     li.removeCycle(li.head);
	     boolean isCyclePresent1=li.detectCycle(li.head);
	     System.out.println(isCyclePresent1);*/
 // Delete from begining;

	     // Node de= li.deleteStart(li.head);
	     // li.printReverseList(de);
// Detlete From a perticular Key
	     /*Node de = li.deleteNode(li.head,2);
	     li.printReverseList(de);
*/
	     // Delete from end;

	      Node de = li.deleteEnd(li.head);
	     li.printReverseList(de);




		
	}
}