// Here we are using the constructor to build the tree with predefined values..
import java.util.*;
class Node{
	Node left,right;
	int data;
	Node(int key,Node l,Node r)
	{
		this.data=key;
		this.left=l;
		this.right=r;
	}
 }
class pair{
	Node node;
	int state;
	pair(Node n,int s)
	{
		this.node=n;
		this.state=s;
	}
}
class binaryTree{
	static Node imple(Integer arr[])
	{
	   Node rt = new Node(arr[0],null,null);
	   pair pn = new pair(rt,1);
	   Stack<pair> st=new Stack<>();
	   st.push(pn);
	   int idx=0;
	   while(st.size()>0)
	   {
	   	  pair top = st.peek();
	   	  if(top.state==1)
	   	  {
	   	  	idx++;
	   	  	if(arr[idx]!=null){
	   	  		top.node.left= new Node(arr[idx],null,null);
	   	  		pair ln= new pair(top.node.left,1);
	   	  		st.push(ln);
	   	      }
	   	      else{
	   	      	top.node.left=null;
	   	      }
	   	      top.state++;
	   	  }
	   	  else if(top.state==2){
	   	  	idx++;
	   	  	if(arr[idx]!=null){
	   	  		top.node.right= new Node(arr[idx],null,null);
	   	  		pair rn= new pair(top.node.right,1);
	   	  		st.push(rn);
	   	      }
	   	      else{
	   	      	top.node.right=null;
	   	      }
	   	      top.state++;
	   	  }
	   	  else{
	   	  	st.pop();
	   	  }
	   }
	   return rt;
	}
// Pre , In , Post By using recursive	
	static void OrdersRecursivePre(Node n)
	{
		if(n == null) return;
		System.out.print(n.data+" ");
		OrdersRecursivePre(n.left);
		OrdersRecursivePre(n.right);
	}
	static void OrdersRecursiveIn(Node n)
	{
		if(n == null) return;
		
		OrdersRecursiveIn(n.left);
		System.out.print(n.data+" ");
		OrdersRecursiveIn(n.right);
	}
	static void OrdersRecursivePost(Node n)
	{
		if(n == null) return;
		OrdersRecursivePost(n.left);
		OrdersRecursivePost(n.right);
		System.out.print(n.data+" ");
	}

	// InOrder PreOrder And PostOrder using iterative method

	static void OrdersIterative(Node n)
	{
		if(n==null) return;
      Stack<pair> st = new Stack<>();
      pair rtp = new pair(n,1);
      st.push(rtp);
      String pre="";
      String in="";
      String post="";
      while(st.size() > 0)
      {
      	pair top=st.peek();
      	if(top.state == 1)// pre, left
      	{
      		pre+=top.node.data +" ";
      		top.state++;
      		if(top.node.left !=null)
      		{
      			pair lp = new pair(top.node.left,1);
      			st.push(lp);
      		}
      	}
      	else if(top.state == 2)// in, right
      	{
      		in+=top.node.data +" ";
          	top.state++;
          	if(top.node.right !=null)
      		{
      			pair rp = new pair(top.node.right,1);
      			st.push(rp);
      		}
      	}
      	else{ 
      	 // Post , pop()
      		post+=top.node.data+" ";
      		st.pop();
      	}
      }
     System.out.println(pre);
     System.out.println(in);
     System.out.println(post);

	}
	static int treeSize(Node n)
	{
		if(n==null){
			return 0;
		}
		return treeSize(n.left) + treeSize(n.right)+1;
	}
	static int maxNode(Node n)
	{
		if(n==null){
			return Integer.MIN_VALUE;
		}
		int lm = maxNode(n.left);
		int rm = maxNode(n.right);
		int tm =Math.max(n.data,Math.max(lm,rm));
		return tm;
	}
	static int heightOftree(Node n)
	{
		//-1 for edges  and 0 for nodes
		if(n==null){
			return -1;
		}
		int lh=heightOftree(n.left);
		int rh=heightOftree(n.right);
		return Math.max(lh,rh)+1;

	}
	static int sum(Node n)
	{
		if(n==null) return 0;
		return sum(n.left) + sum(n.right) + n.data;
	}
	static void display(Node n)
	{
		if(n==null)
		{
			return; 
		}
		String str="";
		str+= n.left==null ? ".":n.left.data;
		str+="<--" + n.data + "-->";
		str+= n.right==null ? ".":n.right.data;
		System.out.println(str);
		display(n.left);
		display(n.right);
	}

