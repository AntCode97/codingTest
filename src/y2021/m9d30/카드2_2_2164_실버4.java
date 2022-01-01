package y2021.m9d30;

import java.util.Scanner;

public class 카드2_2_2164_실버4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer =N ;
        int count = 0;

        while (answer>1){
            count+=1;
           answer /=2;
        }

        int powN = (int) Math.pow(2, count);
        if(N == powN){
            System.out.println(N);
        } else {
            System.out.println((N%powN)*2);
        }


        }
}
