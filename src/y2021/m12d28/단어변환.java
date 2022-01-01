package 십이월28;

import java.util.LinkedList;
import java.util.Queue;

//프로그래머스
public class 단어변환 {

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        answer = bfs(begin, target, words);
        return answer;
    }

   static class Word {
        String word;
        int count = 0;
        public Word(String word, int count){
         this.word = word;
         this.count = count;
        }
    }

    static int check(String word, String target){
        int count = 0;
        int idx = -1;
        for (int i=0;i<word.length();i++){
            if(word.charAt(i) != target.charAt(i)){
                count +=1;
                idx = i;
            }

            if(count >2) return -1;
        }
        if (count==1) return idx;
        else return -1;
    }

    static int bfs(String begin, String target, String[] words){

        Queue<Word> wordQueue = new LinkedList<>();
        boolean visited [] = new boolean[words.length];
        wordQueue.add(new Word(begin, 0));
        int answer = 0;

        while(!wordQueue.isEmpty()){

            Word current = wordQueue.poll();

            if(current.word.equals(target)){
                answer = current.count;
                break;
            }

            for (int i=0; i<words.length; i++){
                String word = words[i];
                //바꿀 수 있는 지호가인
                if(visited[i]) continue;

                int idx = check(current.word, word);
                if(idx != -1 ){

                    visited[i] = true;
                    wordQueue.add(new Word(word, current.count+1));
               }


            }

        }
        return answer;

    }

    public static void main(String[] args) {

        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }


}
