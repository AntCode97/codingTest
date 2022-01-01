package y2021.m8d25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_참외밭_실버5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());
        int [][] side = new int[7][2];
 //       int [] sideSum = new int[4];
        for(int i=0;i<6;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<2;j++){
              side[i][j] = Integer.parseInt(st.nextToken());
//              sideSum[side[i][0]]+=side[i][1];
            }
        }
        int Mw =Integer.MIN_VALUE, mw= Integer.MAX_VALUE, Mh=Integer.MIN_VALUE, mh= Integer.MAX_VALUE;
        for(int i =0;i<6;i++){
            if(side[i][0] == 3 || side[i][0] == 4){
                Mw =  Math.max(side[i][1], Mw);
            } else{
                Mh =  Math.max(side[i][1], Mh);
            }
        }
        for(int i =0;i<6;i++){
            if(side[i][0] == 3 || side[i][0] == 4){
                if(side[i][1] == Mw ){
                    if(i==5 ){
                        if(side[i-1][1] != Mh) mh = side[i-1][1];
                        else {
                            mh = side[0][1];
                        }
                    } else if(i==0){
                        if(side[i+1][1] != Mh) mh = side[i+1][1];
                        else {
                            mh = side[5][1];
                        }
                    }
                    if(i !=5){
                        if(side[i+1][1] !=Mh) mh = side[i+1][1];
                        else if(i !=0 && side[i-1][1] !=Mh) mh = side[i-1][1];
                    }
                }
            } else{
                if(side[i][1] == Mh ){
                     if(i==5 ){
                        if(side[i-1][1] != Mw) mw = side[i-1][1];
                        else {
                            mw = side[0][1];
                        }
                    }
                     else if(i ==0){
                         if(side[i+1][1] != Mw) mw = side[i+1][1];
                         else {
                             mw = side[5][1];
                         }
                     }
                     else if(i !=5){
                        if(side[i+1][1] !=Mw) mw = side[i+1][1];
                        else if(i !=0 && side[i-1][1] !=Mw) mw = side[i-1][1];
                    }
                }
            }
        }
//        int sum=0;
//        sum += side[0][1]*side[1][1];
//
//        if(side[2][1] <side[0][1]){
//            sum -= side[3][1] * side[4][1];
//        } else{
//            sum+= side[3][1]*side[4][1];
//            sum-=side[4][1] *side[5][1];
//        }
        int sum = Mw * Mh;
        sum-= (Mw-mw)*(Mh-mh);

        System.out.println(sum*N);

    }
}
