import java.util.HashSet;
import java.util.Set;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Set<Integer> list = new HashSet<>();
        for(int i=0; i<6; i++){
            list.add(win_nums[i]);
        }
        int count = 0;
        int zeroCheck = 0;
        for(int i=0; i<6; i++){
            if(list.contains(lottos[i])){
                count++;
            }
            
            if(lottos[i] == 0){
                zeroCheck++;
            }
        }
        int best = count + zeroCheck;
        int worst = count;
        if(best == 6) answer[0] = 1;
        else if(best == 5) answer[0] = 2;
        else if(best == 4) answer[0] = 3;
        else if(best == 3) answer[0] = 4;
        else if(best == 2) answer[0] = 5;
        else answer[0] = 6;
        
        if(worst == 6) answer[1] = 1;
        else if(worst == 5) answer[1] = 2;
        else if(worst == 4) answer[1] = 3;
        else if(worst == 3) answer[1] = 4;
        else if(worst == 2) answer[1] = 5;
        else answer[1] = 6;
        
        return answer;
    }
}