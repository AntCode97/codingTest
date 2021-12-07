package 구월15;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 이분그래프_골드4 {
    static Node[] adjList;
    static int V;
    static int E;
    static boolean able = true;
    static int[] colors;
    static boolean[] visited;
    static List<Integer>[] adj;
    static class Node{
        int vertex;
        Node link;
        public Node(int vertex, Node link){
            this.vertex = vertex;
            this.link = link;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "vertex=" + vertex +
                    ", link=" + link +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for(int tc =0;tc<K;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            //adjList = new Node[V+1];
            adj = new LinkedList[V+1];
            visited = new boolean[V+1];
            for (int i = 1; i < V+1; i++)
                adj[i] = new LinkedList<>();

            E = Integer.parseInt(st.nextToken());
            for(int i = 0;i<E;i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adj[from].add(to);
                adj[to].add(from);
//                adjList[from] = new Node(to, adjList[from]);
//                adjList[to] = new Node(from, adjList[to]);
            }
            able = true;
            bfs(1);
            for(int i=2;i<=V;i++){
                if(!visited[i]) bfs(i);
            }
            if(able) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    private static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();

        colors = new int[V+1];

        queue.offer(start);
        int togle = 1;
        colors[start] = 1;
        visited[start] =true;
        while (!queue.isEmpty()){
            int current = queue.poll();
          //  togle*=-1;


         //   System.out.print(colors[current]+"현재:" + current + "-> " );
            for (int temp : adj[current]){
                visited[temp] = true;
                if(colors[current] ==colors[temp]){
           //         System.out.println("싸이클" +current +" "+temp);
                    able = false;
                    return;
                }
                if(colors[temp] == 0){
                    colors[temp] = colors[current]*-1;
                    queue.offer(temp);
                }

                }
            }
        //    System.out.println("끝");
        return;
        }

    }

