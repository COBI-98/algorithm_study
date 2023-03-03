import java.util.*;

class Solution {
    
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int m = number.length();
        int size = m - k;
        int count = 0;
        int check = 0;
        
        while(size > 0){
            int max = -1;
            for(int i=count; i<=m-size;i++){
                if(number.charAt(i) > max){
                    max = number.charAt(i);
                    check = i;
                }
            }
            count = check+1;
            sb.append(String.valueOf(number.charAt(check)));
            
            size--;
        }
        
        return sb.toString();
    }
}