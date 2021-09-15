package 팔월24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 서로소집합_D4 {
    static int N; //원소 개수
    static int M; //연산 개수
    static int[] parents; // 부모원소를 관리(트리처럼 사용)
    private static void make() {
        // 모든 원소를 자신을 대표자로 만듦
        for(int i =1;i<=N;i++){
            parents[i] = i;
        }
    }
    //a가 속한 집합의 대표자 찾기
    private static int find(int a) {
        if(a == parents[a]) return a; // 자신이 대표자
        return parents[a] = find(parents[a]); // 자신이 속한 집합의 대표자를 자신의 부모로 : path compression
    }
    //두 원소를 하나의 집합으로 합치기(대표자를 이용해서 합침)
    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false; // 이미 같은 집합이므로 합치지 않음
        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(bf.readLine());
        for(int tc =1;tc<=T;tc++){
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder("#"+ tc+ " ");
            parents = new int[N+1];
            make();
            for(int i =0 ;i<M;i++){
                st = new StringTokenizer(bf.readLine());
                int t = Integer.parseInt(st.nextToken());
                if(t==0){
                    union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                } else{
                    int aRoot = find(Integer.parseInt(st.nextToken()));
                    int bRoot = find(Integer.parseInt(st.nextToken()));
                    if(aRoot ==bRoot) sb.append(1);
                    else sb.append(0);
                }
            }
            System.out.println(sb.toString());
        }


    }
}
