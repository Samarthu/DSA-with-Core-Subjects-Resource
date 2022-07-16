// mergesort for Linked List 

import java.util.*;
class Node{
		int data;
		Node next;
		Node(int val){
			data=val;
			next=null;
		}
	}
class mergeSortLinkedList {
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

public static Node midLL(Node h)
	{
		if(h==null || h.next == null) return h;
		Node slow=h;
		Node fast=h;
		while(fast.next!=null && fast.next.next!=null){
			fast =fast.next.next;
			slow =slow.next;
			
		}
		return slow;
	}
 public static Node mergefun(Node l1,Node l2)
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

	public static Node mergeSort(Node li)
	{
		if(li==null || li.next == null) return li;
		Node mid = midLL(li);
		Node nhead=mid.next;
		mid.next =null;

		Node l1 = mergeSort(li);
		Node l2 = mergeSort(nhead);
		return mergefun(l1,l2);
	}
	public static  void print(Node h){
	 	//Node h=head;
	 	while(h!=null){
	 		System.out.print(h.data+"->");
	 		h=h.next;
	 	}
	 	System.out.print("NULL");
	 	System.out.println();
	 }


	public static void main(String[] args) {
        mergeSortLinkedList li = new mergeSortLinkedList();
        Scanner sc=new Scanner(System.in);
	    System.out.println("Enter the List size");
	    int n=sc.nextInt();
	    while(n--!=0)
	    {
	    	li.appendList(new Node(sc.nextInt()));
	    }
	    Node nhead = mergeSort(li.head);
	    print(nhead);	

	}
}
