package 팔월10;

import java.util.ArrayList;
import java.util.Scanner;

public class 요세푸스문제 {
	public static void main(String[] args) {
		//N, K입력
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		//K-1번째 친구를 리스트에 삭제.
		//마지막 삭제했던 위치에서 K-1번째 친구를 또 삭제.
		// 그런데 리스트의 크기보다 더 넘어간다면, list의 size만큼 돌아오자..
		//리스트가 다 비어져 없어질때까지 시행
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= N; i++) {
			list.add(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int idx = 0; //현재 위치 기억할 변수
		while(!list.isEmpty()) {
			idx += K-1;
			while(idx >= list.size())
				idx -= list.size();
			sb.append(list.remove(idx)).append(", ");
		}
		sb.delete(sb.length()-2, sb.length()).append(">");
		System.out.println(sb);
	}
}
