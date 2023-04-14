import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int priority : priorities){
            pq.offer(priority);
        }
        
        while(!pq.isEmpty()){
            for(int i=0; i< priorities.length;i++){
                if(priorities[i] == pq.peek()){
                    if(i == location){
                        answer++;
                        return answer;
                    }
                    answer++;
                    pq.poll();
                }
            }
        }
        return answer;
    }
}