package 구월15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 먹을것인가_먹힐것인가_실버3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc =0;tc<T;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N =Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int A[] = new int[N];
            int B[] = new int[M];

           st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++){
                B[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);
            Arrays.sort(B);
            int count =0;
            int i = N-1;
            int j = M-1;
            for(;i>=0;i--){
                if(j==-1) break;
                if(A[i]<=B[j]){
                    i++;
                    j--;

                } else  count+=(j+1);
            }

            System.out.println(count);
    }
    }
}
