package y2021.m8d25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 하나로_Prim_D4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int T = Integer.parseInt(bf.readLine());
        for(int tc =1 ;tc<=T ; tc++){
            int N = Integer.parseInt(bf.readLine());
            int [][] island = new int[N][2];
            for (int j=0;j<2;j++) {
                st = new StringTokenizer(bf.readLine());
                for (int i = 0; i < N; i++) {
                    island[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            double E = Double.parseDouble(bf.readLine());
            double[][] matrix = new double[N][N];
            double [] distance = new double[N];
            double [] edge = new double[N];

            boolean[] visited = new boolean[N];
            final int INFINITY = Integer.MAX_VALUE;
            int start=0;
            Arrays.fill(distance, Double.MAX_VALUE);
            Arrays.fill(edge, Double.MAX_VALUE);
            Arrays.fill(matrix, Double.MAX_VALUE);
            distance[start] = 0;
            edge[start] = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++){
                    matrix[i][j] = getDistance(island[i][0],island[i][1], island[j][0], island[j][1]);
                }
            }
            //System.out.println(Arrays.deepToString(matrix));
            double min =0;
            double result = 0;
            for(int i=0;i<N;i++){
                min =Double.MAX_VALUE;
                int current=-1;

                for(int j=0;j <N ; j++){
                    if(!visited[j] && distance[j] < min){
                        min = distance[j];
                        current = j;

                    }
                }
                visited[current] =true;
                result += min;

            for(int c=0; c<N; ++c){
                if(!visited[c] && matrix[current][c] != 0
                        &&  distance[c] > matrix[current][c]){
                    distance[c] = matrix[current][c];
                }
            }


            }

            double sum = 0;
            for(int i =0 ;i<N;i++){
                sum += edge[i];
            }
            System.out.println("#"+tc + " "+ Math.round(E*result));

        }
    }
    static double getDistance(int x, int y, int x2, int y2){
        return Math.pow(x-x2 , 2) +Math.pow(y-y2 , 2);
    }
}
