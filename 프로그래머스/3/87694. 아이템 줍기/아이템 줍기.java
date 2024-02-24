import java.util.*;

class Solution {
    private int[][] map;
    private int answer;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        answer=0;

        // 1. map 초기화
        map= new int[101][101];

        // 2. 사각형 테두리 -> 1, 사각형 내부 -> 2 로 채우기
        for(int i=0; i<rectangle.length; i++){
            fill(2*rectangle[i][0], 2*rectangle[i][1], 2*rectangle[i][2], 2*rectangle[i][3]);
        }

        // 3. bfs로 양쪽 탐색 후 최단거리 찾기
        bfs(2*characterX, 2*characterY, 2*itemX, 2*itemY);

        return answer/2;
    }

    // 사각형 테두리 -> 1, 사각형 내부 -> 2 로 채우기
    private void fill(int x1, int y1, int x2, int y2){
        for(int i=x1; i<=x2; i++){
            for(int j=y1; j<=y2; j++){
                // 이미 다른 사각형의 내부인 경우
                if(map[i][j]==2) {
                   continue; 
                } 

                // 새로운 내부인 경우
                map[i][j]=2;

                // 테두리인 경우
                if(i==x1||i==x2||j==y1||j==y2){
                    map[i][j]=1;
                }
            }
        }
    }

    static private int[] dx= {-1, 0, 0, 1};
    static private int[] dy= {0, -1, 1, 0};

    private void bfs(int startX, int startY, int itemX, int itemY){
        boolean[][] visited= new boolean[101][101];
        Queue<int[]> queue= new LinkedList<>();
        queue.add(new int[] {startX,startY});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x= current[0];
            int y= current[1];

            for(int i=0; i<4; i++){
                int nx= x+dx[i];
                int ny= y+dy[i];

                if(!isRange(nx, ny)) {
                    continue; 
                } 
                
                if(map[nx][ny]!=1 || visited[nx][ny]) {
                    continue;
                } 

                map[nx][ny] = map[x][y]+1;

                if(nx==itemX && ny==itemY){ 
                    answer= (answer==0)? map[nx][ny]:Math.min(answer,map[nx][ny]);
                    continue;
                }

                visited[nx][ny]= true;
                queue.add(new int[] {nx,ny});
            }
        }
    }

    private boolean isRange(int x, int y){
        return x >= 0 && x <= 100 && y>= 0 && y <= 100;
    }
}