package 구월30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 좋은친구_골드3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long count =0;
        LinkedList<Integer> queue []= new LinkedList[21];
        for(int i=0;i<21;i++) queue[i] = new LinkedList<>();
        for (int i=0;i<N;i++){
            int len = br.readLine().length();
            while (!queue[len].isEmpty() && i - queue[len].peek() > K){
                queue[len].poll();
            }
            count += queue[len].size();
            queue[len].add(i);

        }

        System.out.println(count);
    }

}
