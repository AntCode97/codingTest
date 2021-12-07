package 백준;

import java.util.LinkedList;
import java.util.Scanner;

public class 카드2_2164_실버4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
//        int cards[] = new int[N];
        LinkedList<Integer> cards = new LinkedList<>();
        for(int i=1;i<=N;i++){
            cards.add(i);
        }
        while (cards.size() >1){
            cards.removeFirst();
            Integer firstCard = cards.pollFirst();
            cards.add(firstCard);
        }
        System.out.println(cards.get(0));
    }
}
