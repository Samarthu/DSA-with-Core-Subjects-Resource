// Remove PrimeNumbers from ArrayList
import java.util.*;
class RemovePrimeInArrayList{
	static boolean isPrime(int idx)
	{
	   boolean isPri = true;
	   for (int div=2; div*div<=idx ; div++) {
	   	  if( idx % div == 0)
	   	  {
	   	  	isPri = false;
	   	  	break;
	   	  }
	   }
	   return isPri;
	}
	static ArrayList<Integer>getRemovedPrimeNoInArr(ArrayList<Integer>a)
	{
		for(int i = a.size()-1 ; i >=0 ; i--)
		{
	        int idx = a.get(i);
	        if(isPrime(idx))
	         {
	         	a.remove(i);
	         }			
		}
		return a;
	}
	static ArrayList<Integer> removeOdds(ArrayList<Integer>a)
	{
		for(int i=a.size()-1;i>=0;i--)
		{
			if(a.get(i)%2 != 0)
			{
				a.remove(i);
			}
		}
		return a;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int  n = sc.nextInt();
	    ArrayList<Integer> arr = new ArrayList<>();
	    while(n--!=0)
	    {
	    	arr.add(sc.nextInt());
	    }
	    System.out.println(arr);
	   	ArrayList<Integer> newArr = getRemovedPrimeNoInArr(arr);
	   	System.out.println(newArr);
	   //System.out.println(removeOdds(arr));
	}
}