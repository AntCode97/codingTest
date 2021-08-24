package 팔월23;


import java.util.*;

public class Contact_D4 {

    static int N;
    static int Start;
    static int maxDepth;
    static int [] depth;
    static int answer = Integer.MIN_VALUE;
    static int answer2 = Integer.MIN_VALUE;
    static Map<Integer, List<Integer>> nums;
    static Map<Integer, Boolean> visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int tc = 1; tc<=10 ;tc++){
            N = sc.nextInt();
            Start = sc.nextInt();
            answer = Start;
            nums = new HashMap<>();
            visited = new HashMap();
            depth = new int[N];
            for(int i=0;i<N/2;i++){
                int a = sc.nextInt();
                if(nums.containsKey(a)){
                    visited.put(a, false);
                    List aList = nums.get(a);
                    aList.add(sc.nextInt());
                    nums.put(a, aList);
                } else{
                    visited.put(a, false);
                    List<Integer> aList = new ArrayList<>();
                    aList.add(sc.nextInt());
                    nums.put(a, aList);
                }
            }
            bfs(0);

            System.out.println("#"+tc+" "+ answer2);


        }
    }

    static  void bfs(int idx){
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        List slist = nums.get(Start);
        Node start = new Node(Start);
        start.depth=0;
        start.neighbors = slist;
        queue.add(start);
        visited.put(Start, true);
        while (!queue.isEmpty()) {
            int maxV = 0;
            while (!queue.isEmpty()) {
                Node n = queue.poll();

                if (n.neighbors != null) {

                    for (int k = 0; k < n.neighbors.size(); k++) {
                        int nextNum = n.neighbors.get(k);
                        if (visited.containsKey(nextNum)) {
                            if (visited.get(nextNum)) continue;
                        }

                        Node nextN = new Node(nextNum);
                        nextN.neighbors = nums.get(nextNum);
                        nextN.depth = n.depth + 1;
                        queue2.add(nextN);
                        visited.put(nextNum, true);

                    }
                }
            }
            queue = queue2;
            for(Node no : queue2){
                maxV = Math.max(maxV, no.num);
            }
            if(queue2.isEmpty()){
                answer2= answer;
            }
            answer = maxV;

            queue2 = new LinkedList<>();
        }
    }
    static class Node{
        int num;
        int depth;
        List<Integer> neighbors;
        Node(int num){
            this.num = num;
            neighbors= new ArrayList<>();
        }
    }

}
