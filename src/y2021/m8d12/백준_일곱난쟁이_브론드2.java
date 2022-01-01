package y2021.m8d12;

import java.util.Arrays;
import java.util.Scanner;

public class 백준_일곱난쟁이_브론드2 {
    static int[] shortMen ;
    static boolean[] sel = new boolean[9];
    static boolean cnt = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        shortMen = new int[9];
        for(int i=0;i<9;i++)
            shortMen[i] = sc.nextInt();
        Arrays.sort(shortMen);
        powerSet(0, 0);
    }
    static void powerSet(int idx, int count) {
        if(cnt)
            return;
        if(count==7) {
            int sum =0;
            for(int i = 0; i < shortMen.length; i++) {
                if(sel[i])
                    sum += shortMen[i];
            }
            if(sum==100){
                for(int i = 0; i < shortMen.length; i++) {
                    if(sel[i])
                        System.out.println(shortMen[i]);
                }
                cnt=true;
            }
            return;
        } if(idx==9)
            return;
        sel[idx] = true;
        count++;
        powerSet(idx + 1, count);
        sel[idx] = false;
        count--;
        powerSet(idx + 1, count);
    }
}
