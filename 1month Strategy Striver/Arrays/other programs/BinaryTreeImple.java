// Binary Treees

import java.util.*;

// Here Create the Base for Tree in Structure
//    N 
//	 / \
// null null
class Node{
	Node left,right;
	int key;
	Node(int item){
		key = item;
		left=right=null;
	}
}
class BinaryTreeImple{
	Node root;
	BinaryTreeImple(int item){
		root= new Node(item);
	}
	BinaryTreeImple(){
		root= null;
	}

	static void preorder(Node root){
		if(root == null){
			return;
		}
      System.out.print(root.key+" ");
      preorder(root.left);
      preorder(root.right);
	}
	static void postorder(Node root){
		if(root == null){
			return;
		}
		postorder(root.left);
		//System.out.print(root.key+" ");
		postorder(root.right);
		System.out.print(root.key+" ");

	}
	static void inorder(Node root){
		if(root == null){
			return;
		}
		inorder(root.left);
		System.out.print(root.key+" ");
		inorder(root.right);
	}


    int sumAtK(Node root, int k)
    {
    	// Base case 
    	if(root==null)
    		return -1;
        int sum=0;
        int level=0;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty())
        {
        	Node curr = q.poll();
        	if(curr==null)
        	{
        		if(!q.isEmpty())
        		{
        			q.add(null);
        			level++;
        		}
        	}
        
        else
        {
        	    if(curr.left!=null)
				{
					q.add(curr.left);
				}
				if(curr.right!=null)
				{
					q.add(curr.right);
				}
        	   if(level == k)
        	    {
        		sum+=curr.key;
        	    }
     
        }

       }
        return sum;
    }


	void levelOrderTraversing(Node root)
	{
		if(root==null)
			return;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		while(!q.isEmpty())
		{
			Node curr = q.poll();

			if(curr == null)
			{
				if(!q.isEmpty())
				{
					q.add(null);
					System.out.println();
				}
			}
			else{
				if(curr.left!=null)
				{
					q.add(curr.left);
				}
				if(curr.right!=null)
				{
					q.add(curr.right);
				}

				System.out.print(curr.key+" ");
			}

		}
	}
	int countNodes(Node root)
	{
		if(root==null)
			return 0;
		return countNodes(root.left) + countNodes(root.right) + 1;
	}
	int sumOfNodes(Node root)
	{
		if(root==null)
			return 0;
		return sumOfNodes(root.left) + sumOfNodes(root.right) + root.key;
	}
	public int calHeight(Node root)
	{
		if(root==null)
			return 0;
		int rHeight = calHeight(root.right);
		int lHeight = calHeight(root.left);
		return Math.max(rHeight,lHeight)+1;
	}

	int calcDiameter(Node root)
	{
		if(root == null)
		{
			return 0;
		}
		int rHei = calHeight(root.right);
		int lHei = calHeight(root.left);
		int currDiameter = rHei + lHei +1;

		int lDiameter = calcDiameter(root.left);
		int rDiameter =calcDiameter(root.right);
		return Math.max(currDiameter, Math.max(lDiameter,rDiameter));
	}
	public static void main(String[] args) {
		BinaryTreeImple tree = new BinaryTreeImple();           // Structure of tree is 
		tree.root = new Node(2); 								//       2 
		tree.root.left = new Node(3);							//		/  \
		tree.root.left.left= new Node(5);						//     3    7
		tree.root.left.right = new Node(6);						//    / \  / \
		tree.root.right=new Node(7);							//   5   6 8  9
		tree.root.right.left=new Node(8);						//
		tree.root.right.right=new Node(9);
	    //preorder(tree.root);
	    //postorder(tree.root);
	   // inorder(tree.root);

	//	<--This is levelOrderTraversing of tree-->

        //tree.levelOrderTraversing(tree.root);

        // Sum of Kth level element

        // int sum = tree.sumAtK(tree.root,2);
        // System.out.println("The Sum is :" + sum);

        //// Count the no Nodes that present in the tree.

        /*int nnode = tree.countNodes(tree.root);
        System.out.println("The Node count is:" + nnode); */
         // Sum of All Nodes that present in the Tree
        /*int nodeSum = tree.sumOfNodes(tree.root);
        System.out.println("The Node count is:" + nodeSum); */

        // Height of tree 

       /* int height = tree.calHeight(tree.root);
        System.out.println("The Height of tree is:" + height);*/

        // Diameter of Tree 
        int diameterTree =  tree.calcDiameter(tree.root);
        System.out.println("The Diameter of tree is:" + diameterTree);





	}
}