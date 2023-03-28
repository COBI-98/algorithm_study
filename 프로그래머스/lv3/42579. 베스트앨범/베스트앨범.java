import java.util.*;
import java.io.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        int m = genres.length;
        HashMap<String,Integer> hm = new HashMap<>();
        HashMap<Integer,Integer> hmidx = new HashMap<>();
        
        for(int i = 0; i<m;i++){
            hmidx.put(i,plays[i]);
        }
        for(int i=0; i<m;i++){
            if(hm.containsKey(genres[i])){
                hm.put(genres[i],hm.get(genres[i])+plays[i]);
            }else{
                hm.put(genres[i],plays[i]);    
            }         
        } 
        
        List<String> keySet = new ArrayList<>(hm.keySet());
        keySet.sort((o1, o2) -> hm.get(o2).compareTo(hm.get(o1)));
        
        List<Integer> idxkeySet = new ArrayList<>(hmidx.keySet());
        idxkeySet.sort((o1, o2) -> hmidx.get(o2).compareTo(hmidx.get(o1)));
        
        
        for(String s : keySet){
            int count = 1;
            for(int i : idxkeySet){
                if(genres[i].equals(s) && count<3){
                    count++;
                    answer.add(i);
                }
            }
        }
        
        return answer;
    }
}