package y2021.m8d13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 백준_캐슬디펜스_17135_골드4 {
    static boolean sel[];
    static int MaxSum=0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int ground [][] = new int[N][M];


        for(int i=0;i<N ;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                int k = Integer.parseInt(st.nextToken());
                ground[i][j] = k;
            }
        }
        sel = new boolean[M];
        powerSet(0,N, M,D, 0,ground);

        System.out.println(MaxSum);
    }

    static int distance(int hi, int hj, int ci, int cj){
        return Math.abs(hi-ci) + Math.abs(hj-cj);
    }
    static void powerSet(int idx,int N, int M,int D, int count, int[][] ground) {
        if(idx ==M) {
            if(count ==3){
                int maxsum=0;
                int [] archer = new int[3];
                int aidx =0;
                for(int i = 0; i < M; i++) {
                    if(sel[i])
                        archer[aidx++] = i;
                }
                Set<Integer[]> enemyList = new HashSet<>();
                for (int r=N;r>=0;r--){
                    Set<Integer[]> enemy = new HashSet<>();
                    for(int i=0;i<3;i++){
                        int mDis = Integer.MAX_VALUE;
                        int er = -1;
                        int ec =-1;
                        for(int d = 1;d<=D;d++){
                            for(int c =0;c<M;c++){
                                if(r-d>=0)
                                if(ground[r-d][c] == 1){
                                    int dis = distance(r-d,c, r, archer[i]);
                                    if(dis<=mDis && dis<=D){
                                        if(dis == mDis){
                                            if(ec >c){
                                                ec=c;
                                                er = r-d;
                                            }
                                        } else{
                                            mDis = dis;
                                            er = r-d;
                                            ec=c;
                                        }

                                    }
                                }
                            }
                        }
                        if(er!= -1 && ec !=-1) {
                            //System.out.println(r+" Archer:"+i+" kill!-> " +er+" "+ec);
                            enemy.add(new Integer[]{er, ec});
                        }
                    }
                    for(Integer [] ee : enemy){

                        if( ground[ee[0]][ee[1]] ==1){
                            //System.out.println(ee[0] + " " +ee[1]);
                            ground[ee[0]][ee[1]] =0;
                            //System.out.println(r+" Archer:"+" kill!-> " +ee[0]+" "+ee[1]);
                            enemyList.add(new Integer[]{ee[0],ee[1]});
                            maxsum+=1;
                        }

                    }

                }
//                System.out.print(maxsum+" archer: ");
//                for(int a =0;a<3;a++){
//                    System.out.print(archer[a] + " ");
//                }
//                System.out.println();
                for(Integer [] ee : enemyList){
                    if( ground[ee[0]][ee[1]] ==0){
                        ground[ee[0]][ee[1]] =1;
                    }
                }
                if(maxsum>MaxSum)
                    MaxSum=maxsum;
            }
            return;
        }
        sel[idx] = true;
        count++;
        powerSet(idx + 1,N, M, D,count, ground);
        sel[idx] = false;
        count--;
        powerSet(idx + 1,N, M, D,count, ground);
    }
}
