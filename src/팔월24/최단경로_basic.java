package 팔월24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 최단경로_basic {
	static class Edge{
		int vertex;
		int weight;
		Edge(int vertex, int weight){
			this.vertex = vertex;
			this.weight = weight;
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
		//dijkstra준비
		//확보된 정점을 체크할 배열
		boolean[] check = new boolean[V];
		//거리를 기록할 배열
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;
		
		for(int i = 0; i < V; i++) {
			//이번에 확보할 정점을 찾는다.
			//check되지 않았으면서(아직 미확보)
			//dist값이 젤 작은 정점의 번호를 찾자.
			int min = Integer.MAX_VALUE;
			int index = -1;
			for(int j = 0; j < V; j++) {
				if(!check[j] && min > dist[j]) {
					min = dist[j];
					index = j;
				}
			}
			//찾아진 정점이 없다는 것은 더이상 경로가 존재하지 않음
			if( index == -1 )
				break;
			//확보로 체크하고
			check[index] = true;
			//확보된 정점으로부터 확보되지않은 정점으로 경로가 존재한다면 거리 갱신
			
			//이 정점으로부터 모든 경로를 탐색
			for(Edge next : adj[index]) {
				//이미 확보된 곳으로 가는 경로는 패스
				if( check[next.vertex] )
					continue;
				//이미 알려진 경로가, 확보된 정점으로부터 가는 거리보다 길면 갱신
				if( dist[next.vertex] > dist[index] + next.weight )
					dist[next.vertex] = dist[index] + next.weight;
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








