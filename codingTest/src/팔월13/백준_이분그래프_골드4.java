package 팔월13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_이분그래프_골드4 {
    static Long count =0L;
    static int V;
    static int E;
    static List<Integer> cycle;

    public static void main(String[] args) throws IOException {
        BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int tc=0;tc<K;tc++){
            st = new StringTokenizer(bf.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            int vertexs[][] = new int[V+1][2];


            for(int i=1;i<=V;i++) {
                vertexs[i][0] =i;
                vertexs[i][1] =i;
            }
            for (int e=0;e<E;e++){
                st = new StringTokenizer(bf.readLine());
                unionParent(vertexs, Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            }

            for(int i=1;i<=V;i++) {
                boolean cnt = false;
                boolean cnt2=false;
                cycle = new ArrayList<>();
                System.out.println("싸이클 체크: "+ i);
                int c = getParent(vertexs, i);
                if(c==-1){
                    System.out.println("싸이클 발생 "+ i+"점갯수"+cycle.size());

                    if(cycle.size()%2!=0) {
                        cnt = true;
                    }
                    for(int k =0;k<cycle.size()-1;k++){
                        if(!checkLine(vertexs,cycle.get(k),cycle.get(k+1))){
                            cnt2=true;
                            break;
                        }
                    }
                    if(!checkLine(vertexs,cycle.get(0),cycle.get(cycle.size()-1)))
                        cnt2=true;

                    if(cnt && (!cnt2)) {
                        System.out.println("NO");
                        break;
                    } else{
                        System.out.println("YES");
                        break;
                    }
                }
            }

        }
    }
    static int getParent(int parent[][], int x){
        int a=-1;
        System.out.println(x+" "+ parent[x][0]+" "+ parent[x][1]);

        if(cycle.contains(x)){
                if (cycle.contains(parent[x][1]))
                    return -1;
                else {
                    cycle.add(parent[x][1]);
                    a= getParent(parent, parent[x][1]);
                }

        }
        else {
            cycle.add(x);
            a= getParent(parent, parent[x][0]);
            if(!cycle.contains(parent[x][1]))
                a=getParent(parent, parent[x][1]);
        }
        if(parent[x][1] == x) return x;
        return a;
    }

    static int findParent(int parent[][], int a, int b){
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a == b) return 1;
        else return 0;
    }
    static boolean checkLine(int vertexs[][], int a, int b){
        if(vertexs[a][0] ==b || vertexs[a][1] ==b) return true;
        if(vertexs[b][0] ==a || vertexs[b][1] ==a) return true;
        return false;
    }


    static boolean unionParent(int parent[][], int a, int b) {

        parent[a][0] = b;
        parent[b][1] = a;
        //System.out.println(a+" "+b);
        boolean result = false;
//        cycle = new ArrayList<>2 3();
//        int a2 = getParent(parent, a);
//        if(a2 == -1) System.out.println("싸이클 발생!"+a +"연결횟수: "+ cycle.size());
//        cycle = new ArrayList<>();
//        int b2 = getParent(parent, b);
//        if(b2 == -1) System.out.println("싸이클 발생!"+a +"연결횟수: "+ cycle.size());


        return result;
    }
}
