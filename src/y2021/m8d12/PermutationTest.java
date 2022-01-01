package y2021.m8d12;

import java.util.Arrays;

public class PermutationTest {
    static int R=3;
    static int N=3;
    static int [] input;
    static int [] numbers;
    public static void main(String[] args) {
        input = new int[]{1,4,7};
        numbers = new int[3];
        permutation(0,0);
    }

    private static void permutation(int cnt, int flag){
        if(cnt ==R){
            System.out.println(Arrays.toString(numbers));
            return;
        }

        //가능한 모든 수들이 들어있는 배열 모든 원소에 대해 시도
        for(int i=0;i<N;i++){
            if((flag&1 <<i)!=0) continue;

            numbers[cnt] = input[i];
            permutation(cnt+1, flag | 1 << i);
        }
    }
}
