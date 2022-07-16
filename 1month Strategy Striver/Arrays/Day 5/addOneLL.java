// Add one to the LinkedList


import java.util.*;
class Node{
		int data;
		Node next;
		Node(){
		}
		Node(int val){

		  data=val;
		  next=null;
		}
	}
class addOneLL{
    public static Node th=null;
    public static Node tt=null;
	public void addLast(Node node){
		if(th==null){
			tt=th=node;
		}else{
			tt.next=node;
			tt=node;
		}
	}

	static Node rev(Node he){
		Node prev=null;
		Node cur=he;
		Node nextPtr;
		while(cur!=null){
			nextPtr=cur.next;
			cur.next = prev;
			prev=cur;
			cur=nextPtr;
		}
		//print(prev);
		return prev;
	}

	static Node addone(Node h)
	{
		h=rev(h);
		Node curr=h;
		boolean f=true;
		while(curr!=null && f==true){
			if(curr.next==null && curr.data == 9 )
			{
				curr.data=1;
				Node tmp=new Node(0);
				tmp.next=h;
				h=tmp;
				curr=curr.next;
			}
			else if(curr.data==9){
				curr.data=0;
				curr=curr.next;
	   	}
			else{
				f=false;
				curr.data+=1;
				curr=curr.next;
			}
			///curr=curr.next;
		}
		h=rev(h);
		return h;
	}
	public static void print(Node h)
	{
		while(h!=null){
			System.out.print(h.data+"->");
			h=h.next;
		}
		System.out.print("NULL");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		addOneLL li = new addOneLL();
		while(n--!=0)
		{
			li.addLast(new Node(sc.nextInt()));
		}
		Node h=addone(addOneLL.th);
		print(addOneLL.th);
	}

} 