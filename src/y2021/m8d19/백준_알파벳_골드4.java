package y2021.m8d19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 백준_알파벳_골드4 {
    static char [][] board;

    static int answer = 0;
    static int count = 0;
    static int R, C;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        for(int i =0; i<R;i++){
            String ss = bf.readLine();
            for(int j=0;j<C;j++){
                board[i][j] = ss.charAt(j);
            }
        }
        Set<Character> charSet = new HashSet<>();
        dfs(0,0,0, charSet);
        System.out.println(answer);
    }
    static void dfs(int r, int c, int idx, Set charSet){
        if(charSet.contains(board[r][c])){
            answer = Math.max(answer, idx);
            return;
        } else{
            charSet.add(board[r][c]);
        }
        for(int i=0; i<4;i++){
            int nr = r+ dr[i];
            int nc = c+ dc[i];
            if(nr>=0 && nr<R && nc>=0 && nc <C){
                dfs(nr, nc, idx+1, charSet);
                //charSet.remove(board[nr][nc]);
            }
        }
        charSet.remove(board[r][c]);
    }
    static int[] dr = { -1, 1, 0, 0};
    static int[] dc = { 0, 0, 1, -1};

}
