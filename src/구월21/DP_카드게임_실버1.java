package 구월21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DP_카드게임_실버1 {
    static int DP [][];
    static int [] left;
    static int [] right;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
//        Queue<Integer> left = new LinkedList<>();
//        Queue<Integer> right  = new LinkedList<>();
        left = new int[N+1];
        right = new int[N+1];
        DP = new int[N+1][N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N; i++){
//            left.add(Integer.parseInt(st.nextToken()));
            left[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N; i++){
//            right.add(Integer.parseInt(st.nextToken()));
            right[i] =Integer.parseInt(st.nextToken());

        }
        for(int i=0;i<=N;i++){
            Arrays.fill(DP[i], -1);
        }

        System.out.println(draw(1, 1));

    }
    static int draw(int l, int r){
        if(l > N || r > N ) return 0;
        if(DP[l][r] != -1 ) return DP[l][r];
        DP[l][r] = 0;
        //왼쪽 보다 오른쪽이 클때
        DP[l][r] = Math.max(draw(l+1, r), draw(l+1, r+1));
        if (left[l] > right[r])
            DP[l][r] =  Math.max(draw(l, r+1) + right[r],DP[l][r]);

        return DP[l][r];
    }
}
