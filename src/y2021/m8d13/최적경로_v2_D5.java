package y2021.m8d13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 최적경로_v2_D5 {
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int MIND=Integer.MAX_VALUE;
    static boolean isSelected[];
    static List<Point> list;
    static Point[] list2;
    static Point start;
    static Point dest;
    public static void main(String[] args) throws IOException {

        BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for(int tc = 1; tc<=T;tc++){
            N = Integer.parseInt(bf.readLine());
            isSelected = new boolean[N];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            start = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            dest = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            list = new ArrayList<>();
            list2 = new Point[N];
            for(int i=0;i<N;i++){
                list.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            }
            MIND=Integer.MAX_VALUE;
            perm(0,0);

            System.out.println("#"+tc+" "+ MIND);
        }


    }
    static int distance(Point A, Point B){
        //return Math.sqrt(Math.pow(A.x-B.x,2)+Math.pow(A.y-B.y,2));
        return Math.abs(A.x -B.x) +Math.abs(A.y-B.y);
    }
    private static void perm(int cnt, int d){
        if(cnt == N){
            d+=distance(list2[cnt-1], dest);
            if(d<MIND){
                MIND = d;
            }
            return;
        }

        for(int i=0;i<N;i++){
            //중복 체크
            if(isSelected[i]) continue;;
            list2[cnt] =list.get(i);
            isSelected[i] = true;
            if(cnt==0){
                d+=distance(start ,list2[cnt]);
            } else{
                d+=distance(list2[cnt],list2[cnt-1]);
            }
            if(d>=MIND){
                isSelected[i] = false;
            } else{
                perm(cnt+1,  d);
                isSelected[i] = false;
            }

            if(cnt==0){
                d-=distance(start ,list2[cnt]);
            } else{
                d-=distance(list2[cnt],list2[cnt-1]);
            }
        }

    }
}
