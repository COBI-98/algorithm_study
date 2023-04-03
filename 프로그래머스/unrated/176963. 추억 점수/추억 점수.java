import java.util.*;
class Solution {
    public static int photol;
    public static int [] answer;
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        photol = photo.length;
        answer = new int[photol];
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<name.length;i++){
            map.put(name[i],yearning[i]);    
        }
        
        
        for(int i=0; i<photol;i++){
            int count = 0;
            for(int j=0; j<photo[i].length;j++){
                if(map.containsKey(photo[i][j])){
                    count = count + map.get(photo[i][j]);
                }
            }
            answer[i] = count;
        }
        
        return answer;
    }
}