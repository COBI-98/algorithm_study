import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        int len = choices.length;
        
        Map<String,Integer> map = new HashMap<>();
        // hashmap 활용
        map.put("R",0);
        map.put("T",0);
        map.put("C",0);
        map.put("F",0);
        map.put("J",0);
        map.put("M",0);
        map.put("A",0);
        map.put("N",0);
        
        for(int i =0; i<len;i++){
            String A = String.valueOf(survey[i].charAt(0));
            String B = String.valueOf(survey[i].charAt(1));
            
            if(choices[i] == 4){
                continue;
            }else if(choices[i] > 4){
                map.put(B, map.get(B) + (choices[i] - 4));
            }else{ 
                map.put(A, map.get(A) + (4 - choices[i]));
            }
        }
        
        if(map.get("R") >= map.get("T")){
            answer += "R";
        }else{
            answer += "T";
        }
        
        if(map.get("C") >= map.get("F")){
            answer += "C";
        }else{
            answer += "F";
        }
        
        if(map.get("J") >= map.get("M")){
            answer += "J";
        }else{
            answer += "M";
        }
        
        if(map.get("A") >= map.get("N")){
            answer += "A";
        }else{
            answer += "N";
        }
        
        return answer;
    }
}