package 십이월31.구름;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 배열합치기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int [] arr = new int[A+B];
        //int [] brr = new int[B];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<A;i++) arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=A;i<A+B;i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        StringBuilder sb= new StringBuilder();
        for (int a : arr) sb.append(a+" ");
        System.out.println(sb.toString());

    }

}
