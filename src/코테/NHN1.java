package 코테;

import java.util.*;

public class NHN1 {

    private static void solution(int N, Operation[] opers){
        int bIdx = 1;
        List<String> bs = new ArrayList<>();
        bs.add("1");
        Queue<String> delete = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            if(opers[i].type == OperationType.branch){
                if(bs.size() == bIdx){
                    bs.add(++bIdx+"");
                } else{
                    bs.add( delete.poll());
                }
            } else{
                delete.add(opers[i].value+"");
                bs.remove(opers[i].value-1);
            }
            System.out.println(Arrays.toString(bs.toArray()));
        }
        Collections.sort(bs);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<bs.size()-1;i++){
            sb.append(bs.get(i) + " ");
        }
        sb.append(bs.get(bs.size()-1));
        System.out.println(sb.toString());

    }

    static class Node implements Comparable<Node> {
        int idx;

        @Override
        public int compareTo(Node o) {
            return this.idx - o.idx;
        }
    }


    private static class Operation{
        OperationType type;
        Integer value;

        public Operation(OperationType type, Integer value){
            this.type = type;
            this.value = value;
        }

    }
    private static enum OperationType{
        branch, merge;
    }


    public static void main(String[] args) {

        int N = 7;
        Operation[] opers = new Operation[N];
//
//        opers[0] = new Operation(OperationType.branch, null) ;
//        opers[1] = new Operation(OperationType.merge , 2);
//        opers[2] = new Operation(OperationType.branch, null);
//        opers[3] = new Operation(OperationType.merge , 2);
//        opers[4] = new Operation(OperationType.branch, null);
//        opers[5] = new Operation(OperationType.merge , 2);
//        opers[6] = new Operation(OperationType.branch, null);
//
//
//        solution(N, opers);

        N = 9;
        opers = new Operation[N];

        opers[0] = new Operation(OperationType.branch, null) ;
        opers[1] = new Operation(OperationType.branch, null);
        opers[2] = new Operation(OperationType.branch, null);
        opers[3] = new Operation(OperationType.branch, null);
        opers[4] = new Operation(OperationType.branch, null);
        opers[5] = new Operation(OperationType.merge , 5);
        opers[6] = new Operation(OperationType.merge , 2);
        opers[7] = new Operation(OperationType.branch, null);
        opers[8] = new Operation(OperationType.merge , 3);


        solution(N, opers);
    }

}
