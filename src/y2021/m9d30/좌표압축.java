package y2021.m9d30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 좌표압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(bf.readLine());


        Map<Integer, Integer> map = new HashMap<>();
        String s = bf.readLine();
        String [] ss = s.split(" ");
        int array[] = new int[N];
        for(int i =0 ;i< N ;i++){
            array[i] = Integer.parseInt(ss[i]);
        }
        int [] array2 = array.clone();

        Arrays.sort(array2);
;
        int count = 0;
        for(int i : array2){
            if(!map.containsKey(i))
               map.put(i, count++);
        }


        for(int i =0; i<N;i++){
            System.out.print(map.get(array[i]) + " ");
        }
    }
}
