// Number of Employees and Managers

import java.util.*;
class NofEmpNMan{
	static Map<String,Integer> getans(int n , Map<String,String> map)
	{
	    Map<String,HashSet<String>> tree = new HashMap<>();
	   	//HashSet<String> hs = new HashSet<>();
	    Map<String,Integer> ans = new HashMap<>();
	    String ceo="";
	    for(String emp : map.keySet())
	    {
	       String man = map.get(emp);
	       if(emp.equals(man))
	       {
	       	 ceo = emp;
	       }
	       else{
	       	   if(tree.containsKey(man))
	       	   {
	       	   	 HashSet<String> emps = tree.get(man);
	       	   	 emps.add(emp);
	       	   }
	       	   else{
	       	   	  HashSet<String> emps = new HashSet<>();
	       	   	  emps.add(emp);
	       	   	  tree.put(man,emps);
	       	   }
	       }
	    }
	    int TotalSize = getSize(tree,ans,ceo);

	    System.out.println(TotalSize);
	    return ans;
	}
	static int getSize(Map<String,HashSet<String>> tree, Map<String,Integer> ans, String ceo)
	{
		if(tree.containsKey(ceo) == false)
		{
			ans.put(ceo,0);
			return 1;
		}
		int sz =0;
		for(String emp : tree.get(ceo))
		{
			int si = getSize(tree,ans,emp);
			sz+=si; 
		}
		ans.put(ceo,sz);
		return sz+1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<String,String> mp = new HashMap<>();
		for (int i=0;i<n ;i++ ) {
			String str1 = sc.next();
		    String str2 = sc.next();
		    mp.put(str1,str2);
		}
		Map<String,Integer> ans = getans(n,mp);
        for (String key : ans.keySet()) {
        	System.out.println(key + " " + ans.get(key));
        }
	}
}