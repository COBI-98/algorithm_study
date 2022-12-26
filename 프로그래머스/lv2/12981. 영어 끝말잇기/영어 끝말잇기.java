import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> gameList = new ArrayList<>();
        int count = 0;
        int care = 1;
        for(int i = 0; i<words.length; i++){
            count++;
            if(!gameList.contains(words[i])){
                gameList.add(words[i]);
            } else{
                break;
            }
            
            if(i==0){
                continue;
            }
            String s= words[i-1].substring(words[i-1].length()-1,words[i-1].length());
            String p= words[i].substring(0,1);
            
            if(!s.equals(p)){
                break;
            }
           
            if(count == n){
                count = 0;
                care++;
            }
            
            
        }
        if(count != 0 ){       
            answer[0] = count;
            answer[1] = care;       
        }
        return answer;
    }
}