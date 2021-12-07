package 구월27;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 도시분할계획_크루스칼_골드4 {
    static int N;
    static int[] parents; // 부모원소를 관리(트리처럼 사용)
    private static void make() {
        // 모든 원소를 자신을 대표자로 만듦
        for(int i =0;i<=N;i++){
            parents[i] = i;
        }
    }
    //a가 속한 집합의 대표자 찾기
    private static int find(int a) {
        if(a == parents[a]) return a; // 자신이 대표자
        return parents[a] = find(parents[a]); // 자신이 속한 집합의 대표자를 자신의 부모로 : path compression
    }
    //두 원소를 하나의 집합으로 합치기(대표자를 이용해서 합침)
    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false; // 이미 같은 집합이므로 합치지 않음
        parents[bRoot] = aRoot;
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int V = Integer.parseInt(st.nextToken());
        N=V;
        parents= new int[V+1];
        int E = Integer.parseInt(st.nextToken());
        Node [] adjList = new Node[E];
        boolean visited [] = new boolean[V+1];


        for(int i=0;i<E;i++){
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight =Integer.parseInt(st.nextToken());
            adjList[i] = new Node(from, to, weight);

        }

        Arrays.sort(adjList);

        //확보된 정점의 수
        int cnt = 1;
        int result =0;
        int maxW = Integer.MIN_VALUE;
        //모든 정점을 확보할 때까지
        make();
        for(Node edge : adjList) {
            if(union(edge.from, edge.to)){
                result += edge.weight;
                maxW = Math.max(maxW, edge.weight);
                if(++cnt == V) break; // 신장트리 완성
            }
        }

        System.out.println(result-maxW);


    }

    static class Node implements Comparable<Node>{

        public Node(int from,int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        int from;
        int to;
        int weight;

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight , o.weight);
        }
    }
}
