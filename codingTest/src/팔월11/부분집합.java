package 팔월11;

public class 부분집합 {
	static String[] msg = {"사과", "오렌지", "수박"};
	static boolean[] sel = new boolean[3];
	public static void main(String[] args) {
		powerSet(0);
	}
	static void powerSet(int idx) {
		if(idx == msg.length) {
			for(int i = 0; i < msg.length; i++) {
				if(sel[i])
					System.out.print(msg[i] + " ");
			}
			System.out.println();
			return;
		}
		sel[idx] = true;
		powerSet(idx + 1);
		sel[idx] = false;
		powerSet(idx + 1);
	}
}
