import java.util.*;
class Solution {
    static ArrayList<int[]> list = new ArrayList<int[]>();
    static int maxScore = Integer.MIN_VALUE;
    static int[] ryan;
    static int[] apeach;
    static int len;
    
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        len = info.length;
        ryan = new int[len];
        apeach = info;
        
        dfs(n, 0, 0);
        
        if(maxScore <= 0) {
            return new int[]{-1};
        }
        
        Collections.sort(list, (o1, o2) -> {
           for(int i=len-1;i>=0;i--){
               if(o1[i] != o2[i]) return o2[i] - o1[i];
           } 
           return 0;
        });
        
        return list.get(0);
    }
    
    public static void dfs(int n, int depth, int start){
        if(depth == n){
            int a_sum = 0;
            int r_sum = 0;
            for(int i=0;i<len;i++){
                if(apeach[i] == 0 && ryan[i] == 0) continue;
                if(apeach[i] >= ryan[i]) a_sum += (10-i);
                else r_sum += (10-i);
            }
            
            if(r_sum > a_sum){
                int score = r_sum - a_sum;
                if(maxScore < score){
                    maxScore = score;
                    list.clear();
                    list.add(ryan.clone());
                } else if(maxScore == score){
                    list.add(ryan.clone());
                }
            }
            
            return;
        }
        
        for(int i=start;i<len;i++){
            ryan[i]++;
            dfs(n, depth+1, i);
            ryan[i]--;
        }
    }
}