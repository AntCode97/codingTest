package 구월15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class twoXn타일링_실버3 {
    static double [] nums = new double[1002];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 2;
        for(int i=3;i<=N;i++){
            nums[i] = (nums[i-1] + nums[i-2])%10007;
        }
        System.out.println((int)nums[N]);

    }
}
