package 구월14;

public class 막대색칠하기 {
	public static void main(String args[]){
	
		System.out.println(f(4));
		
	}
//	1cm 짜리 파란 막대와 1cm 짜리 노란 막대 그리고 2cm 짜리 빨간 막대가 있다.
//	이 막대들을 연결하여 길이가 ncm인 막대를 만드는 방법의 수를 f(n)이라 하자.
	static int f(int n) {
		int [] stick = new int[n+1];
		stick[1] = 2;
		stick[2] = 5;
		
		for(int i=3;i<=n;i++) {
			stick[i]= 2*stick[i-1] + stick[i-2];
		}
		
		return stick[n];
	}
	
}
