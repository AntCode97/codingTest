package 구월21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DP_가장긴바이토닉부분수열_골드3 {

    static int [] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        int [] DL = new int[N + 1];
        int [] DR = new int[N + 1];
//        Arrays.fill(DL, 1);
//        Arrays.fill(DR, 1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for(int i=1;i<=N;i++){
            DL[i] = 1;
            for(int j=1;j<i;j++) {
                if(arr[j] < arr[i] && DL[i] < DL[j]+1)
                    DL[i] = DL[j]+1;
               // else DL[i]= DL[i-1];
            }
            if(max<DL[i]) max = DL[i];
        }
        max=0;
        for(int i=N;i>=1;i--){
            DR[i] = 1;
            for(int j=N;j>i;j--)
                if(arr[i] > arr[j] && DR[i] < DR[j]+1)
                    DR[i] = DR[j]+1;
               // else DR[i]= DR[i-1];
        }
        max=0;

        for(int i=1;i<=N;i++)
            if(max < DL[i]+DR[i])
                max = DL[i]+DR[i];

        System.out.println(max-1);
    }
}
