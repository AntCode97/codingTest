package y2021.m8d25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_직사각형_실버1 {

    static class Square {
        int x1, y1, x2, y2;

        public Square(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int [][] square = new int[4][4];
        int [][] square2 = new int[4][4];
        for (int i = 0; i<4;i++){
            st = new StringTokenizer(bf.readLine());
                int x1, y1, p1, q1, x2,y2, p2, q2;
                x1 = Integer.parseInt(st.nextToken());
                y1 = Integer.parseInt(st.nextToken());
                p1 = Integer.parseInt(st.nextToken());
                q1 = Integer.parseInt(st.nextToken());
                x2 = Integer.parseInt(st.nextToken());
                y2 = Integer.parseInt(st.nextToken());
                p2 = Integer.parseInt(st.nextToken());
                q2 = Integer.parseInt(st.nextToken());
                
                String result ="a";
            if (q1 < y2 || q2 < y1 || x1 > p2 || p1 <x2) //겹치지 않으면 : d
                    result = "d";
            //각 면에 대해서 검사해서 점인지 선인지 확인
            if (p1 == x2)    //일단 한면이 겹치는지 확인
                if (q1 == y2 || y1 == q2) result = "c";
                else result =  "b" ; //   꼭지점이면 점, 아니면 선
            if (x1 == p2)
                if (y1 == q2 || q1== y2)  result = "c" ;
                else result =  "b";
            if (q1 == y2)
                if (p1 == x2 || p2== x1)  result = "c" ;
                else result = "b";
            if (q2 == y1)
                if (p1 == x2 || p2== x1) result = "c"  ;
                else result = "b";
            //#여기 까지 왔는데..if 안걸렸으면 a
            System.out.println(result);
        }

    }

}
