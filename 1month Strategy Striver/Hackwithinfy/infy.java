import java.util.*;
class infy{
    public static int getAns(int n, int[] a)
    {
        int ans= 0;
        for(int i=0;i<n;i++)
        {
            ans+= a[i] * (int) Math.pow(10,i+1);
        }
        return ans;
    }
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i= 0;i<n;i++){
          a[i] = sc.nextInt();
      }
      int [] na = new int[n];
      int j =0,p=n-1;
      for(int i= 0;i<n;i++){
          if(i% 2 == 0)
          {
            na[i] = a[p--];
          }
          else{
            na[i] = a[j++];
          }
      }
      System.out.println(Arrays.toString(na));
     ///int djn[] = {2,2,1,6};
      int ans = getAns(n,na);
      System.out.println(ans);
    }
   
}


