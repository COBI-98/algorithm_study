import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        int len = queue1.length;
        long sum1 = 0;
        long sum2 = 0;
        
        long target = (sum1 + sum2) / 2;
        
        int answerCnt = 0;
        
        
        
        for(int i=0;i<len;i++){
            sum1 += queue1[i];
            sum2 += queue2[i];
            que1.offer(queue1[i]);
            que2.offer(queue2[i]);
       }

         
        while(sum1 != sum2){
            if(answerCnt >= len*3) return -1;
            
            if(sum1 > sum2){
                sum1 -= que1.peek();
                que2.offer(que1.peek());
                sum2 += que1.poll();
                
            }else{
                sum2 -= que2.peek();
                que1.offer(que2.peek());
                sum1 += que2.poll();
            }
            answerCnt++;
            
        }
        
        return answerCnt;
    }
}