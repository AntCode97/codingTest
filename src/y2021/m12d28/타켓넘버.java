package 십이월28;

import java.util.ArrayList;
import java.util.List;

public class 타켓넘버 {

    static List<Integer> add;
    static List<Integer> sub;
    static int targetSum = 0;
    public static int solution(int[] numbers, int target) {
        int answer = 0;

        add = new ArrayList<>();
        sub = new ArrayList<>();
        dfs(0, numbers, target);

        return targetSum;
    }

    public static void dfs(int idx, int[] numbers, int target){

        if(idx == numbers.length){
            int sum = 0;
            for (Integer a : add){
                sum+=a;
            }
            for (Integer s : sub){
                sum-=s;
            }
            if (sum == target) targetSum+=1;

            return ;

        }

        add.add(numbers[idx]);
        dfs(idx+1, numbers, target);
        add.remove(add.size()-1);
        sub.add(numbers[idx]);
        dfs(idx+1, numbers, target);
        sub.remove(sub.size()-1);


    }

    public static void main(String[] args) {

        System.out.println(solution(new int[] {1, 1, 1, 1, 1}, 3));

    }
}
