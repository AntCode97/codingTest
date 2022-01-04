package y2021.m9d24;

import java.io.IOException;
import java.util.Scanner;

public class Flatten {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1 ; test_case <=10; test_case++){
            int dump [] = new int[100];
            int N = sc.nextInt();
            int max = 0, min = 100;
            int maxIdx =0, minIdx=0;

            for(int i =0; i<100;i++){
                dump[i] = sc.nextInt();
                if(dump[i] > max){
                    max = dump[i];
                    maxIdx = i;
                }
                if(dump[i] < min){
                    min = dump[i];
                    minIdx = i;
                }
            }
            while (N >0){
                if(dump[minIdx] < dump[maxIdx]) {
                    //System.out.println(N+" " +dump[minIdx] + " " + dump[maxIdx] + " " + maxIdx+ " " + minIdx);
                    dump[minIdx]+=1;
                    dump[maxIdx]-=1;
                    max --;
                    min++;
                    N--;

                }else{
                    break;
                }


                for(int i =0; i<100;i++){
                    if(dump[i] > max){
                        max = dump[i];
                        maxIdx = i;
                    }
                    if(dump[i] < min){
                        min = dump[i];
                        minIdx = i;
                    }
                }
            }
            System.out.println("#" + test_case + " " + (dump[maxIdx] - dump[minIdx]));
        }

    }
}
