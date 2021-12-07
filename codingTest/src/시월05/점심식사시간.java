package 시월05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 점심식사시간 {
    static int pcount;
    static int selected[];
    static int ans;
    static int N;
    static  List<Person> people;
    static Stair [] stairs;
    static int map [][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            boolean visited[][] = new boolean[N][N];

            stairs = new Stair[2];
            int count =0;
            people = new ArrayList<>();
            //계단에서 매초 마다, 도달할 수 있는 사람을 체크
            //도달한 사람은 큐에 넣고, 시간이 다 되었으면 나가게 해줌
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] >1){
                        stairs[count++] = new Stair(i, j);
                        visited[i][j] = true;
                    }
                }
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j] ==1){
                        people.add(new Person(i, j, distance(stairs[0].r, stairs[0].c , i, j), distance(stairs[1].r, stairs[1].c , i, j)));
                    }
                }
            }
            pcount = people.size();
            selected= new int[pcount+1];
            ans = Integer.MAX_VALUE;
            dfs(0);
            System.out.println("#"+tc+" " +ans);

        }
    }
    static int dr[] = {-1, 1, 0 ,0};
    static int dc[] = {0, 0, -1, 1};

    static void dfs(int idx){
        if(idx == pcount) {
            ans = Math.min(ans, getTime(pcount));
       //     System.out.println("dd"+ans);
            return;
        }

        selected[idx] = 0;
        dfs(idx + 1);
        selected[idx] = 1;
        dfs(idx + 1);
    }

    private static int getTime(int pcount) {
        stairs[0].waiting.clear();
        stairs[1].waiting.clear();

        for(int i =0; i<people.size();i++){
            stairs[selected[i]].waiting.add(new Node(people.get(i).r, people.get(i).c, distance(stairs[selected[i]].r, stairs[selected[i]].c , people.get(i).r, people.get(i).c)));
        }

        int time = 0;
        while (true){
            time++;
            for(int i=0;i<2;i++){

                //계단에 도착한 후, K만큼의 시간이 지났는가?
                while (!stairs[i].people.isEmpty() && time - stairs[i].people.peek().t >= map[stairs[i].r][stairs[i].c]){
                    stairs[i].people.poll();
                    pcount--;
                }

                //계단에 도착할만큼 시간이 지났는가?
                while (!stairs[i].waiting.isEmpty()){
                    boolean cnt = false;
                    Node person = stairs[i].waiting.peek();
                    //도착하고 1초 뒤에 계단에 내려가기 시작하므료 >= 아닌 >
                    if(time - person.t >0){
                        //이미 계단에 있는 사람이 아닌가?
                        if(stairs[i].people.size()<3){
                            person = stairs[i].waiting.poll();
                            person.t = time;
                            stairs[i].people.add(person);
                            continue;
                        }


                    }
                    break;
                }
            }
            if(stairs[0].waiting.isEmpty() && stairs[1].waiting.isEmpty() && stairs[0].people.isEmpty() && stairs[1].people.isEmpty()){
                break;
            }
        }
        //System.out.println("t"+time);
        return time;
    }

    static class Node implements Comparable<Node>{
        public Node(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.t = time;
        }
        int r;
        int c;
        int t;

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.t, o.t);
        }
    }

    static class Person implements Comparable<Person>{
        public Person(int r, int c, int time1, int time2) {
            this.r = r;
            this.c = c;
            this.d[0] = time1;
            this.d[1] = time2;
        }
        int r;
        int c;
        int sel;
        int[] d = new int[2];

        @Override
        public int compareTo(Person o) {
            return Integer.compare(this.d[selected[sel]], o.d[selected[o.sel]]);
        }
    }
    static int distance(int r1, int c1, int r2, int c2){
        return Math.abs(r1- r2) + Math.abs(c1- c2);
    }
    static class Stair{
        int r;
        int c;
        Queue<Node> people;
        Queue<Node> waiting;

        public Stair(int r, int c) {
            this.r = r;
            this.c = c;
            this.people = new PriorityQueue<>();
            this.waiting = new PriorityQueue<>();
        }
    }
}
