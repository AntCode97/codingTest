package 구월28;

import java.util.Scanner;

public class 조합_D3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        power(2, 5, 1000000007);
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int R = sc.nextInt();

            System.out.println("#"+test_case+ " " +nCr(N,R,1234567891));
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
