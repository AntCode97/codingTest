package 시월05;

import java.util.Scanner;

public class 벽돌깨기_Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); //공을 던지는 횟수 1 ≤ N ≤ 4
			int W = sc.nextInt(); //맵의 가로크기 2 ≤ W ≤ 12
			int H = sc.nextInt(); //맵의 세로크기 2 ≤ H ≤ 15
			int[][] map = new int[H][W];
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++)
					map[i][j] = sc.nextInt();
			}
			ans = 987654321;
			dfs(map, N);
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static void deepCopy(int[][] origin, int[][] copy) {
		for (int i = 0; i < origin.length; i++) {
			for (int j = 0; j < origin[i].length; j++) {
				copy[i][j] = origin[i][j];
			}
		}
	}
	static int ans;
	//모든 경우에 대해 공을 떨궈보는 재귀함수
	static void dfs(int[][] map, int N) {
		if( N == 0 )
		{
			ans = Math.min(ans, getCnt(map));
			return;
		}
		
		for(int j = 0; j < map[0].length; j++) {
			//현재 호출에서 있는 맵에 떨구면 안되고, 현재 맵의 복사를 떠서, j번째에 공던지고. 아래로 밀착하고, 그 맵을 던져주면서 재귀
			//j번째 열에 공떨궈보고 다음 공 떨구는 재귀 호출
			int[][] tmp = new int[map.length][map[0].length];
			deepCopy(map, tmp);
			//tmp에 j번째 열에 공투하.
			//j번째 열에서 처음으로 0이 아닌 값이 나오는 행을 찾아서 그 행,열 에 boooooooooomb
			for(int i = 0; i < tmp.length; i++) {
				if(tmp[i][j] != 0) {
					booooomb(tmp, i, j);
					break;
				}
			}
			gravity(tmp);
			dfs(tmp, N-1);
		}
	}
	
	
	//특정 벽돌위치를 지정했을때 지워지는 모든 벽돌을 탐색하는 함수
	static void booooomb(int[][] map, int h, int w) {
		if( h < 0 || w < 0 || h >= map.length || w >= map[h].length )
			return;
		
		int range = map[h][w];
		map[h][w] = 0;
		for(int i = 1; i <range; i++) {
			booooomb(map, h, w + i);
			booooomb(map, h, w - i);
			booooomb(map, h + i, w);
			booooomb(map, h - i, w);
		}
	}
	
	
	//아래로 밀착시키는 함수
	static void gravity(int[][] map) {
		for(int i = map.length-1; i >= 0; i--) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 0) {
					//현재 열의 현재 행 위로 이동 0이 아닌애를 발견할때까지.
					for(int k = i; k >= 0; k--) {
						if(map[k][j] != 0) {
							map[i][j] = map[k][j];
							map[k][j] = 0;
							break;
						}
					}
				}
			}
		}
	}
	
	//현재 벽돌의 갯수를 세는 함수
	static int getCnt(int[][] map) {
		int cnt = 0;
		for(int i = 0; i < map.length; i++) {
//			System.out.println(Arrays.toString(map[i]));//디버깅용
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] != 0)
					cnt++;
			}
		}
		return cnt;
	}
}













