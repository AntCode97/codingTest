package y2021.m8d12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_패션왕신혜빈_실버3 {
    static int answer=0;
    static boolean selected[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(bf.readLine());

        for(int t=0;t<TC;t++){
            int N = Integer.parseInt(bf.readLine());
            //Map<String, String[]> clothes = new HashMap<>();
            String[][] clothes = new String[N][2];
            StringTokenizer st ;
            Map<String, List<String>> comC = new HashMap<>();
            for (int i=0;i<N;i++){
                st = new StringTokenizer(bf.readLine());
                String cloth = st.nextToken();
                String type = st.nextToken();
                clothes[i][0] = cloth;
                clothes[i][1] = type;
                if(comC.get(type) ==null){
                    List<String> c = new ArrayList<>();
                    c.add("");
                    c.add(cloth);
                    comC.put(type, c);
                } else{
                    List<String> c = comC.get(type);
                    c.add(cloth);
                    comC.put(type, c);
                }
            }
            answer=1;
            for(String key : comC.keySet()){
                answer*=comC.get(key).size();
            }
            System.out.println(answer-1);
        }
    }


}
