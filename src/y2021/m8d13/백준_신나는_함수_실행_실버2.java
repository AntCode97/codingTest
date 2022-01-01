package y2021.m8d13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_신나는_함수_실행_실버2 {
    static int ww[][][] = new int[101][101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ww[0][0][0] =1;
        while (true){
            st= new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==-1 && b==-1 &&c==-1)
                break;
            System.out.println("w("+a+", "+b+", "+c+") = "+  w(a,b,c));

        }
    }
    static int w(int a, int b, int c){
        if (a <= 0 || b <= 0 || c <= 0) {
            return ww[0][0][0];
        } else if(ww[a][b][c] !=0){
            return ww[a][b][c];
        }
        else if (a > 20 || b > 20 || c > 20){
            return w(20, 20, 20);
        } else if (a < b && b < c) {
            ww[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
            return ww[a][b][c];
                    //ww[a][b][c-1] + ww[a][b-1][c-1] - ww[a][b-1][c];
                   //
        }
        else {
            ww[a][b][c] =  w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
         return    ww[a][b][c];
        }
    }
}
