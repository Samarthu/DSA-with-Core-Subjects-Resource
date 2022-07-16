// Day2.1 Set Matrix to Zeros

import java.util.*;

class setMatrixtoZero{
// Most optimized way to solving the problem  Time complexity is  O(n*m + n*m) space Complexity is: O(1)
static void setZeroMatrix(int[][] arr){

int col0=1, rows=arr.length, cols=arr[0].length;

for(int i=0 ;i<rows;i++)
{
	if (arr[i][0]== 0 ) {
		col0=0;
	}
	for (int j=1;j<cols ;j++ ) {
		if(arr[i][j]==0){
			arr[i][0] = arr[0][j] = 0;
		}
		
	}
}
 
for(int i=rows-1 ;i >= 0;i--){
	for (int j=cols-1 ;j>= 1 ;j-- ) {

		if(arr[i][0] ==0 ||arr[0][j]==0)
		{
			arr[i][j]=0;
		}
	}	
	if(col0== 0) arr[i][0]=0;	
}
}

static void print(int arr[][])
{
  for(int i=0;i<arr.length;i++){
  	for (int j=0;j<arr[i].length;j++ ) {

  		System.out.print(arr[i][j]+" ");
  		
  	}
  	System.out.println();
  }
}
static int getSUm(int a[][])
{
	int sum = 0;
	for(int i = 0;i<a.length;i++)
	{
		for(int j = 0;j<a[0].length;j++)
		{
			if(a[i][j] != 0)
			{
				sum+=a[i][j];
			}
		}
	}
	return sum;
}
	public static void main(String[] args) {
		   Scanner sc = new Scanner(System.in);
		   int n = sc.nextInt();
		   int m = sc.nextInt();
		   int arr[][]=new int[n][m];
		   for(int i=0;i<n;i++)
		   {
		   	for(int j=0;j<n;j++)
		   	{
		   		arr[i][j] = sc.nextInt();

		   	}
		   }

		 System.out.println("----------------"		);
    int sum = getSUm(arr);
		System.out.println(sum);
    setZeroMatrix(arr);
		print(arr);
	  sum = getSUm(arr);
		System.out.println(sum);
		
	}
}