package 팔월17;

import java.util.Scanner;

public class 백준_설탕배달_브론즈1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int min = Integer.MAX_VALUE;
        for(int a=0; a<=N/5;a++){
            for(int b=0;b<=N/3;b++){
                if(a*5 +b*3 ==N){
                    min = Math.min(min, a+b);
                }
            }
        }
        if(min!=Integer.MAX_VALUE)
            System.out.println(min);
        else System.out.println(-1);
    }
}
