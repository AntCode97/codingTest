package 구월15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 용액_골드5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int idx=0 , jdx=0;


        int minV = Integer.MAX_VALUE;
        int i=0, j = N-1;
        for(i=0;i<N-1;i++){
            if(i==j) break;
            int tmp =  arr[i] + arr[j] ;
            //System.out.println(tmp + " " + i+ " "+ j);
            if(Math.abs(tmp) <minV){
                minV = Math.abs(tmp) ;
                idx = i;
                jdx =j;
//                if(tmp<0){
//                    i--;
//                    j--;
//                }
            }
            if(tmp>0){
                i--;
                j--;
            }
            if(tmp ==0) {
                idx = i;
                jdx =j;
                break;
            }
        }
        if(arr[idx] < arr[jdx])
        System.out.println(arr[idx]+ " " +arr[jdx]);
        else System.out.println(arr[jdx]+ " " +arr[idx]);
    }
}
