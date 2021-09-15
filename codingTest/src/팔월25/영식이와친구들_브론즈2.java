package 팔월25;

import java.util.Scanner;

public class 영식이와친구들_브론즈2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();
        int ball [] = new int [N];

        int now = 0;
        int count  = 0;
        while (true){

            ball[now]++;
            if(ball[now] == M) break;

            if(ball[now]%2 == 0){
                if(now-L <0) now = N+(now-L);
            else now = (now-L)%N;

            } else{
                now = (now+L)%N;
            }
            count++;
        }
        System.out.println(count);
    }

}
