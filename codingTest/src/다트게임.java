public class 다트게임 {
    public static int solution(String dartResult) {
        int answer = 0;
        int tmpScore =0;
//        for(int i=0;i<dartResult.length();i++){
//
//        }
        while (dartResult.length()>1){
//            if(!(dartResult.contains("S") && dartResult.contains("D") && dartResult.contains("T"))){
//                answer
//            }
            dartResult = dartResult.replaceFirst("S", "K");
            String S[] = dartResult.split("K");
            dartResult = dartResult.replaceFirst("D", "K");
            String D[] = dartResult.split("K");
            dartResult = dartResult.replaceFirst("T", "K");
            String T[] = dartResult.split("K");

            if(S[0].length()<2) {
                System.out.println(S[0]);
                int score = Integer.parseInt(S[0]);
                if (S.length > 1) {
                    if (S[1].charAt(0) == '*') {
                        answer+=tmpScore;
                        answer += score * 2;
                        dartResult = S[1].substring(1, S[1].length());
                    } else if (S[1].charAt(0) == '#') {
                        answer -= score;
                        dartResult = S[1].substring(1, S[1].length());
                    } else {
                        answer += score;
                        dartResult = S[1];
                    }
                } else {
                    answer += score;
                    break;
                }
                tmpScore = score;
            }else  if(D[0].length()<2){

                int score = Integer.parseInt(D[0]);
                if(D.length>1){
                    if(D[1].charAt(0)=='*'){
                        answer+=tmpScore;
                        answer+=Math.pow(score,2)*2;
                        dartResult = D[1].substring(1, D[1].length());
                    } else if(D[1].charAt(0)=='#'){
                        answer-=score;
                        dartResult = D[1].substring(1, D[1].length());
                    } else{
                        answer+=Math.pow(score,2);
                        dartResult = D[1];
                    }
                } else {
                    answer+=Math.pow(score,2);
                    break;
                }
                tmpScore = score;
            } else  if(T[0].length()<2){

                int score = Integer.parseInt(T[0]);
                if(T.length>1){
                    if(T[1].charAt(0)=='*'){
                        answer+=tmpScore;
                        answer+=Math.pow(score,3)*2;
                        dartResult = T[1].substring(1, T[1].length());
                    } else if(T[1].charAt(0)=='#'){
                        answer-=score;
                        dartResult = T[1].substring(1, T[1].length());
                    } else{
                        answer+=Math.pow(score,3)*2;
                        dartResult = T[1];
                    }
                } else {
                    answer+=Math.pow(score,3);
                    break;
                }
                tmpScore = score;
            }

        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {

        solution("1S2D*3T");
        solution("1D2S#10S");
        solution("1D2S0T");
        solution("1S*2T*3S");
        solution("1D#2S*3S");
        solution("1T2D3D#");
        solution("1D2S3T*");
        solution("10D2S3T*");

    }
}
