package 십이월31.프로그래머스;

import java.util.HashMap;

public class 완주하지못한선수 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> peeple = new HashMap<>();

        for (String p : participant) {
            if (peeple.containsKey(p)) peeple.put(p, peeple.get(p)+1);
            else peeple.put(p, 1);
        }
        for (String c : completion){
            if (peeple.get(c) == 1) peeple.remove(c);
            else peeple.put(c, peeple.get(c)-1);
        }

        for (String key : peeple.keySet()){
            if(peeple.get(key) !=0) answer =key;
        }
        return answer;
    }
}
