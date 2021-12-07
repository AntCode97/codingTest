package 구월29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 나무재테크_골드4 {
    static int N, M, K;
    static int map[][];
    static int ground[][];
    static LinkedList<Tree> treeMap[][];
    static Queue<Tree> deletes;
    static Queue<Tree> alive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        ground = new int[N+1][N+1];
        treeMap = new LinkedList[N+1][N+1];
        deletes = new LinkedList<>();
        alive = new LinkedList<>();
//        가장 처음에 양분은 모든 칸에 5만큼 들어있다.
        for(int i=1;i<=N;i++) Arrays.fill(ground[i], 5);

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                treeMap[i][j] = new LinkedList<>();
            }
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            treeMap[r][c].add(new Tree(age));
        }

        while (K>0){
            //봄
            //나이가 어린 나무부터 양분을 먹는다.
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){

                    Collections.sort(treeMap[i][j]);
                        while (!treeMap[i][j].isEmpty()){
                            Tree t= treeMap[i][j].poll();
                            if(ground[i][j] >= t.age){
                                //봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다.
                                ground[i][j] -=t.age;
                                t.age+=1;
                                t.r =i;
                                t.c =j;
                                alive.add(t);
                            } else{
                                deletes.add(t);
                            }
                        }
                        while (!deletes.isEmpty()){
                            Tree t = deletes.poll();
                            ground[i][j] += Math.floor(t.age/2);
                        }

                }
            }

            //가을
            // 가을에는 나무가 번식한다. 번식하는 나무는 나이가 5의 배수이어야 하며,
            // 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
            while(!alive.isEmpty()) {
                Tree t = alive.poll();
                if (t.age != 0 && t.age%5==0 ) {
                    for(int d=0;d<8;d++){
                        int nr = t.r + dr[d];
                        int nc = t.c + dc[d];
                        // 상도의 땅을 벗어나는 칸에는 나무가 생기지 않는다.
                        if(nr <1 || nc <1|| nr>N ||nc>N) continue;
                        treeMap[nr][nc].add(0, new Tree(1));
                    }
                }
                treeMap[t.r][t.c].add(t);
            }
            //겨울
            //겨울에는 S2D2가 땅을 돌아다니면서 땅에 양분을 추가한다. 각 칸에 추가되는 양분의 양은 A[r][c]이고, 입력으로 주어진다.
            for(int i=1;i<=N;i++) {
                for (int j = 1; j <= N; j++) {
                    ground[i][j] +=map[i][j];
                }
            }
            K--;
        }
        int sum=0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                sum += treeMap[i][j].size();
            }
        }
        System.out.println(sum);



    }
    static int dr [] = new int[]{-1, -1, -1, 0, 0, 1, 1,1};
    static int dc [] = new int[]{-1, 0, 1, -1, 1, -1, 0,1};
    static class Tree implements Comparable<Tree>{
        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Tree){
                Tree t = (Tree) obj;
                super.equals(t.age);
            }
            return super.equals(obj);
        }

        int age;
        int r;
        int c;
        public Tree(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return Integer.compare(this.age ,o.age);
        }
    }
    static void print(){
        System.out.println("==================");
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}