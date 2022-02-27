package y2022.m01d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution42 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b= Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

    }

    static int getCount(int n){

        int count =1;
        while (n!=1){
            if (n%2 !=0){
                n = 3*n+1;
                count++;
            }
            while (n%2==0){
                Double tmp =Math.log(n)/Math.log(2);
                if(tmp == Math.floor(tmp)){
                    count += Math.floor(tmp);
                    n = (int) (n/Math.pow(2, tmp));
                } else {
                    count++;
                    n/=2;
                }

            }

        }

        return count;
    }
}
