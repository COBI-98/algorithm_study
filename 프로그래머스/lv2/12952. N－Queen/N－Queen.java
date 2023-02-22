import java.util.*;

class Solution {
    public static int answer = 0;
    public static int [] map;
    public int solution(int n) {
        
        map = new int[n];
        nQueen(0,n);
        return answer;
    }
    
    public static void nQueen(int depth, int n){
        if(depth == n){
            answer++;
            return;
        }
        
        for(int i=0; i<n; i++){
            map[depth] = i;
            if(nQueenCheck(depth)){
                nQueen(depth+1,n);
            }
        }
    }
    
    public static boolean nQueenCheck(int col){
        
        for(int i=0; i< col ; i++){
            if(map[col] == map[i] ){
                return false;
            }
            
            if(Math.abs(map[col] - map[i]) == Math.abs(col-i)){
                return false;
            }
        }    
        
        return true;
    }
}