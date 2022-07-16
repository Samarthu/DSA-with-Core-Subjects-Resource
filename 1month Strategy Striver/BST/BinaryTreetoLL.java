// Convert Binary search tree to LinkedList
import java.util.*;
class Node{
	int data;
	Node left,right;
	Node(int d)
	{
		this.data = d;
		this.left=this.right = null;
	}
	Node(){}
}
class BinaryTreetoLL{
	public static Node insert(Node n, int key){
		if(n == null) return new Node(key);
		else if(n.data > key){
			n.left = insert(n.left, key);
		}
		else{
			n.right = insert(n.right,key);
		}
		return n;
	}
	public static void inOrder(Node n)
	{
		if(n == null ) return;
		inOrder(n.left);
		System.out.print(n.data+ " ");
		inOrder(n.right);
	}
	static Node prev = null;
	static void convertionToDLL1(Node root)
	{
		if(root == null) return;
		convertionToDLL1(root.left);
		prev.right = root;
		root.left  = prev;
		prev = root;
		convertionToDLL1(root.right);
	}
	static Node convertionToDLL(Node root)
	{
		Node dummy = new Node(-1);
		prev=dummy;
		convertionToDLL1(root);
		Node head = dummy.right;
		dummy.right=head.left = null;
		/* circular linked List convertion
	    head.left = prev;
		prev.right = head;
		*/ 
		return head;
	}
	// Flatten Tree  to LinkedList

	static void flattenToLL(Node n)
	{
		if(n == null || (n.left == null && n.right == null)) return;
		if(n.left !=null)
		{
			flattenToLL(n.left);

			Node temp = n.right;
			n.right = n.left;
			n.left = null;
			
			Node t = n.right;
			
			while(t.right != null)
			{
				t=t.right;
			}
			
			t.right = temp;
		}
		flattenToLL(n.right);
	}


	static void print(Node h){
		while(h != null){
			System.out.print(h.data+" ");
			h=h.right;
		}
	}
	public static void main(String[] args) {
		BinaryTreetoLL tree = new BinaryTreetoLL();
		Scanner sc = new Scanner(System.in);
		Node root = insert(new Node(),10);
		insert(root,11);
		insert(root,2);
		insert(root,4);
		insert(root,6);
		insert(root,3);
		insert(root,29);
		insert(root,13);
		insert(root,39);
		insert(root,23);
		inOrder(root);
		// convetion to DLL
		//Node head = convertionToDLL(root); 
		//  convetion to Normal LL
		flattenToLL(root);
		System.out.println();
		print(root);
		System.out.println();
		inOrder(root);

	}
}




/* while(parent!=null)
{
	while(parent!=null)
	{
		if(n.left!=null)
		{
			if(ch!=null)
			{
              ch = n.left;
			}
			else{
	            c.next = n.left;
			}
			c = parent.next;
		}
		if(n.right!=null)
		{
			if(ch!=null)
			{
              ch = parent.left;
			}
			else{
	            c.next = n.left;
			}
			c = parent.next;
		}
		parent = parent.next;
	}
	parent = ch;
	ch=c=null;
}l

*/