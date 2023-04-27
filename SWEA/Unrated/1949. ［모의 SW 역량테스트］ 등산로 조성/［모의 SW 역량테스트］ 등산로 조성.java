import java.util.*;
import java.io.*;

class Solution{
    static int N;
    static int K;
    static int [][] map;
    static boolean [][] visited;
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    static int maxLength;
    
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=tc; test_case++){
        	StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            
            map = new int[N][N];
            visited = new boolean[N][N];
            int maxHeight = 0;
            maxLength = 0;
            
            for(int i=0; i<N;i++){
                st = new StringTokenizer(br.readLine());
            	for(int j=0; j<N;j++){
            		map[i][j] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(maxHeight, map[i][j]);
            	}
            }
            
            for(int i=0; i<N;i++){
            	for(int j=0; j<N;j++){
                    if(map[i][j] == maxHeight){
                        visited[i][j] = true;
                    	dfs(i, j, maxHeight, 1, true);
                        visited[i][j] = false;
                    }
            	}
            }
        
        	sb.append("#"+test_case+" "+maxLength+"\n");
        }
        
        System.out.println(sb);
	}
    
    public static void dfs(int x, int y, int height, int length, boolean shaveCheck) {
		for (int i = 0; i < 4; i++) {
			if (maxLength < length) {
                maxLength = length;
            }
          
			int nx = x + dx[i];
			int ny = y + dy[i];
            
            if(nx >= 0 && ny >= 0 && nx<N && ny <N && !visited[nx][ny] ){
                   if(map[nx][ny] < height){
                        visited[nx][ny] = true;
                        dfs(nx, ny, map[nx][ny], length + 1, shaveCheck);
                        visited[nx][ny] = false;
                    }else{
                        if (shaveCheck) {			
                            for(int j = 1; j <= K; j++) {
                                if((map[nx][ny] - j) < height){
                                    map[nx][ny] -= j;
                                    dfs(nx ,ny, map[nx][ny], length+1, false);
                                    map[nx][ny] += j;
                                 }
                            }
                        }
                    }
                }
            }
		}
}