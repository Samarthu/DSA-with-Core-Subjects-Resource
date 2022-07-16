// Game theory questions

class MaxCoins{
	static  int maxCoins_Count(int a[],int i,int j)
	{
		if(i+1 == j || i==j)
		{
			return Math.max(a[i],a[j]);
		}

		return Math.max(a[i] + Math.min(maxCoins_Count(a,i+2,j),maxCoins_Count(a,i+1,j-1)),
			a[j] + Math.min(maxCoins_Count(a,i+1,j-1),maxCoins_Count(a,i,j-2)));
			
	}
	public static void main(String[] args) {
		int arr[] ={1,2,3,6,4,5};

		System.out.println(maxCoins_Count(arr,0,arr.length-1));
	}
	
}


