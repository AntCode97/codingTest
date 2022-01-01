package 구월29;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회전초밥_골드4 {
    public static void main(String[] args) throws IOException {
        //회전 초밥 벨트에 놓인 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        //맛있겠다..
        int sushi[] = new int[N];
        int visited[] = new int[d+1];
        for(int i=0;i<N;i++){
            sushi[i] = Integer.parseInt(br.readLine());
        }


        int max =0;
        int start=0;
        int count =0;
        for(int i=0;i<N+k;i++){

            if(visited[sushi[i%N]] ==0){
                count++;
            }
            visited[sushi[i%N]]++;

            if(i >= k-1){

//                //쿠폰쓸 초밥이 없을 때
                if(visited[c] ==0)
                    max = Math.max(max, count+1);
                else max = Math.max(max, count);
                visited[sushi[start%N]]--;
                if( visited[sushi[start%N]] ==0) count--;
                start++;
            }
        }

        System.out.println(max);
    }

}
