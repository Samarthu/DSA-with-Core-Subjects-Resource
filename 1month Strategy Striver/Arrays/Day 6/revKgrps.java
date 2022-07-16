 // Day 6
// Reversing the linked list for K groups

class revKgrps{
	Node head;
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

// Appending the linked List 
	public void append(int n)
	{
		Node newnode = new Node(n);
		if(head==null)
		{
			head=newnode;
			return;
		}
		Node last=head;
		while(last.next!=null)
		{
			last=last.next;
		}
		last.next=newnode;
	}

	void printList(Node h)
	{
		while(h!=null)
		{
			System.out.print(h.data+"->");
			h=h.next;
		}
		System.out.print("NULL");
		System.out.println();
	}

	public Node kthrevgrps(Node head,int k)
	{
		Node dummy = new Node();
		dummy.next = head; 
		int count=0;
		while(head.next!=null)
		{
			head=head.next;
	     	count++;
		}
		///System.out.println(count);
		//dummy=head;

        Node prev = dummy,cur=dummy,nex=dummy;

        while(count >= k)
        {
        	cur = prev.next;
        	nex=cur.next;
        	for (int i=1;i<k;i++ ) {
        		cur.next = nex.next;
        		nex.next = prev.next;
        		prev.next = nex;
        		nex = cur.next;	
        	}
        	prev=cur;
        	count-=k;
        }
		return dummy.next;

	}

	public void deleteAtEnd(Node h){
		if(h== null || h.next== null)
		{
			h=null;
			return;
		}

		while(h!=null && h.next.next!=null)
		{
			h=h.next;
		}
		h.next=null;
	}
	public Node deleteStart(Node h)
	{
		if(h== null || h.next== null)
		{
			
			return null;
		}
		h=h.next;
		return h;
	}

	public Node deleteKey(Node h, int key)
	{
		Node temp=h;
		Node prev=null;
		if(h == null || (h.next==null && h.data!= key) )
		{
			return null;

		}
		if(temp.next==null && temp.data == key )
		{
			head = temp.next;
			return head;
		}
		while(temp!=null && temp.data!=key)
		{
			prev=temp;
			temp=temp.next;
		}
		prev.next=temp.next;
		return head;
	}

	public static void main(String[] args) {

		revKgrps li = new revKgrps();
		li.append(1);
		li.append(2);
		li.append(3);
		li.append(4);
		li.append(5);
		li.append(6);
		li.append(7);
		li.append(8);
		li.printList(li.head);
		Node nh = li.kthrevgrps(li.head,3);
		li.printList(nh);
// for deleting the element in the linkedList
    	/*li.deleteAtEnd(nh);
     	li.printList(nh);
     	Node nnl = li.deleteStart(nh);
     	li.printList(nnl);
     	Node nn = li.deleteKey(nh,5);
     	li.printList(nn);
        */

        

	}
}