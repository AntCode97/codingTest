package 백준;

import java.util.Scanner;

public class 스위치켜고끄기_1244_실버4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] switches = new int[N+1];

        for(int i =1; i<=N; i++){
            switches[i]= sc.nextInt();
        }
        int S = sc.nextInt();
        int [][] students = new int[S][2];
        for(int i = 0; i<S; i++){
            for(int j =0 ;j<2;j++)
                students[i][j] = sc.nextInt();
        }
        for(int i = 0; i<S; i++){
            //남자일 때
            if(students[i][0] ==1){
                for(int k =students[i][1]; k<=N; k+=students[i][1]){
                    if(switches[k] ==1){
                        switches[k] = 0;
                    } else switches[k] =1;
                }
            } else if(students[i][0] ==2){
                //여자일 때
                int idx = students[i][1];
                if(switches[idx] ==1){
                    switches[idx] = 0;
                } else switches[idx] =1;
                for(int k = 1; k<=N ; k++){
                    if(idx-k <1 || idx+k >N){
                        break;
                    }
                    if(switches[idx+k] ==switches[idx-k]){
                        if(switches[idx+k] ==1){
                            switches[idx+k] = 0;
                        } else switches[idx+k] =1;
                        if(switches[idx-k] ==1){
                            switches[idx-k] = 0;
                        } else switches[idx-k] =1;
                    } else{
                        break;
                    }
                }
            }

        }

        for(int i =1; i<=N; i++){

                System.out.print(switches[i] +" ");
                if(i %20==0){
                    System.out.println("");
                }
        }

    }

}
