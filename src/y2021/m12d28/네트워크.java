package 십이월28;

public class 네트워크 {
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean visited [] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i])
            answer+= dfs(i, computers, visited, n);
        }
        return answer;
    }

    public static int dfs(int idx, int[][] computers, boolean[] visited, int n){

        visited[idx] = true;
        for (int i=0;i<n;i++){
            //컴퓨터가 연결되어 있고 방문하지 않은 노드일 때
            if(i!=idx && computers[idx][i] ==1 && !visited[i]){
                dfs(i, computers, visited, n);
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
}
