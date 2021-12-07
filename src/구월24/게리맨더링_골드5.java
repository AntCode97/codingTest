package 구월24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게리맨더링_골드5 {
    static int N;
    static boolean selected [];
    static boolean visited [];
    static int adjList [][];
    static int map[];
    static int Tcount;
    static int Fcount;
    static int minCount ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        adjList = new int[N+1][];
        selected = new boolean[N+1];
        visited = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        map = new int[N+1];
        for(int i=1;i<=N;i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            adjList[i] = new int[k+1];
            for(int j=1;j<=k;j++){
                adjList[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        minCount = Integer.MAX_VALUE;
        if(N==2){
            System.out.println(Math.abs(map[1] - map[2]));
            return;
        }
        dfs(1, 1);
        if(minCount == Integer.MAX_VALUE) System.out.println(-1);
        else  System.out.println(minCount);

    }
    static void dfs(int idx, int depth){
        //System.out.println(idx);
        if(idx == N+1){
            //선택한 구역이 인접한 지 체크
            boolean T = check(true);
            boolean F = check(false);
         //   System.out.println(T + " " +F);
            if(T && F && Tcount+Fcount ==N){
                int Tsum =0;
                int Fsum = 0;
                for(int i=1;i<=N;i++){
                    if(selected[i]){
                  //      System.out.print(i+ " ");
                        Tsum += map[i];
                    } else{
                        Fsum += map[i];
                    }
                }
              //  System.out.println();
                minCount = Math.min(minCount, Math.abs(Tsum-Fsum));
           //   System.out.println("최소" + minCount);
            }


            return;
        }


                selected[idx] =true;
                dfs(idx+1, depth+1);
                selected[idx] =false;
                dfs(idx+1, depth+1);

//        for(int i=1;i<adjList[idx].length;i++){
//            if(!visited[adjList[idx][i]]){
//                visited[adjList[idx][i]] = true;
//                selected[adjList[idx][i]] =true;
//                dfs(adjList[idx][i], depth+1);
//                selected[adjList[idx][i]] =false;
//                dfs(adjList[idx][i], depth+1);
//                visited[adjList[idx][i]] = false;
//            }
//
//        }

    }
    static boolean check(boolean ch){
        boolean able[] = new boolean[N+1];
        visited = new boolean[N+1];
        int count  =0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=N;i++){
            if(selected[i] ==ch){
                able[i] = true;
                queue.add(i);
                break;
            }
        }
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for(int i=1;i<adjList[cur].length;i++){
                if(selected[adjList[cur][i]] == ch && !able[adjList[cur][i]]){
                    able[adjList[cur][i]] = true;
                    queue.add(adjList[cur][i]);
                }
            }
        }
        for(int i=1;i<=N;i++){
            if(selected[i] ==ch){
                count++;
                if(!able[i]) return false;
            }
        }
        if(count==N) return false;
        if(ch) Tcount=count;
        else Fcount =count;

        return true;
    }
    static int dr [] = {0,0,1,-1};
    static int dc [] = {1,-1,0,0};

    static class Node{
        int r;
        int c;
        int day;
        public Node(int r, int c, int day) {
            this.r = r;
            this.c = c;
            this.day = day;
        }


    }
}
