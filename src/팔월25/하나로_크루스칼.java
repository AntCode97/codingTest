package 팔월25;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 하나로_크루스칼 {
	static class Edge{
		int v1;
		int v2;
		long weight;
		Edge(int v1, int v2, long weight){
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][2];//일단 좌표를 여기에 저장해두자.
			for(int i = 0; i < N; i++)
				arr[i][0] = sc.nextInt();//x좌표
			for(int i = 0; i < N; i++)
				arr[i][1] = sc.nextInt();//y좌표
			double E = sc.nextDouble();
			//간선의 갯수가 N * (N-1) /2 개로 나오는 것 이해하기
			Edge[] edges = new Edge[N * (N-1) / 2];
			int idx = 0;
			//모든 간선을 따져볼때 반복이 왜 이렇게 돌면 되는지 이해하기.
			//예 :  1번정점은 2,3,4,5로
			//		2번정점은 3,4,5로
			//		3번정점은 4,5로
			//		4번정점은 5로
			//		5번정점은 갈곳이 없음.
			//위에서 한줄한줄이 큰 for문이라고 한다면 첫정점부터 N-1까지만 돌면됨
			//위 한줄한줄에서 숫자콤마들이 작은 for문이라고 한다면
			// 큰 for문 +1부터 N까지 돌면됨
			for(int i = 0; i < N-1; i++	) {
				for(int j = i+1; j < N; j++)
					edges[idx++] = new Edge(i, j, dist(arr[i][0], arr[j][0], arr[i][1], arr[j][1]));
			}
			//Comparable을 구현하지 않았을때 1회용으로 Comparator활용하기
			//Comparable을 구현했다고 하더라도 이 Comparator가 우선 동작
			Arrays.sort(edges, new Comparator<Edge>() {
				@Override
				public int compare(Edge o1, Edge o2) {
					return Long.compare(o1.weight, o2.weight);
				}
			});
			//크루스칼 시작
			parents = new int[N];
			for(int i = 0; i < N; i++)
				makeSet(i);
			
			long result = 0;//신장트리의 합을 저장할 변수
			int cnt = 0;// 확보된 정점의 수
			for(int i = 0; i < N*(N-1)/2; i++) {
				int a = findSet(edges[i].v1);
				int b = findSet(edges[i].v2);
				//이미 같은 그룹이면 패스
				if( a == b )
					continue;
				unionSet(a, b);
				result += edges[i].weight;
				cnt++;
				if( cnt == N-1 )
					break;
			}
			System.out.println("#" + tc + " " + Math.round(result * E));
		}
	}
	//거리구하는 수식은 각각 x,y좌표의 차의 제곱의 합
	static long dist(int x1, int x2, int y1, int y2) {
		return (long)(Math.pow(x1-x2,2) + Math.pow(y1-y2, 2));
	}
	
	//크루스칼을 위한 union find연산
	static int[] parents;
	static void makeSet(int a) {
		parents[a] = a;
	}
	static int findSet(int a) {
		if( parents[a] == a )
			return a;
		else
			return parents[a] = findSet(parents[a]);
	}
	static void unionSet(int a, int b ) {
		int pa = findSet(a);
		int pb = findSet(b);
		if( pa != pb )
			parents[pa] = pb;
	}
}
