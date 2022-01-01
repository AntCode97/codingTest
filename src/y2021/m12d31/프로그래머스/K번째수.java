package 십이월31.프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i=0;i<commands.length;i++){
            List<Integer> a = new ArrayList<>();
            for (int j=commands[i][0]-1;j<commands[i][1];j++) a.add(array[j]);
            Collections.sort(a);
           answer[i]=  a.get(commands[i][2]-1);
        }
        return answer;
    }
}
