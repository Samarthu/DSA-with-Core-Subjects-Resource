// In this Program we are doing the basically the LevelOrding traversal and
// doing program according to that
import java.util.*;
class Node{
	Node left,right;
	int data;
	Node(int k){
		data=k;
		left=null;
		right=null;
	}
}
class LevelOrderQuestions{
   Node root;
   LevelOrderQuestions(int item){
   	root=new Node(item);
   }
   LevelOrderQuestions(){root=null;}
   void display(Node n){
    if(n==null) return;
   	String str="";
   	str+= n.left==null? ".": n.left.data;
   	str+="<-" + n.data +"->";
   	str+=n.right==null? ".": n.right.data;
   	System.out.println(str);
   	display(n.left);
   	display(n.right);
   }
 
 ArrayList<Integer> leftview(Node n)
 {
 	//if(n==null) return;
   	Queue<Node> q= new LinkedList();
   	ArrayList<Integer> ans = new ArrayList<>();
   	q.add(n);
   	while(!q.isEmpty()){
   		int size = q.size();
   		ans.add(q.peek().data);
   		while(size-->0)
   		{
   			Node el = q.poll();
   			if(el.left!=null) q.add(el.left);
   			if(el.right!=null) q.add(el.right);
   		}
   	}
   	return ans;
 }

  ArrayList<Integer> rightview(Node n)
 {
 	//if(n==null) return;
   	Queue<Node> q= new LinkedList();
   	ArrayList<Integer> ans = new ArrayList<>();
   	q.add(n);
   	while(!q.isEmpty()){
   		int size = q.size();
   		ans.add(q.peek().data);
   		while(size-->0)
   		{
   			Node el = q.poll();
   			if(el.right!=null) q.add(el.right);
   			if(el.left!=null) q.add(el.left);
   		}
   	}
   	return ans;
 }


 int sumAtK(Node n,int k)
 {
 	if(n==null) return -1;
   	Queue<Node> q= new LinkedList();
   	q.add(n);
   	int sum=0;
   	int level=0;
   	while(!q.isEmpty()){
   		int size = q.size();
   		while(size-->0)
   		{
   			Node el = q.poll();
   			if(level==k)
   			{
   				sum+=el.data;
   			}
   			
   			//System.out.print(el.data+" ");
   			if(el.left!=null) q.add(el.left);
   			if(el.right!=null) q.add(el.right);
   			//q.remove();
   		}
   		level++;
   	}
   	return sum;
 }

   public void levelOrderTravers(Node n){
   	if(n==null) return;
   	Queue<Node> q= new LinkedList();
   	q.add(n);
   	while(!q.isEmpty()){
   		int size = q.size();
   		while(size-->0)
   		{
   			Node el = q.poll();
   			System.out.print(el.data+" ");
   			if(el.left!=null) q.add(el.left);
   			if(el.right!=null) q.add(el.right);
   			//q.remove();
   		}
   		System.out.println();
   	}
   }

   // vertical order Travers
   static class vpair{
   	Node node;
   	int hl;
   	 vpair(Node n,int hl){
   	    this.node=n;
   	    this.hl=hl;
   	 }
   }
  static int width(Node n,int hl,int[] minMax)
  {
  	 if(n== null) return 0;
  	 minMax[0] = Math.min(minMax[0],hl);
  	 minMax[1] = Math.max(minMax[1],hl);
  	 if(n.left!=null) width(n.left,hl-1,minMax);
  	 if(n.right!=null) width(n.right,hl+1,minMax);
     int w= minMax[1]-minMax[0]+1;
  	 return w;
  }
 List<Integer> topview_fun(Node n)
 {
 	int minMax[] = new int[2];
 	List<Integer> ans = new ArrayList<>();
 	int len = width(n,0,minMax);
 	//System.out.println(len); 
 	for(int i=0;i<len;i++) ans.add(null);
 	LinkedList<vpair> que = new LinkedList<>();
 	que.add(new vpair(n,Math.abs(minMax[0])));
 	while(!que.isEmpty())
 	{
 		int size = que.size();
 		while(size-- > 0){
 			vpair el = que.poll();
 			Node nd = el.node;
 			int h =Math.abs(el.hl);
 			if(ans.get(h)== null) ans.set(h,nd.data);
 			if(nd.left !=null)que.add(new vpair(nd.left,el.hl-1));
   		if(nd.right !=null)que.add(new vpair(nd.right,el.hl+1));
 		}
 	}	
 	return ans;

 }
   List<List<Integer>> verticaOrderravers(Node n)
   {
   	LinkedList<vpair> que = new LinkedList();
   	Map<Integer,List<Integer>> mp = new HashMap<>();
   	int minh=0,maxh=0,width=0;
   	List<List<Integer>> ans = new ArrayList();
   	que.add(new vpair(n,0));
   	while(!que.isEmpty())
   	{
   		int size = que.size();
   		while(size-->0)
   		{
   			vpair rp = que.removeFirst();
   			minh = Math.min(minh,rp.hl);
   			maxh=Math.max(maxh,rp.hl);
   			mp.putIfAbsent(rp.hl, new ArrayList<>());
   			mp.get(rp.hl).add(rp.node.data);
   			if(rp.node.left !=null)que.add(new vpair(rp.node.left,rp.hl-1));
   			if(rp.node.right !=null)que.add(new vpair(rp.node.right,rp.hl+1));
   		}
   	}
   	width=maxh-minh+1;
   	System.out.println("widthis :" + width);
   	for(int i=minh;i<=maxh;i++)
   	{
   		ans.add(mp.get(i));
   	}
   	return ans;
   }
	public static void main(String[] args) {
		LevelOrderQuestions tree = new LevelOrderQuestions();
		tree.root = new Node(10);
		tree.root.left = new Node(12);
		tree.root.right = new Node(14);
		tree.root.left.left=new Node(15);
		tree.root.left.right=new Node(16);
		tree.root.right.left=new Node(17);
		tree.root.right.right=new Node(18);
		//tree.display(tree.root);
		//tree.levelOrderTraverstreerooans.add(el.data);t);
		//int sum = tree.sumAtK(tree.oot,2);
		//System.out.println(sum);
		//ArrayList<Integer> leftView = tree.leftview(tee.root);
		//ArrayList<Integer> rightView = treeMath.abs(.righ)tvie(tree.root);
		//System.out.println(leftView +" " + rightView);
      /// Vertical Order Traversal
		List<List<Integer>> ans = tree.verticaOrderravers(tree.root);
		System.out.println(ans);
		List<Integer> topview = tree.topview_fun(tree.root);
		System.out.println(topview);
	}
}