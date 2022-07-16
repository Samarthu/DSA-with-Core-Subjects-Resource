// Day 1.5 Merge The Intervals

import java.util.*;
public class mergeintervals{

// Optimized Method By using stack 
	public static void merge_interval(Interval arr[]){
      if(arr.length <= 0)
      	return;
      Stack<Interval> stk =new Stack<>();
      Arrays.sort(arr,new Comparator<Interval>(){
      	public int compare(Interval i1, Interval i2){
      		return i1.start - i2.start;
      	}
      });
      stk.push(arr[0]);
      for (int i=1;i<arr.length ;i++ ) {

      	Interval top = stk.peek();
      	if( top.end <arr[i].start){
      		stk.push(arr[i]);
      	}
      	else if(top.end<arr[i].end){
      		top.end= arr[i].end;
      		stk.pop();
      		stk.push(top);
      	}
      }
      System.out.println("The Merged Intervals are  :" );
      while(!stk.isEmpty())
      {
      	Interval t = stk.pop();
      	System.out.print("[" +t.start+","+ t.end + "]");

      }
	}
     public static void main(String[] args) {    	 
        Interval arr[]=new Interval[4];
        arr[0]=new Interval(1,3);
        arr[1]=new Interval(2,6);
        arr[2]=new Interval(15,19);
        arr[3]=new Interval(20,22);
        merge_interval(arr);
     }
}
class Interval{
	int start,end;
	Interval(int start,int end)
	{
		this.start=start;
		this.end=end;
	}
}