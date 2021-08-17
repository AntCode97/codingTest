package 팔월13;

import java.util.Scanner;

public class NtoM_1 {
    static int n;
    static int m;
    static int[] arr;
    static int[] tf;
    static boolean[] barr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("야 아무거 내놔봐");
        n = sc.nextInt();
        m = sc.nextInt();
        barr = new boolean[n];
        tf = new int[n];
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        perm(0, 0);
    }

    static void perm(int idx, int cnt) {

            if(cnt==m) {
                for (int i = 0; i < m; i++) {
                    System.out.print(arr[tf[i]]);
                }
                System.out.println();
                return;

            }


        for (int i = 0; i < n; i++) {
            if (barr[i]) continue;
            tf[idx] = i;
            cnt++;
            barr[i] = true;
            perm(idx + 1, cnt);
            cnt--;
            barr[i] = false;
        }
    }
}