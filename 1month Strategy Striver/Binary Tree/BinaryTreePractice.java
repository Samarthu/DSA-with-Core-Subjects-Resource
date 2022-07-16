/// create a binary tree from stack 

import java.util.*;

class Node{
	Node left;
	Node right;
	int data;
	Node(){}
	Node(int val)
	{
		this.data = val;
		this.left=this.right = null;
	}
}
class BinaryTreePractice{
	static class pair{
		Node n;
		int state;
		pair(Node n,int s)
		{
			this.n = n;
			this.state=s;
		}
	}
	static Node createBinaryTree(Integer arr[])
	{
		Stack<pair> st = new Stack<>();
		Node fn = new Node(arr[0]);
		st.push(new pair(fn,1));
		int i=0;
		while(st.size()> 0)
		{
			pair top = st.peek();
			if(top.state == 1)
			{
				i++;
				if(arr[i]!=null)
				{
				    Node no = new Node(arr[i]);
					top.n.left = no;
					st.push(new pair(no,1));	
				}else{
					top.n.left = null;
				}
				top.state++;
			}
			else if(top.state == 2)
			{
			   i++;
		       if(arr[i]!=null)
		       {
		       	 Node no = new Node(arr[i]);
				top.n.right = no;
				st.push(new pair(no,1));
		       }else{
		       	  top.n.right = null;
		       }
				top.state++;
			}
			else{
				st.pop();
			}
		}
		return fn;
 	}

 	static void printTree(Node n)
 	{
 	   if(n == null) return;
 	   String str="";
 	   str+= n.left == null ? "." : n.left.data+"";
 	   str+= "<--" + n.data +"-->";
 	   str+= n.right == null ? ". " : n.right.data+"";
 	   System.out.println(str);
 	   printTree(n.left);
 	   printTree(n.right);
 	}
 	static void pre(Node n)
 	{
 		if(n == null) return;
 		System.out.print(n.data+" ");
 		pre(n.left);
 		pre(n.right);
 	}
 	static void in(Node n)
 	{
 		if(n == null)  return;
 		in(n.left);
 		System.out.print(n.data+" ");
 		in(n.right);
 	}
 	static void post(Node n)
 	{
 		if(n == null) return;
 		post(n.left);
 		post(n.right);
 		System.out.print(n.data+" ");
 	}

 	static int maxNode(Node n)
 	{
 		if(n == null) return Integer.MIN_VALUE;
 		int l = maxNode(n.left);
 		int r = maxNode(n.right);
 	    int max = Math.max(n.data,Math.max(l,r));
 	    return max;
 	}
 	static int size(Node n)
 	{
 		if(n==null)  return 0 ;
 		int l = size(n.left);
 		int r = size(n.right);
 		return l + r + 1 ; 
 	}
 	static int height(Node n)
 	{
 		if(n == null) return -1;
 		int l = height(n.left);
 		int r = height(n.right);
 		return Math.max(l,r) + 1;

 	}
 	static class bstpair{
 		boolean isBST;
 		int min;
 		int max;
 	}
 	static bstpair isBinary(Node n)
 	{
 		if(n == null)
 		{
 		    bstpair pr = new bstpair();
 		    pr.isBST = true;
 		    pr.min = Integer.MAX_VALUE;
 		    pr.max = Integer.MIN_VALUE;
 		    return pr;
 		}

 		bstpair l = isBinary(n.left);
 		bstpair r = isBinary(n.right);

 		bstpair bp = new bstpair();
 		bp.isBST = l.isBST && r.isBST && (n.data >= l.max  && n.data <= r.min);
 		bp.min = Math.min(n.data,Math.min(l.min,r.min));
 		bp.max = Math.max(n.data,Math.max(l.max,r.max));
 		return bp;
 	}
 	static class dia{
 		int ht;
 		int di;
 		dia(){}
 		dia(int ht,int di){
 			this.ht = ht;
 			this.di = di;
 		}
 	}
 	static int diame(Node n)
 	{
 		if(n == null) return 0;
 		int l = diame(n.left);
 		int r =diame(n.right);
 		int fes = height(n.left) + height(n.right) + 2;
 		return Math.max(fes,Math.max(l,r));
 	}
 	static dia diameter(Node n)
 	{
 		if(n == null)
 		{
 			dia d = new dia();
 			d.ht = -1;
 			d.di = 0;
 			return d;
 		}
 		dia l = diameter(n.left);
 		dia r = diameter(n.right);
 		dia dn = new dia();
 		dn.ht = Math.max(l.ht,r.ht) +1;
 		int fes = l.ht + r.ht + 2;
 		dn.di = Math.max(fes,Math.max(l.di,r.di));
 		return dn;
 	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer arr[] = {40,20,10,null,null,30,null,null,60,50,null,null,70,null,null};
		Node rtn = createBinaryTree(arr);
		printTree(rtn);
		pre(rtn);
		System.out.println();
		System.out.println("-----------------------");
		in(rtn);
		System.out.println();
		System.out.println("-----------------------");
		post(rtn);
		System.out.println();
		System.out.println("-----------------------");
		System.out.println(maxNode(rtn));
		System.out.println(size(rtn));
		System.out.println(height(rtn));
		System.out.println(diameter(rtn).di);
		System.out.println(diame(rtn));
		bstpair bp = isBinary(rtn);
		System.out.println(bp.isBST);
 	}
}