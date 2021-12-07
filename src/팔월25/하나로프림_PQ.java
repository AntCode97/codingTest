package 팔월25;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 하나로프림_PQ {
	static class Edge implements Comparable<Edge>{
		int dest; 
		long cost;
		Edge(int d, long c){
			dest = d;
			cost = c;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Long.compare(this.cost, o.cost);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			//각 정점별로 인접리스트 참조변수
			ArrayList<Edge>[] adj = new ArrayList[N];
			for(int i = 0; i < N; i++) {
				adj[i] = new ArrayList<>();
			}
			 int[][] arr = new int[N][2];
	         for (int i = 0; i < N; i++)
	             arr[i][0] = sc.nextInt();
	         for (int i = 0; i < N; i++)
	             arr[i][1] = sc.nextInt();
	         double E = sc.nextDouble();
			//입력되어지는 간선 배열을 인접리스트에 저장
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					long c = distance(arr[i][0], arr[j][0], arr[i][1], arr[j][1]);
					adj[i].add(new Edge(j,c));
					adj[j].add(new Edge(i,c));
				}
			}
			boolean[] visited = new boolean[N];
			PriorityQueue<Edge> queue = new PriorityQueue<>();
			//0번을 방문하거로 체크하고, 0번에서 이어지는 모든 간선을 queue에 삽입.
			visited[0] = true;
			queue.addAll(adj[0]);
			//확보한 정점의 개수
			int cnt = 1;
			long result = 0;
			//모든 정점을 확보할때까지
			while( cnt != N ) {
				Edge edge = queue.poll();
				//이미 확보된 정점이 나오면 다시.
				if( visited[edge.dest] )
					continue;
				//확보되지 않는 놈이 나오면. 방문체크하고, 그놈에서부터 나가는 간선을 큐에 추가
				result += edge.cost;
				queue.addAll(adj[edge.dest]);
				visited[edge.dest] = true;
				cnt++;
			}
			System.out.println("#" + tc + " " + Math.round(result*E));
		}
	}
	static long distance(int x1, int x2, int y1, int y2) {
        long d = (long)((Math.pow(x1-x2,2) + Math.pow(y1-y2,2)));
        return d;
    }
}

























