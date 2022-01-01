package y2021;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ladder1_2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1 ; test_case <=10; test_case++){
            int ladder [][] = new int[100][100];
            int N = (int) sc.nextInt();
            int dx [] = { -1, 1};
            for(int i =0; i<100;i++) {
                for (int j = 0; j < 100; j++) {
                    ladder[i][j] = (int) sc.nextInt();
                }
            }
            int x = 0;
            int y = 99;
            int start = 0;
            int idx =0;
            List<Integer> startPoints = new ArrayList<>();
            for(;x<100;x++) {

                if (ladder[y][x] == 2) {
                    startPoints.add(x);
                    idx = startPoints.indexOf(x);
                    start = x;
                } else if(ladder[y][x] ==1){
                    startPoints.add(x);
                }
            }
          //  System.out.println(startPoints.toString());
                    x= start;
                    for(;y>0;y-=1){

                        for(int i =0 ; i<2;i++){
                            int nx =  x + dx[i];
                            if( nx >=0 && nx <100 ){
                                if( ladder[y][nx] ==1){
                                    if(i==0){
                                  //     System.out.println("Left 1: " + x + " " + y);
                                        x=left(ladder, x ,y, startPoints, idx);
                                        idx--;
                                   //     System.out.println("Left 2: " + x + " " + y);
                                        break;
                                    } else if(i ==1){



                                  //      System.out.println("Right 1: " + x + " " + y);
                                        x =right(ladder, x, y, startPoints, idx);
                                        idx++;
                                  //      System.out.println("Right 2: " + x + " " + y);
                                        break;
                                    }
                                }
                            }
                        }


                    }
//                    if(ladder[y][x] ==1 && y ==0){
//
//                    }
                    System.out.println("#" + test_case + " " +x);

                }

            }




        static int left(int [][] ladder, int x, int y, List startPoints, int idx){
            if(idx>0)
            return (int) startPoints.get(idx-1);
            else return (int) startPoints.get(idx);
        }

    static int right(int [][] ladder, int x, int y, List startPoints, int idx){

        if(idx<startPoints.size())
            return (int) startPoints.get(idx+1);
        else return (int) startPoints.get(idx);
    }

    }

