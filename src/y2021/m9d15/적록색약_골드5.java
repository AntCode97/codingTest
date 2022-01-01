package 구월15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 적록색약_골드5 {
    static char colors [][] ;
    static char colors2 [][] ;
    static boolean selected [] ;
    static int N;
    static int count=0;
    static int count2=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        colors = new char[N][N];
        //적록색맹용 배열
        colors2 = new char[N][N];


        for(int i=0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<N;j++){
                char c = line.charAt(j);
                colors[i][j] = c;
                //
                if(c == 'R' || c=='G')   colors2[i][j] ='R';
            }
        }
        //적록 생맹이 아닐때 구역 수를 구함
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(colors[i][j] != 'D'){
                    dfs(i, j, true);
                }
            }
        }
        System.out.print(count+" ");
        count = 0;
        //적록 생맹일 때 구역 수를 구함
        colors = Arrays.copyOf(colors2, N);
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(colors[i][j] != 'D'){
                    dfs(i, j, true);
                }
            }
        }
        System.out.println(count);

    }
    static int dc[] = {0, 1, 0, -1};
    static int dr[] = {1, 0, -1, 0};
    static void  dfs(int idx, int jdx, boolean start){

        char color = colors[idx][jdx];
        colors[idx][jdx] = 'D';
            for(int i=0;i<4;i++){
                int nc = idx+dc[i];
                int nr = jdx+dr[i];
                if(nc>=0 && nc<N && nr>=0 &&nr<N){
                    if(colors[nc][nr] == color){
                        dfs(nc, nr, false);
                    }
                }
            }

        if(start) count++;
    }

}
