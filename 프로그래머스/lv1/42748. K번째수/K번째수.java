import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int idx=0; idx<commands.length; idx++){
            int[] arr = array.clone();
            
            int i= commands[idx][0];
            int j= commands[idx][1];
            int k= commands[idx][2];
            
            int[] new_arr = Arrays.copyOfRange(arr, i-1, j);
            
            Arrays.sort(new_arr);
            answer[idx] = new_arr[k-1];
        }
        return answer;
    }
}