import java.util.*;
import java.lang.*;

class Solution {
    
    static int pricesLen;
    static int[] answer;
    static Queue<Integer> q = new LinkedList<>();
    
    public int[] solution(int[] prices) {
        init(prices);
        solve(prices); 
        return answer;
    }
    
    private static void init(int[] prices){
        pricesLen = prices.length;
        answer = new int[pricesLen];
    }
    
    private static void solve(int[] prices){
        for(int i=0; i<pricesLen; i++) {
            int price = prices[i];
            int count = 0;
            for(int j= i + 1; j<pricesLen; j++){
                count++;
                if(price > prices[j]){
                    break;
                }
            }    
            answer[i] = count;
        }
    }
}