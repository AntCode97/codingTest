package 구월15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일이삼_더하기_실버3 {
    static int [] nums = new int[11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 4;
        nums[4] = 7;


        for(int i =5;i<11;i++){
            nums[i] = nums[i-1] + nums[i-2] + nums[i-3];
        }

        for(int tc= 0;tc<T;tc++){
            int N = Integer.parseInt(br.readLine());

            System.out.println(nums[N]);
        }
    }
}
