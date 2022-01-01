package y2021.m8d20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_색종이붙이기_골드2 {
    static int map[][];
    static int paper[] = new int[]{5,5,5,5,5};
    static int count = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        map = new int[10][10];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=0;i<10;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j =0;j<10;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        btr(0, 0);
        if(count == Integer.MAX_VALUE)
            System.out.println(-1);
        else System.out.println(count);

    }
    static void btr(int r, int used){
        //가지치기
        if(used>=count) return;

        int ridx = -1, cidx =-1;
        //1이 있는 부분을 찾음
        for(int i =r ; i<10;i++){
            for(int j=0 ; j<10;j++){
                if(map[i][j] ==1) {
                    ridx = i;
                    cidx = j;
                    break;
                }
            }
            if(ridx != -1) break;
        }
        //1이 없으면 함수 종료 //기저 조건
        if(ridx == -1) {

            count = Math.min(count, used);
            return;
        }
        //덮을 수 있는 가장 큰 색종이를 찾음
        for(int p =4;p>=0;p--){
            boolean canpaper =true;
            if(ridx + p <10 && cidx + p <10 ){
            for(int i = ridx; i<=ridx + p ;i++){
                for(int j = cidx; j<=cidx + p ;j++){

                    if(map[i][j] ==0){
                        //System.out.println("못 덮음" + p + " " +i+" "+ j);
                        canpaper = false;
                        break;
                    }
                }
            }} else canpaper =false;
            if(canpaper){

                    //색종이로 덮음
                    if(paper[p]>=1) {
                        paper[p] -= 1;
                        for(int i = ridx; i<=ridx + p ;i++){
                            for(int j = cidx; j<=cidx + p ;j++){
                                map[i][j] = 0;
                            }
                        }
                            btr(ridx,used+1);
                            paper[p] += 1;
                            // 색종이 제거
                            for (int i = ridx; i <= ridx + p; i++) {
                                for (int j = cidx; j <= cidx + p; j++) {
                                    map[i][j] = 1;
                                }
                            }
                    }
            }
        }


    }
}
