package 구월29;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 나무재테크_Solution {
    static int N, M, K; //N은 좌표의 크기, M은 나무의 수, K는 몇년인지
    //좌표의 각 칸은 증가값과 영양분으로 구성
    static class Node{
        int val;
        int nutirment = 5;
        Node(int val){
            this.val = val;
        }
    }
    static Node[][] map;
    static class Tree implements Comparable<Tree>{
        int r,c,age;
        Tree(int r, int c, int age){
            this.r = r;
            this.c = c;
            this.age = age;
        }
        @Override
        public int compareTo(Tree o) {
            // TODO Auto-generated method stub
            return Integer.compare(this.age, o.age);
        }
    }
    //모든 나무가 들어있을 공간
    static PriorityQueue<Tree> trees = new PriorityQueue<>();
    //봄에 살아남은 나무가 잠시 들어가있을 큐 ( 가을에 처리 됨 )
    static Queue<Tree> alive = new LinkedList<>();
    //봄에 죽은 나무가 잠시 들어가있을 큐 ( 여름에 처리 됨 )
    static Queue<Tree> dead = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new Node[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                map[i][j] = new Node(sc.nextInt());
            }
        }
        for(int i = 0; i < M; i++) {
            trees.add(new Tree(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        for(int i = 0; i < K; i++) {
            spring();
            summer();
            autumn();
            winter();
        }
        System.out.println(trees.size());
    }

    static void spring() {
        //모든 trees의 나무들을 다 꺼내서,
        while(!trees.isEmpty()) {
            Tree tree = trees.poll();
            //살수있다면, 산놈큐로 이동 ( 해당 위치의 양분을 자신의 나이만큼 먹음 )
            if( tree.age <= map[tree.r][tree.c].nutirment) {
                map[tree.r][tree.c].nutirment -= tree.age;
                tree.age++;
                alive.add(tree);
            }
            //죽어야된다면, 죽은놈큐로 이동
            else
                dead.add(tree);
        }
    }
    static void summer() {
        //죽은놈 큐를 다 꺼내면서, 해당 위치의 양분에 죽는 나무 나이/2
        while(!dead.isEmpty()) {
            Tree tree = dead.poll();
            map[tree.r][tree.c].nutirment += tree.age/2;
        }
    }
    static void autumn() {
        //산놈 큐를 돌면서, 8방에 새로운 나무를 심는다. (나무배열에 추가)
        while(!alive.isEmpty()) {
            Tree tree = alive.poll();
            //나이가 5배수인 나무이면
            if( tree.age % 5 == 0) {
                //8방에 자식나무들 생성
                for(int i = 0; i < 8; i++) {
                    int nr = tree.r + dr[i];
                    int nc = tree.c + dc[i];
                    if( nr >= 1 && nc >= 1 && nr <= N && nc <= N ) {
                        trees.add(new Tree(nr, nc, 1));
                    }
                }
            }
            //나도 죽진 않았음
            trees.add(tree);
        }
    }
    static void winter() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                map[i][j].nutirment += map[i][j].val;
            }
        }
    }


    static int[] dr = {-1,1,0,0,-1,-1,1,1};
    static int[] dc = {0,0,-1,1,-1,1,-1,1};
}