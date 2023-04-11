class Solution {
    static int [][] map;
    static int n;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        n = queries.length;
        map = new int[rows][columns];
        initSquare(rows,columns);
        
        return rotateNums(map, queries);
    }
    
    public void initSquare(int rows, int columns){
        
        int setNum = 1;
        for(int i=0; i<rows;i++){
            for(int j=0;j<columns;j++){
                map[i][j] = setNum;
                setNum++;
            }
        }
        
    }
    
    public int[] rotateNums(int[][] square, int[][] queries){
        
        int[] answer = new int[n];
        int minimalsIdx=0;

        for(int[] query : queries){
            int x1 = query[0]-1;
            int y1 = query[1]-1;
            int x2 = query[2]-1;
            int y2 = query[3]-1;
            int firstNum = square[x1][y2];
            int min = firstNum;
            
            for(int i=y2-1; i>=y1; i--){
                min = Math.min(min, square[x1][i]);
                square[x1][i+1] = square[x1][i];
            }

            for(int i=x1+1; i<=x2; i++){
                min = Math.min(min, square[i][y1]);
                square[i-1][y1] = square[i][y1];
            }

            for(int i=y1+1; i<=y2; i++){
                min = Math.min(min, square[x2][i]);
                square[x2][i-1] = square[x2][i];
            }

            for(int i=x2-1; i>=x1; i--){
                min = Math.min(min, square[i][y2]);
                square[i+1][y2] = square[i][y2];
            }

            square[x1+1][y2] = firstNum; //시작때 첫행 마지막 칸 남겨놓은거 square로 변경
            answer[minimalsIdx] = min;
            minimalsIdx++;
        }
        return answer;
    }
}