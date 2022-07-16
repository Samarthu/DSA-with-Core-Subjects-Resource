 // Largest Area of rectangle in Histrogram

 import java.util.*;
 class LargestAreaRectHistrogram{
    static int largestArea(int a[])
    {
    	int rb[]=new int[a.length];// right smaller element
    	Stack<Integer> st = new Stack<>();
    	st.push(a.length-1);
    	rb[a.length-1]=a.length;
    	for(int i=a.length-2;i>=0;i--)
    	{
    		while(st.size() > 0 && a[i] < a[st.peek()])
    		{
    			st.pop();
    		}
    		if(st.size()==0) rb[i]=a.length;
    		else rb[i]=st.peek();
    		st.push(i);
    	}
    	System.out.println(Arrays.toString(rb));
    	int lb[]=new int[a.length]; // left smaller element
      st = new Stack<>();
    	lb[0]=-1;
    	st.push(0);
    	for(int i=1;i<a.length;i++)
    	{
    		while(st.size() > 0 && a[i] < a[st.peek()])
    		{
    			st.pop();
    		}
    		if(st.size()==0){
    			lb[i]=-1;
    		}
    		else{
    		    lb[i]=st.peek();	
    		} 
    		st.push(i);
    	}
    	System.out.println(Arrays.toString(lb));	
    	int maxArea=0;
    	for(int i=0;i<a.length;i++)
    	{
    		int width = rb[i]-lb[i]-1;
    		int area = a[i]* width;
    		if(area > maxArea)
    		{
    			maxArea=area;
    		}
    	}
    	return maxArea;
     }
 	public static void main(String[] args) {
 		Scanner sc= new Scanner(System.in);
 		int n =sc.nextInt();
 		int a[]= new int[n];
 		int i=0;
 		while(n--!=0)
 		{
 			a[i++] = sc.nextInt();
 		}
  		int area = largestArea(a);
 		System.out.println(area);
 	}
 }