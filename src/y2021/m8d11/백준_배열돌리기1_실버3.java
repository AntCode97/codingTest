package y2021.m8d11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_배열돌리기1_실버3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int N2 =  N, M2=M;
        int [][] nums = new int[N][M];
        int MaxCount = Math.min(N, M)/2;
        int count = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++)
                nums[i][j] = Integer.parseInt(st.nextToken());
        }
        while (count<MaxCount){
            int [] corners = new int[4];
            corners[0] = nums[count][count];
            corners[1] = nums[N2-1-count][count];
            corners[2] = nums[N2-1-count][M2-1-count];
            corners[3] = nums[count][M2-1-count];
            for (int i=0;i<4;i++){
                System.out.print(corners[i] + " ");
            }
            System.out.println();
            //윗변

            for(int i=0;i<M-1-count;i++){

                System.out.println("윗변"+ " " +  i + " " + count);
                nums[count][count+i]=nums[count][count+i+1];
            }
            nums[count+1][count] =  corners[0];
            for (int i=0;i<N2;i++){
                for(int j=0;j<M2;j++){
                    System.out.print(nums[i][j] + " ");
                }
                System.out.println();
            }

            //좌변

            for(int i=0;i<N-1-count;i++){
                System.out.println("좌변"  +  i + " " + count);
                nums[N-1-count-i][count]=nums[N-2-count-i][count];
            }
            nums[count+1][count] =  corners[0];
            for (int i=0;i<N2;i++){
                for(int j=0;j<M2;j++){
                    System.out.print(nums[i][j] + " ");
                }
                System.out.println();
            }

            //밑변

            for(int i=0;i<M-1-count;i++){

                System.out.println("밑변"+ " " +  i + " " + count);
                nums[N-1-count][M-1-count-i]=nums[N-1-count][M-2-count-i];
            }
            nums[N-1-count][count+1] =  corners[1];

            for (int i=0;i<N2;i++){
                for(int j=0;j<M2;j++){
                    System.out.print(nums[i][j] + " ");
                }
                System.out.println();
            }

            //우변

            for(int i=0;i<N-1-count;i++){

                System.out.println("우변"+ " " +  i + " " + count);
                nums[i+count][M-1-count]=nums[count+i+1][M-1-count];
            }
            nums[N-2-count][M-1-count] =  corners[2];
            for (int i=0;i<N2;i++){
                for(int j=0;j<M2;j++){
                    System.out.print(nums[i][j] + " ");
                }
                System.out.println();
            }

            count++;

        }
        for (int i=0;i<N2;i++){
            for(int j=0;j<M2;j++){
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }
}
