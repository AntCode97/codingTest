package y2022.m01d03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Solution1 {
    public static void main(String[] args) throws Exception {
     BufferedReader br = new BufferedReader(new InputStreamReader(in));
     StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    if(m ==1 ){
        System.out.println("INFINITE");
        return;
    }
    int answer = n;
    int coupon = n;

    while (coupon >=m){
        int plus = coupon/m;
        coupon %=m;
        answer+=plus;
        coupon+=plus;
    }

        System.out.println(answer);

    }
}
