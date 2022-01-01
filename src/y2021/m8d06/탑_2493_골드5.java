package y2021.m8d06;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 탑_2493_골드5 {



    public static void main(String[] args) throws IOException {{
        class Tower {
            int index;
            int height;
            int target=0;


            public Tower(int index, int height) {
                this.index = index;
                this.height = height;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getTarget() {
                return target;
            }

            public void setTarget(int target) {
                this.target = target;
            }

            public int getIndex() {
                return index;
            }

            public void setIndex(int index) {
                this.index = index;
            }

        }
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        List<Tower> towers = new ArrayList<>();
        StringTokenizer stoken = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            towers.add(new Tower(i+1, Integer.parseInt(stoken.nextToken())));
        }

        //레이저를 수신할 수 있는 타워
        Stack<Tower> st = new Stack<>();
        for(int i=0; i<N;i++){

            Tower t = towers.get(i);
            //레이저를 수신하지 못하는 탑들 제거
            while ( !st.empty() && st.peek().getHeight() < t.getHeight() ){
                st.pop();
            }

            //스택에 타워가 남아 있을 떄
            if(!st.empty())
                t.setTarget(st.peek().getIndex());


            st.push(t);
        }


        for(int i=0;i<N;i++){
            System.out.print(towers.get(i).getTarget() + " ");
        }
    }
    }}