	static boolean checkBST(Node n,long min , long max)
	{
		if(n==null) return true;
		if(n.data >= max || n.data <= min) return false;
		return checkBST(n.left,min,n.data) && checkBST(n.right,n.data,max);
	}

	static boolean checkValidBST(Node n)
	{
		
			return checkBST(n,Long.MIN_VALUE,Long.MAX_VALUE);
	}
	//sumit sir code
	static class bstpair{
		boolean isBST;
		int min;
		int max;
	}

	static bstpair isBStree(Node n)
	{
		if(n== null)
		{
			bstpair bsp = new bstpair();
			bsp.isBST = true;
			bsp.min = Integer.MAX_VALUE;
			bsp.max =Integer.MIN_VALUE;
		    return bsp;
		}

		bstpair lp = isBStree(n.left);
		bstpair rp = isBStree(n.right);

		bstpair mp = new bstpair();
		mp.isBST = lp.isBST && rp.isBST && (n.data>= lp.max&& n.data<=rp.min);
		mp.min = Math.min(n.data,Math.min(lp.min,rp.min));
		mp.max = Math.max(n.data,Math.max(lp.max,rp.max));

		return mp;

	}
    // Efficient Approch for Calculating the diameter of tree 
    static class diaPair{
    	int ht;
    	int dia;
    }
    static diaPair diameter(Node n){
    	if(n==null)
    	{
    		diaPair p = new diaPair();
    		p.ht=-1;
    		p.dia=0;
    		return p;
    	}
    	diaPair lp = diameter(n.left);
    	diaPair rp = diameter(n.right);
    	diaPair mp= new diaPair();
    	mp.ht = Math.max(lp.ht,rp.ht)+1;
    	int fes = lp.ht+rp.ht+2;
    	mp.dia = Math.max(fes, Math.max(lp.dia,rp.dia));
    	return mp;
    }
    // N^2 not efficient code..
    static int di(Node n)
    {
    	if(n==null)
    	{
    		return 0;
    	}
    	int lp=di(n.left);
    	int rp=di(n.right);
    	int res=heightOftree(n.left) + heightOftree(n.right)+2;
    	return Math.max(res, Math.max(lp,rp));
    }
	public static void main(String[] args) {
	  Scanner sc= new Scanner(System.in);
	  /*Integer arr[]={50, 25, 12, null, null, 37 ,30 ,null ,null, null ,75, 62 ,null, 70 ,null ,null ,87 ,null ,null};*/
	   /*Integer arr[] = {50,25,10,null,null,27,null,null,75,66,null,null,87,null,null};*/
	  Integer arr[] = {2,2,null,null,2,null,null};
	  Node n1 = imple(arr);
	  display(n1);
	  int size =treeSize(n1);
	  int maxValue = maxNode(n1);
	  int height = heightOftree(n1);
	  int add = sum(n1);
	  diaPair p = diameter(n1);
	  System.out.println(p.dia);
	  System.out.println(di(n1));
	  OrdersIterative(n1);
	  boolean  isBST = checkValidBST(n1);
	  System.out.println(isBST);
      bstpair isBStrans = isBStree(n1);
	  System.out.println(isBStrans.isBST);

	  //Recursion method of printing inorder preorder postorder 
	  /*OrdersRecursivePre(n1);
	  System.out.println();
	  OrdersRecursiveIn(n1);
	  System.out.println();
	  OrdersRecursivePost(n1);*/
	  //System.out.println("Height:"+height+"\n" + "Size:" + size +"\n" + "maxValue:" + maxValue +"\n "+"Sum:"+add);
	}
}