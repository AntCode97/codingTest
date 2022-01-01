package y2021.m8d23;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Contact {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			int start = sc.nextInt();
			// 1번부터 100번의 정점이 각각 사용할 링크드리스트 들
			List<Integer>[] adj = new LinkedList[101];
			// 각 정점들이 사용할 실제 링크드리스트 객체를 할당
			for (int i = 1; i < 101; i++)
				adj[i] = new LinkedList<>();
			// from to 집합을 N/2개만큼 입력을 받아 처리
			for (int i = 0; i < N / 2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				// from이 갖는 링크드리스트에 to를 추가
				adj[from].add(to);
			}
//			//bfs시작.
//			//큐와 방문체크배열을 준비
//			Queue<Node> queue = new LinkedList<>();
//			boolean[] visited = new boolean[101];
//			//첫번째 방문지를 큐에 추가하고 방문체크
//			queue.add(new Node(start, 1));
//			visited[start] = true;
//			
//			int maxCnt = 0; //가장 높은 방문순서값을 기억할 곳
//			int ans = 0; //정답노드의 번호
//			//bfs탐색
//			while( !queue.isEmpty()) {
//				Node node = queue.poll();
//				//정답인지 체크.
//				//maxCnt 보다 더 길게 방문해왔으면 갱신
//				if( maxCnt < node.cnt) {
//					maxCnt = node.cnt;
//					ans = node.num;
//				}
//				//같은 길이라면 더 큰 노드의 번호를 기억 그러면 그게 정답
//				else if( maxCnt == node.cnt ) {
//					ans = Math.max(node.num, ans);
//				}
//				//이번에 꺼낸 노드에서 인접했고 방문안했으면 큐에 넣고 방문체크
//				for(int num : adj[node.num] ) {
//					if( visited[num] )
//						continue;
//					visited[num] = true;
//					queue.add(new Node(num, node.cnt + 1));
//				}

			int ans = 0;
			//큐와 방문배열을 준비
			Queue<Integer> queue = new LinkedList<>();
			boolean[] visited = new boolean[101];
			//시작 노드를 큐에넣고 방문체크
			queue.add(start);
			visited[start] = true;
			//정답을 저장할 변수
			int max = 0;
			//큐를 탐색
			while (!queue.isEmpty()) {
				//현재 큐의 사이즈를 보고
				int size = queue.size();
				max = 0;
				//사이즈 만큼 돌면서 하나씩 처리
				for (int i = 0; i < size; i++) {
					int num = queue.poll();
					max = Math.max(max, num);
					for (int n : adj[num]) {
						if (visited[n])
							continue;
						visited[n] = true;
						queue.add(n);
					}
				}
			}
			System.out.println("#" + tc + " " + max);

		}
	}

	static class Node {
		int num, cnt;

		Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
}
