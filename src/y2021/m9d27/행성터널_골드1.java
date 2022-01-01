package 구월27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 행성터널_골드1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int V = Integer.parseInt(bf.readLine());
        Node [] planets = new Node[V];
        boolean visited [] = new boolean[V+1];
        List<Tunnel>[] adjList = new ArrayList[V];


        for(int i=0;i<V;i++){
            st = new StringTokenizer(bf.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z =Integer.parseInt(st.nextToken());
            planets[i] =new Node(x,y,z, i);
            adjList[i] = new ArrayList<>();
        }

       // Arrays.sort(planets);
       // System.out.println(Arrays.toString(planets));
        Queue<Tunnel> queue = new PriorityQueue<>();
        Arrays.sort(planets, new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.x, o2.x);
            }
        });
        for(int i =0;i <V-1;i++){
            adjList[planets[i].idx].add(new Tunnel( planets[i+1].idx, Math.abs(planets[i].x - planets[i+1].x)));
            adjList[planets[i+1].idx].add(new Tunnel( planets[i].idx, Math.abs(planets[i].x - planets[i+1].x)));
           // queue.add(new Tunnel(planets[i].idx, planets[i+1].idx, Math.abs(planets[i].x - planets[i+1].x)));
        }
        Arrays.sort(planets, new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.y, o2.y);
            }
        });
        for(int i =0;i <V-1;i++){
            adjList[planets[i].idx].add(new Tunnel( planets[i+1].idx, Math.abs(planets[i].y - planets[i+1].y)));
            adjList[planets[i+1].idx].add(new Tunnel( planets[i].idx, Math.abs(planets[i].y - planets[i+1].y)));
          //  queue.add(new Tunnel(planets[i].idx, planets[i+1].idx, Math.abs(planets[i].y - planets[i+1].y)));
        }
        Arrays.sort(planets, new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.z, o2.z);
            }
        });

        for(int i =0;i <V-1;i++){
            adjList[planets[i].idx].add(new Tunnel( planets[i+1].idx, Math.abs(planets[i].z - planets[i+1].z)));
            adjList[planets[i+1].idx].add(new Tunnel( planets[i].idx, Math.abs(planets[i].z - planets[i+1].z)));
        }
        //확보된 정점의 수
        int cnt = 1;
        int result = 0;
        visited[0] = true;
        queue.addAll(adjList[0]);

        while(cnt != V && !queue.isEmpty()){

            Tunnel t =  queue.poll();
            if(visited[t.to] ) continue;
            visited[t.to] = true;
            result += t.w;
            queue.addAll(adjList[t.to]);
            cnt++;

        }
        System.out.println(result);

    }

    static class Node {

        int x;
        int y;
        int z;
        int idx;

        public Node(int x, int y, int z, int idx) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.idx = idx;

        }


    }
    static class Tunnel implements Comparable<Tunnel>{
        int to;
        int w;

        public Tunnel(int to, int w) {
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Tunnel o) {
            return Integer.compare(this.w, o.w);
        }
    }

}
