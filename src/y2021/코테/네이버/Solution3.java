package y2021.코테.네이버;

import java.util.*;

//미술 작품에 가격을 매기는 일은 쉽지 않습니다.
// 작품의 가치를 매길 수 있는 정확한 지표가 없기 때문입니다.
// 그렇기 때문에 사람의 주관이 많이 들어가게 됩니다.
//
//        이런 문제를 해결하기 위해 여러 전문가들에게 감정을 맡겨보기로 했습니다.
//        하지만 전문가도 항상 정당한 값을 매기기는 어렵습니다.
//        또 의도적으로 높게 혹은 낮게 가격을 매길 수 있습니다.
//        그래서 다음과 같은 4가지 방법으로 판매가를 결정하려고 합니다.
//        1번 방법부터 적용시킬 수 있으면 적용시켜서 판매가를 결정하고,
//        적용시킬 수 없다면 다음 방법으로 차례차례 넘어갑니다.
//          1
//        가장 비싸게 책정한 가격과 가장 싸게 책정한 가격의 차가 d원 이하라면,
//        모두 정당한 가격으로 책정했다고 판단해 전문가들이 제시한 모든 가격의 평균값으로 판매가를 결정합니다.
            //2
//        가장 비싸게 책정한 가격 하나와 가장 싸게 책정한 가격 하나를 제외시킵니다.
//        나머지 가격 중, 가장 비싸게 책정한 가격과 가장 싸게 책정한 가격의 차가 d원 이하라면,
//        앞서 제외한 두 가격 외에는 모두 정당한 가격이라고 판단해,
//        두 가격을 제외한 모든 가격의 평균값으로 판매가를 결정합니다.
//          3
//        전문가들이 매긴 모든 가격에서 임의로 k개의 가격을 골랐을 때
//        가장 비싸게 책정한 가격과 가장 싸게 책정한 가격의 차가 d원 이하라면,
//        그 k개의 가격이 정당하다고 판단해 그 k개의 평균값을 판매가로 결정합니다.
//        만약 정당한 가격을 책정한 k개의 가격을 고르는 방법이 여러 개라면,
//        그중에서 평균값이 가장 낮은 것을 판매가로 결정합니다.
            //4
//        중앙값을 판매가로 결정합니다.
//        즉, 전문가들이 매긴 모든 가격을 오름차순으로 정렬했을 때,
//        가운데 위치하는 가격을 판매가로 결정합니다. 가격의 개수가 짝수라면,
//        가운데 위치하는 두 가격 중에 크지 않은 가격을 판매가로 결정합니다.
//        [주의사항]: 평균값을 계산할 때 모든 소수점 이하는 버립니다.
//
//        전문가들이 매긴 가격들을 담은 정수 배열 prices, 정수 d, 정수 k 가 주어질 때,
//        미술 작품의 판매가를 return 하도록 solution함수를 완성해주세요.
public class Solution3 {

    static int[] selected ;
    static int minPrice;
    static boolean able ;
    public static int solution(int[] prices, int d, int k){
        int answer = 0;
        selected = new int[prices.length];
        minPrice = Integer.MAX_VALUE;
        able = false;


//          1
//        가장 비싸게 책정한 가격과 가장 싸게 책정한 가격의 차가 d원 이하라면,
//        모두 정당한 가격으로 책정했다고 판단해 전문가들이 제시한 모든 가격의 평균값으로 판매가를 결정합니다.
        int n = prices.length;
        Arrays.sort(prices);
        if (prices[n-1] -prices[0] <=d ) {
            answer =(int) Arrays.stream(prices).average().getAsDouble();
        }
        else {
            //2
//        가장 비싸게 책정한 가격 하나와 가장 싸게 책정한 가격 하나를 제외시킵니다.
//        나머지 가격 중, 가장 비싸게 책정한 가격과 가장 싸게 책정한 가격의 차가 d원 이하라면,
//        앞서 제외한 두 가격 외에는 모두 정당한 가격이라고 판단해,
//        두 가격을 제외한 모든 가격의 평균값으로 판매가를 결정합니다.
            if (prices[n-2] - prices[1] <=d ){
                answer = 0;
                for (int i=1;i<n-1;i++){
                    answer+=prices[i];
                }
                answer = answer/(n-2);
            }else{
            //          3
            //        전문가들이 매긴 모든 가격에서 임의로 k개의 가격을 골랐을 때
            //        가장 비싸게 책정한 가격과 가장 싸게 책정한 가격의 차가 d원 이하라면,
            //        그 k개의 가격이 정당하다고 판단해 그 k개의 평균값을 판매가로 결정합니다.
            //        만약 정당한 가격을 책정한 k개의 가격을 고르는 방법이 여러 개라면,
            //        그중에서 평균값이 가장 낮은 것을 판매가로 결정합니다.
                int [] numbers = new int[k];
                dfs(0, numbers, prices,0, k, prices.length,d);
                if (able){
                    int sum =0;
                    for (int a: selected){
                        sum+=a;
                    }
                    sum/=selected.length;
                    answer =sum;
                }
                else {
                    if(prices.length%2 ==0){
                        if (prices[prices.length/2] < prices[prices.length/2-1])
                            answer = prices[n/2];
                        else answer = prices[n/2-1];
                    }else answer = prices[n/2];
                }
            }

        }



        return answer ;
    }

    static void dfs(int cnt, int[] numbers, int[] prices, int start, int k, int n, int d){
        if(cnt == k){
            List<Integer> selects = new ArrayList<>();
            for (int num : numbers){
                selects.add(prices[num]);
            }
            int max = selects.stream().max(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o1, o2);
                }
            }).get();
            int min = selects.stream().min(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o1,o2);
                }
            }).get();

            if (max - min <=d){
                int average = (int)Arrays.stream(numbers).average().getAsDouble();
                if(average< minPrice){
                    minPrice = average;
                    selected = numbers;
                    able = true;
                }
            }

            return;
        }

        for(int i=start;i<n;i++){
            numbers[cnt] =i;
            dfs(cnt+1,numbers, prices,i+1, k,n,d);

        }

    }

    public static void main(String[] args) {
       System.out.println(solution(new int[]{4, 5, 6, 7, 8}	,4, 3)); //6
        System.out.println(solution(new int[]{4, 5, 6, 7, 8}	,2, 1)); //6
       System.out.println(solution(new int[]{4, 5, 6, 7, 8}	,1, 2)); //4
        System.out.println(solution(new int[]{8, 4, 5, 7, 6}	,1, 3)); //6
        System.out.println(solution(new int[]{1, 8, 1, 8, 1, 8}	,6, 4)); //1

    }
}
