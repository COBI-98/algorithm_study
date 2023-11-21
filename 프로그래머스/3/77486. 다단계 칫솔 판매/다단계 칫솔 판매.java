import java.util.*;

class Solution {

    static final int AMOUNT_UNIT = 100;
    static int N;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        N = enroll.length;
        HashMap<String, String> memberMap = new HashMap<>();
        HashMap<String, Integer> indexMap = new HashMap<>();

        for (int idx = 0; idx < N; idx++){
            memberMap.put(enroll[idx], referral[idx]);
            indexMap.put(enroll[idx], idx);
        }
        
        int[] answer = new int[N];

        for (int i = 0; i < seller.length; i++){
            String person = seller[i];
            int quantity = amount[i];
            int salePrice = quantity * AMOUNT_UNIT;

            while (!person.equals("-")){
                int parentSalePrice = salePrice / 10;
                int mine = salePrice - parentSalePrice;
                answer[indexMap.get(person)] += mine;
                person = memberMap.get(person);
                salePrice /= 10;
                if (salePrice < 1) {
                    break;
                }
            }
        }
        return answer;
    }
}