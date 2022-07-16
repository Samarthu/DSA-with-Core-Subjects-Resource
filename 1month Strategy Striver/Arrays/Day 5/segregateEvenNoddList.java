// Segregate even and odd linked list in O(1);


import java.util.*;

class Node{

	Node next;
	int data;
	Node(){};
	Node(int val)
	{
	  data=val;
	  next=null;
	}
}
class segregateEvenNoddList{
	Node head;
   
public static Node tt=null;
public static Node th=null;
public void addLast(Node node)
{
	//Node node=new Node(val);
	if(th==null)
	{

		th=node;
		tt=node;
		//head=tt;
	}
	else{
		tt.next=node;
		tt=node;				
	}
}
/*
public void addLast(Node newnode){
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
}*/
public void prinList()
{
	Node h=th;
	while(h!=null)
	{
		System.out.print(h.data+"->");
		h=h.next;
	}
	System.out.print("NULL");
	System.out.println();

}
public void segEvenOdd(Node head)
{
	Node ev = null;
    Node od = null;
    Node e=null;
    Node o=null;
    Node curr=head;
    while(curr!=null)
    {
    	int el =curr.data;
    	if((el%2)==0)
    	{
    		if(ev==null)
    		{
    			ev=curr;
    			e=ev;
    		}
    		else{

    			e.next=curr;
    			e=e.next;
    		}
    	}
    	else{
    		if(od==null)
    		{
    			od=curr;
    			o=od;
    		}
    		else{
    			o.next=curr;
    			o=o.next;
    		}
    	}
    	curr=curr.next;
    }

   ///if(od==null || ev==null) return;
 
 e.next = od;
 o.next=null;
 head=ev;
 print(ev);

}


static void print(Node h)
{ 
	while(h!=null)
	{
		System.out.print(h.data+"->");
		h=h.next;
	}
	System.out.print("NULL");
	System.out.println();	
}
public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   segregateEvenNoddList li=new segregateEvenNoddList();
   System.out.println("Enter the size of linked List");
   int n=sc.nextInt();
    while(n--!=0)
    {
    	li.addLast(new Node(sc.nextInt()));
    }

   li.prinList();
   li.segEvenOdd(segregateEvenNoddList.th);



 }
}