package 십이월03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동철이의일분배_D4 {

    static boolean selected [] ;
    static int worked [];
    static int N;
    static double maxSum;
    static double works [][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = Integer.parseInt(br.readLine());
            works = new double[N][N];
            selected = new boolean[N];
            worked = new int[N];
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    works[i][j] = Double.parseDouble(st.nextToken())/100;
                }
            }
            maxSum=0;
            dfs(0, 0, 1);
            System.out.println("#"+test_case +" "+ String.format("%.6f", maxSum*100));
        }

    }

    static void dfs(int idx, int count, double sum){

            idx=idx;

            if(count==N){
                maxSum = Math.max(sum, maxSum);
                return;
            }

        if(sum < maxSum) {
            return;
        };

        for(int j=0;j<N;j++){
            // j가 아직 선택 안됐으면
            if(selected[j] || works[idx][j] ==0) continue;

            selected[j] = true;
            double sum2 = sum* works[idx][j];
            dfs(idx+1, count+1, sum2);
            selected[j] = false;


        }


    }
}
