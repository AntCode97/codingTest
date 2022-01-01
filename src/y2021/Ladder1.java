package y2021;

import java.io.IOException;
import java.util.Scanner;

public class Ladder1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        for(byte test_case = 1 ; test_case <=10; test_case++){
            byte ladder [][] = new byte[100][100];
            byte N = (byte) sc.nextInt();
            byte dx [] = { -1, 1};
            for(byte i =0; i<100;i++) {
                for (byte j = 0; j < 100; j++) {
                    ladder[i][j] = (byte) sc.nextInt();
                }
            }

            for(byte x = 0 ;x<100;x++){
                byte y  =99;
                if(ladder[y][x] ==2){
                    //System.out.println("시작" + test_case + " " +x + " "+y);
                    for(;y>0;y-=1){

                    for(byte i =0 ; i<2;i++){
                        byte nx = (byte) (x + dx[i]);
                        if( nx >=0 && nx <100 ){
                            if( ladder[y][nx] ==1){
                                if(i==0){
                                   //System.out.println("Left 1: " + x + " " + y);
                                    x-=left(ladder, x ,y);
                                    //System.out.println("Left 2: " + x + " " + y);
                                    break;
                                } else if(i ==1){



                                    //System.out.println("Right 1: " + x + " " + y);
                                    x +=right(ladder, x, y);

                                    //System.out.println("Right 2: " + x + " " + y);
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
//                    break;
                    //System.out.println("오류 체크" + x + " " + y);
                    break;
                }

            }

            }
        }

        static byte left(byte [][] ladder, byte x, byte y){
            byte count =0;
            while (ladder[y][x] ==1 ){
                if(x>0){
                    x--;
                    count+=1;
                }
                else{
                    count+=1;
                    break;
                }
            }
            return (byte) (count-1);
        }

    static byte right(byte [][] ladder, byte x, byte y){
        byte count =0;
        while (ladder[y][x] ==1 ){
            if(x<99){
                x++;
                count+=1;
            }
            else {
                count+=1;
                break;
            }
        }
        return (byte) (count-1);
    }

    }

