package 팔월13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_치킨_배달_15686_골드5 {
    static boolean sel[];
    static int minSum = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int city [][] = new int[N][N];
        int house[][] = new int[2*N][2];
        int chicken [][] = new int[13][2];
        int hidx =0;
        int cidx=0;
        for(int i=0;i<N ;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                int k = Integer.parseInt(st.nextToken());
                if(k==1){
                    house[hidx][0] = i;
                    house[hidx++][1] = j;
                } else if(k==2){
                    chicken[cidx][0] = i;
                    chicken[cidx++][1] = j;
                }
                city[i][j] = k;
            }
        }
        sel = new boolean[cidx];
        powerSet(0, M, 0,cidx,hidx,house, chicken);

        System.out.println(minSum);
    }

    static int distance(int hi, int hj, int ci, int cj){
        return Math.abs(hi-ci) + Math.abs(hj-cj);
    }
    static void powerSet(int idx, int M, int count, int cidx, int hidx, int[][]house, int[][] chicken) {
        if((count == M || idx ==cidx) ) {
            if(count==0)
                return;

            int mSum = 0;
            for(int h=0;h<hidx;h++){
                int min = Integer.MAX_VALUE;
            for(int i = 0; i < cidx; i++) {
                if(sel[i]){
                            int d = distance(house[h][0], house[h][1], chicken[i][0], chicken[i][1]);
                            if(min>d){
                                min = d;
                            }
                    }
                }
                mSum+=min;
                //System.out.println(mSum);
            }
            if (mSum!=0 && mSum<minSum){
                minSum=mSum;
            }
            return;
        }
        sel[idx] = true;
        count++;
        powerSet(idx + 1, M, count,cidx,hidx,house, chicken);
        sel[idx] = false;
        count--;
        powerSet(idx + 1, M, count,cidx,hidx,house, chicken);
    }
}
