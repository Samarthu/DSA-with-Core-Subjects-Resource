// Median of Stream Array.. which means that the value of array is not constant..

import java.util.*;
class MedianOfStream{
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	public void insertNum(int n)
	{
		if(maxHeap.size() == 0 || maxHeap.peek() >= n)
		{
			maxHeap.add(n);
		}
		else minHeap.add(n);

		if(maxHeap.size() > minHeap.size()+1)
		{
			minHeap.add(maxHeap.poll());
		}
		else if(maxHeap.size() < minHeap.size())
		{
			maxHeap.add(minHeap.poll());
		}
	}
	public double findMedian()
	{
		if(maxHeap.size() == minHeap.size())
		{
			double ans = maxHeap.peek() / 2.0 + minHeap.peek() /2.0;
			return ans;
		}

		return maxHeap.peek();
	}
	public void print()
	{
		System.out.println("maxHeap:" + maxHeap);
		System.out.println("minHeap:" + minHeap);
	}
	public static void main(String[] args) {
		MedianOfStream obj = new MedianOfStream();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of times u \5 perform operation :");
		int n = sc.nextInt();
		while(n--!=0)
		{
			System.out.println("1.Insert\n2.Median\n3.print");
			int ch = sc.nextInt();
			switch(ch)
			{
				case 1:System.out.println("Enter how many item u want to insert");
			           int times = sc.nextInt();
			           for(int i=0;i<times;i++)
			           {
			           	 	int no = sc.nextInt();
				       		obj.insertNum(no);
			           }
				       break;
				case 2: double median = obj.findMedian();
				        System.out.println(median);
				        break;
				case 3:obj.print();
				       break;        
				default:
				       System.out.println("Wrong choice");
				       break;               
			}
		}
	}
}