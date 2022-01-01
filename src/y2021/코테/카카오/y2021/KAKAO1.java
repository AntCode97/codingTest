package y2021.코테.카카오.y2021;

import java.util.*;

public class KAKAO1 {
    public Collection<Integer> solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        List<Integer> answer2 = new ArrayList<>();
        Map<String, Set<String>> ids = new LinkedHashMap<>();
        Map<String, Integer> ids2 = new LinkedHashMap<>();
        for(String a : id_list){
            ids.put(a, new HashSet<>());
            ids2.put(a, 0);
        }
        int count  =0;
        for(String b: report){

            String[] b2 = b.split(" ");
                ids.get(b2[1]).add(b2[0]);

            count++;
        }
        for(String key : ids.keySet()){
            if(ids.get(key).size() >= k) {
                for (String s : ids.get(key)) {
                    ids2.put(s, ids2.get(s)+1);
                //    System.out.println(key + " " + s);
                }
            }
        }

        return ids2.values();
    }

    public static void main(String[] args) {
        KAKAO1 k = new KAKAO1();

        k.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new	String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},	2);

    }
}
