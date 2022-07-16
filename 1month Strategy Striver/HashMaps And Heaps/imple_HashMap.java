// Here We implementing the HashMap in java 
import java.util.*;
import java.io.*;
class imple_HashMap{
	public static class HashMap<K,V>{
		private class HMnode{
			K key;
			V value;
			HMnode(K key, V val)
			{
				this.key = key;
				this.value = val;
			}
		}
	private int size;
	private LinkedList<HMnode> buckets[] ;
	public HashMap(){
		initbuckets(4);
		size=0;
	}
	private void initbuckets(int N){
		buckets = new LinkedList[N];
		for(int bi=0;bi<buckets.length;bi++)
		{
			buckets[bi] = new LinkedList<>();
		}
	}
	private int getIndexWithinBucket(K key,int bi)
	{
		int di=0;
		for(HMnode node : buckets[bi])
		{
			if(node.key.equals(key))
			{
				return di;
			}
			di++;
		}
		return -1;
	}

	private int hashfn(K key)
	{
		int hash =  key.hashCode();
		return Math.abs(hash) % buckets.length;
	}
	public void put(K key, V value) throws Exception{
		int bi =  hashfn(key);
		int di = getIndexWithinBucket(key,bi);
		if(di!=-1)
		{
			HMnode node = buckets[bi].get(di);
			node.value = value;
		}
		else{
			HMnode node = new HMnode(key,value);
			buckets[bi].add(node);
			size++;
		}
		double lamda = size * 1.0 / buckets.length;
		if(lamda > 2.0)
		{
			rehash();
		}
	} 
	private void rehash() throws Exception{
		LinkedList<HMnode>[] obl = buckets;
		initbuckets(obl.length * 2);
		for(int i=0;i<obl.length;i++)
		{
			for(HMnode node : obl[i])
			{
				put(node.key,node.value);
			}
		}
	}
	public boolean containsKey(K key)throws Exception{
		int bi =  hashfn(key);
		int di = getIndexWithinBucket(key,bi);
		if(di!=-1)
		{
			return true;
		}
		else{
			return false;
		}
	}

	public V get(K key) throws Exception{
		int bi =  hashfn(key);
		int di = getIndexWithinBucket(key,bi);
		if(di!=-1)
		{
			HMnode node = buckets[bi].get(di);
			return node.value;
		}
		else{
			return null;
		}
	}
	public V remove(K key)throws Exception{
		int bi =  hashfn(key);
		int di = getIndexWithinBucket(key,bi);
		if(di!=-1)
		{
			HMnode node = buckets[bi].remove(di);
			size--;
			return node.value;
		}
		else{
			return null;
		}
	}
	public int size()throws Exception{
		return size;
	}

	public ArrayList<K>  keyset() throws Exception{
		ArrayList<K> keys = new ArrayList<>();
		for(int i = 0 ;i< buckets.length ;i++){
			for(HMnode node : buckets[i])
			{
				keys.add(node.key);
			}
		}
		return keys;
	}
	public void display(){
		System.out.println("Display Begins:");
		for(int i=0;i<buckets.length;i++)
		{
			System.out.print("Bucket"+i+" ");
			for(HMnode node: buckets[i])
			{
				System.out.print(node.key+"@"+node.value + ",");
			}
			System.out.println(".");
		}
		System.out.println("Display Ends");
	}
}
	public static void main(String[] args) throws Exception{
		imple_HashMap obj = new imple_HashMap();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,Integer> mp = new HashMap();
        String str=br.readLine();

        while(str.equals("quit")==false)
        {
        	if(str.startsWith("put")){
        		String[] part = str.split(" ");
        		String k = part[1];
        		Integer v = Integer.parseInt(part[2]);
        		mp.put(k,v);
        	}

        	else if(str.startsWith("get")){
        		String[] part = str.split(" ");
        		String k = part[1];
        		System.out.println(mp.get(k));
        	}

        	else if(str.startsWith("remove"))
        	{
        		String[] part = str.split(" ");
        		String k = part[1];
        		System.out.println(mp.remove(k));
        	}
        	else if(str.startsWith("containsKey"))
        	{
        		String[] part = str.split(" ");
        		String k = part[1];
        		System.out.println(mp.containsKey(k));
        	}
        	else if(str.startsWith("size")){
        		System.out.println(mp.size());
        	}
        	else if(str.startsWith("display")){
        		mp.display();
        	}
        	str = br.readLine();
        }
	}
}