class Solution {
    public static int answer = 0;
    public static int n;
    public static int size;
    public static boolean [] visited;
    public int solution(String begin, String target, String[] words) {
        n = begin.length();
        size = words.length;
        
        visited = new boolean[size];
        
        dfs(0,begin,target,words);
        
        return answer;
    }
    
    public static void dfs(int cnt, String begin, String target, String[] words){
        
        
        if(begin.equals(target)){
            answer = cnt;
            return;
        }
        
        for(int i=0; i<size; i++){
            if(visited[i]){
                continue;
            }
            
            int k = 0;
            
            for(int j = 0; j<n; j++){
                if(begin.charAt(j) == words[i].charAt(j)){
                    k++;
                }
            }
            
            if(k == n-1){
                visited[i] = true;
                dfs(cnt+1,words[i],target,words);
                visited[i] = false;
            }
        }
        
        
        
    }
}