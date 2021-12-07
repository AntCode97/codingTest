package 팔월10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 사칙연산유효성검사_D4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for(int test=1; test<=10;test++){
           int N = Integer.parseInt(bf.readLine());
            String [] nodes = new String[N+1];
            StringTokenizer st ;
            int N2 = (int) (Math.log(N)/Math.log(2));
            for(int i=1;i<=N;i++){
                st =new StringTokenizer(bf.readLine());
                st.nextToken();
                nodes[i] = st.nextToken();
                if(i*2<N) {
                    nodes[i*2] = st.nextToken();
                }
                if(i*2+1<N) {
                    nodes[i*2+1] =st.nextToken();
                }
            }
            int result =1;
            for(int i=N ; i>=1 ; i--){
                if(N%2==0){
                    result=0;
                    break;
                }
                if(i*2<N){
                    //문자
                    if(CheckNumber(nodes[i]))
                    {
                        result=0;
                        break;
                    }
                }else {
                    //숫자
                    if(!CheckNumber(nodes[i]))
                    {
                        result=0;
                        break;
                    }
                }
            }
            System.out.println("#"+test + " " + result);
        }
    }
    public static boolean CheckNumber(String str){
        char check;

        if(str.equals(""))
        {
            //문자열이 공백인지 확인
            return false;
        }

        for(int i = 0; i<str.length(); i++){
            check = str.charAt(i);
            if( check < 48 || check > 58)
            {
                //해당 char값이 숫자가 아닐 경우
                return false;
            }

        }
        return true;
    }
}

