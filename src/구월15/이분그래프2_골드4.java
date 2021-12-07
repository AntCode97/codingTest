package 구월15;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 이분그래프2_골드4 {
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
            adjList = new Node[V+1];
            visited = new boolean[V+1];
            E = Integer.parseInt(st.nextToken());

            for(int i = 0;i<E;i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjList[from] = new Node(to, adjList[from]);
                adjList[to] = new Node(from, adjList[to]);
            }
            able = true;
            bfs(1);
            for(int i=2;i<=V;i++){
                if(!visited[i]) bfs(i);
            }
            //한번이라도, 인접한 정점이 같은 색깔이면 NO
            if(able) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    private static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        //정점을 빨간색과 파란색으로 구분
        //빨간색이면 1, 파란색이면 -1
        colors = new int[V+1];

        queue.offer(start);
        colors[start] = 1;
        visited[start] =true;
        while (!queue.isEmpty()){
            int current = queue.poll();

            for (Node temp = adjList[current]; temp!=null; temp=temp.link){
                visited[temp.vertex] = true;
                //현재 정점과 연결된 점이 같은 색깔이면, 이분그래프가 아니므로
                //리턴
                if(colors[current] ==colors[temp.vertex]){
                    able = false;
                    return;
                }
                //현재 정점과 연결된 정점이 다른 색깔이 되도록함
                if(colors[temp.vertex] == 0){
                    colors[temp.vertex] = colors[current]*-1;
                    queue.offer(temp.vertex);
                }

                }
            }

        return;
        }

    }

