package 팔월9;

import java.awt.*;
import java.util.LinkedList;
import java.util.Scanner;

public class 암호문1D3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int N = sc.nextInt();
            LinkedList<Integer> list = new LinkedList<Integer>();
            for(int i=0;i<N;i++){
                list.add(sc.nextInt());
            }
            int M = sc.nextInt();
            for(int i=0;i<M;i++){
                sc.next();
                int insertIdx = sc.nextInt();
                int insertN = sc.nextInt();
                for(int j=0;j <insertN; j++){
                    list.add(insertIdx++, sc.nextInt());
                }
            }
            System.out.print("#" +test_case + " ");
            for(int i=0;i<10;i++)
                System.out.print(list.get(i) + " ");
            System.out.println();

        }
    }
}
