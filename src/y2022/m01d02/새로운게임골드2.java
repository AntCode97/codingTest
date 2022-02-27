//package y2022.m01d02;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Stack;
//import java.util.StringTokenizer;
//
//import static java.lang.System.in;
//
//public class 새로운게임골드2 {
//    //체스판 좌표에서 가장 위에 있는 말의 인덱스
//    static int[][] location;
//    static Piece [] pieces;
//    static int N;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//
//        int[][] map = new int[N][N];
//        location = new int[N][N];
//
//        for (int i=0;i<N;i++){
//            st = new StringTokenizer(br.readLine());
//            Arrays.fill(location[i], -1);
//            for (int j=0;j<N;j++){
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        pieces = new Piece[K];
//        for (int i=0;i<K;i++){
//            st = new StringTokenizer(br.readLine());
//            int r = Integer.parseInt(st.nextToken()), c= Integer.parseInt(st.nextToken()), d= Integer.parseInt(st.nextToken());
//            r--;c--;
//            pieces[i] = new Piece(r,c,d, i);
//            location[r][c] = i;
//        }
//        int turn = 0;
//
//        while (turn <= 1000){
//            turn++;
//            for (int i=0;i<K;i++){
//
//
//                int nd = pieces[i].dircet;
//                int nr = pieces[i].r + dr[nd];
//                int nc = pieces[i].c + dc[nd];
//
//
//                move(N, map, i, nd, nr, nc);
//
//
//                if (pieces[i].check()){
//                    System.out.println(turn);
//                    return;
//                }
//
//
//            }
//        }
//
//        System.out.println(-1);
//
//
//    }
//
//    private static void move(int N, int[][] map, int i, int nd, int nr, int nc) {
//        if(nr >= N || nr <0 || nc >= N || nc <0) {
//            if (nd %2 ==1) nd +=1;
//            else nd -=1;
//            pieces[i].dircet = nd;
//            nr = pieces[i].r + dr[nd];
//            nc = pieces[i].c + dc[nd];
//            if (map[nr][nc] ==2) return;
//            else if (map[nr][nc] ==1) pieces[i].reverseMove(nd);
//            else move(N, map, i, nd, nr, nc);
//        }
//        else if (map[nr][nc] == 1){
//            pieces[i].reverseMove(nd);
//        } else if(map[nr][nc] ==2){
//            if (nd %2 ==1) nd +=1;
//            else nd -=1;
//            pieces[i].dircet = nd;
//            nr = pieces[i].r + dr[nd];
//            nc = pieces[i].c + dc[nd];
//            if(nr >= N || nr <0 || nc >= N || nc <0) return;
//            if (map[nr][nc] ==2) return;
//            else if (map[nr][nc] ==1) pieces[i].reverseMove(nd);
//            else move(N, map, i, nd, nr, nc);
//
//        } else {
//            pieces[i].move(nd);
//        }
//
//    }
//
//    static int[] dr = {0, 0, 0, -1, 1};
//    static int[] dc = {0, 1, -1, 0 ,0};
//    static class Piece{
//        public Piece(int r, int c, int dircet, int idx) {
//            this.r = r;
//            this.c = c;
//            this.dircet = dircet;
//            this.idx = idx;
//        }
// //1부터 순서대로 →, ←, ↑, ↓
//        int r;
//        int c;
//        int dircet;
//        int idx;
//
//        Piece up;
//        Piece down;
//
//        void move(int d){
//
//
//            int nr = r+dr[d];
//            int nc = c+dc[d];
//            int nd = d;
//
//            if(nr >= N || nr <0 || nc >= N || nc <0) {
//                if (nd %2 ==1) nd +=1;
//                else nd -=1;
//                dircet = nd;
//                nr = r + dr[nd];
//                nc = c + dc[nd];
//                if(nr >= N || nr <0 || nc >= N || nc <0) return;
//            }
//
//            int nowTop = location[r][c];
//            //밑의 말이 있으면, location을 밑의 말로 바꿈
//            if(down != null) location[r][c] = down.idx;
//            else location[r][c] = -1;
//
//            this.r += dr[nd];
//            this.c += dc[nd];
//
//            if (location[r][c] != -1){
//                //이동한 자리에 있던 말을 아래로 깔고
//                down = pieces[location[r][c]];
//                //이동한 자리에 있던 말은 this를 위로 올린다.
//                pieces[location[r][c]].up = this;
//                location[r][c] = nowTop;
//            } else down = null;
//            if (up!=null){
//                Piece tmp = up;
//                while (tmp != null){
////                up.move(nd);
//                    tmp.r= this.r;
//                    tmp.c= this.c;
//                    tmp = tmp.up;
//                }
//            }
//
//
//        }
//        public void reverseMove(int nd) {
//            Stack<Piece> order = new Stack<>();
//            Piece tmp = this.up;
//            while (tmp != null){
//                order.add(tmp);
//                tmp = tmp.up;
//            }
//            if (!order.isEmpty()){
//
//                Piece piece = order.pop();
//                Piece bottom = piece;
//                piece.up = piece.down;
//                piece.down = null;
//                while (!order.isEmpty()){
//                    piece = order.pop();
//                    Piece oldUp = piece.up;
//                    piece.up = piece.down;
//                    piece.down = oldUp;
//                }
//                piece.up = null;
//                bottom.move(nd);
//            } else this.move(nd);
//
//
//        }
//        boolean check(){
//            if (up !=null){
//                int count = 0;
//                Piece tmp = up;
//                while (tmp != null){
//                    count++;
//                    tmp = tmp.up;
//                    if (count >=4) return true;
//                }
//            }
//
//            if (down !=null){
//                int count = 0;
//                Piece tmp = down;
//                while (tmp != null){
//                    count++;
//                    tmp = tmp.down;
//                    if (count >=4) return true;
//                }
//            }
//
//            return false;
//        }
//
//
//    }
//}
