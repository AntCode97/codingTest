package 구월29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소가길을건넌이유5_실버2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int light[] = new int[N+1];
        int min = Integer.MAX_VALUE;
        for(int i=0;i<B;i++){
            light[Integer.parseInt(br.readLine())]++;
        }
        int sum=0;
        for(int i=1;i<=N;i++){

            if(i>K){
                min = Math.min(min, sum);
                sum-=light[i-K];
            }
                sum+=light[i];

        }
        min = Math.min(min, sum);
        System.out.println(min);

    }
}
