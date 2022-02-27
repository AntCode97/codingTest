package y2021;

import java.util.*;

public class 최단경로_pq {
	static class Edge implements Comparable<Edge>{
		int vertex;
		int weight;
		Edge(int vertex, int weight){
			this.vertex = vertex;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); //정점의 개수
		int E = sc.nextInt(); //간선의 개수
		int K = sc.nextInt()-1; //시작 정점(정점 번호가 1번부터 시작함)
		List<Edge>[] adj = new ArrayList[V];
		for(int i = 0; i < V; i++)
			adj[i] = new ArrayList<Edge>();
		//간선의 정보를 입력받자.
		for(int i = 0; i < E; i++) {
			int from = sc.nextInt()-1;//출발점, 번호는 1부터니까 배열인덱스맞게 -1
			int to = sc.nextInt()-1;//도착점
			int weight = sc.nextInt();//가중치
			//출발점정점이 갖는 인접정보에 도착점의 정보를 넣어준다.
			adj[from].add(new Edge(to, weight));
		}
		//거리를 기록할 배열
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		//큐에 들어가는 자료는, 정점.거리 인데
		//출발점부터 정점까지 가는 알려진 누적거리가 저장됨
//		dist[K] = 0;
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		queue.add(new Edge(K, 0));
		while(!queue.isEmpty()) {
			Edge e = queue.poll();
			//이미 처리된 정점이 나오면 버리면 됨(increase key를 하지 않아서 생긴 중복)
			if(dist[e.vertex] < e.weight)
				continue;
			dist[e.vertex] = e.weight;//47을 없애고 39와 52를 살려도 됨
			
			for( Edge next : adj[e.vertex] ) {
				if( dist[next.vertex] > dist[e.vertex] + next.weight ) {
					queue.add(new Edge(next.vertex, dist[e.vertex] + next.weight));
//					dist[next.vertex] = dist[e.vertex] + next.weight;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < V; i++) {
			if(dist[i] == Integer.MAX_VALUE)
				sb.append("INF").append("\n");
			else
				sb.append(dist[i]).append("\n");
		}
		System.out.println(sb);
	}
}








