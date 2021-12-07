package 팔월10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 백준_요세푸스문제_실버5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        List<Integer> people = new ArrayList<>();
        List<Integer> list = new ArrayList<>();


        for(int i=1;i<=N;i++){
            people.add(i);
        }

        int count=0;
        int count2=0;
        boolean cnt = false;
        int i =0;
        while (!people.isEmpty()){

            int M = people.size();
            count=0;

            for(;i<M;i+=K){
                if(i+K-1-count>=people.size()){
                    break;
                }
                list.add(people.get(i+K-1-count));
                //System.out.println(people.get(i+K-1-count) + " " + (i+K-1-count));
                people.remove(i+K-1-count);
                count++;
            }
            if(i+K-1-count>=people.size()){
                i -=M;
            }

        }
        System.out.print("<");
            for(int j=0;j<N;j++){
                if(j==N-1){
                    System.out.print(list.get(j));
                }else
                System.out.print(list.get(j) + ", ");
            }
        System.out.println(">");
    }
}
