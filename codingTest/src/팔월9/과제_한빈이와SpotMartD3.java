package 팔월9;

import java.util.Scanner;

public class 과제_한빈이와SpotMartD3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test=1;test<=T;test++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int bag = 0;
            int MaxBag = 0;
            int snacks[] = new int[N];
            boolean visited [] = new boolean[N];
            int select[] = new int[2];
            for(int i=0;i<N;i++){
                snacks[i] = sc.nextInt();
            }
            for(int v = 0;v<N;v++){

                bag += snacks[v];
                for(int k=v+1;k<N;k++){
                    bag +=snacks[k];

                    if(MaxBag <bag && bag <=M ){
                        MaxBag = bag;
                    }
                    bag -=snacks[k];
                }
                bag -=snacks[v];
            }
            if(MaxBag ==0)
                MaxBag= -1;

            System.out.println("#" + test+ " "+MaxBag);
        }
    }



}
