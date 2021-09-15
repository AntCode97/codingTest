package 구월15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연속합_실버2 {
    static int [] nums = new int[11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr [] = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d [] = new int[n+1];
        Arrays.fill(d, -999999999);
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        d[1] = arr[1];
        for(int i =2 ;i<n+1;i++){
            d[i] = Math.max(d[i-1] + arr[i], arr[i]);
        }
        System.out.println(Arrays.stream(d).max().getAsInt());

    }
}
