
public class 아파트색칠하기 {
	public static void main(String args[]){
	
		System.out.println(f(8));
		
	}
	static int f(int n) {
		int [] apart = new int[n+1];
		apart[1] = 2;
		apart[2] = 3;
		
		for(int i=3;i<=n;i++) {
			apart[i] = apart[i-1] + apart[i-2];
		}
		
		return apart[n];
	}
	
}
