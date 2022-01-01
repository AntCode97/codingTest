package y2022.m01d01;

import java.util.Arrays;

public class N으로표현 {
    static int [] DP = new int[32000];
    public static int solution(int N, int number) {
        Arrays.fill(DP, Integer.MAX_VALUE);
        DP[N] = 1;
        DP[0] = 2;
        int sum =0;
        for (int i=0;i<=Math.log(number);i++){
            sum+= N*Math.pow(10, i);
            if (sum>32000) break;
            DP[sum] = i+1;
        }
        int answer = f(number, N, 0);
        return answer;
    }

    public static int f(int idx, int N, int cnt){
        if(cnt > 8 || idx> 32000) return -1;
        if (DP[idx] == Integer.MAX_VALUE){

            idx=idx;
            int plus=Integer.MAX_VALUE, divi=Integer.MAX_VALUE ,mult= Integer.MAX_VALUE;

            if (idx >= N){
               plus =  f(idx-N, N,cnt+1)+1;
               DP[idx] = Math.min(DP[idx], plus );
            }
            //sub = f(idx+N, N) +1;

            if(idx%N ==0 ) {
                mult = f(idx/N, N, cnt+1)+1;
                DP[idx] = Math.min(DP[idx], mult);
                String sdx = String.valueOf(idx);
                int count =0;
                for (int i=0;i<sdx.length();i++){
                    if(sdx.charAt(i) !='N') break;
                    count++;
                }
                if(count==sdx.length()){
                    DP[idx] = Math.min(DP[idx], count);
                }
            }
            divi = f(idx*N, N,cnt+1) +1;
            DP[idx] = Math.min(divi, DP[idx]);

            return DP[idx];
        }
        else return DP[idx];
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 12));
        System.out.println(solution(2, 11));

    }
}
