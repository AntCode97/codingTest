package 구월15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합_실버2 {
    static int nums [] ;
    static boolean selected [] ;
    static int N;
    static int S;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N];
        selected = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }


        dfs(0, 0);
        //S가 0이면 부분집합이 공집합일 때도 COUNT되기 때문에
        //공집합인 경우는 세지 않기 위해 1을 빼준다.
        if(S == 0) count--;
        System.out.println(count);

    }
    static void  dfs(int idx, int sum){

        if(idx==N) {
            if (sum == S)
                count++;
            return;
        }
            sum += nums[idx];
            dfs(idx+1, sum);

            sum -= nums[idx];
            dfs(idx+1, sum);

    }
}
