package 구월21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DP_가장큰증가부분수열_실버2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int D[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        D[0] = arr[0];
        // D[i] 는 arr[i]를 증가 수열에 포함시켰을 때, 최대합
        for(int i = 1;i<N;i++)
        {
            for(int j = 0;j<i;j++)
            {
                if(arr[j] <arr[i]){

                    D[i] = Math.max(D[i], D[j]);
                }
            }
            D[i] +=arr[i];
        }
        System.out.println(Arrays.toString(D));
        System.out.println(Arrays.stream(D).max().getAsInt());
    }
}
