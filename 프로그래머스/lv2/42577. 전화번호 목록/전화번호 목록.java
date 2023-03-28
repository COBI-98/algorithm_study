import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int m = phone_book.length;
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0;i<m;i++){
            hm.put(phone_book[i], phone_book[i].length());
        }
        
        for(String s : phone_book){
            for(int i = 1; i < s.length(); i++) {
				if(hm.containsKey(s.substring(0, i))) {
					return false;
				}
			}       
        }
        return answer;
    }
}