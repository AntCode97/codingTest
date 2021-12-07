package 팔월12;

public class 부분집합_비트마스크재귀 {
	static String[] msg = {"사과", "오렌지", "수박"};
	public static void main(String[] args) {
		powerSet(0, 0);
	}
	//비트마스크값을 들고 다니자.
	static void powerSet(int idx, int flag) {
		if(idx == msg.length) {
			for(int i = 0; i < msg.length; i++) {
				//검사하는 곳 비트 &연산으로 변경
//				if(sel[i])
//					System.out.print(msg[i] + " ");
				if( (flag & 1 << i ) != 0 )
					System.out.print(msg[i]);
			}
			System.out.println();
			return;
		}
		//가지고 가는 경우 오른쪽에서 idx번째 비트를 on 시킨 값을 전달
//		sel[idx] = true;
//		powerSet(idx + 1);
		powerSet(idx + 1, flag | ( 1 << idx ));
		//안가지고 가는 경우는 flag를 그대로 들고 가.
//		sel[idx] = false;
//		powerSet(idx + 1);
		powerSet(idx + 1, flag);
	}
}
