import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class test {
    public static void main(String[] args) {

        int sizeOfMatrix = 6;
        int [][] matrix = new int[6][6];

        List<Integer> space = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        for(int i=0;i<sizeOfMatrix;i++){
            for(int j=0;j<sizeOfMatrix;j++){
                if(matrix[i][j] ==1)
                {   int count = 0;
                    queue.add(new Node(i, j));
                    while (!queue.isEmpty()){
                        Node cur = queue.poll();
                        matrix[cur.r][cur.c] = 0;
                        count++;
                        for(int k=0;k<4;k++){
                            int nr = cur.r +dr[k];
                            int nc = cur.c + dc[k];
                            if(nr<0 || nc <0 || nr>=sizeOfMatrix || nc>=sizeOfMatrix) continue;
                            if(matrix[nr][nc] ==1){
                                queue.add(new Node(nr, nc));
                            }
                        }
                    }
                    space.add(count);
                }
            }
        }

        Collections.sort(space);
        System.out.println(space.size());
        StringBuilder sb = new StringBuilder();
        for (int c: space) sb.append(c+ " ");
        String answer = sb.toString();

        System.out.println(sb.toString().substring(0, sb.length()-1));

    }
    static int dr [] = {1,1,0,0};
    static int dc [] = {0,0,0,0};

    static class  Node {
        int r, c;

        public Node() {

        }

        public Node(int x, int y) {
            this.r = x;
            this.c = y;
        }
    }
}

