package 팔월11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도영이가만든맛있는음식_2961_실버1 {
    static int cnt=1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        int ings[][] = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            ings[i][0] = Integer.parseInt(st.nextToken());
            ings[i][1] = Integer.parseInt(st.nextToken());
        }
        cnt=1000000000;
        powerSum(0, 1, 0, ings, N);
        System.out.println(cnt);
    }
    static void powerSum(int idx, int sour,int bitter, int[][] ings, int N) {

        if( idx == N ) {
            return;
        }


        sour*=ings[idx][0];
        bitter+=ings[idx][1];
        if(cnt>Math.abs(bitter-sour)){
            cnt = Math.abs(bitter-sour);
        }
        powerSum(idx + 1, sour, bitter, ings,N);
        sour/=ings[idx][0];
        bitter-=ings[idx][1];
        powerSum(idx + 1, sour, bitter, ings,N);
    }
}
