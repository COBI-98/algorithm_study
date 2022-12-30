import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] sTrim = s.split(" ");
        List<Integer> test = new ArrayList<>();
        for(int i =0;i<sTrim.length;i++){
            test.add(Integer.valueOf(sTrim[i]));
        }
        
        Integer min = Collections.min(test);
        Integer max = Collections.max(test);
        answer = String.valueOf(min)+" "+String.valueOf(max);
        return answer;
    }
}