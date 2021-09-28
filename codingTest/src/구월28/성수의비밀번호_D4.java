package 구월28;

import java.util.Scanner;

public class 성수의비밀번호_D4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int sum=0;
            int toggle = -1;
            for(int i=N; i>0 ;i--){
                toggle *= -1;
                long tmp = (long) (toggle* nCr(N, i,1000000007)*Math.pow(i,M) %1000000007);
                System.out.println(tmp);
                sum += tmp;
            }

            System.out.println("#"+test_case+ " " +sum);
        }
    }

    static long power(long x, long y, long p){
        long res = 1L;
        x = x % p;

        while (y > 0) {
            if( y % 2 == 1)
                res = (res * x) % p;
            y = y >> 1;
            x = (x*x)%p;
        }
        return res;
    }

    static long nCr(int n, int r, int p){
        if (r==0) return 1L;
        long [] fac = new long[n+1];
        fac[0] = 1;

        for(int i = 1; i <= n ;i++)
            fac[i] = fac[i-1] * i % p;

        return (fac[n]*power(fac[r], p-2, p)
        % p * power(fac[n-r], p-2, p)%p
        )%p;
    }
}
