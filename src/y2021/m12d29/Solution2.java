package y2021.m12d29;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
// 문장에 한 단어의 철자를 순서대로 반복해서 끼워 넣어 암호화하는 방법이 있습니다.
// 당신은 이 방법을 통해 문장을 암호화하려고 합니다.
//    예를 들어, 문장 "i love coding"이 주어지고 키워드 "mask"가 주어지면,
//    "mai lsovke cmodinag"과 같이 문장을 바꿀 수 있습니다.

//    키워드의 첫 번째 철자인 'm'은 원래 문장의 첫 글자인 'i'를 건너뛰지 않고 삽입되었고,
//    두 번째 철자인 'a'도 원래 문장의 글자를 건너뛰지 않고 'i' 앞에 삽입되었습니다.
//    세 번째 철자인 's'는 원래 문장의 'i l'을 건너뛴 후 삽입되었고,
//    네 번째 철자인 'k'는 원래 문장의 'ov'를 건너뛴 후 삽입되었습니다.
//    키워드의 마지막 철자인 'k'까지 삽입했다면 다시 첫 번째 철자부터 반복합니다.
//    이후, 'm'은 'e c'를 건너뛴 후 삽입되었고, 'a'는 'odin'을 건너뛴 후 삽입되었습니다.
//    따라서 키워드의 각 철자들이 건너뛴 문장의 글자 수는 [0, 0, 3, 2, 3, 4]입니다.
//    즉, 문장과 키워드, 건너뛸 글자 수를 나타내는 배열이 주어지면 암호문을 만들 수 있습니다.
//
//    복호화를 하는 방법은 단순합니다.
//    암호화된 문장을 왼쪽부터 한 글자씩 읽어가면서 키워드에 해당하는 철자가 나오면 해당 알파벳을 지우면 됩니다.
//    이때 암호화된 문장의 길이를 원래 문장의 길이와 맞추기 위해 철자를 삽입한 횟수만큼만 글자를 지웁니다.
//    위의 암호화 문장 "mai lsovke cmodinag"도 이 방법을 통해 원래 문장으로 복원할 수 있습니다.
//
//    그러나 복호화가 제대로 되지 않는 경우도 있습니다.
//    예를 들어 문장 "i love coding"과 키워드 "mode",
//    건너뛸 글자 수 [0, 10]이 주어지면 암호문 "mi love codoing"을 만들 수 있습니다.
//    위의 방법대로 복호화하면 m, o를 순서대로 지워, "i lve codoing"이라는 결과를 얻게 됩니다.
//    이런 결과가 나온 이유는 삽입된 키워드의 철자 대신 원래 문장의 글자를 지웠기 때문입니다.
//    이를 해결하기 위해 암호화를 할 때 다음과 같은 규칙을 따릅니다.
//
//    키워드의 철자를 삽입하기 위해 원래 문장을 건너뛰는 도중,
//    방금 건너뛴 글자와 이번에 삽입할 키워드의 철자가 같은 경우 건너뛰는 것을 중단하고 그 위치에 키워드의 철자를 삽입합니다.
//    위 예시의 경우, 0번 건너뛴 위치에 'm'을 삽입한 뒤,
//    다음 철자 'o'를 삽입하기 위해 10번 건너뛰는 도중에 "love"에서 'o'를 발견하고 "lo"뒤에 'o'를 삽입합니다.
//    따라서 "mi loove coding"으로 암호화됩니다. 키워드가 "mode"이고 키워드의 철자를 삽입한 횟수가 2이므로 왼쪽에서부터 첫 번째 'm'와 'o'을 지우면 원래 문장을 얻을 수 있습니다.
//    암호화하려는 문장을 나타내는 문자열 sentence, 키워드를 나타내는 문자열 keyword,
//    건너뛸 글자(또는 공백) 수를 순서대로 나타내는 정수 배열 skips가 매개변수로 주어집니다.
//    위 방법을 따라 만든 암호문을 return 하도록 solution 함수를 완성해주세요.
    public static String solution(String sentence, String keyword, int[] skips){
        StringBuilder sb = new StringBuilder(sentence);
        Queue<Character> queue = new LinkedList<>();
        int[] skips2 = new int[skips.length];
        for (int i=0;i<skips.length;i++) skips2[i] = skips[i];
        int lastIdx = 0;
        for (int i=0;i<skips.length ;i++){
            i=i;
            if(queue.isEmpty()){
                for (Character c : keyword.toCharArray()){
                    queue.add(c);
                }
            }
            Character c = queue.poll();
            int cidx = -1;
            for (int j=lastIdx;j<lastIdx+skips[i] && j<sb.length();j++){
                if(sb.charAt(j) == c){
                    cidx = j+1;
                    break;
                }
            }
            if (cidx != -1){
                sb.insert(cidx, c);
                lastIdx = cidx+1;

            } else{
                if(lastIdx+skips[i] == sb.length()){
                    sb.append(c);
                    lastIdx = sb.length();
                } else if (lastIdx+skips[i] < sb.length()){
                    sb.insert(lastIdx + skips[i], c);
                    lastIdx +=1 + skips[i];
                }

            }

        }
        return sb.toString() ;
    }
    public static void main(String[] args) {
        System.out.println(solution("i love coding", "mask", new int[]{0, 0, 3, 2, 3, 4})); //"mai lsovke cmodinag"
        System.out.println(solution("i love coding", "mode", new int[]{0, 10}));
        System.out.println(solution("abcde fghi", "axyz", new int[]{3, 9, 0, 1})); //"aabcde fghixy"
        System.out.println(solution("encrypt this sentence", "something", new int[]{0, 1, 3, 2, 9, 2, 0, 3, 0, 2, 4, 1, 3})); //"seoncrmypett thihisng ssenteonmcee"

    }
//    sentence	keyword	skips	result
//"i love coding"	"mask"	[0, 0, 3, 2, 3, 4]	"mai lsovke cmodinag"
//        "i love coding"	"mode"	[0, 10]	"mi loove coding"
//        "abcde fghi"	"axyz"	[3, 9, 0, 1]	"aabcde fghixy"
//        "encrypt this sentence"	"something"	[0, 1, 3, 2, 9, 2, 0, 3, 0, 2, 4, 1, 3]	"seoncrmypett thihisng ssenteonmcee"
}
