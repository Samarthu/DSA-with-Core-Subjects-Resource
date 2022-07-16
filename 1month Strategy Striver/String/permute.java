 // Permuatation of String and Array of number 
 import java.util.*;
 class permute{
 	static Set<String> hs=new HashSet<>();
 	static Set<String> hs1=new HashSet<>();
 	static void permuatation(String arr,int l,int r)
 	{	
    	if(l==r)
 		{
 			if(hs.contains(arr)) 
                return;
 			hs.add(arr);
 			System.out.println(arr);
 			return;
 		}
 		for (int i=l;i<=r; i++) {
 			arr=change(arr,l,i);
 			permuatation(arr,l+1,r);
 			arr=change(arr,l,i);
 		}
 	}
 	static String change(String a,int i,int j)
 	{
 		char char1[] =a.toCharArray();
        char temp=char1[i];
 		char1[i]=char1[j];
 		char1[j]=temp;
 		return String.valueOf(char1);
 	}
 	static List<List<Integer>> permuatationArray(int arr[])
 	{
 		List<List<Integer>> ans = new ArrayList<>();
 		List<Integer> res= new ArrayList<>();
 		boolean visited[] =new boolean[arr.length+1];
 		backTraku(ans,res,visited,arr);
 		return ans;
 	}
 	static void backTraku(List<List<Integer>> ans, List<Integer> res,boolean[] visited, int a[])
 	{
 		if(res.size() == a.length)
 		{
 			ans.add(new ArrayList<>(res));
 			return;
 		}
 		for(int i=0;i<a.length;i++)
 		{
 			if(visited[i]==true ) continue; // This Line is for avoiding the duplicates
 			res.add(a[i]);
 			visited[i]=true;
 			backTraku(ans,res,visited,a);
 			visited[i]=false;
 			res.remove(res.size()-1);
 		}
 	}
  static int[] change1(int a[],int i,int j)
  {
  	int tmp=a[i];
  	a[i]=a[j];
  	a[j]=tmp;
  	return a;
  }

 	public static void main(String[] args) {
 		String str ="abcc";
 		//permuatation(str,0,str.length()-1);
 		int arr[] = {1,2,3};
 		System.out.println(permuatationArray(arr));


 	}
 }