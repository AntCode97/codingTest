package 팔월10;

import java.util.Scanner;

// N 과 K가 주어짐. 
// N 은 출력되어져야 되는 전체 숫자. 1부터 N까지의 숫자가 한번씩 출력되어야함.
// N이 7 이라면
// K가 3이라면
// 1 2 3 4 5 6 7
// 3 6 2 7 5 1 4

public class 요세푸스문제_모듈러 {
	public static void main(String[] args) {
		//N : 7 , K : 3
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		//요기에 1부터 N을 담을 것이고, 이미 출력한 자리는 -1로 바꿔서 무효처리
		for(int i = 1; i <= N; i++) {
			arr[i-1] = i;
		}
		int pos = 0; // 현재 검사하는 위치.
		int cnt = 0; //현재 쿵 친 횟수 이 횟수가 K가되면 출력한다.
		int outcnt = 0; //처리된 숫자의 갯수. 이게 N이되면 종료.
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(outcnt != N) {
			//pos위치에 -1이 아닌(그러니까 유효한) 숫자라면 쿵 횟수 증가
			if( arr[pos % N] != -1) {
				cnt++;
			}
			//쿵횟수가 따에 달했다면 
			if( cnt == K ) {
				//출력하고
				sb.append(arr[pos % N]).append(", ");
				//쿵횟수를 0으로 초기화 하고
				cnt = 0;
				//해당 자리 -1로 체크해서 무효처리
				arr[pos % N] = -1;
				//출력카운트 추가
				outcnt++;
			}
			//다음 자리로 이동
			pos++;
		}
		sb.delete(sb.length()-2, sb.length()).append(">");
		System.out.println(sb.toString());
	}
}
