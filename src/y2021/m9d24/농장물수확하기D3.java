package y2021.m9d24;

import java.util.Scanner;

public class 농장물수확하기D3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int sum  =0;
            int farm [][] = new int[N][N];
            sc.nextLine();
            for(int i=0;i<N;i++){
                String s = sc.nextLine();
                for (int j=0;j<N;j++){

                    farm[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
                }
            }
            for(int i =1; i<=N/2+1;i++){
                for(int x =1;x<=2*i-1;x++){
             //       System.out.println((i-1) + " " +(N/2+x-i));
                    sum+=farm[i-1][N/2-i+x];

                }
            }
            //System.out.println("----------------");
            for(int i =N/2+1; i<N;i++){
                for(int x =0;x<2*(N-i)-1;x++){
             //       System.out.println((i) + " " +(i+x-N/2));
                    sum+=farm[i][i+x-N/2];

                }
            }


            System.out.println("#"+test_case + " " +sum);
        }
    }
}
