package 팔월23;

public class 유니온파인드{
    static int[] parent = new int[10];
    public static void main(String[] args) {

    }
    //각 원소를 자신을 팀장으로 하는 집합을 만드는 연산 makeSet
    static void makeSet() {
        for(int i = 0; i < 10; i++)
            parent[i] = i;
    }
    //내 팀장님을 구하는 연산
    static int findSet(int n) {
        if(n == parent[n])
            return n;
        else
            return findSet(parent[n]);
    }
    //두 팀을 합치는 unionSet
    static void unionSet(int a, int b) {
        //두 원소의 각 팀장을 먼저 찾는다.
        int pa = findSet(a);
        int pb = findSet(b);
        if( pa != pb )
            parent[pb] = pa;
    }
}