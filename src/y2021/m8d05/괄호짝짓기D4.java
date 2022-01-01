package y2021.m8d05;

import java.util.Scanner;
import java.util.Stack;

public class 괄호짝짓기D4 {
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);



        for(int test_case = 1; test_case <= 10; test_case++)
        {

            Stack<String>parentheses1 = new Stack<>();
            Stack<String>parentheses2 = new Stack<>();
            Stack<String>parentheses3 = new Stack<>();
            Stack<String>parentheses4 = new Stack<>();

            int N=sc.nextInt();
            sc.nextLine();
            String a = sc.nextLine();
            boolean cnt = true;
            //System.out.println(a);
            for(int i=0 ; i<N;i++){
              char p = a.charAt(i);
              if(p=='(') parentheses1.push(p+"");
              else if(p=='[') parentheses2.push(p+"");
              else if(p=='{') parentheses3.push(p+"");
              else if(p=='<') parentheses4.push(p+"");
              else if(p==')') {
                    if(parentheses1.size() > 0){
                        parentheses1.pop();
                    } else {
                        cnt = false;
                        break;
                    }
                } else if(p==']') {
                    if(parentheses2.size() > 0){
                        parentheses2.pop();
                    } else {
                        cnt = false;
                        break;
                    }
                }
                else if(p=='}') {
                    if(parentheses3.size() > 0){
                        parentheses3.pop();
                    } else {
                        cnt = false;
                        break;
                    }
                }
                else if(p=='>') {
                    if(parentheses4.size() > 0){
                        parentheses4.pop();
                    } else {
                        cnt = false;
                        break;
                    }
                }



            }
            int answer = 0;
            if(cnt && parentheses1.isEmpty() && parentheses2.isEmpty() && parentheses3.isEmpty() && parentheses4.isEmpty() ){
                answer = 1;
            }
            System.out.println("#" +test_case + " " +answer);

        }
    }
}
