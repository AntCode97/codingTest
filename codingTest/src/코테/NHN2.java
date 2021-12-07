package 코테;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NHN2 {
    static List<Integer> attack = new ArrayList<>();
    static int selected[] ;
    static int answer = 0;
    private static void solution(int NR, int NA, int [][]fq){
        selected = new int[NA];
    //    System.out.println(NR + NA);
    //    System.out.println(Arrays.deepToString(fq));
        dfs(0, 0, NR, NA, fq);
        System.out.println(answer);
    }

    static void dfs(int cnt, int start, int NR, int NA, int[][] fq){
        if(cnt == NA){

            int count = 0;
            int [][] ffq = new int[NR][];
            for(int i=0;i<NR;i++){
                ffq[i] = new int[fq[i].length];
                for(int j=0;j<fq[i].length;j++){
                    ffq[i][j] = fq[i][j];
                }
            }

            for(int i=0;i<NR;i++){
                for(int j=0;j<NA;j++){
                    for(int k=0;k<fq[i].length;k++){
                        if(ffq[i][k] == selected[j]){
                            count++;
                            ffq[i][k] = -1;
                            break;
                        }
                    }
                }
            }

            answer = Math.max(answer, count);
            return;
        }
        for(int i=start;i<=20;i++){
            selected[cnt] = i;
            dfs(cnt+1, i+1, NR, NA, fq);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int NA = Integer.parseInt(st.nextToken());
        int[][] fq = new int[N][];
        for(int i=0;i<N;i++){
            String line = br.readLine();
            String [] tmp = line.split(" ");
            fq[i] = new int[tmp.length];
            for(int j=0;j<tmp.length;j++){
                fq[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        solution(N, NA, fq);

    }

}
