package 구월27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Algo2_광주_4반_이윤준 {
	
	static int V;
	static int E;
	static boolean visited [];
	static int colors [];
	static List<Integer> [] adjList  ;
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			visited = new boolean[V+1];
			//그래프를 저장할 인접리스트
			adjList = new ArrayList[V+1];
			//정점의 색깔을 저장할 배열
			colors = new int[V+1];
			for(int i=1;i<=V;i++) {
				adjList[i] = new ArrayList<Integer>();
			}
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList[from].add(to);
				adjList[to].add(from);
			}
			
			boolean cnt = true;
			for(int i=1;i<=V;i++) {
				//모든 정점에 대해서 bfs돌렸을때 
				//이분그래프인지 확인
				if(!bfs(i)) {
					//이분그래프가 아니면 NO를 출력
					cnt = false;
					System.out.println("NO");
					break;
				}
			}
			//이분그래프이면 YES를 출력
			if(cnt) System.out.println("YES");
			
			
			

			
		}
		
		
	}
	
	static boolean bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();

		//시작 정점의 색깔을 1로 칠함
		//그리고 현재 정점과 이어진 정점은 현재 정점의 색깔 * -1로 칠해서
		//이웃한 정점은 서로 다른 색깔을 가지게함
		//만약 이웃한 정점이 같은 색깔을 가지는 경우가 생기면 이분그래프가 아님
		//같은 색깔을 가지는 경우가 없으면 이분그래프임
		queue.add(start);
		visited[start] = true;
		colors[start] =1;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for(int next : adjList[current]) {
				visited[next] =true;
				if(colors[next]==0 ) {
					//현재 정점과 다른 색을 칠하고, 큐에 넣음
					colors[next] = colors[current]*-1;

					queue.add(next);
				}
				//현재 정점과 색이 같으면 이분그래프가 아니므로, false를 리턴
				if(colors[next] == colors[current]) return false;
			}
			
		}
		//여기까지 왔으면 이웃한 모든 정점이 다른 색깔을 가지므로
		//이분그래프임
		return true;
		
	}
	


}
