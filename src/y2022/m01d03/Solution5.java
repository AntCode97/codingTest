package y2022.m01d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N ==0) {
            System.out.println(0);
            return;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(Math.abs(o2), Math.abs(o1));
            }
        });
        PriorityQueue<Integer> wait = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(Math.abs(o2), Math.abs(o1));
            }
        });
        for (int i=0;i<N;i++){
            queue.add(Integer.parseInt(br.readLine()));
        }
        int first = queue.poll();
        int nowSize = Math.abs(first);

        // 음수면 -1, 양수면 1
        int able = first/nowSize;
        int count = 1;

        while (!queue.isEmpty()){
            int cur = queue.poll();
            int curSize = Math.abs(cur);
            int curAble = cur/curSize;

            if (curSize < nowSize && able != curAble){
                nowSize= curSize;
                able = curAble;
                count++;
            }
        }

        System.out.println(count);


    }
}
