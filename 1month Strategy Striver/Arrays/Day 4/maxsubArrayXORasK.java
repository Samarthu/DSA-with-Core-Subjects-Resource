//maxsubarray with xor for K
import java.util.*;
class maxsubArrayXORasK{

	static int maxsubArrayXORasK_fun(int a[], int k){
		Map<Integer,Integer> freq = new HashMap<Integer,Integer>();
		int xor =0, cnt=0;
		for (int i=0;i<a.length ;i++ ) {
			xor = xor^a[i];

			if(freq.get(xor^k)!=null){
				cnt+=freq.get(xor^k);
				System.out.print(cnt + ":"+i+" ");
			}
			if(xor==k){
				cnt+=1;
				System.out.println();
				System.out.print(cnt + ":"+i+" " );
			}

			if(freq.get(xor)!=null){
				freq.put(xor,freq.get(xor)+1);
			}
			else
			{
				freq.put(xor,1);
			}
		}
		System.out.println();
		System.out.println(freq);
		return cnt;

	}
	
	public static void main(String[] args) {

		int arr[] ={2,4,4,6,2,5,7};
		int k = 6;
		int cnt= maxsubArrayXORasK_fun(arr,k);
		System.out.println(cnt);
		
	}
}