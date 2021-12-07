package 팔월25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


public class 하나로프림_PQ2 {
	static class Edge implements Comparable<Edge> {
		int dest;
		long cost;

		Edge(int d, long c) {
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
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			// 각 정점별로 인접리스트 참조변수
			ArrayList<Edge>[] adj = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				adj[i] = new ArrayList<>();
			}
			int[][] arr = new int[N][2];
			for (int i = 0; i < N; i++)
				arr[i][0] = sc.nextInt();
			for (int i = 0; i < N; i++)
				arr[i][1] = sc.nextInt();
			double E = sc.nextDouble();
			// 입력되어지는 간선 배열을 인접리스트에 저장
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					long c = distance(arr[i][0], arr[j][0], arr[i][1], arr[j][1]);
					adj[i].add(new Edge(j, c));
					adj[j].add(new Edge(i, c));
				}
			}
			//dist와 pq를 동기화
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			Edge[] dist = new Edge[N];
			//dist안의 각 거리들은 무한대
			for(int i = 1; i < N; i++) {
				dist[i] = new Edge(i, Long.MAX_VALUE);
				pq.add(dist[i]);
			}
			//시작점은 0
			dist[0] = new Edge(0, 0);
			pq.add(dist[0]);
			long result = 0;
			while(!pq.isEmpty()) {
				//현재 dist가 가장 작은 친구를 데려와서
				Edge e = pq.poll();
				result += e.cost;
				//그 친구로부터 출발하는 모든 간선에 대해서
				for( Edge next : adj[e.dest ]) {
					//그 간선의 목적지가 아직 pq에 들어있는 정점이라면	
					//그리고 더 빨리 도착할 수 있다면
					if( pq.contains(dist[next.dest]) && dist[next.dest].cost > next.cost	) {
						//dist갱신
						dist[next.dest].cost = next.cost;
						//decrease key연산
						pq.remove(dist[next.dest]);
						pq.add(dist[next.dest]);
					}
				}
			}
			System.out.println("#" + tc + " " + Math.round(result * E));
		}
	}

	static long distance(int x1, int x2, int y1, int y2) {
		long d = (long) ((Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
		return d;
	}
}
