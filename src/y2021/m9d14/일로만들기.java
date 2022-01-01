import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일로만들기 {
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(f(n));
		
	}
	static int f(int n) {
//		X가 3으로 나누어 떨어지면, 3으로 나눈다.
//		X가 2로 나누어 떨어지면, 2로 나눈다.
//		1을 뺀다.
		int []nums = new int[n+1];
		nums[1] = 0;
		//nums[2] = 1;
		for(int i =2;i<=n;i++) {
			int min = Integer.MAX_VALUE;
			if(i%3 == 0) {
				if(min> nums[i/3]) min = nums[i/3];
			}
			if(i%2 == 0) {
				if(min> nums[i/2]) min = nums[i/2];
			}
			if(min> nums[i-1]) min = nums[i-1];
			
			
			nums[i] = min+1;
		}
		return nums[n];
	}
	
}
