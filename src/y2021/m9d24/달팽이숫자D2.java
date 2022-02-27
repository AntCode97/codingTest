package y2021.m9d24;

import java.util.Scanner;

public class 달팽이숫자D2 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int snail [][] = new int[N][N];
            int count2 =0;
            int N2 =N;
            int i =1;
            while(i<= N*N){



                int a = count2;
                while (i >= N2*count2 && a<N2-count2-1 && i <=N*N){
                    snail[count2][a++] = i++;

                }
                a =count2;
                while (i >= N2*(count2+1)-(count2+1) && a< N2 - count2 && i <=N*N){
                    snail[a++][N2-count2-1] = i++;
                }

                a = N2-count2-2 ;
                while (i >= N2*(count2+2)-(count2+1) && a >=count2 && i <=N*N ){
                    snail[N2-count2-1][a--] = i++;
                }


                a = N2-count2-2;
                while (i >= N2*(count2+3)-(count2+1) && a >count2 && i <=N*N){
                    snail[a--][count2] = i++;
                }

                count2++;


            }
            System.out.println("#" + test_case);
            for(i= 0; i<N;i++){
                for(int j=0;j<N;j++){
                    System.out.print(snail[i][j] + " ");
                }
                System.out.println("");
            }


        }
    }
}
