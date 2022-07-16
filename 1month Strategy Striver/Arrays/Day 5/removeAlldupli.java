// Remove the duplicate element in the linked list

import java.util.*;

class Node{
	int data;
	Node next;
	Node(){
	}
	Node(int val)
	{
		data=val;
		next=null;
	}
}
class removeAlldupli{
	Node head;
	static public Node th=null;
	static public Node tt=null;
	
// Add last method;
	public void addLast(Node node)
	{
		if(th==null)
		{
			tt=th=node;
		}
		else
		{
			tt.next = node;
			tt=node;
		}
	}
// Normally we add node to end of our linkedList 

public void addEnd(Node node)
{
	if(head ==null){ head=node;}
	else {

		Node last = head;
		// iterate till last element of the  list
		while(last.next!=null)
		{
			last=last.next;
		}
		last.next = node;
	}
}
   
   public Node removeAllDuplicates(Node ha)
   {
   	  if(ha==null || ha.next==null) return ha;

   	  Node dummy= new Node();
   	  Node itr = dummy;
   	  itr.next = ha;/// potential element
   	  Node curr = ha.next;
   	  while(curr!=null){
   	  	boolean flag=false;
   	  	while(curr !=null && itr.next.data == curr.data){
   	  		flag=true;
   	  		curr=curr.next;
   	  	}
   	  	if(flag)
   	  	{
   	  		itr.next=curr;
   	  	}
   	  	else{
   	  		itr=itr.next;
   	  	}
   	  	if(curr!=null) curr=curr.next;
   	  }
   	  return dummy.next;
   }


	public void removeDuplicates(Node h)
	{
		if(h==null || h.next==null) return;

		Node cur=h;
		while(cur!=null)
		{
			Node fw=cur.next;
			cur.next=null;
			if(tt==null || tt.data!= cur.data) addLast(cur);
			cur=fw;
		}
	}


   public void print(Node h){
   	   //Node h =th;
   	   while(h!=null)
   	   {
   	   	  System.out.print(h.data+"->");
   	   	  h=h.next;
   	   }
   	   System.out.print("NULL");
   	   System.out.println();
   }


    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	removeAlldupli li = new removeAlldupli();
    	System.out.println("Enter the size of linkedList :");
    	int n=sc.nextInt();
    	while(n--!=0)
    	{
    		li.addEnd(new Node(sc.nextInt()));
    	}
    	li.print(li.head);
    	//li.removeDuplicates(li.head);
    	//li.print(removeAlldupli.th);
    	Node res = li.removeAllDuplicates(li.head);
    	li.print(res);
    }
}