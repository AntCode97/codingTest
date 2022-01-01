package 구월08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부등호_백준_실버2 {
    static double maxSign = Integer.MIN_VALUE;
    static double minSigh = Integer.MAX_VALUE;
    static char [] signs;
    static int N;
    static int [] numbers = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1,};
    static int [] answer ;
    static int [] maxA ;
    static int [] minA ;
    static boolean first = true;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        signs = new char[N];
        answer = new int[N+1];
        maxA = new int[N+1];
        minA = new int[N+1];
        Arrays.fill(answer, -1);
        for(int i =0;i <N;i++){
           signs[i] =  st.nextToken().charAt(0);
        }
        for(int i=0;i<10;i++){
            if(numbers[i]>0){
            numbers[i]--;
            answer[0] = i;
            dfs(1);
            answer[0] = -1;
            numbers[i]++;
            }
        }

//        System.out.println(Arrays.toString(signs));
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0 ; i<=N;i++){
            sb1.append(maxA[i]);
            sb2.append(minA[i]);
        }
        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
//        System.out.println(Arrays.toString(maxA));
//        System.out.println(Arrays.toString(minA));

    }

    static void dfs(int cnt){
        //System.out.println(cnt);
        //System.out.println(Arrays.toString(answer));
        if(cnt ==N+1){
            double sum = 0;

            for(int i=N;i>=0;i--){

                sum+=Math.pow(10, N-i)*answer[i];
            }
            if(first){
                first = false;
                maxA = Arrays.copyOf(answer, answer.length);
                minA = Arrays.copyOf(answer, answer.length);
            }
            if(sum > maxSign) {
                maxSign = sum;
                maxA = Arrays.copyOf(answer, answer.length);
            }
            if(sum < minSigh) {
                minSigh = sum;
                minA = Arrays.copyOf(answer, answer.length);
            }
//            System.out.println("도착: "+Arrays.toString(answer) + " " +sum);
            return;
        }
        int idx =0;
        for(; idx<10;idx++){
            if(numbers[idx] >0){
                if(isCorrect(answer[cnt-1], idx, signs[cnt-1])){
                    numbers[idx]--;
                    answer[cnt] = idx;
                    dfs(cnt+1);
                    numbers[idx]++;
                    answer[cnt] = -1;
                }

            }
        }
    }
    static boolean isCorrect(int a, int b, char c){
        if(c =='>'){
            return a>b;
        } else return a<b;
    }

}
