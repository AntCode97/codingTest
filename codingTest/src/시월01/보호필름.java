package 시월01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 보호필름 {
    static int D,W,K;
    static int [][] map;
    static int selected[];
    static int m; //약물 사용 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            m = Integer.MAX_VALUE;
            map= new int[D][W];
            selected = new int[D];
            Arrays.fill(selected, 2);
            for(int i=0;i<D;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<W;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(0,0);
            System.out.println("#"+tc + " " + m);
        }

    }
    static void dfs(int row, int count){

        if(check()){
            m = Math.min(m, count);
        }
        if(count >= m || row ==D) return;
       // int tmp [] = Arrays.copyOf(map[row], W);
        int tmp[] = new int[W];
        for(int i=0;i<W;i++){
            tmp[i] = map[row][i];
        }
        dfs(row+1, count);
        Arrays.fill(map[row], 0);
        dfs(row+1, count+1);
        Arrays.fill(map[row], 1);
        dfs(row+1, count+1);
        //map[row] = Arrays.copyOf(tmp, W);
        for(int i=0;i<W;i++){
            map[row][i] = tmp[i];
        }

//        if(count >= m) return;
//        if(idx ==D){
//            int film2 [][] = new int[D][W];
//            for(int i=0;i<D;i++){
//                if(selected[i]==2) film2[i] = Arrays.copyOf(map[i], W);
//                else if(selected[i]==1) Arrays.fill(film2[i], 1);
//                else Arrays.fill(film2[i], 0);
//            }
//            if(check(film2)){
//                m = Math.min(m, count);
//            }
//            return;
//        }



    }
    static boolean check(){
        int [] start = Arrays.copyOf(map[0], W);
        int count [] = new int[W];
        int answer =0;
        boolean pass ;
        Arrays.fill(count, 1);

        for(int j = 0; j< W; j++){
            pass = false;
            for(int i =1; i<D;i++){
                if(map[i][j] == start[j]){
                    count[j]+=1;
                } else{
                    start[j] = map[i][j];
                    count[j] =1;
                }
                if(count[j] >=K) {
                    pass = true;
                    break;
                }
            }
            if(!pass) return false;
        }

        return true;
    }
    static boolean check(int [][] film){
        int [] start = Arrays.copyOf(film[0], W);
        int count [] = new int[W];
        int answer =0;
        boolean pass ;
        Arrays.fill(count, 1);

        for(int j = 0; j< W; j++){
            pass = false;
            for(int i =1; i<D;i++){
                if(film[i][j] == start[j]){
                    count[j]+=1;

                } else{
                    start[j] = film[i][j];
                    count[j] =1;
                }
                if(count[j] >=K) {
                    pass = true;
                    break;
                }
            }
            if(!pass) return false;
        }

        return true;
    }
}
