package y2021.코테.네이버;

//1번부터 순서대로 번호가 매겨진 사람들이 카드를 각각 30장씩 갖고 있습니다. 카드는 빨간색(R), 초록색(G), 파란색(B) 3종류이며,
// 가장 적게 갖고 있는 카드 매수로 점수가 결정됩니다. 예를 들어 빨간 카드 10장, 초록 카드 5장, 파란 카드 15장으로 구성된 카드 뭉치를 갖고 있다면 5점을 받습니다.
//
//        모든 사람은 한 번씩, 다른 사람과 카드를 1장 교환할 수 있는 기회를 가집니다. 원하지 않는다면 기회를 쓰지 않을 수도 있습니다. 만약 다른 사람의 교환 신청을 받아들여 교환을 했다면 교환 기회를 사용한 것으로 간주합니다. 모든 교환이 끝난 뒤, 사람들의 카드 점수 합을 구하려고 합니다.
//
//        사람들은 다음과 같은 규칙에 따라 교환 상대를 정합니다.
//
//        1번 사람부터 차례대로 교환 상대를 지목합니다.
//        교환을 통해 양쪽이 동시에 이득을 볼 수 있어야 합니다. 즉, 각자의 점수(=가장 적게 갖고 있는 카드 매수)가 동시에 상승해야 합니다.
//        교환 가능한 사람이 여러 명일 경우, 가장 번호가 낮은 사람과 교환합니다.

import java.util.HashMap;

public class Solution1 {
    public static int solution(int[][]cards){
        int answer = 0;
        int N = cards.length;

        Person[] people = new Person[N];

        for (int i=0;i<N;i++){
            people[i] = new Person(cards[i]);
        }

        for(int i=0;i<N;i++){

            for (int j=i+1; j<N;j++){
                people[i].exchange(people[j]);
            }

            answer+=people[i].score;
        }

        return answer ;
    }

    static class Person{

        char scoreCard ;
        int exchangeCount =1;
        int score ;
        HashMap<Character, Integer> cards;
        Person(int[]cards){
            this.cards = new HashMap<>();
            this.cards.put('R', cards[0]);
            this.cards.put('G', cards[1]);
            this.cards.put('B', cards[2]);
            

            this.getScore();
        }
        Person(Person p){
            this.scoreCard = p.scoreCard;
            this.score = p.score;
            this.cards = new HashMap<>();
            this.cards.putAll(p.cards);
            this.exchangeCount = p.exchangeCount;
        }

        void getScore(){
            if (this.cards.get('R') < this.cards.get('G')){
                if (this.cards.get('R') < this.cards.get('B')) scoreCard = 'R';
                else scoreCard = 'B';
            } else if(this.cards.get('G') < this.cards.get('B')) scoreCard = 'G';
            else scoreCard = 'B';
            score = this.cards.get(scoreCard);

        }

        void exchange(Person p){
            //교환으로 서로 이득을 볼 수 있다면
            Person tmp1 = new Person(this);
            Person tmp2 = new Person(p);
            if( p.cards.get('R').equals(p.cards.get('G')) && p.cards.get('G').equals(p.cards.get('B'))) return;

            if (this.exchangeCount>0 && p.exchangeCount>0 && this.cards.get(p.scoreCard) >0
                    && p.cards.get(this.scoreCard) >0){
                this.cards.put(p.scoreCard, this.cards.get(p.scoreCard) -1);
                p.cards.put(p.scoreCard, p.cards.get(p.scoreCard)+1);

                p.cards.put(this.scoreCard, p.cards.get(this.scoreCard) -1);
                this.cards.put(this.scoreCard, this.cards.get(this.scoreCard)+1);

                this.getScore();;
                p.getScore();
                //System.out.println(tmp1.score+ "바꾸기전"+  tmp2.score);
                if (!(tmp1.score < this.score && tmp2.score < p.score)){
                    this.scoreCard = tmp1.scoreCard;
                    this.score = tmp1.score;
                    this.cards = new HashMap<>();
                    this.cards.putAll(tmp1.cards);

                    p = tmp2;
                } else{
                    this.exchangeCount=0;
                    p.exchangeCount=0;
                }
                //System.out.println(this.score+ "바꾼후"+  p.score);
            }
        }

    }

    public static void main(String[] args) {

        System.out.println(solution(new int[][]{{10, 5, 15}, {5, 15, 10}, {10, 11, 9}}));
        System.out.println(solution(new int[][] {{10, 5, 15}, {8, 9, 13}, {10, 10, 10}} ));
        System.out.println(solution(new int[][] {{8, 11, 11}, {6, 15, 9}, {14, 2, 14}, {8, 20, 2}} ));
        System.out.println(solution(new int[][] {{8, 11, 11}, {10, 7, 13}, {15, 10, 5}, {7, 17, 6}}));
        System.out.println(solution(new int[][] {{0, 0, 30}, {30, 0, 0}} ));


    }
}
