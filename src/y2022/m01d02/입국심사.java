package y2022.m01d02;

import java.util.Arrays;

public class 입국심사 {
    public long solution(int n, int[] times) {


        Arrays.sort(times);

        long start = 0;
        long end = Long.MAX_VALUE;
        long answer = end;
        while (start <= end){

            long mid = (start+end)/2;
            if(check(n, times, mid)){
                if( answer >= mid) answer = mid;
                end = mid-1;
            }
            else {
                start = mid+1;
            }

        }

        return (long) answer;
    }

    boolean check(int n, int[] times, long mid){
        long sum=0;
        for (int t : times){
            sum+= (long) mid/t;
        }
        if(sum>=n) return true;
        return false;
    }
}
