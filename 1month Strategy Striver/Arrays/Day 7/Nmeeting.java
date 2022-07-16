import java.util.*;
class meeting{
    int start=0;
    int end=0;
    int pos=0;
    
    meeting(int start,int end,int pos)
    {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}


// We Sort our object in ascending order  which indicates that  -1,1 ans for descending order we have to use 1,-1  
class meetingComparator implements Comparator<meeting>
{
    public int compare(meeting a1,meeting a2)
    {
        if(a1.end < a2.end)
        {
            return -1;
        }
        else if(a1.end > a2.end)
        {
            return 1;
        }
        else if(a1.pos < a2.pos){
            return -1;
        }
        return 1;
    }
}

    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    
    

class Nmeeting{

    static void printArry(ArrayList<meeting> ms){
        for(meeting a:ms)
        {
            System.out.print(a.start+" ");
            System.out.print(a.end+" ");
            System.out.print(a.pos+" ");
            System.out.println();
        }

    }

    public static int maxMeetings(int start[], int end[], int n)
    { 
        // add your code here
        
        ArrayList<meeting> ms = new ArrayList<>();
        for(int i=0;i<start.length;i++)
        {
            ms.add(new meeting(start[i],end[i],i+1));
        }
        
        meetingComparator  mc = new meetingComparator();
        Collections.sort(ms,mc);
        // We require a Data Structure to return the ans
        printArry(ms); 
        ArrayList<Integer> ans = new ArrayList<>();
        int limit = ms.get(0).end;
        ans.add(ms.get(0).pos);
        for(int i=1;i<start.length;i++)
        {
            if(ms.get(i).start >limit)
            {
                limit = ms.get(i).end;
                ans.add(ms.get(i).pos);
            }
        }
        
        return ans.size();
        
    }


    public static void main(String[] args) {
        int arr1[]= {1,3,4,6,2,10};
        int arr2[] ={2,6,9,10,8,11};
        int n=6;        
        int ans = maxMeetings(arr1,arr2,n);
        System.out.println(ans);
    }
    
}