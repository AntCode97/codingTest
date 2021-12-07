package 팔월17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_Z_실버1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int rs =0;
        int cs =0;
        int answer =0;
        while (N>0){
            int side = (int) Math.pow(2, N-1);
            int square = side*side;
            //우측 사각형
            if(r < rs+side && c >= cs+side){
                answer+=square;
                cs+=side;
            }//좌측 아래 사각형
            else if(r >= rs+side && c < cs+side){
                answer+=square*2;
                rs+=side;
            } //우측 아래 사각형
            else if(r >= rs+side && c >= cs+side){
                answer+=square*3;
                rs+=side;
                cs+=side;
            }
            N--;
        }
        System.out.println(answer);

    }


}
