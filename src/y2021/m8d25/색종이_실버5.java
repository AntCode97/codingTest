package y2021.m8d25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이_실버5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int paper [][] = new int [100][100];
        for(int i =0;i<N;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x =  Integer.parseInt(st.nextToken());
            int y =  Integer.parseInt(st.nextToken());
            for(int j = x; j<x+10;j++){
                for(int k = y; k<y+10; k++){
                    paper[j][k]= 1;
                }
            }
        }
        int sum =0;
        for(int i =0 ;i<100;i++){
            for(int j =0;j<100;j++){
                sum+=paper[i][j];
            }
        }
        System.out.println(sum);
    }
}
