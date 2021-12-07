package 시월01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 무선충전 {
    static int M;
    static int A;
    static int selected[];
    static User userA;
    static User userB;
    static BC [] bcs;
    static int maxSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            selected = new int[2];

            int moveA[] = new int[M+1];
            int moveB[] = new int[M+1];
            st = new StringTokenizer(br.readLine());
            for(int i =1; i<=M ;i++)
                moveA[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i =1; i<=M ;i++)
                moveB[i] = Integer.parseInt(st.nextToken());

            bcs = new BC[A];
            userA = new User(1,1);
            userB = new User(10,10);
            maxSum = Integer.MIN_VALUE;
            int ans=0;
            for(int i=0;i<A;i++){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());
                bcs[i] = new BC(c,r,C,P, i);
            }

            for(int time =0; time <= M ; time++){
                userA.r += dr[moveA[time]];
                userA.c += dc[moveA[time]];
                userB.r += dr[moveB[time]];
                userB.c += dc[moveB[time]];
                for(int i=0;i<A;i++){
                //    System.out.println(time+"위치"+ " " + userA.r +" "+ userA.c);
                    if(bcs[i].distance(userA)){
                        bcs[i].addUser(userA);
                    } else bcs[i].deleteUser(userA);
                    if(bcs[i].distance(userB)){
                        bcs[i].addUser(userB);
                    } else bcs[i].deleteUser(userB);
                }
               // System.out.println("시간"+time);
                //System.out.println("A위치"+ userA.r + " " +userA.c);
                //System.out.println("B위치"+ userB.r + " " +userB.c);
                if(!userA.bcs.isEmpty() || !userB.bcs.isEmpty()) {
                    maxSum = 0;
                    //System.out.println("time"+time);
                  //  System.out.println(Arrays.toString(userA.bcs.toArray()));
                   // System.out.println(Arrays.toString(userB.bcs.toArray()));
                    dfs(0,0);
                    //System.out.println(maxSum);
                    ans+=maxSum;
                }


                
            }

            System.out.println("#"+tc+ " " +ans);
        }
    }
    static int dr[] ={0, -1,0,1,0};
    static int dc[] ={0, 0, 1,0,-1};
    static void dfs(int cnt, int start){
        if(cnt ==2){
            //충전양 합 구하기
            //bcs[]
            boolean able =bcs[selected[0]].users.contains(userA);
            boolean bble =bcs[selected[1]].users.contains(userB);
            //System.out.println("A: "+selected[0] + " B:" + selected[1]);
            if(!able && !bble){
                return;
            }
            if(able && bble){
                if(selected[0] == selected[1]) {
                    maxSum = Math.max(maxSum,bcs[selected[0]].P);
                } else {
                    maxSum = Math.max(maxSum,bcs[selected[0]].P + bcs[selected[1]].P);
                }
            } else if(able) maxSum = Math.max(maxSum,bcs[selected[0]].P);
            else if(bble)  maxSum = Math.max(maxSum,bcs[selected[1]].P);

            return;
        }
        for(int i=0;i<A;i++){
            selected[cnt] =i;
            dfs(cnt+1, i+1);
        }
    }
    static class User{
        int r;
        int c;
        int sum=0;
        List<BC> bcs = new ArrayList<>();
        public User(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static class BC implements Comparable<BC>{
        int r, c;
        int idx;
        int C;
        int P;
        int amount;
        Queue<User> users ;
        public BC(int r, int c, int c1, int p, int idx) {
            this.r = r;
            this.c = c;
            this.C = c1;
            this.P = p;
            this.idx = idx;
            this.amount=P;
            users = new LinkedList<>();
        }
        public void addUser(User u){
            if(!users.contains(u)){
                users.add(u);
                u.bcs.add(this);
            }
        }
        public void deleteUser(User u){
            if(users.contains(u)){
                users.remove(u);
                u.bcs.remove(this);
            }
        }
        public void charge(){
            int size = users.size();
            int amount = P/size;
            while (!users.isEmpty()){
                User u = users.poll();
                u.sum += amount;
            }
        }
        public boolean distance(User u){
            int D = Math.abs(u.r - this.r) + Math.abs(u.c -this.c);
            if(this.C >=D) return true;
            else return false;
        }

        @Override
        public int compareTo(BC o) {
            return Integer.compare(this.amount, o.amount);
        }

    }
}
