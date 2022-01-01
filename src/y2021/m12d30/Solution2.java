package y2021.m12d30;

import java.util.*;

public class Solution2 {

    public static String solution(int[] stones, int k) {
        List<String> answer = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(stones));
        int minCount = Integer.MAX_VALUE;
        while (!queue.isEmpty()){

            Node cur = queue.poll();
            //System.out.println(cur);
            int count = 0;
            int zeroCount = 0;
            int lastIdx = 0;
            for (int i=0;i<stones.length;i++){
                if(cur.stones[i] !=0) {
                    count++;
                    lastIdx = i;
                } else zeroCount++;
                if (count>2) break;
            }



            if (count == 1 && cur.stones[lastIdx] == k && cur.order.size() <= minCount){
                minCount = cur.order.size();
                StringBuilder sb = new StringBuilder();
                for (int a : cur.order) sb.append(a);
                answer.add(sb.toString());

            }
            if(count !=1 && zeroCount>1) continue;
            if (cur.order.size() > minCount) continue;



            for (int i=0;i<stones.length;i++){

                if (!check(cur.stones, i)) continue;
                int [] newStones = new int[stones.length];
                for (int s=0;s<stones.length;s++) newStones[s]=cur.stones[s];

                select(newStones, i);
                List<Integer> newOrder = new ArrayList<>();
                newOrder.addAll(cur.order);
                newOrder.add(i);

                queue.add(new Node(newStones,newOrder));

            }

        }
        if (answer.size() >1){
            Collections.sort(answer);
            return answer.get(answer.size()-1);
        }
        return "-1";

    }

    static class Node{
        int [] stones;
        List<Integer> order;

        public Node(int[] stones) {
            this.stones = stones;
            this.order = new ArrayList<>();
        }

        public Node(int[] stones, List<Integer> order) {
            this.stones = stones;
            this.order = order;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "stones=" + Arrays.toString(stones) +
                    ", order=" + order +
                    '}';
        }
    }

    static boolean check(int [] stones, int idx){
        for (int i=0;i<stones.length ;i++){
            if (i !=idx && stones[i] <=0) return false;

        }
        return true;
    }
    static void select(int [] stones, int idx){
        for (int i=0;i<stones.length ;i++){
            if (i !=idx ) stones[i]-=1;
            else stones[i]+=1;
        }

    }



    public static void main(String[] args) {

        System.out.println(solution(new int[]{1, 3, 2}, 3)); //"202"
        System.out.println(solution(new int[]{4, 2, 2, 1, 4}, 1)); //3213
        System.out.println(solution(new int[]{5, 7, 2, 4, },	20)); // -1
                	

    }


}
