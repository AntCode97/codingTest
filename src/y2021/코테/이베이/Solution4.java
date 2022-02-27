package y2021.코테.이베이;

public class Solution4 {

    public static int solution(int n, int k, String bulbs) {
        int answer = -2;

        char[] Bulbs2 = bulbs.toCharArray();
        int [] numbers = new int[bulbs.length()];



        return answer;
    }

    static void turn(char[] bulbs, int idx){
        if (bulbs[idx] == 'R') bulbs[idx] = 'G'; // R -> 3번
        else if (bulbs[idx] == 'G') bulbs[idx] = 'B'; // G -> 2번
        else if (bulbs[idx] == 'B') bulbs[idx] = 'R'; //B -> 1번번
   }

    public static void main(String[] args) {
        System.out.println(solution(6, 3 ,"RBGRGB"));  //"	3
        System.out.println(solution(3, 2 ,"BGG"));  //-1
        System.out.println(solution(4, 2 ,"GBBG"));  //"	6
        System.out.println(-2%3);
    }


}
