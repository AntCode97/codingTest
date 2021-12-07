package 팔월5;

import java.util.Scanner;

public class 부분집합2 {
    static int N, totalCnt, S;
    static  int []input;
    static boolean[] isSelected ;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        input = new int[N];
        isSelected = new boolean[N];
        totalCnt = 0;

        for(int i=0;i<N;i++){
            input[i] = sc.nextInt();
        }
        generateSubset(0);
        System.out.println("경우의 수: "+ totalCnt);
    }
    private static void generateSubset(int cnt){ // cnt : 부분집합을 처리하기 위해 고려된 원소수

        if(cnt == N){
            //부분 집합 완성

            //부분집합의 합을 계산
            int sum= 0;
            for(int i =0 ;i<N;i++){
                if(isSelected[i]) sum += input[i];
            }
            if(sum ==S){
                totalCnt++;
                for(int i =0;i<N;i++){
                    System.out.print((isSelected[i] ? input[i] : "X")+" ");
                }
                System.out.println();
            }
            return;
        }


        //현재 원소를 부분집합에 넣기
        isSelected[cnt] = true;
        generateSubset(cnt+1);
        //현재 원소를 부분집합에 넣지 않기
        isSelected[cnt] = false;
        generateSubset(cnt+1);

    }

}
