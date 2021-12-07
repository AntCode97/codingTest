package 구월28;

import java.util.Scanner;

public class 원점으로집합_D4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int arr[] = new int [N];
            int maxV =Integer.MIN_VALUE;
            for(int i=0;i<N;i++){
                int x =  sc.nextInt();
                int y = sc.nextInt();
                arr[i] = Math.abs(x)+Math.abs(y);
                maxV = Math.max(maxV, arr[i]);
            }

            int rest = arr[0]%2;
            boolean cnt = false;
            for(int i=1;i<N;i++){
                if(arr[i]%2 != rest){
                    cnt=true;
                    break;
                }
            }
            if(cnt) {
                System.out.println("#"+test_case+" " + -1);
                continue;
            }

            int count =0;
            boolean done = true;
            int sum=0;
            while (true){

                if(sum >= maxV && sum %2 == rest)
                   break;

                sum += ++count;
            }
            System.out.println("#"+test_case + " " +count);

        }

    }
}
