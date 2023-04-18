import java.util.*;
class Solution {
    // 오른쪽 왼쪽 대각선 m-1 n-1 까지 
    // 거꾸로 돌면서 비어있다면 그자리 차지.
    public static char[][] blockMap;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        blockMap = new char[m][n];
        
        for(int i=0; i<m;i++){
            String str = board[i];
            for(int j=0;j<n;j++){
                blockMap[i][j] = str.charAt(j);
            }
        }
        
        while(true){
            int count = 0;
            boolean[][] checked = new boolean[m][n];
            for(int i=0; i<m-1;i++){
                for(int j=0; j<n-1;j++){
                    if(blockMap[i][j] == 0 || blockMap[i][j+1] == 0
                      || blockMap[i+1][j] == 0 || blockMap[i+1][j+1] == 0){
                        continue;
                    }
                    if(blockMap[i][j] == blockMap[i][j+1]
                      && blockMap[i][j] == blockMap[i+1][j]
                      && blockMap[i][j] == blockMap[i+1][j+1]){
                        checked[i][j] = true;
                        checked[i+1][j] = true;
                        checked[i][j+1] = true;
                        checked[i+1][j+1] = true;
                    }
                }
            }

            for(int i=0; i<m;i++){
                for(int j=0;j<n;j++){
                    if(checked[i][j]){
                        blockMap[i][j] = 0;
                        count++;
                    }
                }
            }
            
            if(count == 0){
                break;
            }
            
            for(int i = m-2; i>=0; i--){
                for(int j=0; j<n;j++){
                    if(blockMap[i+1][j] == 0 && blockMap[i][j] != 0){
                        int d = downUpdate(i+1,j,m);
                        blockMap[d][j] = blockMap[i][j];
                        blockMap[i][j] = 0;
                    }
                }
            }
            
            answer += count;
        }
        
        return answer;
    }
    
    public static int downUpdate(int x,int y,int m){
        int updateI = 0;
        for(int i=x; i<m;i++){
            //아래로 떨어질때 프렌즈들을만난다면
            if(blockMap[i][y] != 0){
                updateI = i-1;
                break;
            }
            
            // 끝까지 내렸는데 프렌즈들이 없다. 맨 아래 블록도 빈공간이다.
            if(i == m-1 && blockMap[i][y] == 0){
                updateI = m-1;
            }
        }
        return updateI;
    }
}