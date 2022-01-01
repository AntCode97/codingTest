package 시월05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 우체국_플레티넘4 {
    static int V ;
    static int P ;
    static long L ;
    static long town[];
    static boolean selected[];
    static int answer[];
    static long distance[];
    static long minD ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            L = Long.parseLong(st.nextToken());
            town = new long[V];
            //각 마을에서 경찰서까지의 거리를 저장할 배열
            distance = new long[V];
            Arrays.fill(distance, Long.MAX_VALUE);
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<V ; i++){
                town[i] = Long.parseLong(st.nextToken());
            }

            selected = new boolean[V];
            // 각 마을에서의 거리 합이 최소가 되게하는 경찰서를 저장할 배열
            answer = new int[P];
            minD = Long.MAX_VALUE;
            dfs(0, 0);
            System.out.println(Math.round(minD));
            Arrays.sort(answer);

            for(int i=0;i<P;i++){
                System.out.print(town[answer[i]]+ " ");
            }

        }


    static void dfs(int idx, int count){
        //선택된 경찰서가 P개가 될 때까지 dfs 돌림
        if(idx == V && count ==P){
            int polices []= new int[V];
            //선택된 경찰서에서 각 마을에서 가장 가까운 경찰서를 알아내고
            //거리값을 구해서 distance배열에 저장
            for (int i=0;i<V;i++){
                for(int j=0;j<V;j++){
                    if(selected[j]){
                        long d = distance(town[i], town[j]);
                        if(distance[i] >=d ){
                            distance[i] = d;
                            polices[i] = j;
                        }
                    }
                }
            }

            // 최저값을 갱신할 수 있는 지확인
            int sum = 0;
            for(int i=0;i<V;i++){
                sum+=distance[i];
            }
            //최저값이 갱신되면
            if(sum < minD){
                minD = sum;
                Set<Integer> pol = new HashSet<>();
                for(int i=0;i<V;i++){
                    pol.add(polices[i]);
                }
                int pidx = 0;
                //마을과의 거리합이 최소가 되기하는 경찰서의 좌표값들을
                //answer배열에 담음음
                for(int p : pol){
                    answer[pidx] =  p ;
                    pidx++;
                }
            }
            Arrays.fill(distance, Long.MAX_VALUE);

            return;
        }
        if(idx >=V )return;

        //경찰서를 설치할 지점을 선택해가면서 dfs를 돌림
        selected[idx] = true;
        dfs(idx+1, count+1);
        selected[idx] = false;
        dfs(idx+1, count);
    }

    static long distance(long A, long B){
        //A와 B의 거리를 구함
        return Math.min(Math.abs(A-B), L - Math.abs(A-B));
    }
}
