 // Huffaman coding 
import java.util.*;
class MinHeapNode{
	int freq;
	char c;
	MinHeapNode left,right;
	MinHeapNode(char c ,int d)
	{
		this.c = c;
		this.freq =d;
		left=right=null;
	}
}
class HuffManCode{
	static ArrayList<Integer> addi=new ArrayList<>();
	static void getCodes(MinHeapNode root, String s, ArrayList<String>ans)
	{
		if(root==null) return;
		if(root.c!='$'){
			ans.add(s);
			System.out.println(root.c +":"+ s);
		}else{
			addi.add(root.freq);
		}
		getCodes(root.left,s+'0',ans);
		getCodes(root.right,s+'1',ans);
	}
	static void MinHeapOp(String s, int[] arr)
	{
		// Define the nodes
		MinHeapNode left, right ,root;
		// implementation of priority Queue
		PriorityQueue<MinHeapNode> q = new PriorityQueue<>(new Comparator<MinHeapNode>(){
			public int compare(MinHeapNode x, MinHeapNode y)
			{
				/*
			   if(x.freq>=y.freq) return 1;
			   else return -1;
			   */
			   return x.freq - y.freq;
			}
		});
		// Add all the data to the queue;
        for(int i=0;i<arr.length;i++) q.add(new MinHeapNode(s.charAt(i) , arr[i]));

        //System.out.println(q.peek().freq);

        while(q.size() > 1)
        {
        	left = q.poll();
        	right =q.poll();
        	root = new MinHeapNode('$', left.freq + right.freq);
        	root.left=left;
        	root.right = right;
        	q.add(root);
        }

        ArrayList<String> ans= new ArrayList<>();
        getCodes(q.poll(),"",ans);
        System.out.println(ans + " size of que:" + q.size());
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str =sc.next();
		int n = str.length();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		MinHeapOp(str,arr);
		System.out.println(addi);
	}
}