package 팔월9;

import java.util.Scanner;

public class 준홍이의카드놀이D3 {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.print("#"+test_case + " ");
            int K;
            if(N>=M){
                for(int i=M+1 ;i<=N+1;i++){
                    System.out.print(i + " ");
                }
            } else {
                for(int i=N+1 ;i<=M+1;i++){
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }
}
