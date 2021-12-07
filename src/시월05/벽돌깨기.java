package 시월05;

import java.util.Scanner;

public class 벽돌깨기 {
    static int N;
    static int W;
    static int H;
    static int selected[];
    static int map[][] ;
    static int blocks[][];
    static int bCnt = 0;
    static int maxCnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            W = sc.nextInt();
            H = sc.nextInt();
            selected = new int[N];
            blocks = new int[H][W];
            for(int i=0; i<H;i++){
                for(int j=0; j<W;j++){
                    blocks[i][j] = sc.nextInt();
                }
            }
            maxCnt=Integer.MAX_VALUE;
            dfs(0);
            System.out.println("#" + test_case + " " + maxCnt);

        }
    }
    private static void dfs(int cnt){
        if(cnt == N){
            bCnt = 0;
            map = new int[H][W];
            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++){
                    int tmp =  blocks[i][j];
                    map[i][j] =tmp;
                }

            }
//            for(int i=0;i<N;i++){
//                System.out.print(selected[i] + " ");
//            }
//            System.out.println();
//            print();
            for(int i=0;i<N;i++){

                int b = map[0][selected[i]];
                int height = 0;
                while (b <=0 && height<H-1){
                    b = map[++height][selected[i]];
                }
                //부수기
                crash(height, selected[i]);
                //빈칸제거
                removeBlank();
          //      print();
            }
            int result = getRemain(map);
           // System.out.println(result);
            maxCnt = Math.min(maxCnt, result);
            return;
        }

        for(int i=0;i<W;i++){
            selected[cnt] =i;
            dfs(cnt+1);
        }

    }

    private static int getRemain(int[][] map) {
        int count =0;
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                if(map[i][j] > 0) count++;
            }
        }
        return count;
    }

    private static void removeBlank() {
        for (int j=0;j<W;j++){
            int start = H-1;
            while (start > 0){
                if(map[start][j] ==0){//빈칸이면 벽돌 내리기
                    int nr = start-1;
                    while (nr > 0 && map[nr][j] ==0) nr--;
                    map[start][j] = map[nr][j]; //윗칸 벽돌 내리기
                    map[nr][j] = 0;
                }
                --start;
            }
        }
    }

    static void crash(int idx, int jdx) {
        // 벽돌 좌표, idx, jdx 깨기
        int size = map[idx][jdx];
        map[idx][jdx] = 0;
        if(size ==1 || size ==0) return;
        for(int i= idx-(size-1); i<=idx+(size-1);i++){
            if(i <0 || i>= H) continue;
            if(map[i][jdx] ==1 ) {
                map[i][jdx] = 0;
            }
            else crash(i, jdx);
        }
        for(int j=jdx-(size-1);j<=jdx+(size-1);j++){
            if(j < 0 || j>=W) continue;
            if(map[idx][j] ==1) {
                map[idx][j] = 0;
            }
            else crash(idx, j);
        }
    }

    static void print(){
        for(int i=0;i < H ;i++){
            for(int j=0;j<W;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=================================");
    }
}
