package 시월06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이분탐색_기타레슨_실버1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int videos[]= new int[N];
        int low =1, high =0;
        for(int i =0; i<N;i++){
            videos[i] = Integer.parseInt(st.nextToken());
            low = Math.max(low, videos[i]);
            high+=videos[i];
        }
        int answer = high;
        while (low <= high){
            int mid= (low + high)/2;
            int blue = mid;
            int count =1;

            for(int i=0;i<N;i++){
                //블루레이에 담을 수 있는 만큼 영상을 담는다.
                if(blue>= videos[i]) blue-=videos[i];
                //용량이 모자라면, 새 블루레이에 담는다.
                else {
                    count++;
                    blue = mid;
                    if(blue>= videos[i]){
                        blue-=videos[i];
                    } else break;


                }
            }
            //if(blue<mid) count++;
            //M개 만큼 블루레이를 사용했을 때
           // if(count == M )
            //블루레이를 너무 많이 사용함
            //블루레이 용량을 늘려야함
            if(count > M){
                low = mid+1;

            }
            else{
                //사용해야할 블루레이 갯수가 모자람
                //블루레이 크기를 줄여야함
                high = mid-1;
                answer= Math.min(answer, mid);

            }


        }
        System.out.println(answer);


    }
}
