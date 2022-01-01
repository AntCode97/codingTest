package y2021.m8d06;

import java.util.LinkedList;
import java.util.Scanner;

public class 퍼펙트셔플D3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test=1;test<=T;test++){
            int N = sc.nextInt();
            LinkedList<String> A = new LinkedList<>();
            LinkedList<String> B = new LinkedList<>();
            LinkedList<String> C = new LinkedList<>();

            for(int i=0; i<N;i++){
                String a = sc.next();

                if((i+1) <= (N+1)/2){
                    //System.out.println("A" + " "+ a);
                    A.add(a);
                } else{
                    //System.out.println("B" + " " +a);
                    B.add(a);
                }

            }
            for(int i=0;i<(N+1)/2 ;i++){
                String card = A.poll();
                String card2 = B.poll();
                if(card != null)
                C.add(card);
                if(card2 !=null)
                C.add(card2);
                //System.out.println(card + card2);
            }
            System.out.print("#" + test + " ");
            for (int i=0;i<N;i++){
                String s = C.poll();
                if(s != null)
                    System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
