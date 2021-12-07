package 구월23;

import java.util.Arrays;
import java.util.Scanner;

public class 프로세스연결하기 {
    static int map [][];
    static int N;
    static int minSum;
    static int maxCount = Integer.MIN_VALUE;
    static int countMax[] ;
    static String last = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            map = new int[N][N];
            for(int i=0;i<N ;i++){
                for(int j=0;j<N;j++){
                    map[i][j] = sc.nextInt();
                }
            }
            minSum= Integer.MAX_VALUE;
            countMax = new int[12];
            Arrays.fill(countMax, Integer.MAX_VALUE);
            maxCount = 0;
            dfs(1,1,0, 0);
            System.out.println("#"+test_case+ " "+countMax[maxCount]);
//            for(int i=1;i<N-1 ;i++){
//                for(int j=1;j<N-1;j++){
//                    if(map[i][j] ==1){
//
//                    }
//                }
//            }

        }
    }
    static int dr [] = {0, 0 , 1, -1};
    static int dc [] = {1, -1 , 0, 0};
    static void printMap(){
        System.out.println("==========================");
        for(int i=0;i<N;i++){
            System.out.println();
            for(int j=0;j<N;j++){
                System.out.print(map[i][j] + " ");
            }
        }
        System.out.println();
    }

    static void dfs(int idx, int jdx, int sum,int count){

        if(idx==N-1 && jdx ==N-1 ){

            if(maxCount<=count){
               // printMap();
                //System.out.println(idx+ " "+  jdx+ " " +sum+ " " + last + " " + count);
                maxCount = count;
                countMax[maxCount] = Math.min(countMax[maxCount], sum);
                //minSum = Math.min(minSum, sum);
            }

            return;
        }
        int nidx ,njdx;
        if(jdx ==N-1){
            nidx = idx+1;
            njdx = 1;
        } else {
            nidx = idx;
            njdx = jdx+1;
        }
        if(idx != N-1 && jdx != N-1 && map[idx][jdx] ==1) {
            int tmp = upWire(idx, jdx);
            if (tmp != -1) {
                dfs(nidx, njdx, sum + tmp, count+1);
                upWire2(idx, jdx);
            }
            int tmp2 = downWire(idx, jdx);
            if (tmp2 != -1) {
                dfs(nidx, njdx, sum + tmp2, count+1);
                downWire2(idx, jdx);
            }
            int tmp3 = rightWire(idx, jdx);
            if (tmp3 != -1) {
                dfs(nidx, njdx, sum + tmp3, count+1);
                rightWire2(idx, jdx);
            }
            int tmp4 = leftWire(idx, jdx);
            if (tmp4 != -1) {
                dfs(nidx, njdx, sum + tmp4,count+1);
                leftWire2(idx, jdx);
            }
            dfs(nidx,njdx, sum,count);
//            if(tmp == -1 && tmp2==-1&& tmp3==-1&& tmp4==-1)

        } else{
            dfs(nidx,njdx, sum,count);
        }


    }

    //위 체크
    static int upWire(int idx, int jdx){
        last = "up";
        boolean cnt = false;
        int sum = 0;
        for(int i = idx-1 ; i>=0 ; i--){
            if(map[i][jdx] !=0){
                cnt = true;
                break;
            } else sum++;
        }
        if(cnt) return -1;
        for(int i = idx-1 ; i>=0 ; i--){
            map[i][jdx] = -1;
        }

        return sum;
    }
    //위 만회
    static void upWire2(int idx, int jdx){
        last = "up2";
        for(int i = idx-1 ; i>=0 ; i--){
            map[i][jdx] =0;
        }
    }
    //아래
    static int downWire(int idx, int jdx){
        last = "down";
        boolean cnt = false;
        int sum = 0;
        for(int i = idx+1 ; i<N ; i++){
            if(map[i][jdx] !=0){
                cnt = true;
                break;
            } else sum++;
        }
        if(cnt) return -1;
        for(int i = idx+1 ; i<N ; i++){
            map[i][jdx] = -1;
        }
        return sum;
    }
    static void downWire2(int idx, int jdx){
        last = "down2";
        for(int i = idx+1 ; i<N ; i++){
            map[i][jdx] = 0;
        }
    }

    //오른쪽
    static int rightWire(int idx, int jdx){
        last = "right";
        boolean cnt = false;
        int sum = 0;
        for(int i = jdx+1 ; i<N ; i++){
            if(map[idx][i] !=0){
                cnt = true;
                break;
            } else sum++;
        }
        if(cnt) return -1;
        for(int i = jdx+1 ; i<N ; i++) {
            map[idx][i] = -1;
        }
        //Arrays.fill(map[idx], jdx+1, N, -1);
        return sum;
    }
    static void rightWire2(int idx, int jdx) {
        last = "right2";
        //Arrays.fill(map[idx], jdx+1, N, 0);
        for(int i = jdx+1 ; i<N ; i++) {
            map[idx][i] = 0;
        }
    }

    //왼쪽
    static int leftWire(int idx, int jdx){
        last = "left";
        boolean cnt = false;
        int sum = 0;
        for(int i = 0 ; i<jdx ; i++){
            if(map[idx][i] !=0){
                cnt = true;
                break;
            } else sum++;
        }
        if(cnt) return -1;
        for(int i = 0 ; i<jdx ; i++){
            map[idx][i] = -1;
        }
        //Arrays.fill(map[idx], 0, jdx, -1);
        return sum;
    }
    static void leftWire2(int idx, int jdx){
        //Arrays.fill(map[idx], 0, jdx, 0);
        last = "left2";
        for(int i = 0 ; i<jdx ; i++){
            map[idx][i] = 0;
        }
    }
}
