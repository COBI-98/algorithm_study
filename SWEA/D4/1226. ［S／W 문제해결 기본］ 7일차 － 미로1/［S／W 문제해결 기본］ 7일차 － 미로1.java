import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

class Solution{
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    static int [][] map;
    static boolean [][] visited;
    static class miro{
    	int x;
        int y;
        public miro(int x, int y){
        	this.x = x;
            this.y = y;
        }
    }
    
    public static Queue<miro> q ;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
		for(int test_case = 1; test_case <= 10; test_case++){
            int tc = Integer.parseInt(br.readLine());
			map = new int[16][16];
            visited = new boolean[16][16];
			q = new LinkedList<>();
            
            int A;
            int B;
            for(int i=0; i<16; i++){
                String str = br.readLine();
            	for(int j=0; j<16; j++){
                	map[i][j] = str.charAt(j) - '0';
                    
                    if(map[i][j] == 2){
                    	q.offer(new miro(i,j));
                    }
                    
                }
            }
            if(bfs()){
            	sb.append("#"+tc+" "+1+"\n");
            }else{
           		sb.append("#"+tc+" "+0+"\n");
            }
		}
        
        System.out.println(sb);
	}
    
    public static boolean bfs(){
    	
        while(!q.isEmpty()){
        	miro m = q.poll();
            
            visited[m.x][m.y] = true;
            
            for(int i=0; i<4;i++){
            	int nx = m.x + dx[i];
            	int ny = m.y + dy[i];
                
                if(map[nx][ny] == 3){
                	return true;
                }
                
                if(nx>=0 && ny>=0 && nx<16 && ny<16){
                	if(!visited[nx][ny] && map[nx][ny] == 0){
                    	q.add(new miro(nx,ny));
                    }
                }
            }
        }
        
        return false;
    }
}