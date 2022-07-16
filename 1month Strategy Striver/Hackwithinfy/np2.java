import java.util.*;
class np2 {
    static ArrayList<Integer> np = new ArrayList<>();
    static boolean isprime(Integer a)
    {
        if(a == 0 || a == 1) return false;
        for(int i=2;i<=a/2 ;i ++)
        {
            if(a%i == 0){
                return false;
            }
        }
        return true;
    }
    static int prime_count(List<Integer> A){
        int cnt = 0;
        for (Integer a: A){
            if(isprime(a)){
                cnt++;
            }
            else{
                np.add(a);
            }
        }
        return cnt;
    }
   
    public static int solve(int n, List<Integer> A){
        int cnt1 = prime_count(A);
        if(cnt1 == n) return cnt1;
       
        for(Integer a : A){
            if(np.contains(a)){
                int i = A.indexOf(a);
                A.set(i,a+1);
                int ci = prime_count(A);
                if(ci > cnt1){
                    cnt1= ci;
                }
            }
        }
        return cnt1;
   }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> A =new ArrayList<>();
        for(int i= 0;i<n;i++){
            A.add(sc.nextInt());
        }
        int ans = solve(n,A);
        System.out.println(ans);
    }
}
