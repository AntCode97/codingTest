package 구월29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게으른백곰_실버4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int map []= new int[1000001];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[x] = w;
        }
        int sum =0;

        int max = Integer.MIN_VALUE;
        for(int i=0;i<map.length;i++){
            sum+=map[i];

            if(i>2*K){
                sum-=map[i-2*K-1];

            }
            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}
