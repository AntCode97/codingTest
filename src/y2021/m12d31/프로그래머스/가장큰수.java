package 십이월31.프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 가장큰수 {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        List<Integer> nums = new ArrayList<>();
        for (int n:numbers) nums.add(n);

        Collections.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer s1 = Integer.parseInt(o1+""+o2);
                Integer s2 = Integer.parseInt(o2+""+o1);

                return Integer.compare(s2, s1);
            }
        });

        for (int n: nums) answer.append(n);
        if (answer.charAt(0)=='0') return "0";
        return answer.toString();
    }

}
