/// Round Robbin Algorithm of CPU Scheduing
import java.util.*;
class pair implements Comparable<pair>{
	int id;
	int at;
	int bt;
	pair(int id,int at,int bt)
	{
		this.id=id;
		this.at=at;
		this.bt=bt;
	}
	public int compareTo(pair o)
	{
		return this.at - o.at;
	}
}
class RRAlgo{
	static void roundRobinAlgo(pair[]  data,int tq,int n,int[] bt1)
	{
		int ct[] = new int[n];
		int wt[] = new int[n];
		int tat[] = new int[n];
		Queue<pair> rq = new LinkedList<>();
	    Queue<pair> eq = new LinkedList<>();
	    eq.add(data[0]);
	    rq.add(data[0]);
		int cnt = 0;
		int t_wt= 0;
		int t_tat= 0;
		while(rq.size() > 0)
		{
		    pair el = rq.poll();
		    int is = el.id;
		    if(el.bt - tq < 0)
		    {
		    	el.bt= 0;
		    	cnt+=1;
		    }
		    else{
		    	el.bt -= tq;
		    	cnt+=tq;
		    }
		    //System.out.print(cnt+" ");
		    if(el.bt == 0 && ct[el.id-1]== 0)
		    {
		    	ct[el.id-1] = cnt;
		    }
		    while(is < n && data[is].at <= cnt)
		    {
		    	if(rq.contains(data[is])== false && eq.contains(data[is]) == false)
		    	{
		    		rq.add(data[is]);
		            eq.add(data[is]);
		    	    is++;
		    	}
		    	
		    }
		    if(el.bt > 0)
		    {
		    	rq.add(el);
		    }
		}
		for(int i=0;i<n;i++){
		   tat[i] = ct[i]- data[i].at;
		   t_tat+=tat[i];
		}
		for (int i=0 ; i<n;i++ ) {
		   wt[i] =  tat[i] - bt1[i];
		   t_wt+=wt[i];
		}
		float avg_wt  = (float)t_wt / (float) n;
		float avg_tat = (float)t_tat / (float) n;
		System.out.println(Arrays.toString(ct));
		System.out.println(Arrays.toString(wt));
		System.out.println(Arrays.toString(tat));
		System.out.println("Avg_wt ="+ avg_wt);
		System.out.println("Avg_tat ="+ avg_tat);
	}
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in );
	    int n = sc.nextInt();
	    int bt[] = new int[n];
	    int at[] = new int[n];    
	    pair[] data = new pair[n];
	    for (int i =0;i<n ;i++ ) {
	    	int id = sc.nextInt();
	    	int atn = sc.nextInt();
	        at[i] = atn;
	    	int btn = sc.nextInt();
	    	bt[i] = btn;
	    	data[i] = new pair(id,atn,btn);
	    }
	    Arrays.sort(data);
	    int tq = sc.nextInt();
	    roundRobinAlgo(data,tq,n,bt);
	}
}
/*
boolean check = true;
			for(int i=0;i<n;i++){
				if(bt1[i] > 0 && data[i].at <= cnt)
				{
					check = false;
				    if(bt1[i]-tq < 0)
				    {
				    	bt1[i] = 0;
				    	cnt+=1;
				    } else{
				    	bt1[i]-=tq;
				    	cnt+=tq;
				    }
				}
				else{

				}
		    }
		    if(check)
		    	break;*/