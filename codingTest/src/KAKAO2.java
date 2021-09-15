import java.util.*;

public class KAKAO2 {

    public int solution(int n, int k) {
        int answer = 0;

            StringBuilder sb = new StringBuilder();
            int a = (int) (Math.log(n) / Math.log(k));
//        System.out.println(a);
//        System.out.println(Math.pow(k, a));
            while (n > 0 && a >= 0) {
                int m = (int) Math.pow(k, a);
                if (n >= m) {
                    int count = 1;
                    while (n >= count * m) {
                        count++;
                    }
                    count--;
                    if (count == 0) count = 1;
                    n -= count * m;
                    sb.append(count);
                } else {
                    sb.append(0);
                }
                a--;
                //System.out.println(n+ " " +a);
            }
            String res = sb.toString();
            if (res.length() > 0) {
                String[] res2 = res.split("0");
                for (String s : res2) {
                    s = s.trim();
                    if (s.length() > 0 && Character.isDigit(s.charAt(0))) {
                        //System.out.println(s);
                        int p = Integer.parseInt(s.trim());
                        boolean cnt = true;
                        for (int i = 2; i <= (int) Math.sqrt(p); i++) {
                            if (p % i == 0) {
                                cnt = false;
                                break;
                            }
                        }
                        if (cnt && p > 1) {
                            answer++;
                        }
                    }

                }

               System.out.println(answer);
            }


        return answer;
    }

    public static void main(String[] args) {
        KAKAO2 k = new KAKAO2();
        k.solution(437674, 3);
        k.solution(110011, 10);
        k.solution(3, 3);
        k.solution(123456, 9);
    }
}

