package y2022.m01d01;

public class 정수삼각 {
    static int[][] DP = new int[501][501];
    public static int solution(int[][] triangle) {

        DP[0][0] = triangle[0][0];
        int answer = DP[0][0];
        int height = triangle.length;

        for (int i=1;i<height;i++){
            for (int j=0; j<=i;j++){

                //피라미드 젤 왼쪽
                if(j==0){
                    DP[i][j] = DP[i-1][j] + triangle[i][j];
                }else if(j == i){
                    DP[i][j] = DP[i-1][j-1] + triangle[i][j];
                }  else{
                    DP[i][j] = Math.max(DP[i-1][j-1], DP[i-1][j]) + triangle[i][j];
                }

                // 최대값 갱신
                answer = Math.max(answer, DP[i][j]);

            }
        }



        return answer;
    }
    public static void main(String[] args) {
        
    
        System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    
    }
}
