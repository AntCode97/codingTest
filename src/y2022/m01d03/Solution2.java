package y2022.m01d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        PriorityQueue<Burger> burgers = new PriorityQueue<>();

        for (int i=0;i<N;i++){
            int eatTime = Integer.parseInt(st.nextToken());
            int hotTime = Integer.parseInt(st2.nextToken());
            burgers.add(new Burger(hotTime, eatTime));
        }

        int time = 0;
        int endEat = 0;
        while (!burgers.isEmpty()){
            Burger cur = burgers.poll();
            time+= cur.hotTIme;
            endEat = Math.max(endEat, time+ cur.eatTime);

        }
        System.out.println(endEat);

    }

    static class Burger implements Comparable<Burger>{
        int hotTIme ;
        int eatTime ;

        public Burger(int hotTIme, int eatTime) {
            this.hotTIme = hotTIme;
            this.eatTime = eatTime;
        }

        @Override
        public int compareTo(Burger o) {
            return Integer.compare(o.eatTime, this.eatTime);
        }
    }
}
