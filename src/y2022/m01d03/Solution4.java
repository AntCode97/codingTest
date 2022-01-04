package y2022.m01d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int maxCount=0;
        for (int i=b;i>=a;i--){
            int c= getCount(i);
            maxCount = Math.max(maxCount, c);
            System.out.println(c+ " "+ maxCount);
        }
        System.out.println(maxCount);

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
